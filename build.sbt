import ReleaseTransformations._

import scala.language.postfixOps
import scala.sys.process._

// ---------
// Setting / Task Definitions
// ---------

lazy val vegaLiteVersion = settingKey[String]("The release version of vega-lite to build off")

lazy val updateVegaDeps = taskKey[Unit]("Download and replace the vega-lite json schema and examples with the latest versions from their github repo")
updateVegaDeps := {
  val specResources = (resourceDirectory in Compile in vegaLiteSpec).value
  val coreResources = (resourceDirectory in Compile in vegas).value
  val coreTestResources = (resourceDirectory in Test in vegas).value

  val vegaDir = target.value / ("vega-lite-" + vegaLiteVersion.value)
  IO.unzipURL(new URL("https://github.com/vega/vega-lite/archive/v" + vegaLiteVersion.value + ".zip"), target.value)
  IO.copyDirectory(vegaDir / "examples" / "specs", coreTestResources / "example-specs", true)
  IO.copyFile(vegaDir / "vega-lite-schema.json", specResources / "vega-lite-schema.json")

  // Write WebJar.csv to resources, based on ivy-deps
  val deps = (externalDependencyClasspath in vegas in Compile).value
  val webJars = deps
    .map { artifact =>
      val m = artifact.get(Keys.moduleID.key).get
      (m.organization, m.name, m.revision)
    }
    .filter(_._1 == "org.webjars.bower")
    .map { case(_,n,v) => s"$n,$v" }
    .mkString("\n")
  IO.write(coreResources / "webjars.csv", webJars)
}

addCommandAlias("look", "vegas/test:runMain vegas.util.Look")

lazy val mkVegaModel = taskKey[Unit]("Compiles and copies the vega-lite model and codec to the Vegas project")

mkVegaModel := {
  val src = (scalaBinaryVersion.value match {
    case "2.11" => file("spec/target/scala-2.11/Spec.scala")
    case "2.12" => file("spec/target/scala-2.12/Spec.scala")
  })
  val dest = file("core/src/main/scala/vegas/spec/Spec.scala")
  IO.write(dest, "package vegas.spec\n\n")
  IO.append(dest, IO.readBytes(src))
}

mkVegaModel := mkVegaModel
  .dependsOn(compile in vegaLiteSpec in Compile)
  .value

lazy val lastReleaseVersion = taskKey[String]("Gets (using git tag) the version number of the last release")
lastReleaseVersion := {
  ("git tag" !!).split("\n").head.tail
}

lazy val mkNotebooks = inputKey[Unit]("Generates /notebook examples based on example plots in the test fixtures")
mkNotebooks := (Def.inputTaskDyn {
  val ver = version.value
  val baseDir = file("core/src/test/scala/vegas/fixtures")
  val files = (baseDir / "BasicPlots.scala") :: (baseDir / "VegasPlots.scala") :: Nil
  val dest = file("notebooks")
  val args = (ver :: files) :+ dest
  Def.taskDyn {
    (runMain in vegas in Test).toTask(" vegas.util.GenerateNotebooks " + args.mkString(" "))
  }
}).evaluated

// -------
// Build Config
// -------

lazy val circeVersion = "0.7.0"

lazy val commonSettings = Seq(
  description := "The missing matplotlib for Scala and Spark",
  organization := "org.vegas-viz",
  crossScalaVersions := Seq("2.11.8", "2.12.4"),
  scalaVersion := "2.11.8",
  vegaLiteVersion := "1.2.0",
  scalacOptions ++= Seq("-target:jvm-1.7", "-Ywarn-unused-import"),
  homepage := Some(url("http://vegas-viz.org")),
  licenses := Seq("MIT License" -> url("http://www.opensource.org/licenses/MIT")),
//  parallelExecution in Test := false,

  addCompilerPlugin("org.scalamacros" %% "paradise" % "2.1.0" cross CrossVersion.full),
  publishMavenStyle := true,
  publishTo := {
    val nexus = "https://oss.sonatype.org/"
    if (isSnapshot.value)
      Some("snapshots" at nexus + "content/repositories/snapshots")
    else
      Some("releases" at nexus + "service/local/staging/deploy/maven2")
  },
  publishArtifact in Test := false,
  pomIncludeRepository := { _ => false },
  sonatypeProfileName := "org.vegas-viz",
  pomExtra := (
    <scm>
      <url>git@github.com:vegas-viz/Vegas.git</url>
      <connection>scm:git:git@github.com:vegas-viz/Vegas.git</connection>
    </scm>
      <developers>
        <developer>
          <id>aishfenton</id>
          <name>Aish Fenton</name>
        </developer>
        <developer>
          <id>datamusing</id>
          <name>Sudeep Das</name>
        </developer>
        <developer>
          <id>dbtsai</id>
          <name>DB Tsai</name>
        </developer>
        <developer>
          <id>rogermenezes</id>
          <name>Roger Menezes</name>
        </developer>
      </developers>
  ),
  testOptions in Test += Tests.Argument("-oDF"),
  releaseProcess := Seq[ReleaseStep](
    checkSnapshotDependencies,
    inquireVersions,
    runClean,
    runTest,
    setReleaseVersion,
    releaseStepInputTask(mkNotebooks),
    commitReleaseVersion,
    tagRelease,
//    ReleaseStep(action = Command.process("publishSigned", _)),
    ReleaseStep(action = st => st.copy(remainingCommands = Exec("publishSigned", None) +: st.remainingCommands)),
    setNextVersion,
    commitNextVersion,
//    ReleaseStep(action = Command.process("sonatypeReleaseAll", _)),
    ReleaseStep(action = st => st.copy(remainingCommands = Exec("sonatypeReleaseAll", None) +: st.remainingCommands)),
    pushChanges
  )
)

lazy val noPublishSettings = Seq(
  publish := {},
  publishLocal := {},
  publishArtifact := false
)


lazy val macros = project.
  settings(moduleName := "vegas-macros").
  settings(commonSettings: _*).
  settings(
    libraryDependencies ++= Seq(
      "org.scala-lang" % "scala-reflect" % scalaVersion.value,
      "org.scala-lang" % "scala-compiler" % scalaVersion.value % "provided",
      "org.typelevel" %% "macro-compat" % "1.1.1",
      "com.github.julien-truffaut" %% "monocle-core" % (scalaBinaryVersion.value match {
        case "2.11" => "1.1.0"
        case "2.12" => "1.3.2"
      })
    )
  )


// This project exists just to generate the Vega-Lite Json model + codecs
lazy val vegaLiteSpec = project.in(file("spec")).
  settings(commonSettings: _*).
  settings(noPublishSettings: _*).
  settings(
    libraryDependencies ++= Seq(
      "io.circe" %% "circe-core" % circeVersion,
      "io.circe" %% "circe-generic" % circeVersion,
      "io.circe" %% "circe-parser" % circeVersion,
      "com.github.aishfenton" %% "argus" % "0.2.7",
      "org.scalactic" %% "scalactic" % "3.0.5" % "test",
      "org.scalatest" %% "scalatest" % "3.0.5" % "test"
    )
  )
//  settings(sourceGenerators in Compile <+= (sourceManaged in Compile) map genCode)

lazy val vegas = project.in(file("core")).
  settings(moduleName := "vegas").
  dependsOn(macros).
  settings(commonSettings: _*).
  settings(
    libraryDependencies ++= Seq(
      "io.circe" %% "circe-core" % circeVersion,
      "io.circe" %% "circe-generic" % circeVersion,
      "io.circe" %% "circe-parser" % circeVersion,
      "com.github.julien-truffaut" %% "monocle-macro" % (scalaBinaryVersion.value match {
        case "2.11" => "1.1.0"
        case "2.12" => "1.3.2"
      }),
      "com.github.julien-truffaut" %% "monocle-core" % (scalaBinaryVersion.value match {
        case "2.11" => "1.1.0"
        case "2.12" => "1.3.2"
      }),
      "org.scalafx" %% "scalafx" % "8.0.102-R11",
      "org.scala-lang.modules" %% "scala-xml" % "1.0.6",

      // JS deps. Also used to generate "webjars.csv" file for CDN loading.
      "org.webjars.bower" % "vega-lite" % vegaLiteVersion.value,

      // Test deps
      "com.github.aishfenton" %% "argus" % "0.2.7" % "test",
      "org.scalactic" %% "scalactic" % "3.0.5" % "test",
      "org.scalatest" %% "scalatest" % "3.0.5" % "test",
      "org.seleniumhq.selenium" % "selenium-java" % "3.13.0" % "test"
    )
  )

// https://stackoverflow.com/questions/48653876/aggregate-different-modules-based-on-scala-binary-version

lazy val spark = project.
  settings(moduleName := "vegas-spark").
  dependsOn(vegas % "compile->compile; test->test").
  settings(commonSettings: _*).
  settings(
    libraryDependencies ++= Seq(
      "org.apache.spark" %% "spark-sql" % "[2.0,)" % "provided"
    )
  ).
  // remove spark dep and skip compile if version is 2.12
  settings(
    libraryDependencies := (if (scalaBinaryVersion.value == "2.12") Seq.empty
      else libraryDependencies.value),
    skip in compile := scalaBinaryVersion.value == "2.12",
    skip in publish := scalaBinaryVersion.value == "2.12"
  )


lazy val flink = project.
  settings(moduleName := "vegas-flink").
  dependsOn(vegas).
  settings(commonSettings: _*).
  settings(
    libraryDependencies ++= Seq(
      "org.apache.flink" %% "flink-scala" % "[1.1.1,)" % "provided",
      "org.apache.flink" %% "flink-clients" % "[1.1.1,)" % "provided"
    )
  ).
  settings(
    libraryDependencies := (if (scalaBinaryVersion.value == "2.12") Seq.empty
      else libraryDependencies.value),
    skip in compile := scalaBinaryVersion.value == "2.12",
    skip in publish := scalaBinaryVersion.value == "2.12"
  )

lazy val root = (project in file(".")).
  aggregate(vegas, spark, flink, macros).
  settings(commonSettings: _*).
  settings(noPublishSettings: _*)


// Clears screen between refreshes in continuous mode
maxErrors := 5
triggeredMessage := Watched.clearWhenTriggered

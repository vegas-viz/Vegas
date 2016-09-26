import ReleaseTransformations._

// ---------
// Setting / Task Definitions
// ---------

lazy val vegaLiteVersion = settingKey[String]("The release version of vega-lite to build off")

lazy val updateVegaDeps = taskKey[Unit]("Download and replace the vega-lite json schema and examples with the latest versions from their github repo")
updateVegaDeps := {
  val schemaFile = file("core/src/main/resources/vega-lite-schema.json")
  val examples = file("core/src/test/resources/example-specs/")

  val vegaDir = target.value / ("vega-lite-" + vegaLiteVersion.value)
  IO.unzipURL(new URL("https://github.com/vega/vega-lite/archive/v" + vegaLiteVersion.value + ".zip"), target.value)
  IO.copyDirectory(vegaDir / "examples" / "specs", examples, true)
  IO.copyFile(vegaDir / "vega-lite-schema.json", schemaFile)
}

// Gets included into vegaLiteSpec to generate code.
lazy val genCode = (dir: File) => {
  val file = dir / "Container.scala"
  IO.write(file,
    s"""
      import argus.macros._
      @fromSchemaResource("/vega-lite-schema.json", name="Vega", outPath=Some("${(dir / "Spec.scala").getAbsolutePath}"))
      object Spec
    """)
  Seq(file)
}

addCommandAlias("look", "vegas/test:runMain vegas.Look")

lazy val mkVegaModel = taskKey[Unit]("Compiles and copies the vega-lite model and codec to the Vegas project")
mkVegaModel := {
  IO.copyFile(file("spec/target/scala-2.11/src_managed/main/Spec.scala"), file("core/src/main/scala/vegas/spec/Spec.scala"))
}
mkVegaModel <<= mkVegaModel.dependsOn(compile in vegaLiteSpec in Compile)

// -------
// Build Config
// -------

lazy val circeVersion = "0.4.1"

lazy val commonSettings = Seq(
  description := "The missing MatPlotLib for Scala and Spark",
  organization := "com.github.aishfenton",
  scalaVersion := "2.11.8",
  vegaLiteVersion := "1.1.2",
  scalacOptions += "-target:jvm-1.7",
  homepage := Some(url("https://github.com/aishfenton/Vegas")),
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
  sonatypeProfileName := "com.github.aishfenton",
  pomExtra := (
    <scm>
      <url>git@github.com:aishfenton/Vegas.git</url>
      <connection>scm:git:git@github.com:aishfenton/Vegas.git</connection>
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
  releaseProcess := Seq[ReleaseStep](
    checkSnapshotDependencies,
    inquireVersions,
    runClean,
    runTest,
    setReleaseVersion,
    commitReleaseVersion,
    tagRelease,
    ReleaseStep(action = Command.process("publishSigned", _)),
    setNextVersion,
    commitNextVersion,
    ReleaseStep(action = Command.process("sonatypeReleaseAll", _)),
    pushChanges
  )
)

lazy val noPublishSettings = Seq(
  publish := (),
  publishLocal := (),
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
      "com.github.julien-truffaut" %% "monocle-core" % "1.1.0"
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
      "com.github.aishfenton" %% "argus" % "0.2.0",
      "org.scalactic" %% "scalactic" % "2.2.6" % "test",
      "org.scalatest" %% "scalatest" % "2.2.6" % "test"
    )
  ).
  settings(sourceGenerators in Compile <+= (sourceManaged in Compile) map genCode)

lazy val vegas = project.in(file("core")).
  settings(moduleName := "vegas").
  dependsOn(macros).
  settings(commonSettings: _*).
  settings(
    libraryDependencies ++= Seq(
      "io.circe" %% "circe-core" % circeVersion,
      "io.circe" %% "circe-generic" % circeVersion,
      "io.circe" %% "circe-parser" % circeVersion,
      "com.github.julien-truffaut" %% "monocle-macro" % "1.1.0",
      "com.github.julien-truffaut" %% "monocle-core" % "1.1.0",
      "org.scalafx" %% "scalafx" % "8.0.92-R10",
      "com.github.aishfenton" %% "argus" % "0.2.0" % "test",
      "org.scalactic" %% "scalactic" % "2.2.6" % "test",
      "org.scalatest" %% "scalatest" % "2.2.6" % "test",
      "org.seleniumhq.selenium" % "selenium-java" % "3.0.0-beta2" % "test"
    )
  )

lazy val spark = project.
  settings(moduleName := "vegas-spark").
  dependsOn(vegas).
  settings(commonSettings: _*).
  settings(
    libraryDependencies ++= Seq(
      "org.apache.spark" %% "spark-sql" % "[1.5,)" % "provided"
    )
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
  )


lazy val root = (project in file(".")).
  aggregate(vegas, spark, flink, macros).
  settings(commonSettings: _*).
  settings(noPublishSettings: _*)

// Clears screen between refreshes in continuous mode
maxErrors := 5
triggeredMessage := Watched.clearWhenTriggered



// ---------
// Task Definitions
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

// We hide this under the Integration Test config so that ti doesn't get triggered normally.
addCommandAlias("writeVegaSchema", ";clean ;vegas/it:test")
lazy val genCode = (dir: File) => {
  val file = dir / "Container.scala"
  IO.write(file,
    s"""
      import argus.macros._
      @fromSchemaResource("/vega-lite-schema.json", name="Vega", outPath=Some("${(dir / "Vega.scala").getAbsolutePath}"))
      object Spec2
    """)
  Seq(file)
}

addCommandAlias("look", "vegas/test:runMain vegas.Look")

// -------
// Config
// -------

lazy val circeVersion = "0.4.1"

lazy val commonSettings = Seq(
  description := "The missing MatPlotLib for Scala and Spark",
  organization := "com.github.aishfenton",
  version := "0.2.4",
  scalaVersion := "2.11.8",
  vegaLiteVersion := "1.1.2",
  scalacOptions += "-target:jvm-1.7",
  crossScalaVersions := Seq("2.10.6", "2.11.8"),
  homepage := Some(url("https://github.com/aishfenton/Vegas")),
  licenses := Seq("MIT License" -> url("http://www.opensource.org/licenses/MIT")),

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
      </developers>
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
// settings(noPublishSettings: _*)

lazy val vegas = project.in(file("core")).
  settings(moduleName := "vegas").
  dependsOn(macros).
  settings(commonSettings: _*).
  settings(
    libraryDependencies ++= Seq(
      "io.argonaut" %% "argonaut" % "6.1",
      "io.circe" %% "circe-core" % circeVersion,
      "io.circe" %% "circe-generic" % circeVersion,
      "io.circe" %% "circe-parser" % circeVersion,
      "com.github.julien-truffaut" %% "monocle-macro" % "1.1.0",
      "com.github.julien-truffaut" %% "monocle-core" % "1.1.0",
      "org.scalafx" %% "scalafx" % "8.0.92-R10",
      "com.github.aishfenton" %% "argus" % "0.2.0",
      "org.scalactic" %% "scalactic" % "2.2.6" % "test",
      "org.scalatest" %% "scalatest" % "2.2.6" % "test",
      "org.seleniumhq.selenium" % "selenium-java" % "3.0.0-beta2" % "test"
    )
  ).
  // For integration debug task (see writeVegaSchema)
  settings(inConfig(IntegrationTest)(
    Defaults.testSettings ++ Seq(
      sourceGenerators <+= (sourceManaged in IntegrationTest) map genCode
    )
  ))

lazy val spark = project.
  settings(moduleName := "vegas-spark").
  dependsOn(vegas).
  settings(commonSettings: _*).
  settings(
    libraryDependencies ++= Seq(
      "org.apache.spark" %% "spark-sql" % "[1.5,)" % "provided"
    )
  )

lazy val root = (project in file(".")).
  aggregate(vegas, spark).
  settings(commonSettings: _*).
  settings(noPublishSettings: _*)

// Clears screen between refreshes in continuous mode
maxErrors := 5
triggeredMessage := Watched.clearWhenTriggered


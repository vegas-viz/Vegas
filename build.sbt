
lazy val commonSettings = Seq(
  organization := "com.github.aishfenton",
  version := "0.2.3",
  scalaVersion := "2.11.8",
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
      Some("releases"  at nexus + "service/local/staging/deploy/maven2")
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
      "com.github.julien-truffaut"  %%  "monocle-core" % "1.1.0"
    ) ++ (
      if (scalaVersion.value.startsWith("2.10")) Seq("org.scalamacros" %% "quasiquotes" % "2.1.0")
      else Nil
    )
  ).
  settings(noPublishSettings: _*)

lazy val vegas = project.in(file("core")).
  settings(moduleName := "vegas").
  dependsOn(macros).
  settings(commonSettings: _*).
  settings(
    libraryDependencies ++= Seq(
      "io.argonaut" %% "argonaut" % "6.1",
      "com.github.julien-truffaut" %% "monocle-macro" % "1.1.0",
      "com.github.julien-truffaut"  %%  "monocle-core" % "1.1.0",
      "org.scalafx" %% "scalafx" % "8.0.92-R10",
      "org.scalactic" %% "scalactic" % "2.2.6" % "test",
      "org.scalatest" %% "scalatest" % "2.2.6" % "test",
      "org.everit.json" % "org.everit.json.schema" % "1.2.0" % "test"
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


lazy val root = (project in file(".")).
  aggregate(vegas, spark).
  settings(commonSettings: _*).
  settings(noPublishSettings: _*)

// Clears screen between refreshes in continuous mode
maxErrors := 5
triggeredMessage := Watched.clearWhenTriggered


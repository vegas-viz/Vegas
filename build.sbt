
lazy val commonSettings = Seq(
  organization := "netflix",
  version := "0.1.0",
  scalaVersion := "2.11.8",
  scalacOptions += "-target:jvm-1.7"
)

lazy val noPublishSettings = Seq(
  publish := (),
  publishLocal := (),
  publishArtifact := false
)

lazy val vegas = project.in(file("core")).
  settings(moduleName := "vegas").
  settings(commonSettings: _*).
  settings(
    libraryDependencies ++= Seq(
      "io.argonaut" %% "argonaut" % "6.1",
      "com.github.julien-truffaut"  %%  "monocle-core"    % "1.1.0",
      "org.scalactic" %% "scalactic" % "2.2.6" % "test",
      "org.scalatest" %% "scalatest" % "2.2.6" % "test",
      "org.everit.json" % "org.everit.json.schema" % "1.2.0" % "test"
    )
  )

lazy val spark = project.
  settings(moduleName := "vegas-spark").
  dependsOn(vegas).
  settings(commonSettings: _*).
  settings(noPublishSettings)

lazy val root = (project in file(".")).
  aggregate(vegas, spark)



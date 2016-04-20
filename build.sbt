name := "Vegas"

version := "1.0"

scalaVersion := "2.11.8"

scalacOptions += "-target:jvm-1.7"

libraryDependencies ++= Seq(
  "io.argonaut" %% "argonaut" % "6.1",
  "com.github.julien-truffaut"  %%  "monocle-core"    % "1.1.0",
  "org.scalactic" %% "scalactic" % "2.2.6" % "test",
  "org.scalatest" %% "scalatest" % "2.2.6" % "test",
  "org.everit.json" % "org.everit.json.schema" % "1.2.0" % "test"
)


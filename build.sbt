name := """scala-testing"""

version := "0.1.0"

scalaVersion := "2.11.2"

// ScalaTest
libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "2.2.2" % "test",
  "com.typesafe" % "config" % "1.3.0"
)


fork in run := true
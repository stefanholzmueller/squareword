ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.11"

lazy val root = (project in file("."))
  .settings(
    name := "squareword",
    libraryDependencies ++= Seq(
      "org.scala-lang.modules" %% "scala-parallel-collections" % "1.0.4",
      "com.lihaoyi" %% "os-lib" % "0.9.1",
      "com.lihaoyi" %% "upickle" % "3.1.0",
      "org.scalameta" %% "munit" % "0.7.29" % Test
    )
  )

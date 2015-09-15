enablePlugins(ScalaJSPlugin)

name := "Scala.js Tutorial"

scalaVersion := "2.10.5"

libraryDependencies ++= {
  val scalaJsV = "0.8.0"
  Seq(
    "org.scala-js" %%% "scalajs-dom" % scalaJsV,
    "be.doeraene" %%% "scalajs-jquery" % scalaJsV,
    "com.lihaoyi" %%% "utest" % "0.3.0" % "test"
  )
}

jsDependencies += RuntimeDOM

testFrameworks += new TestFramework("utest.runner.Framework")

skip in packageJSDependencies := false

persistLauncher in Compile := true

persistLauncher in Test := false

name := "mnemonic_numbers"

version := "0.1"

scalaVersion := "2.12.6"

scalacOptions ++= Seq(
  "-target:jvm-1.8",
  "-encoding", "UTF-8",
  "-unchecked",
  "-deprecation",
  "-Xfatal-warnings",
  "-Xfuture",
  "-Yno-adapted-args",
  "-Ywarn-dead-code",
  "-Ywarn-numeric-widen",
  "-Ywarn-value-discard",
  "-Ywarn-unused"
)

mainClass in assembly := Some("com.galekseev.mnemonic.numbers.Main")

libraryDependencies ++= Seq(
  "com.typesafe.scala-logging" %% "scala-logging" % "3.9.0",
  "ch.qos.logback" % "logback-classic" % "1.2.3",

  "org.scalatest" %% "scalatest" % "3.0.5" % Test,
  "junit" % "junit" % "4.12" % Test
)

coverageEnabled := true
coverageMinimum := 80
coverageFailOnMinimum := true
coverageExcludedPackages := "com\\.galekseev\\.mnemonic\\.numbers\\.Main"

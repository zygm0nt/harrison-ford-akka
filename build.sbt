name := "harrison-ford-akka"

version := "1.0.0-SNAPSHOT"

scalaVersion := "2.10.1"

scalacOptions ++= Seq(
  "-unchecked",
  "-deprecation",
  "-Xlint",
  "-Ywarn-dead-code",
  "-language:_",
  "-target:jvm-1.7",
  "-encoding", "UTF-8"
)

testOptions += Tests.Argument(TestFrameworks.JUnit, "-v")

seq(Revolver.settings: _*)

libraryDependencies ++= Seq(
    "joda-time" % "joda-time" % "1.4",
  "com.typesafe.akka"  %% "akka-actor"       % "2.2.0",
  "com.typesafe.akka"  %% "akka-slf4j"       % "2.2.0",
  "org.specs2"         %% "specs2"           % "1.14"         % "test",
  "com.typesafe.akka"  %% "akka-testkit"     % "2.2.0"        % "test",
  "com.novocode"        % "junit-interface"  % "0.7"          % "test->default"
)

libraryDependencies ++= Seq(
    "org.clapper" %% "grizzled-slf4j" % "1.0.1",
    "ch.qos.logback" % "logback-classic" % "1.0.13",
    "ch.qos.logback" % "logback-core" % "1.0.13",
    "org.scalatest" %% "scalatest" % "1.9.1" % "test"
)

resolvers ++= Seq("snapshots" at "http://oss.sonatype.org/content/repositories/snapshots",
                  "releases"  at "http://oss.sonatype.org/content/repositories/releases",
                  "spray repo" at "http://repo.spray.io",
                  "akka maven repository" at "http://repo.typesafe.com/typesafe/releases/")

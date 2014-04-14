organization := "com.aurelpaulovic"

name := "scala-kata"

version := "0.1"

scalaVersion := "2.10.4"

resolvers += "Sonatype (releases)" at "https://oss.sonatype.org/content/repositories/releases/"

resolvers += Resolver.sonatypeRepo("snapshots")

libraryDependencies += "org.scalatest" % "scalatest_2.10" % "2.1.3" % "test"

libraryDependencies += "junit" % "junit" % "4.8.1" % "test"

scalacOptions ++= Seq( "-feature", "-deprecation", "-language:implicitConversions" )

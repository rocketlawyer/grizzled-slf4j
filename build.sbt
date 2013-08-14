// ---------------------------------------------------------------------------
// SBT 0.10.x build file for Grizzled SLF4J
// (http://software.clapper.org/grizzled-slf4j)
//
// Copyright (c) 2010-2011 Brian M. Clapper
//
// See accompanying license file for Grizzled SLF4J license.
// ---------------------------------------------------------------------------

// ---------------------------------------------------------------------------
// Basic settings

name := "grizzled-slf4j"

organization := "org.clapper"

version := "1.0.2"

licenses := Seq("BSD" -> url("http://software.clapper.org/grizzled-slf4j/license.html"))

homepage := Some(url("http://software.clapper.org/grizzled-slf4j/"))

description := "A Scala-friendly wrapper for the SLF4J logging framework"

scalaVersion := "2.10.2"

// ---------------------------------------------------------------------------
// Additional compiler options and plugins

scalacOptions ++= Seq("-deprecation", "-unchecked", "-feature")

crossScalaVersions := Seq("2.10.2")

seq(lsSettings :_*)

(LsKeys.tags in LsKeys.lsync) := Seq(
  "log", "logger", "logging", "slf4j", "grizzled", "wrapper"
)

(description in LsKeys.lsync) <<= description(d => d)

// ---------------------------------------------------------------------------
// dependendency

libraryDependencies ++= Seq(
  "org.slf4j" % "slf4j-api" % "1.7.5"
)

// ---------------------------------------------------------------------------
// Publishing criteria

publishTo <<= version { v: String =>
  val nexus = "https://oss.sonatype.org/"
  if (v.trim.endsWith("SNAPSHOT"))
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases" at nexus + "service/local/staging/deploy/maven2")
}

publishMavenStyle := true

publishArtifact in Test := false

pomIncludeRepository := { _ => false }

pomExtra := (
  <scm>
    <url>git@github.com:bmc/grizzled-slf4j.git/</url>
    <connection>scm:git:git@github.com:bmc/grizzled-slf4j.git</connection>
  </scm>
  <developers>
    <developer>
      <id>bmc</id>
      <name>Brian Clapper</name>
      <url>http://www.clapper.org/bmc</url>
    </developer>
  </developers>
)

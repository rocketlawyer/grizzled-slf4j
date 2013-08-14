resolvers ++= Seq(
  "less is" at "http://repo.lessis.me",
  "jgit-repo" at "http://download.eclipse.org/jgit/maven")

addSbtPlugin("org.ensime" % "ensime-sbt-cmd" % "0.1.1")  

addSbtPlugin("com.typesafe.sbt" % "sbt-git" % "0.5.0")

addSbtPlugin("me.lessis" % "ls-sbt" % "0.1.2")

ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.7"

name := "scalapy"

/* =================== ScalaPy BEGIN ========================== */
libraryDependencies += "me.shadaj" %% "scalapy-core" % "0.5.1"

fork := true

import scala.sys.process._
lazy val pythonLdFlags = {
  val withoutEmbed = "python3-config --ldflags".!!
  if (withoutEmbed.contains("-lpython")) {
    withoutEmbed.split(' ').map(_.trim).filter(_.nonEmpty).toSeq
  } else {
    val withEmbed = "python3-config --ldflags --embed".!!
    withEmbed.split(' ').map(_.trim).filter(_.nonEmpty).toSeq
  }
}

lazy val pythonLibsDir = {
  pythonLdFlags.find(_.startsWith("-L")).get.drop("-L".length)
}

javaOptions += s"-Djna.library.path=$pythonLibsDir"
/* =================== ScalaPy END ========================== */
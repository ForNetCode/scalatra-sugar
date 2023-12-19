val scala3Version = "3.3.1"

// zio-json default value needs this, enumeration need this too
ThisBuild / scalacOptions ++= Seq("-Yretain-trees")

import Dependencies.*

lazy val webSugar = project
  .in(file("."))
  .settings(
    name := "web-sugar",
    version := "0.1.0",
    scalaVersion := scala3Version,
    libraryDependencies ++= grpc ++ persistence ++ logLib ++ configLib ++
      httpClient ++ tapir ++ enumExtraLib ++ Seq(
        "redis.clients" % "jedis" % "5.1.0",
        "io.scalaland" %% "chimney" % "0.8.3", // case class convert easily
        "org.hashids" % "hashids" % "1.0.3", // hashids
        "org.scalameta" %% "munit" % "0.7.29" % Test
      )
  )

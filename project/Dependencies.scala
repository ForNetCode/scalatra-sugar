import sbt.*

object Dependencies {

  lazy val grpc = Seq(
    "io.grpc" % "grpc-netty" % scalapb.compiler.Version.grpcJavaVersion,
    "com.thesamet.scalapb" %% "scalapb-runtime-grpc" % scalapb.compiler.Version.scalapbVersion,
    // (optional) If you need scalapb/scalapb.proto or anything from
    // google/protobuf/*.proto
    "com.thesamet.scalapb" %% "scalapb-runtime" % scalapb.compiler.Version.scalapbVersion % "protobuf",
    // "io.jsonwebtoken" % "jjwt" % "0.9.1",
  )

  lazy val logLib = Seq(
    "com.typesafe.scala-logging" %% "scala-logging" % "3.9.5",
    "ch.qos.logback" % "logback-classic" % "1.4.7",
  )

  lazy val persistence = Seq(
    "org.flywaydb" % "flyway-core" % "9.19.4",
    "io.getquill" %% "quill-jdbc" % "4.8.0",
    "org.postgresql" % "postgresql" % "42.6.0" % "compile",
    "mysql" % "mysql-connector-java" % "8.0.17" % "compile",
  )

  lazy val httpClient = {
    val version = "3.9.0"
    Seq(
      "com.softwaremill.sttp.client3" %% "core" % version,
      "com.softwaremill.sttp.client3" %% "zio-json" % version,
      "com.softwaremill.sttp.client3" %% "slf4j-backend" % version,
    )
  }

  lazy val webServer = {
    val scalatraVersion = "3.0.0"
    Seq(
      "org.scalatra" %% "scalatra-jakarta" % scalatraVersion,
      // "org.scalatra" %% "scalatra-swagger" % scalatraVersion,
      "org.scalatra" %% "scalatra-json-jakarta" % scalatraVersion,
      "org.scalatra" %% "scalatra-auth-jakarta" % scalatraVersion,
      // "org.json4s"   %% "json4s-jackson" % "4.1.0-M1",
      // "org.json4s"   %% "json4s-ext" % "4.1.0-M1",
      "dev.zio" %% "zio-json" % "0.6.2",
      "org.eclipse.jetty" % "jetty-webapp" % "11.0.17" % "compile",
    )
  }

  lazy val configLib = Seq(
    "com.typesafe" % "config" % "1.4.2"
  )

  lazy val keycloakLib = Seq(
    "org.keycloak" % "keycloak-core" % "20.0.5", // 21.0.1: java.lang.NoClassDefFoundError: org/jboss/logging/Logger JWKSUtils.java:39
    // "org.keycloak" % "keycloak-adapter-core" % keycloakVersion,
    // "org.keycloak" % "keycloak-authz-client" % keycloakVersion,

  )
  val pekkoVersion = "1.0.1"

  lazy val pekkoLib = Seq(
    "org.apache.pekko" %% "pekko-actor-typed" % pekkoVersion,
    "org.apache.pekko" %% "pekko-remote" % pekkoVersion,
  )
}

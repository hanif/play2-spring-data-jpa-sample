import play.PlayJava

name := """play2-sample"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  javaCore,
  javaJdbc,
  javaJpa.exclude("org.hibernate.javax.persistence", "hibernate-jpa-2.0-api"),
  cache,
  javaWs,
  "javax.inject" % "javax.inject" % "1",
  "javax.interceptor" % "javax.interceptor-api" % "3.1",
  "javax.enterprise" % "cdi-api" % "1.2",
  "org.springframework" % "spring-context" % "4.1.1.RELEASE",
  "org.springframework" % "spring-expression" % "4.1.1.RELEASE",
  "org.springframework" % "spring-orm" % "4.1.1.RELEASE",
  "org.springframework.data" % "spring-data-jpa" % "1.7.0.RELEASE",
  "org.hibernate" % "hibernate-entitymanager" % "4.3.6.Final",
  "org.mockito" % "mockito-core" % "1.9.5" % "test",
  "org.mindrot" % "jbcrypt" % "0.3m"
)


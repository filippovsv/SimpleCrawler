val http4sVersion = "0.23.9"
val circeVersion = "0.14.1"
val scalaScraper = "2.2.1"

name := "SimpleCrawler"

version := "0.1"

scalaVersion := "2.12.15"

libraryDependencies ++= Seq(
    "org.http4s"            %% "http4s-blaze-server" % http4sVersion,
    "org.http4s"            %% "http4s-dsl"          % http4sVersion,
    "org.http4s"            %% "http4s-circe"        % http4sVersion,
    "io.circe"              %% "circe-generic"       % circeVersion,
    "io.circe"              %% "circe-literal"       % circeVersion,
    "net.ruippeixotog"      %% "scala-scraper"       % "2.2.1",
    "net.liftweb"           %% "lift-json"           % "3.5.0"
)



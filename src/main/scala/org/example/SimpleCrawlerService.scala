package org.example

import cats.effect._
import io.circe.generic.auto._
import org.example.htmlscraper.HtmlParsers.titleParser
import org.example.htmlscraper.HtmlScraper
import org.example.utils.Utils
import org.http4s._
import org.http4s.circe._
import org.http4s.dsl.io._
import org.http4s.server.blaze.BlazeServerBuilder

import scala.concurrent.ExecutionContext.Implicits.global

/**
 * Простой краулер-сервис
 */
object SimpleCrawlerService extends IOApp  {
  case class TitlesReq(urls: Array[String])
  implicit val titleDecoder = jsonOf[IO, TitlesReq]

  val jsonApp = HttpRoutes.of[IO] {
    case req@POST -> Root / "titles" =>
      for {
        titleReq <- req.as[TitlesReq]
        resp <- Ok(Utils.toStringJson(HtmlScraper.scrapePar(titleReq.urls.toList)))
      } yield (resp)
  }.orNotFound

  def run(args: List[String]): IO[ExitCode] =
    BlazeServerBuilder[IO](global)
      .bindHttp(8080, "localhost")
      .withHttpApp(jsonApp)
      .serve
      .compile
      .drain
      .as(ExitCode.Success)
}

// curl -i -X POST -H "Content-Type: application/json" -d "{\"urls\": [\"https://www.google.com/\", \"https://www.youtube.com/\"]}" http://127.0.0.1:8080/titles
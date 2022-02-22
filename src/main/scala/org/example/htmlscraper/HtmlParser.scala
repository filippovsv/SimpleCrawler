package org.example.htmlscraper

import net.ruippeixotog.scalascraper.model.Document
import org.example.htmlscraper.model.{ParseResult, Title}
import org.example.htmlscraper.parsers.TitleParser

import scala.util.Try

/**
 * Интерфейс для всех парсеров html-страниц, имплементации парсеров добавляются в пакет parsers
 * @tparam T - тип возвращаемого результата парсинга
 */
trait HtmlParser[T <: ParseResult] {
  def parse(html: Document): Try[T]
}

/**
 * Объект с implicit'тами всех парсеров
 * При создании нового парсер нужно добавить его сюда
 */
object HtmlParsers {

  implicit val titleParser : HtmlParser[Title] = TitleParser
}



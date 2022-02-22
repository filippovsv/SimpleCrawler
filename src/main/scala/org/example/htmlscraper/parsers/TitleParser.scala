package org.example.htmlscraper.parsers

import net.ruippeixotog.scalascraper.model.Document
import org.example.htmlscraper.HtmlParser
import org.example.htmlscraper.model.Title

import scala.util.Try

/**
 * Парсер заголовка html-страницы
 */
object TitleParser extends HtmlParser[Title] {

  override def parse(html: Document): Try[Title] = {
    Try(Title(html.title)).
      map(t => if (t.title.isEmpty) throw new IllegalStateException("Empty title") else t)
  }
}
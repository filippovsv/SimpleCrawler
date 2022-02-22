package org.example.htmlscraper
import net.ruippeixotog.scalascraper.browser.JsoupBrowser
import org.example.htmlscraper.model.{ParseResult, ScrapeResult}

import scala.util.Try
import scala.util.control.NonFatal

/**
 * Скрапер html-страниц
 */
object HtmlScraper {
  private val browser = JsoupBrowser()

  /**
   * Скрапинг одного url'а
   * @param url
   * @param htmlParser
   * @tparam T
   * @return
   */
  def scrape[T <: ParseResult](url: String)(implicit htmlParser: HtmlParser[T]): ScrapeResult[T] = {
    Try(browser.get(url))
      .map(htmlParser.parse(_))
      .flatMap(t => t)
      .map(t => model.ScrapeResult(url = url, result = Some(t)))
      .recover {
        case NonFatal(e) => ScrapeResult(url = url, code = -1, error_msg = Some(e.getMessage));
      } get
  }

  /**
   * Последовательный скрапинг url'ов
   * @param urls
   * @param htmlParser
   * @tparam T
   * @return
   */

  def scrape[T <: ParseResult](urls: List[String])(implicit htmlParser: HtmlParser[T]): List[ScrapeResult[T]] = {
    urls.map(scrape(_)(htmlParser))
  }

  /**
   * Параллельный скрапинг url'ов
   * @param urls
   * @param htmlParser
   * @tparam T
   * @return
   */
  def scrapePar[T <: ParseResult](urls: List[String])(implicit htmlParser: HtmlParser[T]): List[ScrapeResult[T]] = {
    urls.par.map(scrape(_)(htmlParser)).toList
  }
}


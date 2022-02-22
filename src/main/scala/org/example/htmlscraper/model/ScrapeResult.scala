package org.example.htmlscraper.model

/**
 * Результат парсинга
 * @param url - url страницы
 * @param result - результат парсинга
 * @param code - статус обработки
 * @param error_msg - сообщение об ошибки
 * @tparam T - тип возвращаемого результата парсинга
 */
case class ScrapeResult[+T <: ParseResult](url: String, result: Option[T] = None, code: Int = 0, error_msg: Option[String] = None)


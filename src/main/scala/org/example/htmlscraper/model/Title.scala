package org.example.htmlscraper.model

/**
 * Результат парсинга заголовка html-страницы
 * @param title
 */
case class Title(title: String) extends ParseResult

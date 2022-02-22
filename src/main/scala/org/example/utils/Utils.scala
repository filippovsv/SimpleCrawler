package org.example.utils

import net.liftweb.json.Serialization.write
import net.liftweb.json._

/**
 * Утилиты
 */
object Utils {

  /**
   * Сереализация объекта в json-строку
   * @param obj - объект
   * @tparam T - тип объекта
   * @return json-строка
   */
  // Так я и не разобрался, что сделать с circe, чтобы он нормально сериализовал в json
  def toStringJson[T](obj: T): String = {
    implicit val formats: DefaultFormats.type = DefaultFormats
    write(obj)
  }
}

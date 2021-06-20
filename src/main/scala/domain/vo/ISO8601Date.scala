package com.example
package domain.vo

import java.text.SimpleDateFormat
import java.util.Date

/**
 * ISO8601形式の日付オブジェクト
 * 使用例：
 * {{{
 *   val date: String = ISO8601Date.fromDate(new Date()).toString()
 * }}}
 * @param dateEither
 */
class ISO8601Date private(dateEither: Either[Date, String]) {

  private val FORMAT_ISO8601 = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX"
  private val SIMPLE_DATE_FORMAT = new SimpleDateFormat(FORMAT_ISO8601)

  /**
   * Leftに初期化された日付から文字列に変換する
   * @return
   */
  override def toString(): String = {
    return this.dateEither match {
      case Left(value) => {
        return SIMPLE_DATE_FORMAT.format(value)
      }
      case Right(value) => throw new IllegalArgumentException("Dateインスタンスで初期化してください")
    }
  }

  /**
   * Rightに初期化された日付文字列からDateに変換する
   * @return
   */
  def toDate(): Date = {
    return this.dateEither match {
      case Right(value) => {
        try {
          return SIMPLE_DATE_FORMAT.parse(value)
        } catch {
          case e: Exception => return null
        }
      }
      case Left(value) => throw new IllegalArgumentException("Stringを使って初期化してください")
    }
  }

}


/**
 * ISO8601日付のコンパニオンオブジェクト。
 */
object ISO8601Date {
  /**
   * ファクトリメソッド、Dateで初期化
   * @param date
   * @return
   */
  def fromDate(date: Date): ISO8601Date = {
    return new ISO8601Date(Left(date))
  }

  /**
   * ファクトリメソッド、文字列で初期化
   * @param dateString
   * @return
   */
  def fromString(dateString: String): ISO8601Date = {
    return new ISO8601Date(Right(dateString))
  }
}
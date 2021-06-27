package com.example
package domain.vo

import java.text.SimpleDateFormat
import java.util.{Date, TimeZone}

/**
 * ISO8601形式の日付オブジェクト
 * 使用例：
 * {{{
 *   val date: String = ISO8601Date.fromDate(new Date()).toString()
 * }}}
 * @param dateEither
 */
class ISO8601Date private(dateEither: Either[Date, String]) {

  private val SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
  SIMPLE_DATE_FORMAT.setTimeZone(TimeZone.getTimeZone("Asia/Tokyo"))

  /**
   * Leftに初期化された日付から文字列に変換する
   * @return
   */
  override def toString(): String = {
    return this.dateEither match {
      case Left(value) => {
        return SIMPLE_DATE_FORMAT.format(value)
      }
      case Right(_) => throw new IllegalArgumentException("Dateインスタンスで初期化してください")
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
      case Left(_) => throw new IllegalArgumentException("Stringを使って初期化してください")
    }
  }

  /**
   * 引数とオブジェクトを比較する
   * @param date
   * @return
   */
  def isAfter(date: Date): Boolean = {
    val standard = this.dateEither match {
      case Left(value) => value
      case Right(_) => this.toDate()
    }

    return standard.after(date)
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
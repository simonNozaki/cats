package com.example
package domain.vo

/**
 * 電話番号オブジェクト
 *
 * @param value
 */
class TelephoneNumber (value: String) {

  // 携帯電話正規表現
  private val REGEX_PHONE_NUMBER = "0[789]0-[0-9]{4}-[0-9]{4}$".r
  private val REGEX_INTERNATIONAL_PHONE_NUMBER = "^+[0-9]{1,3}.*$".r

  // 初期化処理
  this.value match {
    case null => throw new IllegalArgumentException("電話番号文字列が空です")
    case _ if !(
      REGEX_PHONE_NUMBER.matches(value) &&
      REGEX_INTERNATIONAL_PHONE_NUMBER.matches(value)
    ) => throw new IllegalArgumentException("電話番号が携帯電話形式ではありません")
  }

  /**
   * 日本の国際電話番号に変換
   * @return
   */
  def toInternationalForJp(): TelephoneNumber = {
    val numberJp = "+81" + this.value.substring(1, this.value.length)
    return new TelephoneNumber(numberJp)
  }

  /**
   * 韓国の国際電話番号に変換
   * @return
   */
  def toInternationalForKr(): TelephoneNumber = {
    val numberJp = "+82" + this.value.substring(1, this.value.length)
    return new TelephoneNumber(numberJp)
  }

  /**
   * アメリカの国際電話番号に変換
   * @return
   */
  def toInternationalForUs(): TelephoneNumber = {
    val numberJp = "+1" + this.value.substring(1, this.value.length)
    return new TelephoneNumber(numberJp)
  }

}

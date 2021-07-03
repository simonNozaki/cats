package com.example
package domain.vo

/**
 * 日本語スラングクラス
 * @param word
 */
class JapaneseSlang private (
                    word: String,
                    emergedAt: Option[ISO8601Date]
                    ) {

  /**
   * 言葉の発生した時期を返す
   * @return
   */
  def getDateEmerged(): Option[ISO8601Date] = {
    return this.emergedAt
  }

  /**
   * 辞書にのるような正式な言葉ではなく、スラングであることを確認する
   * @return
   */
  def isPopular(): Boolean = {
    // たとえば外部の辞書を参照する仕組みを使う
    return true
  }

}


/**
 * 日本語スラングコンパニオンオブジェクト
 */
object JapaneseSlang {

  def of(word: String): JapaneseSlang = {
    return new JapaneseSlang(word, null)
  }

}
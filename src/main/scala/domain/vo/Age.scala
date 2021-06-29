package com.example
package domain.vo

/**
 * 年齢オブジェクト
 * 値クラス
 */
class Age (val value: Int) extends AnyVal {

  // ガード節
  if (this.value < 0) {
    throw new IllegalArgumentException("年齢は0以上でなければなりません")
  }

  /**
   * 1歳年をとる
   * @return
   */
  def getOld(): Age = {
    return new Age(this.value + 1)
  }

}

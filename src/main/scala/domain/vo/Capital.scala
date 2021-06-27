package com.example
package domain.vo

/**
 * 資本金データクラス
 * @param amount
 */
case class Capital (value: BigInt) extends AnyVal {

}

object Capital {
  def apply(amount: BigInt): Capital = {
    // ガード
    if (amount < 1) {
      throw new IllegalArgumentException("会社の設立には1円以上が必要です")
    }
    return new Capital(amount)
  }
}
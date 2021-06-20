package com.example
package domain.vo

/**
 * 貨幣オブジェクト
 * 貨幣価値の貨幣単位における操作を提供する。デフォルトは円。
 */
class Money private (value: Double) {

  /**
   * 指定の貨幣に変換する。 dollar, euro, won, chinaYenが使える。
   * @param currency
   * @return
   */
  def toCurrency(currency: String): Money = {
    return currency match {
      case "dollar" => Money.of(value * CurrencyUnitDollar.rate)
      case "euro" => Money.of(value * CurrencyUnitEuro.rate)
      case "won" => Money.of(value * CurrencyUnitWon.rate)
      case "chinaYen" => Money.of(value * CurrencyUnitChinaYen.rate)
    }
  }

  /**
   * 通貨単位Enum
   */
  sealed abstract class CurrencyUnitEnum {
    /**
     * レート
     */
     val rate: Double
  }

  /**
   * 通貨レート: 中華人民元
   */
  private final case object CurrencyUnitDollar extends CurrencyUnitEnum {
    override val rate: Double = 0.01
  }

  /**
   * 通貨レート: 中華人民元
   */
  private final case object CurrencyUnitWon extends CurrencyUnitEnum {
    override val rate: Double = 10
  }

  /**
   * 通貨レート: 中華人民元
   */
  private final case object CurrencyUnitChinaYen extends CurrencyUnitEnum {
    override val rate: Double = 0.05
  }

  /**
   * 通貨レート: ユーロ
   */
  private final case object CurrencyUnitEuro extends CurrencyUnitEnum {
    override val rate: Double = 0.007
  }
}


/**
 * 貨幣のコンパニオンオブジェクト
 */
object Money {

  /**
   * ファクトリメソッド。
   * @param value
   * @return
   */
  def of(value: Double): Money = new Money(value)

}

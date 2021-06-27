package com.example
package domain.vo

/**
 * 企業オブジェクト。融資、原資といった企業のBSに関する知識を表現する
 * @param id ID エンティティで、ライフサイクルを持つ。
 * @param name
 * @param capital
 * @param foundedAt
 * @param section
 * @param bankruptcy
 */
class Company (
    /** id */
    id: Id,
    /** 企業名 */
    name: String,
    /** 資本金 */
    capital: Capital,
    /** 設立日 */
    foundedAt: ISO8601Date,
    /** 企業区分 */
    section: CompanySectionEnum,
    /** 営業状況 */
    bankruptcy: BankruptcyEnum
) {

  /**
   * 債権者保護の手続きに沿って減資する
   * @param amountDecreased 減資する金額
   * @param applyAt 適用日
   * @return
   */
  def reduceCapital(amountDecreased: BigInt, applyAt: ISO8601Date): Either[Company, Exception] = {
    if (!canBeDecreased()) {
      return Right(new IllegalStateException("債権者保護の手続きに失敗しました"))
    }

    val company = new Company(
      this.id,
      this.name,
      new Capital(amountDecreased),
      this.foundedAt,
      this.section,
      this.bankruptcy
    )

    return Left(company)
  }

  /**
   * 会社を倒産にする
   * @return
   */
  def makeBankrupt(): Company = {
    // 債務の精算手続きをしないといけない、手続きはユースケースで実現するといいかも

    return new Company(
      this.id,
      this.name,
      this.capital,
      this.foundedAt,
      this.section,
      Bankrupt
    )
  }

  private def canBeDecreased(): Boolean = {
    return true
  }

}

/**
 * 営業状況列挙型クラス
 */
sealed abstract class BankruptcyEnum {
  val status: String
}

/**
 * 営業状況: 営業中
 */
private case object Active extends BankruptcyEnum {
  override val status: String = "営業"
}

/**
 * 営業状況: 廃業
 */
private case object BusinessClosed extends BankruptcyEnum {
  override val status: String = "廃業"
}

/**
 * 営業状況: 倒産
 */
private case object Bankrupt extends BankruptcyEnum {
  override val status: String = "倒産"
}
package com.example
package domain.vo

/**
 * 企業区分列挙型クラス
 */
sealed abstract class CompanySectionEnum {
  val value: String
}

/**
 * 企業区分: 株式会社
 */
case object CompanyLimited extends CompanySectionEnum {
  override val value: String = "株式会社"
}

/**
 * 企業区分: 合同会社
 */
case object LimitedLiabilityCompany extends CompanySectionEnum {
  override val value: String = "合同会社"
}

/**
 * 企業区分: 有限会社
 */
case object LimitedCompany extends CompanySectionEnum {
  override val value: String = "有限会社"
}
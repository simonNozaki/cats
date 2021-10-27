package com.example
package domain.vo

import java.util.UUID

/**
 * ID基底トレイト
 * モックできるようファクトリメソッドをインスタンスメソッドに
 */
trait Id {
  /**
   * ランダムなIDで生成する、ファクトリメソッド
   * @return
   */
  def create(): Id

  /**
   * 指定の値でIDを生成する
   * @param value
   * @return
   */
  def create(value: String): Id

  def value(): String
}

/**
 * システム共通IDオブジェクト
 * @param value
 */
class BasicId private (value: String) extends Id {
  override def create(): Id = new BasicId(UUID.randomUUID().toString())

  override def create(value: String): Id = {
    if (value.equals("")) {
      throw new RuntimeException("")
    }
    return new BasicId(value)
  }

  override def value(): String = this.value
}

/**
 * モックIDオブジェクト
 * @param value
 */
class MockId private (value: String) extends Id {
  override def create(): Id = new MockId("1234567890")

  override def create(value: String): Id = new MockId(value)

  override def value(): String = this.value
}
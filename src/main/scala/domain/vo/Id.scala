package com.example
package domain.vo

import java.util.UUID

/**
 * システム共通IDオブジェクト
 * @param value
 */
class Id private (value: String) {
}

/**
 * システム共通IDコンパニオンオブジェクト
 */
object Id {
  def of(): Id = {
    return new Id(UUID.randomUUID().toString)
  }
}
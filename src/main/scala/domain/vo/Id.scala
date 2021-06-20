package com.example
package domain.vo

import java.util.UUID

class Id private (value: String) {
}

object Id {
  def of(): Id = {
    return new Id(UUID.randomUUID().toString)
  }
}
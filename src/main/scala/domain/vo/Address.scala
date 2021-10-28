package com.example
package domain.vo

import context.exception.ValueException

/**
 * 郵便番号値オブジェクト
 *
 * @param value ハイフン抜き郵便番号文字列
 */
class Zip private(value: String) {
  if (this.value.isEmpty) {
    throw new ValueException("郵便番号が空です")
  }
  if (this.value.length != 7) {
    throw new ValueException(s"郵便番号の桁数が不正です, 値 => $value")
  }
}

/**
 * 都道府県・市区町村値オブジェクト
 * @param value
 */
class City private(value: String) {
  if (this.value.isEmpty) {
    throw new ValueException("都道府県、もしくは市区町村が空です")
  }
}

/**
 * 住所値オブジェクト
 * @param zip
 * @param city
 */
class Address private(zip: Zip, city: City) {

}

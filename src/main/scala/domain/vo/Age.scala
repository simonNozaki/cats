package domain.vo

/**
 * 年齢に関する知識を表現する。
 * @param value
 */
class Age (value: Int) {

  // ガード
  if (this.value < 0) {
    throw new IllegalArgumentException("年齢は0歳以上です。")
  }

  def getOld(): Age = {
    return new Age(this.value + 1)
  }

}

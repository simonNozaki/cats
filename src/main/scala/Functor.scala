package com.example

/**
 * 関手基底トレイト
 */
trait Functor[F[_]] {

  /**
   * 圏AからBへの関手
   * @param f 射
   * @tparam A マップ元の圏
   * @tparam B マップ先の圏
   * @return
   */
  def map[A, B](f: A => B): F[A] => F[B]

  /**
   * 恒等射を返す
   * @tparam A 圏
   * @return
   */
  def identity[A]: A => A = v => v

}

/**
 * リスト関手
 */
object ListFunctor extends Functor[List] {
  /**
   * 圏AからBへの関手
   *
   * @param f 射
   * @tparam A マップ元の圏
   * @tparam B マップ先の圏
   * @return
   */
  override def map[A, B](f: A => B): List[A] => List[B] = _.map(f)
}

/**
 * Maybe関手
 */
object OptionFunctor extends Functor[Option] {
  override def map[A, B](f: A => B): Option[A] => Option[B] = _.map(f)
}

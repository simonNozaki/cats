package com.example

object Main extends App {

  // 元の圏の射
  val arrowLength: String => Int = _.length()
  val arrowToDouble: Int => Double = _.toDouble

  // 関手によって写される射
  val mappedArrowLength: List[String] => List[Int] = ListFunctor.map(arrowLength)
  val mappedArrowToDouble: List[Int] => List[Double] = ListFunctor.map(arrowToDouble)

  // 射の合成
  val composition = arrowToDouble compose arrowLength

  // 恒等射
  val arrowIdentity = identity(arrowLength)

}

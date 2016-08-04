package com.fuyun.scala.steel.bar.cut

/**
  * Created by bl05959 on 2016/8/4.
  */
trait MaxPrice {
  val p = Array(0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30).toSeq
  def cutMaxPrice(n: Int): Int
}

package com.fuyun.scala.steel.bar.cut

/**
  * Created by bl05959 on 2016/8/4.
  */
object B2T extends MaxPrice {

  override def cutMaxPrice(n: Int): Int = {
    val memo = Array.fill(n + 1)(0)
    (1 to n).foreach { i =>
      val max = (1 to i.min(p.size - 1)).map(j => memo(i - j) + p(j)).max
      memo(i) = max
    }
    memo(n)
  }
}

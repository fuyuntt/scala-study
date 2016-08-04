package com.fuyun.scala.steel.bar.cut

/**
  * Created by bl05959 on 2016/8/4.
  */
object Recursion extends MaxPrice {


  override def cutMaxPrice(n: Int): Int = {
    val memo = Array.fill(n + 1)(-1)
    memo(0) = 0
    def maxPrice(n: Int): Int = {
      if (memo(n) != -1)
        memo(n)
      else {
        val max = Range(1, Math.min(n + 1, p.size))
          .map(cut => p(cut) + maxPrice(n - cut))
          .max
        memo(n) = max
        max
      }
    }
    maxPrice(n)
  }
}

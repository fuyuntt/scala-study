package com.fuyun.scala

/**
  * Created by bl05959 on 2016/6/8.
  */

object CutMaxPrice {
  val p = Array(0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30).toSeq
  val memo = Array.fill(50)(-1)
  memo(0) = 0

  def cutMaxPrice(n: Int): Int = {
    if (memo(n) != -1)
      memo(n)
    else {
      val max = Range(1, Math.min(n + 1, p.size))
        .map(cut => p(cut) + cutMaxPrice(n - cut))
        .max
      memo(n) = max
      max
    }
  }

  def main(args: Array[String]): Unit = {
    val startTime = System.currentTimeMillis()
    println(cutMaxPrice(40))
    println(System.currentTimeMillis() - startTime)
    println(s"premisec: ${156050}")
  }
}

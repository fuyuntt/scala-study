package com.fuyun.scala.steel.bar.cut

/**
  * Created by bl05959 on 2016/6/8.
  */

object CutMaxPrice {
  def time(t1:Long, t2: Long): String = {
    f"${(t2 - t1).toDouble / 1000000}%6.6f ms"
  }
  def main(args: Array[String]): Unit = {
    val n = 401
    val t1 = System.nanoTime()
    val v1 = Recursion.cutMaxPrice(n)
    val t2 = System.nanoTime()
    val v2 = B2T.cutMaxPrice(n)
    val t3 = System.nanoTime()

    println(s"res1: $v1, time1: ${time(t1, t2)}")
    println(s"res2: $v2, time2: ${time(t2, t3)}")
  }
}

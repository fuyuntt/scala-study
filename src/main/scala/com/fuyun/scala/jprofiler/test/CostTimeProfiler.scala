package com.fuyun.scala.jprofiler.test

/**
  * Created by bl05959 on 2016/8/3.
  */
class CostTimeProfiler(points: String*) {
  private val len = points.size
  private val checkPoints = Array.ofDim[Long](len - 1)
  private var startTimes = 0
  private var index = 0
  private var preTime = 0L

  def start(): Unit = {
    preTime = System.nanoTime()
    index = 0
    startTimes += 1
  }

  def check(symbol: Any*): Unit = {
    val now = System.nanoTime()
    checkPoints(index) += now - preTime
    index += 1
    preTime = now
  }

  def statistics(): String = {
    val detail = points.zipWithIndex
      .flatMap { case (point, i) =>
        val lit = List(point)
        if (i < len - 1)
          List(point, f"(${checkPoints(i).toDouble / 1000000}%6.6f ms)")
        else
          lit
      }
      .mkString(" ")
    s"times: $startTimes \ndetail: $detail"
  }

  def reset(): Unit = {
    (0 until(len - 1)).foreach(checkPoints(_) = 0)
    startTimes = 0
  }
}

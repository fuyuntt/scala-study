package com.fuyun.scala.jprofiler.test

/**
  * Created by bl05959 on 2016/8/3.
  */
object RedisProfile {
  def main(args: Array[String]): Unit = {
    val s = (m: Int) => m * 2
    s.getClass.getInterfaces.foreach(println)
  }
}

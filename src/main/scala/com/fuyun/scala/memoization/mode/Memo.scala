package com.fuyun.scala.memoization.mode

import collection.mutable

/**
  * Created by bl05959 on 2016/8/12.
  */
object Memo {
  def memoFunc[I, O](func: I => O): I => O = {
    val memo = mutable.Map[I, O]()
    (input: I) => {
      memo.getOrElseUpdate(input, func(input))
    }
  }

  def consumeTime(m: Int): Int = {
    Thread.sleep(1000)
    m * 3
  }

  def main(args: Array[String]) {
    val fun = memoFunc(consumeTime)
    println(fun(1))
    println(fun(2))
    println(fun(1))
    println(fun(3))
    val st = Stream.from(0)
    st.map(_ * 3)
      .take(10)
      .foreach(println)
  }
}

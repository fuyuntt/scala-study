package com.fuyun.scala.jprofiler.test

/**
  * Created by bl05959 on 2016/8/3.
  */
object RedisProfile {
  def main(args: Array[String]) {
    val profiler = new CostTimeProfiler("fuyun", "liulei", "duanqiao")

    profiler.start()
    profiler.check()
    new String("abc")
    val start = System.nanoTime()
    profiler.check()
    profiler.start()
    profiler.check()
    profiler.check()
    val stop = System.nanoTime()
    println(profiler.statistics())
    println(stop - start)
//    val jedis = new Jedis("storm1")
//    jedis.auth("800best@com")
//
//    jedis.set("test:fuyun", "fuyun is smarter")
//
//    (1 to 100).foreach { _ =>
//      jedis.get("test:fuyun")
//      Array.fill(16, 16, 16)(0)
//    }
  }
}

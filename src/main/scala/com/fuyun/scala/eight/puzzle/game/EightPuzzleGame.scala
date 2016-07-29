package com.fuyun.scala.eight.puzzle.game

import scala.collection.mutable

/**
  * Created by bl05959 on 2016/7/27.
  */
object EightPuzzleGame {
  val rules = List(Rules.left, Rules.right, Rules.up, Rules.down)
  val start = State(Seq(2, 8, 3, 1, 6, 4, 7, 0, 5), 2, 1, null)
  val end = State(Seq(1, 2, 3, 8, 0, 4, 7, 6, 5), 1, 1, null)

  val db = mutable.Set(start)
  val queue = mutable.Queue[State]()

  def search(start: State, stop: State): List[State] = {
    queue.enqueue(start)
    while (queue.nonEmpty) {
      val u = queue.dequeue()
      val finds = rules
        .filter(_.condition(u))
        .map(_.trans(u))
        .filterNot(db)
      if (finds.contains(end)) {
        val last = finds.find(_ == end).get
        var route = List(last)
        var pre = last.pre
        while (pre != null) {
          route = pre :: route
          pre = pre.pre
        }
        return route
      }
      db ++= finds
      queue ++= finds
    }
    Nil
  }

  def main(args: Array[String]): Unit = {
//    db += start.right.left
//    println(db)
//    val s = Seq("a", "b")
//    println(s)
//    val arr = s.toArray
//    arr(1) = "2"
//    println(s)
    println(search(start, end))
  }

}


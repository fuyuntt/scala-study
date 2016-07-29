package com.fuyun.scala.eight.puzzle.game

import scala.collection.mutable

/**
  * Created by bl05959 on 2016/7/27.
  */
object EightPuzzleGame {
  val rules = List(Rules.left, Rules.right, Rules.up, Rules.down)
  val start = State(IndexedSeq(2, 8, 3, 1, 6, 4, 7, 0, 5), 2, 1, null)
  val end = State(IndexedSeq(1, 2, 3, 8, 0, 4, 7, 6, 5), 1, 1, null)

  val db = mutable.Set(start)
  val queue = mutable.Queue[State]()

  def search(start: State, stop: State): List[State] = {
    queue.enqueue(start)
    while (queue.nonEmpty) {
      val u = queue.dequeue()
      val matchingRule = rules.filter(_.condition(u))
      val transRes = matchingRule.map(_.trans(u))
      val newFind = transRes.filterNot(db)
      if (newFind.contains(end)) {
        val last = newFind.find(_ == end).get
        var route = List(last)
        var pre = last.pre
        while (pre != null) {
          route = pre :: route
          pre = pre.pre
        }
        return route
      }
      db ++= newFind
      queue ++= newFind
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
    search(start, end).foreach(println)
  }

}


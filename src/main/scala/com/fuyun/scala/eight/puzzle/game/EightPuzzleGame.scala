package com.fuyun.scala.eight.puzzle.game

import scala.annotation.tailrec
import scala.collection.mutable
import mutable.Queue

/**
  * Created by bl05959 on 2016/7/27.
  */
object EightPuzzleGame {
  val rules = Set(Rules.left, Rules.right, Rules.up, Rules.down)
  val start = State(IndexedSeq(2, 8, 3, 1, 6, 4, 7, 0, 5), 2, 1, null)
  val end = State(IndexedSeq(1, 2, 3, 8, 0, 4, 7, 6, 5), 1, 1, null)


  def search(start: State, stop: State): List[State] = {
    val db = mutable.Set(start)
    val queue = mutable.Queue(start)
    @tailrec def findPath(): State = {
      if (queue.isEmpty)
        return null
      val u = queue.dequeue
      val newStates = rules.filter(_.condition(u))
        .map(_.trans(u))
        .filterNot(db)
      db ++= newStates
      queue ++= newStates
      val res = newStates.find(_ == end)
      if (res.isDefined)
        res.get
      else
        findPath()
    }
    @tailrec def toList(tail: List[State]): List[State] = {
      val pre = tail.head.pre
      if (pre == null)
        tail
      else
        toList(pre :: tail)
    }
    val state = findPath()
    toList(List(state))
  }

  def main(args: Array[String]): Unit = {
    search(start, end).foreach(println)
  }

}


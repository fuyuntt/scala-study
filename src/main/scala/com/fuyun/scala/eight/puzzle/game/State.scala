package com.fuyun.scala.eight.puzzle.game

/**
  * Created by bl05959 on 2016/7/28.
  */
class State(val matrix: Seq[Int], val i0: Int, val j0: Int, val pre: State) {
  assert(this (i0, j0) == 0)

  override def toString: String = {
    matrix.sliding(3, 3).map(_.mkString("  ")).mkString("", "\n", "\n")
  }

  override def equals(o: Any): Boolean = {
    o.isInstanceOf[State] && o.asInstanceOf[State].matrix == matrix
  }

  override def hashCode = matrix.##

  def apply(i: Int, j: Int): Int = {
    matrix(index(i, j))
  }

  private def index(i: Int, j: Int): Int = {
    i * 3 + j
  }

  def left: State = {
    val arr = matrix.toArray
    arr(index(i0, j0)) = this (i0, j0 - 1)
    arr(index(i0, j0 - 1)) = 0
    State(arr.toSeq, i0, j0 - 1, this)
  }

  def right: State = {
    val arr = matrix.toArray
    arr(index(i0, j0)) = this (i0, j0 + 1)
    arr(index(i0, j0 + 1)) = 0
    State(arr.toSeq, i0, j0 + 1, this)
  }

  def up: State = {
    val arr = matrix.toArray
    arr(index(i0, j0)) = this (i0 - 1, j0)
    arr(index(i0 - 1, j0)) = 0
    State(arr.toSeq, i0 - 1, j0, this)
  }

  def down: State = {
    val arr = matrix.toArray
    arr(index(i0, j0)) = this (i0 + 1, j0)
    arr(index(i0 + 1, j0)) = 0
    State(arr.toSeq, i0 + 1, j0, this)
  }
}
object State {
  def apply(matrix: Seq[Int], i0: Int, j0: Int, pre: State): State = new State(matrix, i0, j0, pre)
}

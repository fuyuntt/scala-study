package com.fuyun.scala.eight.puzzle.game

/**
  * Created by bl05959 on 2016/7/28.
  */
trait Rule {
  override def toString = this.getClass.getSimpleName

  def condition(state: State): Boolean

  def trans(state: State): State
}

object Rules {
  object left extends Rule {
    override def trans(state: State): State = {
      state.left
    }

    override def condition(state: State): Boolean = {
      state.j0 >= 1
    }
  }
  object right extends Rule {
    override def trans(state: State): State = {
      state.right
    }

    override def condition(state: State): Boolean = {
      state.j0 <= 1
    }
  }
  object up extends Rule {
    override def trans(state: State): State = {
      state.up
    }

    override def condition(state: State): Boolean = {
      state.i0 >= 1
    }
  }
  object down extends Rule {
    override def trans(state: State): State = {
      state.down
    }

    override def condition(state: State): Boolean = {
      state.i0 <= 1
    }
  }
}

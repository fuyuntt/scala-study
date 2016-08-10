package com.fuyun.scala.self.annotation

/**
  * Created by lk-fuyun on 2016/8/8.
  */
abstract class Graph {
  type Edge
  type Node <: NodeIntf
  abstract class NodeIntf {
    def connectWith(node: Node): Edge
  }
  def nodes: List[Node]
  def edges: List[Equiv]
  def addNode: Node
}

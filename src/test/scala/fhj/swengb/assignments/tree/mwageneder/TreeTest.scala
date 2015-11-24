package fhj.swengb.assignments.tree.mwageneder

import fhj.swengb.assignments.tree.mwageneder.{MathUtil, L2D, Graph}
import org.junit.Assert._
import org.junit.Test

import scala.util.Try

/**
  * Test fixtures for the tree assignment
  */
class TreeTest {

  import Graph._

  private val rootNode: Tree[L2D] = Node(L2D(Pt2D(0.0, 0.0), Pt2D(100, 0.0), colorMap(0)))

  private val treeOfSize1: Branch[L2D] = Branch(
    rootNode,
    Branch(
      Node(L2D(Pt2D(100.0, 0.0), Pt2D(199.985, -1.745), colorMap(0))),
      Node(L2D(Pt2D(100.0, 0.0), Pt2D(199.985, 1.745), colorMap(0)))))
  /*
    Branch(
      Node(L2D(Pt2D(199.985, 1.745), Pt2D(299.985, 1.745), colorMap(1))),
      Node(L2D(Pt2D(199.985, 1.745), Pt2D(299.924, 5.235), colorMap(1))))
      */



  @Test def testRound(): Unit = {
    assertEquals(0.001, MathUtil.round(0.001232), 0.0)
    assertEquals(0.002, MathUtil.round(0.001532), 0.0)
    assertEquals(1.339, MathUtil.round(1.339), 0.0)
  }

  @Test def treeSize0(): Unit = {
    val t: Tree[L2D] = Graph.mkGraph(Pt2D(0, 0), 0, 100, 0, 1, 0)
    assertEquals(rootNode, t)
  }

  /**
    * tree is illegal since the depth is too high
    */
  @Test def illegalTree(): Unit = {
    assertTrue(Try(Graph.mkGraph(Pt2D(0, 0), 0, 100, 17, 1, 0)).isFailure)
  }

  @Test def treeSize1(): Unit = {
    val t: Tree[L2D] = Graph.mkGraph(Pt2D(0, 0), 0, 100, 1, 1, 1)
    assertEquals(
      treeOfSize1, t)
  }

  @Test def treeSize2(): Unit = {
    val t: Tree[L2D] = Graph.mkGraph(Pt2D(0, 0), 0, 100, 2, 1, 1)
    assertEquals(
      Branch(Node(L2D(Pt2D(0.0, 0.0), Pt2D(100.0, 0.0), colorMap(0))), Branch(Branch(Node(L2D(Pt2D(100.0, 0.0), Pt2D(199.985, -1.745), colorMap(0))), Branch(Node(L2D(Pt2D(199.985, -1.745), Pt2D(299.924, -5.235), colorMap(1))), Node(L2D(Pt2D(199.985, -1.745), Pt2D(299.985, -1.745), colorMap(1))))), Branch(Node(L2D(Pt2D(100.0, 0.0), Pt2D(199.985, 1.745), colorMap(0))), Branch(Node(L2D(Pt2D(199.985, 1.745), Pt2D(299.985, 1.745), colorMap(1))), Node(L2D(Pt2D(199.985, 1.745), Pt2D(299.924, 5.235), colorMap(1))))))), t)
  }

  @Test def testTraverse(): Unit = {
    val seqs: Seq[L2D] = Graph.traverse(treeOfSize1)(l2d => l2d)
    assertEquals(3, seqs.size)

    val expected =
      List(
        L2D(Pt2D(0.0, 0.0), Pt2D(100.0, 0.0), colorMap(0)),
        L2D(Pt2D(100.0, 0.0), Pt2D(199.985, -1.745), colorMap(0)),
        L2D(Pt2D(100.0, 0.0), Pt2D(199.985, 1.745), colorMap(0)))
    assertEquals(expected, seqs)

    expected.foreach {
      l2d => assertTrue(seqs.contains(l2d))
    }

  }

}

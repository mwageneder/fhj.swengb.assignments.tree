package fhj.swengb.assignments.tree.mwageneder

import javafx.scene.paint.Color

import org.junit.Assert._
import org.junit.Test

/**
  * Created by lad on 20.09.15.
  */
class L2DTest {

  val epsilon: Double = 0.00000000001

  @Test def testLength(): Unit = {
    assertEquals(1.0, L2D(Pt2D(0, 0), Pt2D(0, 1), Color.GREEN).length, 0.000001)
    assertEquals(1.0, L2D(Pt2D(0, 0), Pt2D(0, -1), Color.GREEN).length, 0.000001)
    assertEquals(1.0, L2D(Pt2D(0, 0), Pt2D(1, 0), Color.GREEN).length, 0.000001)
    assertEquals(1.0, L2D(Pt2D(0, 0), Pt2D(-1, 0), Color.GREEN).length, 0.000001)
    assertEquals(1.4142135623730951, L2D(Pt2D(0, 0), Pt2D(1, 1), Color.GREEN).length, 0.000001)
  }


           /*
  def areSomewhatEqual(a: L2D, b: L2D): Boolean = {
    def areSomewhatEqual(a: Pt2D, b: Pt2D): Boolean = {
      Math.abs(a.x - b.x) < epsilon && Math.abs(a.y - b.y) < epsilon
    }
    areSomewhatEqual(a.start, b.start) && areSomewhatEqual(a.end, b.end)
  }      */

  @Test
  def testAngles(): Unit = {
    assertEquals(0, L2D(Pt2D(0, 0), Pt2D(1, 0), Color.GREEN).angle, epsilon)
    assertEquals(45, L2D(Pt2D(0, 0), Pt2D(1, 1), Color.GREEN).angle, epsilon)
    assertEquals(90, L2D(Pt2D(0, 0), Pt2D(0, 1), Color.GREEN).angle, epsilon)
    assertEquals(135, L2D(Pt2D(0, 0), Pt2D(-1, 1), Color.GREEN).angle, epsilon)
    assertEquals(180, L2D(Pt2D(0, 0), Pt2D(-1, 0), Color.GREEN).angle, epsilon)
    assertEquals(225, L2D(Pt2D(0, 0), Pt2D(-1, -1), Color.GREEN).angle, epsilon)
    assertEquals(270, L2D(Pt2D(0, 0), Pt2D(0, -1), Color.GREEN).angle, epsilon)
    assertEquals(315, L2D(Pt2D(0, 0), Pt2D(1, -1), Color.GREEN).angle, epsilon)

  }

  @Test def doesConstructorOfL2Dwork(): Unit = {
    val o = Pt2D(0, 0)
    assertEquals(L2D(o, Pt2D(1, 0), Color.GREEN), L2D(o, 0, 1, Color.GREEN))
    assertEquals(L2D(o, Pt2D(0, 1), Color.GREEN), L2D(o, 90, 1, Color.GREEN))
    assertEquals(L2D(o, Pt2D(-1, 0), Color.GREEN), L2D(o, 180, 1, Color.GREEN))
    assertEquals(L2D(o, Pt2D(0, -1), Color.GREEN), L2D(o, -90, 1, Color.GREEN))
  }

}

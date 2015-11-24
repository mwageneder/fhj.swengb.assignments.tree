package fhj.swengb.assignments.tree.mwageneder


/**
  * Created by lad on 09.11.15.
  */
case class Pt2D(ax: Double, ay: Double) {
  lazy val x = MathUtil.round(ax)
  lazy val y = MathUtil.round(ay)

  lazy val normed = Pt2D(x, y)
}

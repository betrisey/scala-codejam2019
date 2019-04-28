package CodeJam2019.Round1B.ManhattanCrepeCart

import scala.util.Random

object Generate {
  def main(args: Array[String]): Unit = {
    val q = 100000
    val p = 500
    val cartLocation = randomLocation(q)
    println(s"Cart location: ${cartLocation._1} ${cartLocation._2}")
    println()
    println(1) // 1 test case
    println(p + " " + q)
    for (i <- 1 to 500) {
      val (x, y) = randomLocation(q)
      val dx = cartLocation._1 - x
      val dy = cartLocation._2 - y
      var dir = 'N'
      if (Math.abs(dx) > Math.abs(dy)) {
        // move along x axis
        dir = if (dx > 0) 'E' else 'W'
      } else {
        // move along y axis
        dir = if (dy > 0) 'N' else 'S'
      }

      println(s"$x $y $dir")
    }
  }

  def randomLocation(q: Int): (Int, Int) = (Random.nextInt(q+1), Random.nextInt(q+1))
}

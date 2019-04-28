package CodeJam2019.Round1B.ManhattanCrepeCart

import scala.io.StdIn

object Solution {
  def main(args: Array[String]): Unit = {

    for (i <- 1 to StdIn.readLine.toInt) {
      val Array(n, k) = StdIn.readLine.split(' ').map(_.toInt)
      val cs = StdIn.readLine.split(' ').map(_.toInt)
      val ds = StdIn.readLine.split(' ').map(_.toInt)

      var answer = 0

      for (l <- 1 to n;
           r <- l to n) {
        val diff = Math.abs(cs.slice(l-1, r).max - ds.slice(l-1, r).max) // -1 because 0-indexed
        if (diff <= k) answer += 1
      }

      println(s"Case #$i: ${answer}")
    }
  }
}

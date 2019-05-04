package CodeJam2019.Round1C.BacterialTactics

import scala.io.StdIn
import scala.collection.mutable.Set

object Solution {
  def main(args: Array[String]): Unit = {

    for (i <- 1 to StdIn.readLine.toInt) {
      val Array(r, c) = StdIn.readLine.split(' ').map(_.toInt)
      val matrix = (0 until r).map(_ => StdIn.readLine.toCharArray.map(_ == '#')).toArray

      val answer = 0

      println(s"Case #$i: $answer")
    }
  }
}

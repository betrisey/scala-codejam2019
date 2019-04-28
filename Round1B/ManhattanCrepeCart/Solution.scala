package CodeJam2019.Round1B.ManhattanCrepeCart

import scala.io.StdIn

object Solution {
  def main(args: Array[String]): Unit = {

    for (i <- 1 to StdIn.readLine.toInt) {
      val Array(p, q) = StdIn.readLine.split(' ').map(_.toInt)
      val people = (0 until p).map(_ => {
        val line = StdIn.readLine.split(' ')
        Person(line(0).toInt, line(1).toInt, line(2).head)
      }).toList

      val rows = Array.ofDim[Int](q + 1)
      val cols = Array.ofDim[Int](q + 1)

      for (person <- people) {
        person.direction match {
          case 'N' => for(r <- q until person.y by -1) rows(r) += 1
          case 'S' => for(r <- 0 until person.y) rows(r) += 1
          case 'E' => for(r <- q until person.x by -1) cols(r) += 1
          case 'W' => for(r <- 0 until person.x) cols(r) += 1
        }
      }

      var max = -1
      var maxPos = (0, 0)
      for (x <- 0 to q;
           y <- 0 to q) {
        val sum = cols(x) + rows(y)
        if (sum > max || (sum == max && ((x < maxPos._1) || (x == maxPos._1 && y < maxPos._2)))) {
          max = sum
          maxPos = (x, y)
        }
      }

      println(s"Case #$i: ${maxPos._1} ${maxPos._2}")
    }
  }

  case class Person(x: Int, y: Int, direction: Char)
}

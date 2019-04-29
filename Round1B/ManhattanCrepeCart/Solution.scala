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

      val x = cols.zipWithIndex.maxBy(_._1)._2
      val y = rows.zipWithIndex.maxBy(_._1)._2

      println(s"Case #$i: $x $y")
    }
  }

  case class Person(x: Int, y: Int, direction: Char)
}

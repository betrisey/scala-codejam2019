package CodeJam2019.Qualification.Foregone

import scala.io.StdIn

object Solution {
  def main(args: Array[String]): Unit = {
    for (i <- 1 to StdIn.readLine.toInt) {
      val n = StdIn.readLine.dropWhile(_ == '0')

      val a = StringBuilder.newBuilder
      val b = StringBuilder.newBuilder
      n.map{ x =>
        if (x == '4') {
          a.append('2')
          b.append('2')
        } else {
          a.append(x)
          if (b.nonEmpty) b.append('0')
        }
      }

      if (a.isEmpty) a.append('0')
      if (b.isEmpty) b.append('0')

      val answer = a.toString + " " + b.toString

      println(s"Case #$i: $answer")
    }
  }
}

package CodeJam2019.Qualification.YouCanGoYourOwnWay

import scala.io.StdIn

object Solution {
  def main(args: Array[String]): Unit = {
    for (i <- 1 to StdIn.readLine.toInt) {
      StdIn.readLine
      val answer = StdIn.readLine.map(x => if (x == 'S') 'E' else 'S')
      println(s"Case #$i: $answer")
    }
  }
}

package CodeJam2019.Round1B.Draupnir

import scala.io.StdIn

object Solution {
  def main(args: Array[String]): Unit = {
    val Array(t, w) = StdIn.readLine.split(' ').map(_.toInt)
    for (_ <- 1 to t) {

      val rings = Array.ofDim[Int](6)

      val w1 = askWell(1)
      val w2 = askWell(2)
      val w3 = askWell(3)
      val w4 = askWell(4)
      val w5 = askWell(5)
      val w6 = askWell(6)

      rings(0) = (4 * w1 - 4 * w2 - 2 * w3 + 0 * w4 + 0 * w5 + 1 * w6) / 40
      rings(1) = (-48 * w1 + 48 * w2 + 4 * w3 + 0 * w4 + 0 * w5 - 2 * w6) / 40
      rings(2) = (-16 * w1 - 24 * w2 + 48 * w3 + 0 * w4 + 0 * w5 - 4 * w6) / 40
      rings(3) = (64 * w1 - 64 * w2 - 32 * w3 + 40 * w4 + 0 * w5 - 4 * w6) / 40
      rings(4) = (-64 * w1 + 64 * w2 + 32 * w3 - 40 * w4 + 40 * w5 - 16 * w6) / 40
      rings(5) = (96 * w1 - 16 * w2 - 48 * w3 + 0 * w4 - 40 * w5 + 24 * w6) / 40

      println(rings.mkString(" "))
      Console.flush
      if (StdIn.readLine.toInt == -1) System.exit(0)
    }
  }

  def askWell(day: Int): Int = {
    println(day)
    scala.Console.flush
    val response = StdIn.readLine.toInt
    if (response == -1) System.exit(0)
    response
  }
}

/*
A =   2  1 1 1 1 1
      4  2 1 1 1 1
      8  2 2 1 1 1
      16 4 2 2 1 1
      32 4 2 2 2 1
      64 8 4 2 2 2

A*x=b
x=(ring1, ring2, ..., ring6)
b=(day1, day2, ..., day6)

b=A^(-1)*b
*/

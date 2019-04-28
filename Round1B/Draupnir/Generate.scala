package CodeJam2019.Round1B.Draupnir

import scala.io.StdIn

object Generate {
  def main(args: Array[String]): Unit = {
    val mod = BigInt(2).pow(63)
    print("Rings: ")
    val rings = StdIn.readLine.split(' ').map(_.toInt)
    println()
    while (true) {
      print("Day: ");
      val day = StdIn.readLine().toInt
      val res = (1 to 6).map(i => (BigInt(2).pow(day/i) * rings(i-1)) % mod)
      println(res.mkString(" "))
      println(res.sum % mod)
      println()
    }
  }
}

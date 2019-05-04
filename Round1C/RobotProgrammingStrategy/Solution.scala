package CodeJam2019.Round1C.RobotProgrammingStrategy

import scala.io.StdIn
import scala.collection.mutable.Set

object Solution {
  def main(args: Array[String]): Unit = {

    for (i <- 1 to StdIn.readLine.toInt) {
      val a = StdIn.readLine.toInt
      val adversaries = (0 until a).map(_ => StdIn.readLine.toCharArray).to[Set]

      val sb = StringBuilder.newBuilder
      var moveIndex = 0
      var finished = false
      val lengths = adversaries.map(_.length).toList
      val limit = lcm(lengths)*2+1 // TODO find correct limit, lcm(lengths)+1?
      while (adversaries.nonEmpty && moveIndex < limit && !finished) {
        val x = adversaries.map(x => x(moveIndex % x.length)).toList.distinct

        if (x.length == 1) {
          sb.append(winAgainst(x(0)))
          finished = true
        } else if (x.length == 2) {
          if (winAgainst(x(0)) == x(1)) {
            sb.append(x(1))
            adversaries --= adversaries.filter(y => y(moveIndex % y.length) == x(0))
          } else {
            sb.append(x(0))
            adversaries --= adversaries.filter(y => y(moveIndex % y.length) == x(1))
          }
          moveIndex += 1
        } else {
          sb.clear()
          sb.append("IMPOSSIBLE")
          finished = true
        }
      }

      if (moveIndex == limit)
        println(s"Case #$i: IMPOSSIBLE")
      else
        println(s"Case #$i: ${sb.toString}")
    }
  }

  def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  def lcm(numbers: List[Int]): Int = {
    def lcm(a: Int, b: Int): Int = {
      val g = gcd(a, b)
      if (g == 0) 0 else a * b / g
    }
    numbers reduce lcm
  }

  def winAgainst(a: Char): Char = a match {
      case 'R' => 'P'
      case 'P' => 'S'
      case 'S' => 'R'
  }
}

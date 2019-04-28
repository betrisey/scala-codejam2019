package CodeJam2019.Qualification.DatBae

import scala.collection.mutable
import scala.io.StdIn

object Solution {
  def main(args: Array[String]): Unit = {
    for (_ <- 1 to StdIn.readLine.toInt) {
      //val n = Random.nextInt(1024) + 1
      //val brokenIndexTest = Seq.fill(Random.nextInt(16))(Random.nextInt(n)).toList.sorted.distinct

      def testStore(test: Array[Boolean]): Array[Boolean] = {
        //test.zipWithIndex.filterNot(x => brokenIndexTest.contains(x._2)).map(_._1)
        println(test.map(if (_) '1' else '0').mkString)
        scala.Console.flush
        StdIn.readLine.toCharArray.map(_ == '1')
      }

      val Array(n, b, f) = StdIn.readLine.split(" ").map(_.toInt)

      // Generate
      // 1 -> 01010101...
      // 2 -> 00110011...
      // 3 -> 00001111...
      // ...
      val resMap = Iterator.iterate(1)(_ * 2).take(5)
        .map(i => i -> testStore((0 until n).map(_ / i % 2 != 0).toArray))
        .toMap

      val brokenSet = mutable.TreeSet.empty[Int]

      def addInBroken(start: Int, length: Int, missing: Int, level: Int): Unit = {
        if (missing == 0) return
        if (level == 1) {
          val index = brokenSet.size + start
          if (index < n) brokenSet += brokenSet.size + start
        } else {
          val subList = resMap(level / 2).drop(start).take(length)
          val zeros = subList.count(_ == false)
          val ones = subList.length - zeros

          addInBroken(start, zeros, level / 2 - zeros, level / 2)
          addInBroken(start + zeros, ones, level / 2 - ones, level / 2)
        }
      }

      var drop = 0
      val last = Math.ceil(n / 16.0).toInt
      for (j <- 0 until last) {
        val remaining = resMap(16).drop(drop).takeWhile(x => x == (j % 2 != 0)).length
        val required = if (j == last && n % 16 != 0) n else 16
        addInBroken(drop, remaining, required - remaining, 16)
        drop += remaining
      }

      println(brokenSet.toList.sorted.mkString(" "))
      Console.flush
      if (StdIn.readLine.toInt == -1) System.exit(0)
    }
  }
}

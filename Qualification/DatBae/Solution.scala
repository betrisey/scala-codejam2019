package CodeJam2019.Qualification.DatBae

import scala.collection.mutable
import scala.io.StdIn

object Solution {
  def main(args: Array[String]): Unit = {
    for (i <- 1 to StdIn.readLine.toInt) {
      //val n = Random.nextInt(1024) + 1
      //val brokenIndexTest = Seq.fill(Random.nextInt(16))(Random.nextInt(n)).toList.sorted.distinct

      def testStore(test: Array[Boolean]): Array[Boolean] = {
        //test.zipWithIndex.filterNot(x => brokenIndexTest.contains(x._2)).map(_._1)
        println(test.map(if (_) '1' else '0').mkString)
        scala.Console.flush
        StdIn.readLine.toCharArray.map(_ == '1')
      }

      val Array(n, b, f) = StdIn.readLine.split(" ").map(_.toInt)

      val test1 = (0 until n).map(_ % 2 != 0).toArray
      val test2 = (0 until n).map(_ / 2 % 2 != 0).toArray
      val test4 = (0 until n).map(_ / 4 % 2 != 0).toArray
      val test8 = (0 until n).map(_ / 8 % 2 != 0).toArray
      val test16 = (0 until n).map(_ / 16 % 2 != 0).toArray

      val res1 = testStore(test1)
      val res2 = testStore(test2)
      val res4 = testStore(test4)
      val res8 = testStore(test8)
      val res16 = testStore(test16)

      val resMap = Map(16 -> res16, 8 -> res8, 4 -> res4, 2 -> res2, 1 -> res1)
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
        val remaining = res16.drop(drop).takeWhile(x => x == (j % 2 != 0)).length
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

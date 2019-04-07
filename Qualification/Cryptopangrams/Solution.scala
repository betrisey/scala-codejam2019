package CodeJam2019.Qualification.Cryptopangrams

import scala.io.StdIn

object Solution {
  def main(args: Array[String]): Unit = {
    import scala.collection.mutable.{MutableList, TreeSet}

    for (i <- 1 to StdIn.readLine.toInt) {
      val _ = StdIn.readLine
      val line2 = StdIn.readLine

      val cipher = line2.split(' ').map(BigInt.apply)
      val primes = TreeSet.empty[BigInt]

      // Find to different adjacent characters
      val (a, middleI) = cipher.sliding(2).zipWithIndex.find(x => x._1(0) != x._1(1)).get
      val middlePrime = a(0) / gcd(a(0), a(1))
      primes += middlePrime

      val primeSequence = MutableList.empty[BigInt]
      primeSequence += middlePrime

      var prime = middlePrime
      for (p <- cipher.drop(middleI)) {
        prime = p / prime
        primes += prime
        primeSequence += prime
      }

      prime = middlePrime
      for (p <- cipher.take(middleI).reverse) {
        prime = p / prime
        primes += prime
        primeSequence.+=:(prime)
      }

      val primeMap = primes.zipWithIndex.map(p => p._1 -> (p._2 + 'A').toChar).toMap
      val answer = primeSequence.map(primeMap).mkString

      println(s"Case #$i: $answer")
    }

    def gcd(a: BigInt, b: BigInt): BigInt = {
      if (a < b) gcd(b, a)
      else if (b == 0) a
      else gcd(b, a % b)
    }
  }
}

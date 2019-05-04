package CodeJam2019.Round1C.PowerArrangers

import scala.io.StdIn
import scala.collection.mutable.Set

object Solution {
  def main(args: Array[String]): Unit = {
    val Array(t, f) = StdIn.readLine.split(' ').map(_.toInt)
    for (_ <- 1 to t) {

      val figures = Array.ofDim[Char](5)

      val maps = Array.ofDim[Map[Char,Set[Int]]](5)
      for(i <- 0 until 5) {
        maps(i) = Map[Char,Set[Int]]()

        maps(i) += 'A' -> Set.empty
        maps(i) += 'B' -> Set.empty
        maps(i) += 'C' -> Set.empty
        maps(i) += 'D' -> Set.empty
        maps(i) += 'E' -> Set.empty
      }

      for(i <- 0 until 119) {
        maps(0)(read(i*5)) += i
      }

      figures(0) = maps(0).filter(x => x._2.nonEmpty).minBy(x => x._2.size)._1

      for(i <- maps(0)(figures(0))) {
        maps(1)(read(i*5 + 1)) += i
      }
      figures(1) = maps(1).filter(x => x._2.nonEmpty).minBy(x => x._2.size)._1

      for(i <- maps(1)(figures(1))) {
        maps(2)(read(i*5 + 2)) += i
      }
      figures(2) = maps(2).filter(x => x._2.nonEmpty).minBy(x => x._2.size)._1

      val i = maps(2)(figures(2)).head
      figures(3) = read(i*5 + 4)
      figures(4) = read(i*5 + 3)

      println(figures.mkString)
      Console.flush
      if (StdIn.readLine == 'N') System.exit(0)
    }
  }

  def read(pos: Int): Char = {
    println(pos + 1)
    scala.Console.flush
    val response = StdIn.readLine.charAt(0)
    if (response == 'N') System.exit(0)
    response
  }

  def read2(pos: Int): Char = {
    val response = "ABCDEBACDECABDEACBDEBCADECBADECBDAEBCDAEDCBAECDBAEBDCAEDBCAEDACBEADCBECDABEDCABEACDBECADBEBADCEABDCEDBACEBDACEADBCEDABCEEABCDAEBCDBEACDEBACDABECDBAECDBACEDABCEDCBAEDBCAEDACBEDCABEDCEBADECBADBCEADCBEADEBCADBECADAECBDEACBDCAEBDACEBDECABDCEABDDEABCEDABCADEBCDAEBCEADBCAEDBCAEBDCEABDCBAEDCABEDCEBADCBEADCBDAECDBAECABDECBADECDABECADBECEDBACDEBACBEDACEBDACDBEACBDEACCDEABDCEABECDABCEDABDECABEDCABEDACBDEACBAEDCBEADCBDAECBADECBACEDBCAEDBEACDBAECDBCEADBECADBDCAEBCDAEBADCEBDACEBCADEBACDEBBCDEACBDEADBCEABDCEACDBEADCBEADCEBACDEBAEDCBADECBACEDBAECDBAEBDCABEDCADEBCAEDBCABDECADBECACBEDABCEDAECBDACEBDABECDAEBCDA".charAt(pos)
    if (response == 'N') System.exit(0)
    response
  }
}


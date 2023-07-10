package squareword

import scala.collection.mutable
import scala.collection.parallel.CollectionConverters.VectorIsParallelizable

class Solver(words: Seq[String], length: Int) {
  require(words.forall(_.length == length), words.filter(_.length != length).mkString(", "))
  //private val trie = Trie("")
  //words.foreach(trie.append)

  def findSolutionsPar(square: Square): Seq[Square] = {
    val allWords = wordsWithPrefix(words, square.nextPrefix).diff(square.words)
    val parWords = allWords.toVector.par
    parWords.flatMap { word0 =>
      val square0 = square.insert(word0)
      val words1 = wordsWithPrefix(words, square0.nextPrefix).diff(square0.words)
      val canonicalWords = words1.filter(_ > word0)
      canonicalWords.flatMap(word => findSolutions(square0.insert(word)))
    }.seq
  }

  def findSolutions(square: Square): Seq[Square] =
    if (square.words.size == length * 2) {
      println(s"Found solution: $square")
      List(square)
    } else {
      val nextWords = wordsWithPrefix(words, square.nextPrefix).diff(square.words)
      nextWords.flatMap(word => findSolutions(square.insert(word)))
    }

  private def wordsWithPrefix(words: Seq[String], prefix: String): Seq[String] =
    cache.getOrElseUpdate(prefix, words.filter(_.startsWith(prefix)))

  private val cache: mutable.Map[String, Seq[String]] = scala.collection.concurrent.TrieMap.empty

}

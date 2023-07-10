package squareword

import scala.collection.mutable

case class Trie(prefix: String, children: mutable.Map[Char, Trie] = mutable.Map.empty) {

  def append(word: String): Trie = {
    if (word.isEmpty)
      this
    else {
      val (head, rest) = word.splitAt(1)
      val char = head.charAt(0)
      val subTrie = children.getOrElseUpdate(char, Trie(prefix + head))
      val newTrie = subTrie.append(rest)
      children.update(char, newTrie)
      this
    }
  }

  def find(needle: String, pos: Int = 0): Trie =
    if (prefix == needle)
      this
    else
      children(needle.charAt(pos)).find(needle, pos + 1)

  lazy val collectWords: Seq[String] =
    if (children.isEmpty)
      Seq(prefix)
    else
      children.toSeq.flatMap { case (_, trie) =>
        trie.collectWords
      }

  def wordsWithPrefix(needle: String): Seq[String] =
    find(needle, prefix.length).collectWords

}

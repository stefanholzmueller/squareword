package squareword

case class Square(words: List[String] = Nil) {
  require(words.toSet.size == words.size, words)
  private def verticalWords: Iterator[String] = words.grouped(2).map(_.last)
  def horizontalWords: Iterator[String] = words.grouped(2).map(_.head)
  override def toString: String = words.mkString("[", ",", "]")
  def insert(word: String): Square = Square(words :+ word)
  def nextPrefix: String = {
    val mod = words.size % 2
    val div = words.size / 2
    if (mod == 0)
      verticalWords.map(_.charAt(div)).mkString
    else
      horizontalWords.map(_.charAt(div)).mkString
  }
}

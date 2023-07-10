package squareword

import scala.collection.mutable

class TrieSpec extends munit.FunSuite {

  test("append nothing to empty trie") {
    assertEquals(
      Trie("").append(""),
      Trie("")
    )
  }
  test("append nothing to small trie") {
    assertEquals(
      Trie(
        "a",
        mutable.Map(
          'a' -> Trie("aa")
        )
      ).append(""),
      Trie(
        "a",
        mutable.Map(
          'a' -> Trie("aa")
        )
      )
    )
  }
  test("append a to empty trie") {
    assertEquals(
      Trie("").append("a"),
      Trie(
        "",
        mutable.Map(
          'a' -> Trie("a")
        )
      )
    )
  }
  test("append aa to empty trie") {
    assertEquals(
      Trie("").append("aa"),
      Trie(
        "",
        mutable.Map(
          'a' -> Trie(
            "a",
            mutable.Map(
              'a' -> Trie("aa")
            )
          )
        )
      )
    )
  }
  test("append ab to empty trie") {
    assertEquals(
      Trie("").append("ab"),
      Trie(
        "",
        mutable.Map(
          'a' -> Trie(
            "a",
            mutable.Map(
              'b' -> Trie("ab")
            )
          )
        )
      )
    )
  }
  test("append ab to trie with a") {
    assertEquals(
      Trie("").append("a").append("ab"),
      Trie(
        "",
        mutable.Map(
          'a' -> Trie(
            "a",
            mutable.Map(
              'b' -> Trie("ab")
            )
          )
        )
      )
    )
  }
  test("append abc to trie with ab,ac") {
    assertEquals(
      Trie("").append("ab").append("ac").append("abc"),
      Trie(
        "",
        mutable.Map(
          'a' -> Trie(
            "a",
            mutable.Map(
              'b' -> Trie("ab", mutable.Map('c' -> Trie("abc"))),
              'c' -> Trie("ac")
            )
          )
        )
      )
    )
  }

  test("find subtrie") {
    assertEquals(
      Trie("").append("ab").append("ac").find("a"),
      Trie("a", mutable.Map('b' -> Trie("ab"), 'c' -> Trie("ac")))
    )
    assertEquals(
      Trie("").append("ab").append("ac").find("ab"),
      Trie("ab")
    )
  }

  test("collect words") {
    assertEquals(
      Trie("").append("ab").append("ac").collectWords,
      Seq("ab", "ac")
    )
  }

  test("small trie contains 2 words") {
    assertEquals(
      Trie("").append("ab").append("ac").wordsWithPrefix(""),
      Seq("ab", "ac")
    )
  }

}

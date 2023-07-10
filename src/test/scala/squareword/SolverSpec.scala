package squareword

class SolverSpec extends munit.FunSuite {

  test("solve 2x2 square") {
    assertEquals(
      new Solver(Seq("ab", "ac", "cd", "bd", "ae", "xy"), 2).findSolutions(Square()),
      List(Square(List("ab", "ac", "cd", "bd")), Square(List("ac", "ab", "bd", "cd")))
    )
  }

  test("solve 3x3 square") {
    assertEquals(
      new Solver(Seq("abc", "def", "xyz", "adx", "bey", "cfz"), 3).findSolutions(Square()),
      List(
        Square(List("abc", "adx", "def", "bey", "xyz", "cfz")),
        Square(List("adx", "abc", "bey", "def", "cfz", "xyz"))
      )
    )
  }

}

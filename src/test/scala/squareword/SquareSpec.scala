package squareword

class SquareSpec extends munit.FunSuite {

  test("next prefix of empty square") {
    assertEquals(
      Square().nextPrefix,
      ""
    )
  }

  test("next prefix after 1 word") {
    assertEquals(
      Square().insert("feint").nextPrefix,
      "f"
    )
  }

  test("next prefix after 2 words") {
    assertEquals(
      Square().insert("feint").insert("found").nextPrefix,
      "o"
    )
  }

  test("next prefix after 3 words") {
    assertEquals(
      Square().insert("feint").insert("found").insert("other").nextPrefix,
      "et"
    )
  }

  test("next prefix after 4 words") {
    assertEquals(
      Square().insert("feint").insert("found").insert("other").insert("ether").nextPrefix,
      "uh"
    )
  }

  test("next prefix after 8 words") {
    assertEquals(
      Square()
        .insert("aaaaa")
        .insert("aaaaa")
        .insert("aaaaa")
        .insert("aaaaa")
        .insert("aaaaa")
        .insert("aaaaa")
        .insert("aaaaa")
        .insert("aaaaa")
        .nextPrefix,
      "aaaa"
    )
  }
  test("next prefix after 9 words") {
    assertEquals(
      Square()
        .insert("aaaaa")
        .insert("aaaaa")
        .insert("aaaaa")
        .insert("aaaaa")
        .insert("aaaaa")
        .insert("aaaaa")
        .insert("aaaaa")
        .insert("aaaaa")
        .insert("aaaaa")
        .nextPrefix,
      "aaaaa"
    )
  }

}

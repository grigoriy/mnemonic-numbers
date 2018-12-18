package com.galekseev.mnemonic.numbers

import scala.io.StdIn
import com.galekseev.mnemonic.numbers.WordFinder.{ getSentences, getNumber }

// scalastyle:off
object Main extends App {
  private val inviteUserMessage = "\nPlease enter a number or word or '!' to quit:"

  println(inviteUserMessage)
  var input = StdIn.readLine()

  while (!"!".equalsIgnoreCase(input)) {
    if (isNaturalNumber(input))
      println(
//        getWords(input)
//        getLetters(input)
//          .mkString(" ")
        getSentences(input)
          .sortWith((sentence1, sentence2) => sentence1.size < sentence2.size)
          .map(words => words.map(_.mkString(" ")).mkString("\n"))
          .mkString("\n----------\n")
      )
    else
      println(getNumber(input))

    println(inviteUserMessage)
    input = StdIn.readLine()
  }

  private def isNaturalNumber(s: String) =
    s.filterNot(Set('1', '2', '3', '4', '5', '6', '7', '8', '9', '0')).isEmpty
}

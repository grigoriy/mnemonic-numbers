package com.galekseev.mnemonic.numbers

import java.text.Collator
import java.util.Locale

import com.galekseev.mnemonic.numbers.WordFinder.{getNumber, getSentenceConstructors}

import scala.io.StdIn

// scalastyle:off
object Main extends App {
  private val inviteUserMessage = "\nPlease enter a number or word or '!' to quit:"

  println(inviteUserMessage)
  var input = StdIn.readLine()

  while (!"!".equalsIgnoreCase(input)) {
    if (isNaturalNumber(input))
      println(
//        getLetters(input).mkString(" ")
        getSentenceConstructors(input)
          .sortWith(numWords(_) < numWords(_))
          .map(wordSets =>
            wordSets.map(wordSet => sortAlphabeticallyIgnoringCase(wordSet).mkString(" "))
              .mkString("\n")
        )
          .mkString("\n----------\n")
      )
    else
      println(getNumber(input))

    println(inviteUserMessage)
    input = StdIn.readLine()
  }

  private def isNaturalNumber(s: String) =
    s.filterNot(Set('1', '2', '3', '4', '5', '6', '7', '8', '9', '0')).isEmpty

  private def sortAlphabeticallyIgnoringCase(strings: Seq[String]): Seq[String] = {
    val collator = Collator.getInstance(Locale.forLanguageTag("ru"))
    collator.setStrength(Collator.SECONDARY)
    strings.sortWith((a, b) => collator.compare(a, b) == -1)
  }

  private def numWords(sentence: Seq[Seq[String]]): Int =
    sentence.size
}

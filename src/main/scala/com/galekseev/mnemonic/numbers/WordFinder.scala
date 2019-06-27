package com.galekseev.mnemonic.numbers

import scala.io.Source

object WordFinder {
  private val charToDigit = Map[Char, Int](
    'б' -> 2,
    'в' -> 8,
    'г' -> 5,
    'д' -> 2,
    'ж' -> 6,
    'з' -> 8,
    'й' -> 9,
    'к' -> 4,
    'л' -> 9,
    'м' -> 6,
    'н' -> 0,
    'п' -> 5,
    'р' -> 1,
    'с' -> 7,
    'т' -> 3,
    'ф' -> 5,
    'х' -> 6,
    'ц' -> 2,
    'ч' -> 4,
    'ш' -> 6,
    'щ' -> 6
  )
  private val numToWords = parseNumToWords(Source.fromResource("words_from_freq"))
  //  private val digitToChars = reverse(charToDigit)

  def getNumber(word: String): String =
    wordToNumber(word)

  def getSentenceConstructors(number: String): Seq[Seq[Seq[String]]] = {
    var cache: Map[String, Seq[Seq[Seq[String]]]] = Map.empty

    def helper(number: String, accum: Seq[Seq[String]]): Seq[Seq[Seq[String]]] =
      cache.getOrElse(number,
        if (number.isEmpty)
          Seq(Seq.empty)
        else {
          val result = (for {
            i <- 1 to number.length
            words = getWords(number.substring(0, i))
            if words.nonEmpty
          } yield {
            val remainder = number.substring(i)
            val remainderResult = helper(remainder, accum)
            remainderResult.map(words +: _)
          }).flatten.distinct
          cache = cache.updated(number, result)
          result
        }
      )

    helper(number: String, Seq.empty)
  }

  //  def getLetters(number: String): Seq[String] =
  //    number.map(digit =>
  //      new String(digitToChars(Integer.parseInt(digit.toString)).toArray)
  //    )

  private def parseNumToWords(dictionary: Source): Map[String, Seq[String]] =
    reverse(
      dictionary.getLines()
        .map(word => word -> wordToNumber(word))
        .filter(_._2.nonEmpty)
        .toMap
    )

  private def getWords(number: String): Seq[String] =
    numToWords.getOrElse(number, Seq.empty)

  private def wordToNumber(word: String): String =
    (for {
      letter <- word
      letterLower = letter.toLower
      if charToDigit.contains(letterLower)
    } yield charToDigit(letterLower)).mkString

  private def reverse[A, B](map: Map[A, B]): Map[B, Seq[A]] =
    map.toSeq.map(t => (t._2, t._1)).groupBy(_._1).mapValues(seq => seq.map(_._2))
}

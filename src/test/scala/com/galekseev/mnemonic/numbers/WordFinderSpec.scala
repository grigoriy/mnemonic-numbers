package com.galekseev.mnemonic.numbers

import com.galekseev.BaseSpec
import com.galekseev.mnemonic.numbers.WordFinder.{getNumber, getSentenceConstructors}

// scalastyle:off
class WordFinderSpec extends BaseSpec {

  "WordFinder" when {

    "given 'собака'" should {
      "return 724" in {
        val numberOrError = getNumber("собака")

        assert(Integer.parseInt(numberOrError) === 724)
      }
    }

    "given 5124" should {
      "return a list containing 'городок'" in {
        val sentenceConstructors = getSentenceConstructors("5124")

        assert(sentenceConstructors.exists(_.exists(_.contains("городок"))))
      }
    }

  }
}

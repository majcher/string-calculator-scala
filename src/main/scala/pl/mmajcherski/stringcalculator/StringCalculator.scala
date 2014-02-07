package pl.mmajcherski.stringcalculator

import com.google.common.base.Splitter
import scala.collection.JavaConversions._

object StringCalculator {
	class NegativeNumbersNotSupportedException(message: String = null) extends RuntimeException(message) {
	}
}

class StringCalculator {
	private val DefaultForEmptyInput: String = "0"
	private val DelimiterLinePrefix: String = "//"
	private val DefaultSplitPattern: String = "[,\n]"

	def add(input: String): Integer = {
		val nonEmptyInput = provideDefaultValue(input)
		val splitInput = splitText(nonEmptyInput)
		val numbers = convertToNumbers(splitInput)
		throwExceptionIfContainsNegativeNumbers(numbers)
		numbers.sum
	}

	private def provideDefaultValue(input: String): String = {
		if (input.isEmpty) DefaultForEmptyInput else input
	}

	private def splitText(nonEmptyInput: String): Iterable[String] = {
		if (nonEmptyInput.startsWith(DelimiterLinePrefix))
			splitUsingUserProvidedDelimiter(nonEmptyInput)
		else
			splitUsingDefaultDelimiters(nonEmptyInput)
	}

	private def splitUsingUserProvidedDelimiter(nonEmptyInput: String): Iterable[String] = {
		val customDelimiter = nonEmptyInput.substring(DelimiterLinePrefix.length, nonEmptyInput.indexOf('\n'))
		val numbersString = nonEmptyInput.substring(DelimiterLinePrefix.length + customDelimiter.length + 1)
		Splitter.on(customDelimiter).split(numbersString)
	}

	private def splitUsingDefaultDelimiters(nonEmptyInput: String): Iterable[String] = {
		Splitter.onPattern(DefaultSplitPattern).split(nonEmptyInput)
	}

	private def convertToNumbers(splitInput: Iterable[String]): List[Int] = {
		splitInput.toList.map(_.toInt)
	}

	private def throwExceptionIfContainsNegativeNumbers(numbers: List[Int]) {
		val negativeNumbers = numbers.filter(_ < 0)
		if (!negativeNumbers.isEmpty) {
			val formattedNegativeNumbers = negativeNumbers.mkString(", ")
			throw new StringCalculator.NegativeNumbersNotSupportedException("Negatives not allowed: " + formattedNegativeNumbers)
		}
	}
}

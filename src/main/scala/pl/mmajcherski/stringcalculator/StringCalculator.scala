package pl.mmajcherski.stringcalculator

import com.google.common.base.Splitter
import scala.collection.JavaConversions._
import pl.mmajcherski.stringcalculator.StringCalculator.NegativeNumbersNotSupportedException

object StringCalculator {
	class NegativeNumbersNotSupportedException extends RuntimeException {
	}
}

class StringCalculator {
	private val DefaultForEmptyInput: String = "0"
	private val FirstLineStartString: String = "//"
	private val DefaultSplitPattern: String = "[,\n]"

	def add(input: String): Integer = {
		val nonEmptyInput = if (input.isEmpty) DefaultForEmptyInput else input
		val customDelimiterOption = if (input.startsWith(FirstLineStartString)) new Some(input.charAt(2)) else None
		val numbersString = if (customDelimiterOption.isDefined) nonEmptyInput.substring(4) else nonEmptyInput
		val splitter = if (customDelimiterOption.isDefined) Splitter.on(customDelimiterOption.get) else Splitter.onPattern(DefaultSplitPattern)

		val numbers = splitter.split(numbersString).toList.map(_.toInt)

		if (!numbers.filter(_ < 0).isEmpty) {
			throw new StringCalculator.NegativeNumbersNotSupportedException()
		}

		numbers.sum
	}

}

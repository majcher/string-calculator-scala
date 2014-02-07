package pl.mmajcherski.stringcalculator

import com.google.common.base.Splitter
import scala.collection.JavaConversions._

class StringCalculator {

	private val DefaultForEmptyInput: String = "0"
	private val FirstLineStartString: String = "//"
	private val DefaultSplitPattern: String = "[,\n]"

	def add(input : String) : Integer = {
		val nonEmptyInput = if (input.isEmpty) DefaultForEmptyInput else input
		val customDelimiter = if (input.startsWith(FirstLineStartString)) new Some(input.charAt(2)) else None
		val nonEmptyInputWithoutDelimiter = if (customDelimiter.isDefined) nonEmptyInput.substring(4) else nonEmptyInput
		val splitter = if (customDelimiter.isDefined) Splitter.on(customDelimiter.get) else Splitter.onPattern(DefaultSplitPattern)
		splitter.split(nonEmptyInputWithoutDelimiter).toList.map(_.toInt).sum
	}

}

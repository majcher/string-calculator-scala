package pl.mmajcherski.stringcalculator

import org.scalatest.{FlatSpec, Matchers}

class StringCalculatorTest extends FlatSpec with Matchers {

	val calc = new StringCalculator()

	"String calculator" should "return 0 for empty input string" in {
		val result = calc.add("")
		result should equal (0)
	}

}

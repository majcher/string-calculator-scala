package pl.mmajcherski.stringcalculator

import org.scalatest.{FlatSpec, Matchers}

class StringCalculatorTest extends FlatSpec with Matchers {

	val calc = new StringCalculator()

	"String calculator" should "return 0 for empty input string" in {
		val result = calc.add("")
		result should equal (0)
	}

	it should "return 1 for '1' input" in {
		val result = calc.add("1")
		result should equal (1)
	}

	it should "return 3 for '1,2' input" in {
		val result = calc.add("1,2")
		result should equal (3)
	}

}

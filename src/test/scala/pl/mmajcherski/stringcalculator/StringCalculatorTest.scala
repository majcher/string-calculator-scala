package pl.mmajcherski.stringcalculator

import org.scalatest.{FlatSpec, Matchers}

class StringCalculatorTest extends FlatSpec with Matchers {

	val calc = new StringCalculator()

	"String calculator" should "provide sum equal to zero for empty string" in {
		val result = calc.add("")
		result should equal (0)
	}

	it should "provide sum equal to single number passed as string" in {
		val result = calc.add("1")
		result should equal (1)
	}

	it should "provide sum of two comma delimited numbers" in {
		val result = calc.add("1,2")
		result should equal (3)
	}

	it should "provide sum of any comma delimited numbers" in {
		val result = calc.add("1,2,3,4,5")
		result should equal (15)
	}

	it should "handle new line delimited numbers" in {
		val result = calc.add("1\n2")
		result should equal (3)
	}

	it should "handle new line and comma delimited numbers" in {
		val result = calc.add("1\n2,3")
		result should equal (6)
	}

	it should "support custom delimiters in format of //[delimiter]\\n[numbers...]" in {
		val result = calc.add("//;\n1;2")
		result should equal (3)
	}

}

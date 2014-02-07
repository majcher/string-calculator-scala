package pl.mmajcherski.stringcalculator

class StringCalculator {

	def add(input : String) : Integer = {
		if (input.isEmpty) 0 else input.split(',').map(_.toInt).sum
	}

}

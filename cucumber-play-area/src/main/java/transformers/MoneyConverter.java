package transformers;

import nicebank.MonetaryAmount;
import cucumber.api.Transformer;

public class MoneyConverter extends Transformer<MonetaryAmount> {

	public MonetaryAmount transform(String amount) {

		String[] numbers = amount.substring(1).split("\\."); //disregard the currency symbol.
		int dollars = Integer.parseInt(numbers[0]);
		int cents = Integer.parseInt(numbers[1]);
		return new MonetaryAmount(dollars, cents);
	}

}
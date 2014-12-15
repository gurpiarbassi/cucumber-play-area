package nicebank;

import static org.junit.Assert.assertEquals;



import cucumber.api.java.en.Then;
import support.KnowsMyAccount;

public class CashSlotSteps {

	
	private KnowsMyAccount helper;

	public CashSlotSteps(KnowsMyAccount helper) {
		this.helper = helper;
	}
	
	@Then("^\\$(\\d+) should be dispensed$")
	public void $ShouldBeDispensed(int dollars) throws Throwable {
		assertEquals("Incorrect amount dispensed -", dollars, helper
				.getCashSlot().getContents());
	}
}

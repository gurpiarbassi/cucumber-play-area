package nicebank;

import static org.junit.Assert.assertEquals;



import support.KnowsMyAccount;
import transformers.MoneyConverter;
import cucumber.api.Transform;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class AccountSteps {

	
	private KnowsMyAccount helper;

	
	public AccountSteps(KnowsMyAccount helper) {
		this.helper = helper;
	}

	@Given("^my account has been credited with (\\$\\d+\\.\\d+)$")
	public void myAccountHasBeenCreditedWith$(
	@Transform(MoneyConverter.class) MonetaryAmount amount)
			throws Throwable {
		Account account = helper.getMyAccount();
		account.credit(amount);
	}
	
	@Then("^the balance of my account should be (\\$\\d+\\.\\d+)$")
	public void theBalanceOfMyAccountShouldBe$(
			@Transform(MoneyConverter.class) MonetaryAmount amount) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    Account account = helper.getMyAccount();
	    assertEquals("Incorrect account balance -", amount,
				account.getBalance());
	}
}

package nicebank;



import cucumber.api.java.en.When;
import support.KnowsMyAccount;

public class TellerSteps {

	
	private KnowsMyAccount helper;
	
	public TellerSteps(KnowsMyAccount helper) {
		this.helper = helper;
	}
	
	@When("^I withdraw \\$(\\d+)$")
	public void iWithdraw$(int amount) throws Throwable {
		helper.getTeller().withdrawFrom(helper.getMyAccount(), amount);
	}
}

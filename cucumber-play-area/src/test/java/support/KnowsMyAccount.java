package support;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import nicebank.Account;
import nicebank.CashSlot;
import nicebank.Teller;

public class KnowsMyAccount {

	private Account myAccount;
	private CashSlot cashSlot;
	private Teller teller;
	private WebDriver webDriver;

	public Account getMyAccount() {
		if (myAccount == null) {
			myAccount = new Account();
		}
		return myAccount;
	}

	public CashSlot getCashSlot() {
		if (cashSlot == null) {
			cashSlot = new CashSlot();
		}
		return cashSlot;
	}

	public Teller getTeller() {
		if (teller == null) {
			teller = new AtmUserInterface(getWebDriver());
		}
		return teller;
	}

	public WebDriver getWebDriver() {
		if (webDriver == null) {
			webDriver = new EventFiringWebDriver(new FirefoxDriver());
		}
		return webDriver;
	}
}
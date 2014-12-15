package support;

import nicebank.Account;
import nicebank.Teller;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AtmUserInterface implements Teller {

	private WebDriver webDriver = null;

	public AtmUserInterface(WebDriver webDriver) {

		this.webDriver = webDriver;
	}

	public void withdrawFrom(Account account, int dollars) {
		try {
			webDriver.get("http://127.0.0.1:8080");
			webDriver.findElement(By.id("Amount")).sendKeys(
					String.valueOf(dollars));
			webDriver.findElement(By.id("Withdraw")).click();
		}catch(Exception e){
			System.out.println("Caught============== " + e);
		}
		finally {
			webDriver.close();
		}
	}
}
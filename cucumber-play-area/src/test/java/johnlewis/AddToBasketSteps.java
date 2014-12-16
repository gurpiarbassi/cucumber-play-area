package johnlewis;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class AddToBasketSteps {

	@Autowired
	private EventFiringWebDriver webDriver;
	
    
	
	@When("^I add the acer laptop to the basket$")
	public void iAddTheAcerLaptopToTheBasket() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		By locator = By.className("btn-plrg-addtobasket");
		WebDriverWait wait = new WebDriverWait(webDriver, 2, 30);
		WebElement element = wait.until(
				ExpectedConditions.presenceOfElementLocated(locator));
		webDriver.findElement(locator).click();
	}
	
	@Then("^item is succesfully added to basket$")
	public void itemIsSuccesfullyAddedToBasket() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		By locator = By.id("addToBasketConfirm");
		WebDriverWait wait = new WebDriverWait(webDriver, 2, 30);
		WebElement element = wait.until(
				ExpectedConditions.presenceOfElementLocated(locator));
		webDriver.findElement(locator);
	}
}

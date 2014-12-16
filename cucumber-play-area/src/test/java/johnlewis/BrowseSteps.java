package johnlewis;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class BrowseSteps {

	@Autowired
	private EventFiringWebDriver webDriver;
	
	
	@Given("^I am on the john lewis site$")
	public void iAmOnTheJohnLewisSite() throws Throwable {
		webDriver.get("http://www.johnlewis.com");
	}

	@When("^I select laptop and macbooks from the mega menu$")
	public void iSelectLaptopAndMacbooksFromTheMegaMenu() throws Throwable {
	   //1. move to electricals first to expand the mega menu
		
		/**Actions action = new Actions(webDriver);
		WebElement electricalsNode = webDriver.findElement(By.id("accessible-megamenu-1418591001023-5"));
		action.moveToElement(electricalsNode).moveToElement(
				webDriver.findElement(By.xpath("//*[@id='accessible-megamenu-1418589323712-6']/div[2]/ul/li[2]/a"))).click();
		***/
		webDriver.get("http://www.johnlewis.com/electricals/laptops-netbooks/c60000876");
		
	}

	@Then("^I should be taken to the Laptop and Macbooks category landing page$")
	public void iShouldBeTakenToTheLaptopAndMacbooksCategoryLandingPage() throws Throwable {
		assertEquals("Incorrect page title -", "Laptops | Macbooks, HP, Samsung & Toshiba | John Lewis",
				webDriver.getTitle());
	    
	}
	
	@When("^I click on the Acer laptop$")
	public void iClickOnTheAcerLaptop() throws Throwable {
		webDriver.findElement(By.className("rr_product_id_1747863")).click();
	}

	@Then("^I should be taken to the Acer Laptop product page$")
	public void iShouldBeTakenToTheAcerLaptopProductPage() throws Throwable {
		assertEquals("Incorrect page title -", "Buy Acer Aspire ES1-512 Laptop, Intel Celeron, 4GB RAM, 500GB, 15.6\", Black | John Lewis",
				webDriver.getTitle());
	}
	
	



}

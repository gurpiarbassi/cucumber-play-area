package nicebank;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import support.KnowsMyAccount;

public class WebDriverHooks {

    private KnowsMyAccount helper;
    
    public WebDriverHooks(KnowsMyAccount helper) {
        this.helper = helper;
    }

    @After
    public void finish(Scenario scenario) {
        try {
            byte[] screenshot = ((EventFiringWebDriver) helper.getWebDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        } catch (WebDriverException somePlatformsDontSupportScreenshots) {
            System.err.println(somePlatformsDontSupportScreenshots.getMessage());
        }
        finally {
            helper.getWebDriver().close();
        }
    }
}
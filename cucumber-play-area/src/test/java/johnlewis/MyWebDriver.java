package johnlewis;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.springframework.stereotype.Component;


public class MyWebDriver extends EventFiringWebDriver {

	public MyWebDriver() {
		super(new FirefoxDriver());
	}
}

package nicebank;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.*;

import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin={"pretty", "html:out"}, features = "src/test/resources/atm", glue="nicebank", monochrome = true, snippets = SnippetType.CAMELCASE)
public class CukesRunner {

}
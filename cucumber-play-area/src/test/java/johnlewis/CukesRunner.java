package johnlewis;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.*;

import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin={"pretty", "html:out"}, features = "src/test/resources/johnlewis", glue="johnlewis", monochrome = true, snippets = SnippetType.CAMELCASE/*, dryRun=true*/)
public class CukesRunner {

}
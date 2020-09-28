package MyRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/main/java/com/qa/crm/features/login.feature", glue= {"com.qa.crm.stepDefinations"},
monochrome = true, 
plugin = {"json:target/cucumber.json"},
dryRun = false, 
publish = true,
strict = true  // will be removed and cucumber By default strict
)
public class TestRunner {

}

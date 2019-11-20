package TestRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = {"src/test/java/Features"}, glue = "src/test/java/Steps"
)
public class TestRunner extends AbstractTestNGCucumberTests {


}

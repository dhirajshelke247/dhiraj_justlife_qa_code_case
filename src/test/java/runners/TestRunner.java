package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepDefinitions", "hooks"},
        plugin = {"pretty", "json:src/test/resources/testResults/result.json"},
        monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
}

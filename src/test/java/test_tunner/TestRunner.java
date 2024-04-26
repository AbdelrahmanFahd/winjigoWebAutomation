package test_tunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/resources/features",
        glue = "StepDefinitions",
        plugin = {"pretty", "html:src/Cucumber-Report"}
)

public class TestRunner {
}

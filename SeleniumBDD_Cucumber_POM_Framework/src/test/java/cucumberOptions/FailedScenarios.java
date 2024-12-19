package cucumberOptions;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "@target/failed_scenarios.txt",
		glue = "StepDefination",
		plugin = { "pretty",
		"html:target/cucumber.html", "json:target/cucumber.json"
//		,"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" 
		}
//        monochrome = true,
//        dryRun=true
)
public class FailedScenarios extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}

}

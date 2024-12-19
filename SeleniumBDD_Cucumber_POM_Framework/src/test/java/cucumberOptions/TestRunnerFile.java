package cucumberOptions;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/java/FeatureFile",
		glue = "StepDefination",
		tags = "@placeOrder or @OfferPage",
		plugin = { "pretty",
		"html:target/cucumber.html", "json:target/cucumber.json",
		"rerun:target/failed_scenarios.txt"
//		,"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" 
		}
//        monochrome = true,
//        dryRun=true
)
public class TestRunnerFile extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}

}

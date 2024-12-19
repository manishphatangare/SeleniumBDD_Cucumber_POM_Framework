package StepDefination;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


import Utils.TestContextSetup;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;

public class Hooks {

	TestContextSetup testContextSetup;

	public Hooks(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
	}

	
	@After
	public void AfterScenario() throws IOException {
		testContextSetup.testBase.WebDriverManager().quit();
	}
	
	@AfterStep
	public void addScreenShot(Scenario scenario) throws IOException
	{
		WebDriver driver=testContextSetup.testBase.WebDriverManager();
		if(scenario.isFailed())
		{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		byte [] fileContent=FileUtils.readFileToByteArray(src);
		scenario.attach(fileContent, "image/png", "image");
		}
	}
}

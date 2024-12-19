package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.core.internal.com.fasterxml.jackson.databind.annotation.JsonAppend.Prop;

public class TestBase {

	 public WebDriver driver;

	public WebDriver WebDriverManager() throws IOException {
		FileInputStream fis = new FileInputStream("src/test/resources/global.properties");
//				System.getProperty("user.dir") + "src//test//resources//global.properties"); // take automatic path from user directory
				
		Properties prop = new Properties();
		prop.load(fis);
		String url = prop.getProperty("url");
//		String browser=prop.getProperty("browser");
		
		if(driver==null)
		{
			driver=new ChromeDriver();
//			if(browser.equalsIgnoreCase("chrome")) {
//				driver = new ChromeDriver();
//			}
//			if(browser.equalsIgnoreCase("edge")) {
//				driver = new EdgeDriver();
//			}
//			if(browser.equalsIgnoreCase("firefox")) {
//				driver = new FirefoxDriver();
//			}
			
			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}

		return driver;
	}

}

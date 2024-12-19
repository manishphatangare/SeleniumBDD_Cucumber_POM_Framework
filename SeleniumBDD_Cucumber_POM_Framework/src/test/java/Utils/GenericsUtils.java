package Utils;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class GenericsUtils {
	
	WebDriver driver;
	public GenericsUtils(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void SwitchWindowToChild()
	{
		Set<String> windows = driver.getWindowHandles();

		Iterator<String> it = windows.iterator();
		String parenWindow = it.next();
		String childWindow = it.next();

		driver.switchTo().window(childWindow);
	}

}

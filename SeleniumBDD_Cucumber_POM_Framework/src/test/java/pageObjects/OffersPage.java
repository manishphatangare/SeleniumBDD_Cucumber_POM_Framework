package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Utils.TestContextSetup;

public class OffersPage {


	public WebDriver driver;

	public OffersPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	private By search=By.xpath("//input[@id='search-field']");
	private By productName=By.xpath("//tr//td[1]");
	private By cartButton=By.xpath("//img[@alt='Cart']");
	
	public void searchItem(String shortName)
	{
		driver.findElement(search).sendKeys(shortName);
	}
	
	public void getSearchText()
	{
		driver.findElement(search).getText();
	}
	
	public String getProductName()
	{
		return driver.findElement(productName).getText();
	}
	public void cartButton()
	{
		driver.findElement(cartButton).click();
	}
	
	
}

package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Utils.TestContextSetup;

public class LandingPage {

	public WebDriver driver;


	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	private By search = By.xpath("//input[@class='search-keyword']");
	private By productName = By.cssSelector("h4.product-name");
	private By topDeals = By.cssSelector("a.cart-header-navlink:nth-child(2)");
	private By cartBag = By.cssSelector("a[class=cart-icon] img");
	private By increment = By.cssSelector("a.increment");
	private By addToCart = By.xpath("//div[@class='product-action'] //button");


	public void incrementQuantity(int quantity)
	{
		int i=quantity-1;
		
		while(i>0)
		{
			driver.findElement(increment).click();
			i--;
		}
	}
	
	public void addToCart()
	{
		driver.findElement(addToCart).click();
	}
	
	public void searchItem(String shortName) {
		driver.findElement(search).sendKeys(shortName);
	}

	public void getSearchText() {
		driver.findElement(search).getText();
	}

	public String getProductName() {
		return driver.findElement(productName).getText();
	}

	public void selectTopDealsPage() {
		driver.findElement(topDeals).click();
	}
	
	public String getTitle()
	{
		return driver.getTitle();
	}
}

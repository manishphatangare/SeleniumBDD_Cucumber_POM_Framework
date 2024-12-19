package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Utils.TestContextSetup;

public class CheckoutPage {

	public WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
	}


	private By checkOutButton = By.xpath("//button[text()='PROCEED TO CHECKOUT']");
	private By bypromoBtn = By.cssSelector("input.promoCode");
	private By placeOrder = By.xpath("//button[text()='Place Order']");
	private By productName = By.xpath("//p[@class='product-name']");

	public void CheckoutItems() {
		driver.findElement(checkOutButton).click();
	}

	public boolean VerifyPromoBtn() {
		return driver.findElement(bypromoBtn).isDisplayed();
	}

	public Boolean VerifyPlaceOrder() {
		return driver.findElement(placeOrder).isDisplayed();
	}

	public String getProductName() {
		return driver.findElement(productName).getText().split("-")[0].trim();
	}
}

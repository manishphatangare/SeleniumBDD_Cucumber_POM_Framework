package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {

	public WebDriver driver;
	public LandingPage landingPage;
	public OffersPage offerspage;
	public CheckoutPage checkOutPage;

	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}

	public LandingPage getLandingPage() {

		landingPage = new LandingPage(driver);

		return landingPage;
	}

	public OffersPage getOfferPage() {
		offerspage = new OffersPage(driver);

		return offerspage;
	}

	public CheckoutPage getcheckOutPage() {
		checkOutPage = new CheckoutPage(driver);
		return checkOutPage;
	}
}

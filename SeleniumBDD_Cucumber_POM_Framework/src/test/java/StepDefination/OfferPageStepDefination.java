package StepDefination;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import Utils.TestContextSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import pageObjects.PageObjectManager;

public class OfferPageStepDefination {

	public String offerPageProducName;
	TestContextSetup testContextSetup;
	 PageObjectManager pageObjectManager;
	 LandingPage landingPage;
	 OffersPage offersPage;
	 
	public OfferPageStepDefination(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		 this.landingPage = testContextSetup.pageObjectManager.getLandingPage();
		 this.offersPage = testContextSetup.pageObjectManager.getOfferPage();
	}

	public void switchToOfferPage() {

		

		landingPage.selectTopDealsPage();
		testContextSetup.genericUtils.SwitchWindowToChild();
	}

	@Then("^User searched for (.+) shortname in offers page$")
	public void user_searched_for_same_shortname_in_offers_page(String shortName) throws InterruptedException {

		

		switchToOfferPage();
		Thread.sleep(1000);
		offersPage.searchItem(shortName);

		Thread.sleep(1000);
		offerPageProducName = offersPage.getProductName();

	}

	@Then("validate product name in offer page matches with Landing Page")
	public void validate_product_name_in_offer_page_matches_with_landing_page() {

		Assert.assertEquals(offerPageProducName, testContextSetup.landingPageProductName);

	}

}

package StepDefination;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import Utils.TestContextSetup;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import pageObjects.PageObjectManager;

public class LandingPageStepDefination {

	public String landingPageProductName;
	public PageObjectManager pageObjectManager;
	TestContextSetup testContextSetup;
	public LandingPage landingPage;

	public LandingPageStepDefination(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
	 this.landingPage = testContextSetup.pageObjectManager.getLandingPage();
	}

	@Given("User is on GreenCart Landing page")
	public void user_is_on_green_cart_landing_page() {

		Assert.assertTrue(landingPage.getTitle().contains("GreenKart"));
		
	}

	
	@Then("^User is searched with ShortName (.+) and extracted actual name of product$")
	public void user_is_searched_with_short_name_and_extracted_actual_name_of_product(String shortName)
			throws InterruptedException {
		landingPage.searchItem(shortName);
		Thread.sleep(2000);
		testContextSetup.landingPageProductName = landingPage.getProductName().split("-")[0].trim();

		System.out.println(testContextSetup.landingPageProductName + " is extracted from Home page");

	}
	

	
	
	@When("Added {string} items of the selected product to cart")
	public void added_items_of_the_selected_product_to_cart(String quantity) throws InterruptedException {

		landingPage.incrementQuantity(Integer.parseInt(quantity));
		
		landingPage.addToCart();
		
	}
	
	

}

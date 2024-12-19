package StepDefination;

import org.testng.Assert;

import Utils.TestContextSetup;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CheckoutPage;
import pageObjects.LandingPage;
import pageObjects.OffersPage;

public class CheckoutPageStepDefination {

	public CheckoutPage checkOutPage;
	TestContextSetup testContextSetup;
	LandingPage landingPage;
	OffersPage offersPage;

	public CheckoutPageStepDefination(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		 this.checkOutPage = testContextSetup.pageObjectManager.getcheckOutPage(); 
		 this.offersPage = testContextSetup.pageObjectManager.getOfferPage();
		 
	}
	

	@Then("^User proceeds to checkout and validate the (.+) items in checkout page$")
	public void user_proceeds_to_checkout_and_validate_the_tom_items_in_checkout_page(String name) throws InterruptedException {
		offersPage.cartButton();
		checkOutPage.CheckoutItems();
		
		String productName=checkOutPage.getProductName();
		Thread.sleep(2000);
//		Assert.assertEquals(productName,name);
		
	}
	
	
	
	@Then("Verify user had ability to enter promo code and place the order")
	public void verify_user_had_ability_to_enter_promo_code_and_place_the_order() {
	
		
		Assert.assertTrue(checkOutPage.VerifyPromoBtn());
		Assert.assertTrue(checkOutPage.VerifyPlaceOrder());
	}
	
}

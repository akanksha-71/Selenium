package steps;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.ExtentManager;
import utils.base;
import page.CheckoutPage;
public class CheckoutStep {
  
	  WebDriver driver = base.initializeDriver();
	    CheckoutPage checkoutPage = new CheckoutPage(driver);
	    ExtentTest test = ExtentManager.createTest("Checkout Test");

	    @Given("I am on the checkout page")
	    public void iAmOnTheCheckoutPage() {
	        driver.get("https://demowebshop.tricentis.com/cart");
	    }

	    @When("I enter shipping details with country {string}, state {string}, and zip {string}")
	    public void iEnterShippingDetails(String country, String state, String zip) {
	        checkoutPage.enterShippingDetails(country, state, zip);
	    }

	    @When("I enter discount code {string}")
	    public void iEnterDiscountCode(String discountCode) {
	        checkoutPage.applyDiscountCode(discountCode);
	    }

	    @When("I enter gift card code {string}")
	    public void iEnterGiftCardCode(String giftCardCode) {
	        checkoutPage.applyGiftCard(giftCardCode);
	    }

	    @When("I estimate shipping")
	    public void iEstimateShipping() {
	        checkoutPage.estimateShipping();
	    }

	    @When("I agree with the terms of service")
	    public void iAgreeWithTheTermsOfService() {
	        checkoutPage.agreeToTerms();
	    }

	    @When("I proceed to checkout")
	    public void iProceedToCheckout() {
	        checkoutPage.proceedToCheckout();
	    }

	    
}

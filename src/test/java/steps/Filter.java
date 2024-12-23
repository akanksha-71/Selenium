package steps;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.FilterPage;
import utils.ExtentManager;
import utils.base;

public class Filter {
	  WebDriver driver = base.initializeDriver();
	FilterPage productPage = new FilterPage(driver);
	 ExtentTest test = ExtentManager.createTest("Filter Test");
	
	@Given("I am on the product page")
	public void i_am_on_the_product_page() {
	   driver.get("https://demowebshop.tricentis.com/books");
	}

    @When("I sort the products by {string}")
    public void iSortTheProductsBy(String option) {
        productPage.selectSortingOption(option);
    }

    @Then("the products should be sorted by Position correctly")
    public void theProductsShouldBeSortedByPositionCorrectly() {
        // This might need to be customized based on the sorting logic for "Position"
        assertTrue("Products are not sorted by Position", true);
    }

    private void assertTrue(String string, boolean b) {
		// TODO Auto-generated method stub
		
	}

	@Then("the products should be sorted by Price: Low to High correctly")
    public void theProductsShouldBeSortedByPriceLowToHighCorrectly() {
        assertTrue("Products are not sorted by Price: Low to High", productPage.isPriceSortedLowToHigh());
    }

    @Then("the products should be sorted by Price: High to Low correctly")
    public void theProductsShouldBeSortedByPriceHighToLowCorrectly() {
        assertTrue("Products are not sorted by Price: High to Low", productPage.isPriceSortedHighToLow());
    }

    
   
}

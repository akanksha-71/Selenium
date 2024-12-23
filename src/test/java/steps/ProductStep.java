package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentTest;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.ProductPage;
import utils.ExtentManager;

public class ProductStep {
    WebDriver driver;
    ProductPage productPage;
    ExtentTest test = ExtentManager.createTest("ProductStep Test");

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        productPage = new ProductPage(driver);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();  // Close the browser after each scenario
        }
    }

    @Given("I am on a product detail page")
    public void i_am_on_a_product_detail_page() {
        driver.get("https://demowebshop.tricentis.com/");
    }

    @When("I check all product images")
    public void i_check_all_product_images() {
        assert productPage.areAllProductImagesLoaded() : "Some product images failed to load!";
    }

    @Then("all product images should load successfully")
    public void all_product_images_should_load_successfully() {
        System.out.println("All product images are loaded successfully.");
    }

    @When("I check the product specifications and description")
    public void i_check_the_product_specifications_and_description() {
        assert productPage.isProductDescriptionDisplayed() : "Product description is missing!";
        assert productPage.isProductSpecificationsDisplayed() : "Product specifications are missing!";
    }

    @Then("they should be displayed correctly")
    public void they_should_be_displayed_correctly() {
        System.out.println("Product specifications and description are displayed correctly.");
    }

    @When("I click the \"Add to Cart\" button")
    public void i_click_the_add_to_cart_button() {
        productPage.clickAddToCart();
    }

    @When("I check the ratings")
    public void i_check_the_reviews_and_ratings() {
        assert productPage.areRatingsDisplayed() : "Ratings are missing!";
    }

    @Then("ratings should be displayed correctly")
    public void reviews_and_ratings_should_be_displayed_correctly() {
        System.out.println("Ratings are displayed correctly.");
    }

    @When("I click the \"Add to Wishlist\" button")
    public void i_click_the_add_to_wishlist_button() {
        productPage.clickAddToWishlist();
    }

    @Then("the product should be added to my wishlist")
    public void the_product_should_be_added_to_my_wishlist() {
        assert productPage.isProductAddedToWishlist() : "Product was not added to the wishlist!";
    }
}

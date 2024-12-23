package steps;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.NavigatePage;
import utils.ExtentManager;
import utils.base;

public class Navigate {
    WebDriver driver;
    NavigatePage navigationPage;
    ExtentTest test = ExtentManager.createTest("Navigate Test");

    // Initialize WebDriver and NavigatePage before each scenario
    @Before
    public void setUp() {
        driver = base.initializeDriver();  // Assuming this method sets up the driver (e.g., ChromeDriver)
        navigationPage = new NavigatePage(driver);  // Initialize NavigatePage with driver
    }

    @Given("User is on the homepage of the Demo Webshop")
    public void user_homepage() {
        driver.get("https://demowebshop.tricentis.com/");
    }

    @When("User selects the category {string}")
    public void user_selects_the_category(String category) {
        navigationPage.selectCategory(category);  // Call method to select the category
    }

    @Then("User should be on the {string} page")
    public void user_should_be_on_the_page(String expectedUrl) {
        assert navigationPage.isCorrectUrl(expectedUrl) : "Category URL mismatch!";
    }

    @When("User clicks on the {string} link in the navigation bar")
    public void user_clicks_on_the_link_in_the_navigation_bar(String linkText) {
        navigationPage.clickNavigationLink(linkText);
    }

    @Then("User should be navigated to the {string} category page")
    public void user_should_be_navigated_to_the_category_page(String category) {
        assert navigationPage.isCorrectUrl(category) : "Navigation URL mismatch!";
    }

    // Close the driver after the scenario is executed (optional)
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

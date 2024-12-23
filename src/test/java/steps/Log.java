package steps;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.LogPage;
import utils.ExtentManager;
import utils.base;


public class Log {
	   WebDriver driver = base.initializeDriver();
	    LogPage loginPage = new LogPage(driver);
	    ExtentTest test = ExtentManager.createTest("Login Test");

	    @Given("I am on the login page")
	    public void iAmOnTheLoginPage() {
	        loginPage.openLoginPage();
	    }

	    @When("I enter valid credentials with email {string} and password {string}")
	    public void iEnterValidCredentialsWithEmailAndPassword(String email, String password) {
	        loginPage.enterEmail(email);
	        loginPage.enterPassword(password);
	    }

	    @When("I click on the login button")
	    public void iClickOnTheLoginButton() {
	        loginPage.clickLoginButton();
	    }

	    @Then("I should be redirected to the homepage")
	    public void iShouldBeRedirectedToTheHomepage() {
	        assertTrue(loginPage.isRedirectedToHomepage());
	    }

	    @When("I enter invalid email {string} and password {string}")
	    public void iEnterInvalidEmailAndPassword(String email, String password) {
	        loginPage.enterEmail(email);
	        loginPage.enterPassword(password);
	    }
	    
	    @When ("I enter email {string} and invalid password {string}")
	    public void iEnterEmailAndInvalidPassword(String email, String password) {
	        loginPage.enterEmail(email);
	        loginPage.enterPassword(password);
	    }
	    
	    @When("I enter invalid credentials with email  {string} and password {string}")
	    public void invalid_credentials(String email, String password) {
	    	loginPage.enterEmail(email);
	        loginPage.enterPassword(password);
	    }
	    
	    @Then("I should see an error message {string}")
	    public void iShouldSeeAnErrorMessage(String errorMessage) {
	        assertEquals(errorMessage, loginPage.getErrorMessage());
	    }

	    @When("I leave the email and password fields empty")
	    public void iLeaveTheEmailAndPasswordFieldsEmpty() {
	        loginPage.enterEmail("");  // Leaving the fields empty
	        loginPage.enterPassword("");
	    }

	    @When("I check the {string} checkbox")
	    public void iCheckTheCheckbox(String checkboxLabel) {
	        loginPage.checkRememberMe();
	    }

	    @Then("I should be remembered when I return to the login page")
	    public void iShouldBeRememberedWhenIReturnToTheLoginPage() {
	        // Verify if the email field is populated with the saved email
	        String savedEmail = loginPage.getEmailFieldValue();
	        assertNotNull(savedEmail);
	    }
	}


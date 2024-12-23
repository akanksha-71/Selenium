package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogPage {
	WebDriver driver;

    // Locators for login page elements
    private By emailField = By.id("Email");
    private By passwordField = By.id("Password");
    private By loginButton = By.xpath("//input[@value='Log in']");
    private By errorMessage = By.xpath("//span[contains(text(),'Login was unsuccessful. Please correct the errors ')]");
    private By rememberMeCheckbox = By.id("RememberMe");

    // Constructor to initialize WebDriver
    public LogPage(WebDriver driver) {
        this.driver = driver;
    }

    // Method to open the login page
    public void openLoginPage() {
        driver.get("https://demowebshop.tricentis.com/login");  // Replace with the actual login page URL
    }

    // Method to enter email
    public void enterEmail(String email) {
        WebElement emailElement = driver.findElement(emailField);
        emailElement.sendKeys(email);
    }

    // Method to enter password
    public void enterPassword(String password) {
        WebElement passwordElement = driver.findElement(passwordField);
        passwordElement.sendKeys(password);
    }

    // Method to click the login button
    public void clickLoginButton() {
        WebElement loginBtn = driver.findElement(loginButton);
        loginBtn.click();
    }

    // Method to get the error message
    public String getErrorMessage() {
        WebElement errorElement = driver.findElement(errorMessage);
        return errorElement.getText();
    }

    // Method to check the "Remember Me" checkbox
    public void checkRememberMe() {
        WebElement rememberMeElement = driver.findElement(rememberMeCheckbox);
        rememberMeElement.click();
    }

    // Method to verify if the user is redirected to the homepage
    public boolean isRedirectedToHomepage() {
        String currentUrl = driver.getCurrentUrl();
        return currentUrl.contains("https://demowebshop.tricentis.com/");  // Replace with actual homepage URL or check
    }

    // Method to verify the email field is populated with a remembered email
    public String getEmailFieldValue() {
        WebElement emailElement = driver.findElement(emailField);
        return emailElement.getAttribute("value");
    }

	
}


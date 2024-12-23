package page;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class CheckoutPage {
	private WebDriver driver;

    // Web Elements for checkout process
    private By discountCodeInput = By.cssSelector("input[name='discountcouponcode']");
    private By applyDiscountButton = By.cssSelector("input[value='Apply coupon']");
    private By giftCardInput = By.cssSelector("input[name='giftcardcouponcode']");
    private By applyGiftCardButton = By.cssSelector("input[value='Add gift card']");
    private By countryDropdown = By.cssSelector("#CountryId");
    private By stateDropdown = By.cssSelector("#StateProvinceId");
    private By zipInput = By.cssSelector("#ZipPostalCode");
    private By estimateShippingButton = By.cssSelector("input[value='Estimate shipping']");
    private By termsCheckbox = By.id("termsofservice");
    private By checkoutButton = By.id("checkout");
    private By totalAmount = By.xpath("//span[@class='nobr'][normalize-space()='Total:']");


    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    // Method to enter shipping details
    public void enterShippingDetails(String country, String state, String zip) {
    	WebElement countryElement = driver.findElement(countryDropdown);
        Select select = new Select(countryElement);
        select.selectByVisibleText(country);
        driver.findElement(stateDropdown).sendKeys(state);
        driver.findElement(zipInput).sendKeys(zip);
    }

    // Method to apply discount code
    public void applyDiscountCode(String discountCode) {
        driver.findElement(discountCodeInput).sendKeys(discountCode);
        driver.findElement(applyDiscountButton).click();
    }

    // Method to apply gift card code
    public void applyGiftCard(String giftCardCode) {
        driver.findElement(giftCardInput).sendKeys(giftCardCode);
        driver.findElement(applyGiftCardButton).click();
    }

    // Method to estimate shipping
    public void estimateShipping() {
        driver.findElement(estimateShippingButton).click();
    }

    // Method to agree with the terms of service
    public void agreeToTerms() {
        driver.findElement(termsCheckbox).click();
    }

    // Method to proceed to checkout
    public void proceedToCheckout() {
        driver.findElement(checkoutButton).click();
    }

   
    // Method to get total amount
    public String getTotalAmount() {
        return driver.findElement(totalAmount).getText();
    }
}

package page;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {
	 WebDriver driver;
	  

	    public ProductPage(WebDriver driver) {
	       
	       
	        PageFactory.initElements(driver, this);
	    }

	    @FindBy(css = ".picture")
	    List<WebElement> productImages;

	    @FindBy(css = ".details")
	    WebElement productDescription;

	    @FindBy(css = ".item-box")
	    WebElement productSpecifications;
	  
	    @FindBy(css = ".button-2.product-box-add-to-cart-button")
	    WebElement addToCartButton;

	    
	    @FindBy(css = ".cart-qty")
	    WebElement cartCount;

	   
	    @FindBy(css = ".rating")
	    WebElement productRatings;
	    
	    @FindBy(xpath = "//span[@class='wishlist-qty']")
	    WebElement addToWishlistButton;

	    @FindBy(id = "bar-notification")
	    WebElement wishlistNotification;

	    public boolean areAllProductImagesLoaded() {
	    	 boolean allLoaded = true;
	    
	        for (WebElement img : productImages) {
	        	 if (img.isDisplayed() && img.getAttribute("src") != null && !img.getAttribute("src").isEmpty()) {
	                 // Image has loaded successfully
	                 allLoaded = allLoaded && true;
	             } else {
	                 // Image has not loaded or src is empty
	                 allLoaded = false; }
	             
	              }
	           return allLoaded;
	        }

	    public boolean isProductDescriptionDisplayed() {
	        return !productDescription.getText().isEmpty();
	    }

	    public boolean isProductSpecificationsDisplayed() {
	        return !productSpecifications.getText().isEmpty();
	    }

	    public void clickAddToCart() {
	        addToCartButton.click();
	    }

	   

	    public boolean areRatingsDisplayed() {
	        return  productRatings.isDisplayed();
	    }

	    public void clickAddToWishlist() {
	        addToWishlistButton.click();
	    }

	    public boolean isProductAddedToWishlist() {
	        return wishlistNotification.isDisplayed() && wishlistNotification.getText().contains("added to your wishlist");
	    }
	}

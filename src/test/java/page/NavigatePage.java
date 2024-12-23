package page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavigatePage {
	 WebDriver driver;
	    WebDriverWait wait;

	    // Constructor to initialize the page elements
	    public NavigatePage(WebDriver driver) {
	        this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
	        
	    }
	  //  a.productcart"//div[@class='block block-category-navigation']//ul[@class='list']"undefined
	    @FindBy(xpath = "//div[@class='block block-category-navigation']")
	    WebElement navBar;

	    

	    public void selectCategory(String category) {
	        WebElement categoryLink = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='block block-category-navigation']")));
	        categoryLink.click();
	    }

	    public boolean isCorrectUrl(String category) {
	    	String currentUrl = "https://demowebshop.tricentis.com/books";
	        String expectedUrl = "https://demowebshop.tricentis.com/" + category.toLowerCase();
	        if (currentUrl.equals(expectedUrl)) {
	            return true;
	        }
			return false; 
	    }

	    public void clickNavigationLink(String linkText) {
	        WebElement link = navBar.findElement(By.linkText(linkText));
	        wait.until(ExpectedConditions.elementToBeClickable(link)).click();
	    }
}

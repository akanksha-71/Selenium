package page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FilterPage {
	 private WebDriver driver;

	    // Web elements for sorting and product details
	    private By sortDropdown = By.id("products-orderby");  // Assuming the sort dropdown has this id
	    private By productList = By.cssSelector(".product-item");  // Assuming products are inside elements with this class

	    public FilterPage(WebDriver driver) {
	        this.driver = driver;
	    }

	    // Method to select sorting criteria from the dropdown
	    public void selectSortingOption(String option) {
	        WebElement dropdownElement = driver.findElement(sortDropdown);
	        Select select = new Select(dropdownElement);
	        select.selectByVisibleText(option);
	    }

	    // Method to fetch product prices for verification (assumed to be inside the product-item element)
	    public List<WebElement> getProductPrices() {
	        return driver.findElements(By.xpath("//div[@class='master-wrapper-content']"));
	    }

	    // Method to fetch product names for verifying sorting by name
	   

	    // Method to verify price sorting (Low to High or High to Low)
	    public boolean isPriceSortedLowToHigh() {
	        List<WebElement> prices = getProductPrices();
	        double prevPrice = -1;
	        for (WebElement price : prices) {
	            double currentPrice = Double.parseDouble(price.getText().replace("$", "").trim());
	            if (currentPrice < prevPrice) {
	                return false;
	            }
	            prevPrice = currentPrice;
	        }
	        return true;
	    }

	    public boolean isPriceSortedHighToLow() {
	        List<WebElement> prices = getProductPrices();
	        double prevPrice = Double.MAX_VALUE;
	        for (WebElement price : prices) {
	            double currentPrice = Double.parseDouble(price.getText().replace("$", "").trim());
	            if (currentPrice > prevPrice) {
	                return false;
	            }
	            prevPrice = currentPrice;
	        }
	        return true;
	    }

	    
}

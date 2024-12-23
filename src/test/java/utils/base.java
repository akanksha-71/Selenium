package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class base {
	   WebDriver driver;

	    public static WebDriver initializeDriver() {
	        
	        ChromeOptions options = new ChromeOptions();
	        options.addArguments("--start-maximized");
	        return new ChromeDriver(options);
	    }

	    public void quitDriver() {
	       
	            driver.quit();
	        
	    }
}

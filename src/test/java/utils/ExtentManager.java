package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	private static ExtentReports extent; // Static instance of ExtentReports

    // Method to initialize ExtentReports
    public static ExtentReports getInstance() {
        if (extent == null) {
            String reportPath = System.getProperty("user.dir") + "/test-output/ExtentReport.html";
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);
            extent.setSystemInfo("Tester", "Akanksha Darade");
        }
        return extent;
    }

    // Method to create a test in the report
    public static ExtentTest createTest(String testName) {
        if (extent == null) {
            getInstance(); // Ensure the ExtentReports instance is initialized
        }
        return extent.createTest(testName); // Create and return the test
    }
}

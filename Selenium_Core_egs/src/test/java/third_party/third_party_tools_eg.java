package third_party;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
public class third_party_tools_eg {
	WebDriver driver;
    Logger log = LogManager.getLogger(third_party_tools_eg.class);
    ExtentReports extent;
    ExtentTest test;

    @BeforeTest
    public void setupReport() {
        ExtentSparkReporter reporter =
                new ExtentSparkReporter("test-output/ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(reporter);
    }

    @Test
    public void verifyGoogleTitle() {
        test = extent.createTest("Google Title Test");

        log.info("Launching browser");
        driver = new ChromeDriver();

        log.info("Opening Google");
        driver.get("https://www.google.com/");
        test.info("Navigated to Google");

        String title = driver.getTitle();
        log.info("Page title: {}", title);

        Assert.assertEquals(title, "Google");
        test.pass("Title verified successfully");

        driver.quit();
        log.info("Browser closed");
    }

    @AfterTest
    public void tearDown() {
        extent.flush();
    }

}

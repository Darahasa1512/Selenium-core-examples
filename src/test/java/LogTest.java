import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LogTest {

    private static final Logger logger = LogManager.getLogger(LogTest.class);

    public static void main(String[] args) {

        logger.info("Test started");

        WebDriver driver = new ChromeDriver();
        logger.debug("Chrome browser launched");

        driver.get("https://www.google.com");
        logger.info("Navigated to Google");

        String title = driver.getTitle();
        logger.info("Page title is: " + title);

        if (title.contains("Google")) {
            logger.info("Title validation PASSED");
        } else {
            logger.error("Title validation FAILED");
        }

        driver.quit();
        logger.info("Browser closed");
        logger.info("Test completed");
    }
}

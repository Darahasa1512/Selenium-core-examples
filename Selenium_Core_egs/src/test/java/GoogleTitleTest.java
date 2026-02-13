import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class GoogleTitleTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void googleTitleTest() {

        driver.get("https://www.google.com");

        String title = driver.getTitle();
        Assert.assertTrue(title.contains("Google"));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login_Test {

    @Test
    public void validLoginTest() {

        ChromeOptions options = new ChromeOptions();
        // COMMENT THIS LINE when running in Eclipse if you want browser visible
        //options.addArguments("--headless=new");

        WebDriver driver = new ChromeDriver(options);

        driver.get("https://the-internet.herokuapp.com/login");

        driver.findElement(By.id("username"))
                .sendKeys("tomsmith");

        driver.findElement(By.id("password"))
                .sendKeys("SuperSecretPassword!");

        driver.findElement(By.cssSelector("button[type='submit']"))
                .click();

        String successMsg = driver.findElement(By.id("flash")).getText();

        Assert.assertTrue(successMsg.contains("You logged into a secure area"));

        driver.quit();
    }
}

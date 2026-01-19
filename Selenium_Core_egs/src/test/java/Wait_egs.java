import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

public class Wait_egs {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
        driver.manage().window().maximize();

        driver.findElement(By.name("firstname")).sendKeys("Tom");
        driver.findElement(By.name("lastname")).sendKeys("Wood");

        driver.findElement(By.id("sex-0")).click();
        driver.findElement(By.id("exp-4")).click();

        driver.findElement(By.id("datepicker")).sendKeys("16-10-2020");

        driver.findElement(By.id("profession-1")).click();

        driver.findElement(By.id("tool-2")).click();

        Select continents = new Select(driver.findElement(By.id("continents")));
        continents.selectByVisibleText("Europe");

        Select seleniumCommands = new Select(driver.findElement(By.id("selenium_commands")));
        seleniumCommands.selectByVisibleText("Browser Commands");

        //Explicit Wait for Submit Button
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement submitBtn = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("submit"))
);

        //Scroll to Submit Button if off-screen
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", submitBtn);

        submitBtn.click();

        driver.quit();
    }
}

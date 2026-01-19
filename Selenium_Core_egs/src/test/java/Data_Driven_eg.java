import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Data_Driven_eg {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test(dataProvider = "formData")
    public void fillForm(String firstName, String lastName, String email,
                         String gender, String phone) throws InterruptedException {

        driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");

        driver.findElement(By.id("name")).sendKeys(firstName);
        driver.findElement(By.id("email")).sendKeys(email);

        if (gender.equalsIgnoreCase("Male")) {
            driver.findElement(By.xpath("//*[@id=\"gender\"]")).click();
        } else {
            driver.findElement(By.xpath("//*[@id=\"practiceForm\"]/div[3]/div/div/div[2]/input")).click();
        }

        driver.findElement(By.id("mobile")).sendKeys(phone);

        WebElement submit = wait.until(
        	    ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"practiceForm\"]/div[11]/input"))
        	);

        	((JavascriptExecutor) driver)
        	    .executeScript("arguments[0].scrollIntoView({block:'center'});", submit);

        	Thread.sleep(300);

        	submit.click();


        System.out.println("Data added successfully");
    }

    

    @DataProvider(name = "formData")
    public Object[][] getData() {
        return new Object[][] {
            { "Tom", "Wood", "tom@gmail.com", "Male", "9876543210" },
            { "Sara", "Lee", "sara@gmail.com", "Female", "9876501234" },
            { "John", "Smith", "john@gmail.com", "Male", "9876598765" }
        };
    }


    @AfterMethod
    public void tearDown() {
    	System.out.println("Data added successfully");
        driver.quit();
    }
}

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Keyboard_Mouse_actions {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.tutorialspoint.com/selenium/practice/upload-download.php");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement uploadInput = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.id("uploadFile"))
        );

        Actions actions = new Actions(driver);

        actions.moveToElement(uploadInput).click().perform();//Move to upload element and clicking
        uploadInput.sendKeys("C:\\Users\\darah\\OneDrive\\Desktop\\Test.txt");
        
        WebElement downloadBtn = driver.findElement(By.linkText("Download"));//Keys to download
        
        actions.moveToElement(downloadBtn)
               .click()                     // click to focus
               .keyDown(Keys.CONTROL)       // press Control
               .sendKeys("a")               // press 'a' with Control
               .keyUp(Keys.CONTROL)         // release Control
               .perform();
        System.out.println("Keyboard control success");

        actions.contextClick(downloadBtn).perform();
        System.out.println("Right Click success");

        actions.doubleClick(downloadBtn).perform();
        System.out.println("Double Click success");
      
        driver.quit();//Closing Browser
    }
}

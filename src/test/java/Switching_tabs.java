import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Switching_tabs {
   public static void main(String[] args) throws InterruptedException {

      WebDriver driver = new ChromeDriver();

      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

      driver.get("https://www.tutorialspoint.com/selenium/practice/browser-windows.php");

      WebElement b = driver.findElement(By.xpath("/html/body/main/div/div/div[2]/button[1]"));
      b.click();
      
      String oW = driver.getWindowHandle();
      
      Set<String> windows = driver.getWindowHandles();

      for (String w : windows) {
         if(!oW.equalsIgnoreCase(w)) {
         
            driver.switchTo().window(w);
            
            WebElement e = driver.findElement
               (By.xpath("/html/body/main/div/div/h1"));
            System.out.println("Text in new tab is: " + e.getText());
            break;
         }
      }
      
      driver.quit();
   }
}
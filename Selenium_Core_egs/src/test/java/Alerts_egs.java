import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Alerts_egs {
   public static void main(String[] args) throws InterruptedException {
   
      WebDriver driver = new ChromeDriver();
      
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
      
      driver.get("https://www.tutorialspoint.com/selenium/practice/alerts.php");
      
      WebElement c = driver.findElement(By.xpath("//button[text()='Alert']"));
      c.click();
      Alert alrt = driver.switchTo().alert();
      alrt.dismiss();
      c.click();
      String s = alrt.getText();
      System.out.println("Alert text is: " + s);// Regular alert
      alrt.accept();
      
      driver.findElement(By.xpath("/html/body/main/div/div/div[2]/div[3]/button")).click();
      Alert alrt1 = driver.switchTo().alert();
      String s1 = alrt1.getText();
      System.out.println("Alert text is: " + s1);
      alrt1.accept();
      WebElement text =driver.findElement(By.xpath("//*[@id='desk']"));
      System.out.println("Text appearing after alert accept: " + text.getText());
      c.click();
      Alert alrt11 = driver.switchTo().alert();
      alrt11.dismiss();
      WebElement text1 =driver.findElement(By.xpath("//*[@id='desk']"));
      System.out.println("Text appearing after alert dismiss: " + text1.getText());//Confirmation Alerts
      
      driver.findElement(By.xpath("/html/body/main/div/div/div[2]/div[4]/button")).click();
      Alert alrt2 = driver.switchTo().alert();
      String s2 = alrt2.getText();
      System.out.println("Alert text is: " + s2);
      alrt2.sendKeys("Selenium");
      alrt2.accept();c.click();
      Alert alrt22 = driver.switchTo().alert();alrt22.sendKeys("Selenium");
      alrt22.dismiss();//Prompt Alerts
      
      // quitting the browser
      driver.quit();
      System.out.println("Test run success");
   }
}
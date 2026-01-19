import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Cookies_eg {
   public static void main(String[] args) throws InterruptedException {

      WebDriver driver = new ChromeDriver();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

      driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");

      driver.manage().addCookie(new Cookie("C1", "VAL1"));
      driver.manage().addCookie(new Cookie("C2", "VAL2"));
      driver.manage().addCookie(new Cookie("C3", "VAL3"));//Adding cookies
      System.out.println("Cookies added successfully");

      Set<Cookie> c = driver.manage().getCookies();
      System.out.println("Cookie details are: " + c);//Getting cookies details

      driver.manage().deleteCookieNamed("C3");//Deleting a certain cookie
      System.out.println("Cookie deleted successfully");

      Set<Cookie> c1 = driver.manage().getCookies();
      System.out.println("Cookie details after deleting C3 cookie are: " + c1);//Cookie details after deletion

      // Closing browser
      driver.quit();
      System.out.println("Code ran successfully");
   }
}
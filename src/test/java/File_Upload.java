import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
public class File_Upload {
	public static void main(String args[]) throws InterruptedException{
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.get("https://www.tutorialspoint.com/selenium/practice/upload-download.php");
		WebElement m = driver.findElement(By.xpath("//*[@id='uploadFile']"));
	      File f = new File("C:\\Users\\darah\\OneDrive\\Desktop\\Test.txt");
	      System.out.println("Getting the file path to be uploaded: " + f.getAbsolutePath());

	      m.sendKeys(f.getAbsolutePath());

	      if (m.getAttribute("value").equalsIgnoreCase("Test.txt")) {
	         System.out.println("File uploaded successfully ");
	      } else {
	         System.out.println("File uploaded unsuccessfully ");
	      }

	      driver.quit();
	   }
	}

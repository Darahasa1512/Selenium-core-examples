import java.io.File;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;
import org.apache.commons.io.FileUtils;

public class Screenshots_eg {

    public static void main(String[] args) throws IOException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");

        // Take screenshot
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        System.out.println("Screenshot taken successfully");

        // Destination path
        File destination = new File("./screenshots/homepage.png");
        System.out.println("Screenshot in destination success");

        // Copy file
        FileUtils.copyFile(source, destination);
        System.out.println("Screenshot saved successfully");

        driver.quit();
    }
}


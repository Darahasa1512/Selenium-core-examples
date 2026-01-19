import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class BrowserOptions_Capabilities_HeadlessTesting{
	public static void main(String args[]) {
		ChromeOptions option= new ChromeOptions();
		option.addArguments("--headless=new"); // Headless Testing
        option.addArguments("--window-size=1920,1080");
		option.addArguments("--incognito");//Options
		System.out.println("Incognito done success");
		//option.addArguments("--start-maximized");
		//System.out.println("Page maximised successfully");
		option.addArguments("--disable-notifications");
		System.out.println("Notifications disabled successfully");
		
		//option.setAcceptInsecureCerts(true);//Capabilities
        //option.setCapability("browserName", "chrome");
        //option.setCapability("platformName", "Windows");
		
		WebDriver driver= new ChromeDriver(option);
		driver.get("https://www.google.com/");
		
		//try {
			//Thread.sleep(4000);
		//} catch(InterruptedException e) {}
		
		System.out.println("Title: " + driver.getTitle());
		
		driver.quit();
		
		System.out.println("Browser options done successfully");
	}

}

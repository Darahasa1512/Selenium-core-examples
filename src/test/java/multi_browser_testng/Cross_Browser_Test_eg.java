package multi_browser_testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Cross_Browser_Test_eg {
	
	static WebDriver driver=null;
	
	@Parameters("browser")
	@BeforeTest
	public void setup(String browser) {
		System.out.println("Browser:" +browser);
		if (browser.equalsIgnoreCase("chrome")){
			driver= new ChromeDriver();
		}
		if (browser.equalsIgnoreCase("ie")){
			driver= new InternetExplorerDriver();
		}
		
		
	}

	@Test
	public void test1() throws Exception {
		driver.get("https://www.google.com/");
		Thread.sleep(1000);
	}
	
	@AfterTest
	public static void teardown() {
		driver.close();
		System.out.println("Cross Browser Test Success");
		
	}
}

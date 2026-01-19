package test;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import page_objectmodel.page_object_model_eg;

public class pom_test_eg {
	private static WebDriver driver= null;
	public static void main(String args[]) {
		googleSearch();
	}
	public static void googleSearch() {
		driver=new ChromeDriver();
		driver.get("https://www.google.com/");
		page_object_model_eg.google_search(driver).sendKeys("Selenium Page Object Model");
		System.out.println("Search success");
		page_object_model_eg.button_search(driver).click();
		System.out.println("Search button clicked success");
		
		driver.close();
		System.out.println("Page Object Model example success");
	}

}

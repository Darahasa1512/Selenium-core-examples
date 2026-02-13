package page_objectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class page_object_model_eg {
	private static WebElement search=null;
	
	public static WebElement google_search(WebDriver driver) {
		search=driver.findElement(By.name("q"));
		return search;
	}
	public static WebElement button_search(WebDriver driver) {
		search=driver.findElement(By.xpath("/html/body/div[2]/div[4]/form/div[1]/div[1]/div[3]/center/input[1]"));
		return search;
	}

}

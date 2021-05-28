package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectUtility {

	static WebDriver driver;
	
	public static WebElement getElement(By locator) {
		
		return driver.findElement(locator);
		
	}
	
	public static void doSelectByVisibleText(By locator , String value) {
		
		
		Select select = new Select(getElement(locator));
		
		select.selectByVisibleText(value);
		
	}
	
	
	
	
	
	
	
}

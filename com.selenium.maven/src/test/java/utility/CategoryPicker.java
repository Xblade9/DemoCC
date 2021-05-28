package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CategoryPicker {

	public static WebElement xpathForDiffCategories(WebDriver driver, String i)

	{

		return driver.findElement(By.xpath("//ul[@class='listNone navbarLft']/li[" + i + "]"));

	}
}

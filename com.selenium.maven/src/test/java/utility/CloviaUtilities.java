package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CloviaUtilities {

	

	public static WebElement xpathForDiffCategories(WebDriver driver, String i)

	{

		return driver.findElement(By.xpath("//ul[@class='listNone navbarLft']/li[" + i + "]"));

	}

	public static WebElement xpathForShopByCategories(WebDriver driver, String text) {

		return driver.findElement(By.xpath("//a[text()='" + text + "']/parent::li"));

	}

	public static WebElement xpathForProductsDisplay(WebDriver driver, String i)

	{

		return driver.findElement(By.xpath("//ul[@id='id_all_list']/li[" + i + "]"));

	}

	public static WebElement xpathForSubTypeText(WebDriver driver) {
		
		return driver.findElement(By.xpath("//h1[@class='countCat ']"));
		
	}
	
public static WebElement xpathForSizeType(WebDriver driver,String i) {
		
		return driver.findElement(By.xpath("//ul[@id='selectSize1']/li['"+i+"']"));
		
	}
	
}

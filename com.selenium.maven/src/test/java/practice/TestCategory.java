package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCategory {

	public static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(19, TimeUnit.SECONDS);

		driver.get("https://www.clovia.com");

		Actions action = new Actions(driver);

		action.moveToElement(xpathForDiffCategories(driver, "6")).perform();

	}

	public static WebElement xpathForDiffCategories(WebDriver xdriver, String i)

	{

		return driver.findElement(By.xpath("//ul[@class='listNone navbarLft']/li[" + i + "]"));

	}

}

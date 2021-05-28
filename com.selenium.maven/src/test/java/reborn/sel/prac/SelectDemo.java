package reborn.sel.prac;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectDemo {

	public String url = "http://demo.guru99.com/test/newtours/register.php";

	public WebDriver driver;

	@Test
	public void f() {
		
		
		JavascriptExecutor js =(JavascriptExecutor)driver;
		
		js.executeScript("window.scrollBy(0,1000)");

		Select s = new Select(driver.findElement(By.xpath("//select[@name='country']")));

		s.selectByVisibleText("INDIA");

	}

	@BeforeTest

	public void open() {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		driver.get(url);

	}

}

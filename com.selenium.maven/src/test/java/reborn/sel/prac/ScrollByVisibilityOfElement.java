package reborn.sel.prac;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScrollByVisibilityOfElement {

	public String url = "http://demo.guru99.com/test/guru99home/";

	public WebDriver driver;

	@Test
	public void f() {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement w = driver.findElement(By.xpath("//div[@class='canvas-middle'] //child::a[text()='SAP Beginners']"));

		js.executeScript("arguments[0].scrollIntoView();", w);

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

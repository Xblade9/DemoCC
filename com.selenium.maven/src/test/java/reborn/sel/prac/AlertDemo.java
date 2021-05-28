package reborn.sel.prac;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertDemo {

	public String url = "http://demo.guru99.com/test/delete_customer.php";

	public WebDriver driver;

	public WebDriverWait wait;

	@Test
	public void alertDemo() throws InterruptedException {

		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Demo123");

		driver.findElement(By.xpath("//input[@type='submit']")).submit();

		String a = driver.switchTo().alert().getText();

		System.out.println(a);

		Thread.sleep(5000);

		driver.switchTo().alert().accept();

	}

	@BeforeTest

	public void open() {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		driver.get(url);

	}

	@AfterTest
	
	public void quit() {
		
		driver.quit();
		
	}
	
	
}

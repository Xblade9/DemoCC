package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.DPicker;

public class Dchecker {

	public String url = "https://www.makemytrip.com";

	public WebDriver driver;

	@Test
	public void f() {

		driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
		
		DPicker.selectDate(driver, "12", "May", "2021");
       
		driver.findElement(By.xpath("//span[text()='RETURN']")).click();
		
		DPicker.selectDateReturn(driver, "28", "May", "2021");
		
	}

	@BeforeTest
	public void beforeTest() {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		driver.get(url);

		driver.findElement(By.tagName("body")).click();

		Assert.assertTrue(driver.getTitle().contains("Make"), "Page Title Not Matched");

		System.out.println(driver.getTitle());

	}

	
	  @AfterTest public void afterTest() {
	  
	  try { Thread.sleep(5000); driver.quit(); } catch (Exception e) {
	  e.printStackTrace(); }
	  
	  }
	 
	
}

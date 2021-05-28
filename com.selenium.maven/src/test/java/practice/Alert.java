package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alert {
	
	public WebDriver driver;
	public String url = "http://demo.guru99.com/test/delete_customer.php ";
	
	
	
  @Test
  public void f() {
	  
	  
	  driver.findElement(By.xpath("//input[@type='text']")).sendKeys("911");
	  
	  driver.findElement(By.xpath("//input[@type='submit']")).click();
	  
	  org.openqa.selenium.Alert alert=driver.switchTo().alert();
	  
	  System.out.println(alert.getText());
	  
	  alert.accept();
	  
  }
  
  
  
  @BeforeTest
	public void beforeTest() {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get(url);

	}

	@AfterTest
	public void afterTest() throws Exception {

		Thread.sleep(2000);
		
		driver.quit();
	}
  
}

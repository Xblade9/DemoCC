package ecommerceScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyCart {

	
	public WebDriver driver;
	
	public WebDriverWait wait;
	
	public String URL="http://live.demoguru99.com/index.php/";
	
	
	@BeforeMethod(description = "For Opening the Appn")
	
	public void open()
	{
		
		WebDriverManager.chromedriver().setup();
		
		driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		driver.get(URL);
		
        Assert.assertTrue(driver.getTitle().contains("Home"));
		
		System.out.println(driver.getTitle());
		
		
	}
	
	
	
	@Test(description = "verify that you cannot add more product in Cart then the product available in store")
	
	public void verifyCart()
	{
		
		
		try
		
		{
			
			
			WebElement e;
			
			e=driver.findElement(By.cssSelector("#header-nav >nav >ol >li:first-child >a"));
			
		    e.click();	 
			
			Assert.assertTrue(driver.getTitle().contains("Mo"));
			
			System.out.println(driver.getTitle());
			
			e=driver.findElement(By.cssSelector("li[class='item last']:first-child >div >div >button >span >span "));
			
			System.out.println(e.getText());
			
			e.click();
			
			Assert.assertTrue(driver.getTitle().contains("Shop"));
			
			System.out.println(driver.getTitle());
			
			e=driver.findElement(By.cssSelector("tr[class='first last odd'] >td:nth-child(4) >input"));
			
			e.click();
			
			e.clear();
			
			e.sendKeys("1000");
			
			e=driver.findElement(By.cssSelector("tr[class='first last odd'] >td:nth-child(4) >button >span"));
			
			e.click();
			
			e=driver.findElement(By.cssSelector("p[class='item-msg error']"));
			
			Assert.assertTrue(e.getText().contains("The"));
			
			System.out.println(e.getText());
			
			e=driver.findElement(By.cssSelector("tr[class='first last']:nth-child(1) >td >button:nth-child(2) >span"));
			
			e.click();
			
			Assert.assertTrue(driver.getTitle().contains("Shop"));
			
			System.out.println(driver.getTitle());
			
			e=driver.findElement(By.cssSelector("div[class='col-main'] >div:last-child >p:first-child"));
			
			Assert.assertTrue(e.getText().contains("You"));
			
			System.out.println(e.getText());
			
			
			
			
		}
		
		
		catch(Exception e)
		
		{
			
			e.printStackTrace();
			
		}
		
	}
	
	
 @AfterMethod(description = "close the Appn")
	
	public void close()
	{
		
		try
		
		{
			
			
			Thread.sleep(3000);
			
			driver.quit();
			
			
			
		}
		
		
		catch(Exception e)
		
		{
			
			e.printStackTrace();
			
		}
		
		
		
	}
	
		
}

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

public class VerifyCostOfProduction {
	
	
	
	public WebDriver driver;
	
	public WebDriverWait wait;
	
	public String URL="http://live.demoguru99.com/index.php/";
	
	
	@BeforeMethod(description = "For Opening the Appn")
	
	public void open()
	{
		
		
		WebDriverManager.chromedriver().setup();
		
		driver= new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		driver.get(URL);
		
		Assert.assertTrue(driver.getTitle().contains("Home"));
		
		System.out.println(driver.getTitle());
		
		
		
	}
	
	
	@Test(description = "verify the cost of product in list page and details page are equal")
	
	public void verifyCost()
	
	{
		
		try
		
		{
			
			
			WebElement e;
			
			e=driver.findElement(By.cssSelector("#header-nav >nav >ol >li:first-child >a"));
			
			e.click();
			
			Assert.assertTrue(driver.getTitle().contains("Mobile"));
			
			System.out.println(driver.getTitle());
			
			e=driver.findElement(By.cssSelector(".product-info >div >span#product-price-1 >span"));
			
			String mobileMenuCost=e.getText();
			
			System.out.println("Mobile Menu Cost : "+mobileMenuCost);
 			
            e.click();
            
            e=driver.findElement(By.xpath("//a[text()='Sony Xperia']"));
            
            e.click();
            
            Assert.assertTrue(driver.getTitle().contains("Sony"));
            
            System.out.println(driver.getTitle());
			
            e=driver.findElement(By.cssSelector("#product-price-1 >span"));
            
            String detailPagePrice=e.getText();
            
            System.out.println("Detail Page Price : "+detailPagePrice);
            
            Assert.assertEquals(mobileMenuCost, detailPagePrice);
            
            System.out.println("Compare Successfully....");
            
			
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

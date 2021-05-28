package ecommerceScripts;

import java.util.Set;
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
import utility.ScreenshortUtility;

public class VerifyCompareTwoProduct {

	
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
	
	
	@Test(description = "Verify that you are able to Compare two product")
	
	public void compareTwoProduct()
	{
		
		
		try
		
		{
			
			WebElement e;
			
			e=driver.findElement(By.cssSelector("#header-nav >nav >ol >li:first-child >a"));
			
		    e.click();	 
			
			Assert.assertTrue(driver.getTitle().contains("Mo"));
			
			System.out.println(driver.getTitle());
			
			e=driver.findElement(By.cssSelector("div.category-products > ul > li:nth-child(1) > div > div.actions > ul > li:nth-child(2) > a"));
			
			e.click();
			
			e=driver.findElement(By.cssSelector("div[class='category-products'] >ul >li:nth-child(2) >div >div:nth-child(4) >ul >li:nth-child(2) >a"));
			
			e.click();
			
			e=driver.findElement(By.cssSelector("div[class='block block-list block-compare'] >div:nth-child(2) >div >button"));
			
			e.click();

			String parentWindow=driver.getWindowHandle();
			
			System.out.println("Parent window : "+parentWindow);
			
			Set<String>productComparisonList=driver.getWindowHandles();
			
			for(String s:productComparisonList)
			{
				
				if(!parentWindow.equalsIgnoreCase(s))
				{
					
					
					driver.switchTo().window(s);
					
					driver.manage().window().maximize();
					
					Assert.assertTrue(driver.getTitle().contains("Prod"));
					
					System.out.println(driver.getTitle());
					
					e=driver.findElement(By.cssSelector("tr[class='odd']:first-child"));
					
					System.out.println(e.getText());
					
					ScreenshortUtility.takeScreenshortUtility(driver, "ProductsReflected");
					
					Thread.sleep(2000);
					
					driver.quit();
					
				}
				
				//driver.switchTo().window(parentWindow);
				
				
			}
			
			
		}
		
		
		catch(Exception e)
		
		{
			
			e.printStackTrace();
			
		}
		
	}
	
	
	 @AfterMethod(description = "close the Appn")
		
		public void tearDown()
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

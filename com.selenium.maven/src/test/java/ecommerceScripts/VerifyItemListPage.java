package ecommerceScripts;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.ScreenshortUtility;

public class VerifyItemListPage

{

	public WebDriver driver;
	
	public String URL="http://live.demoguru99.com/index.php/";
	
	public WebDriverWait wait;
	
	
	@BeforeMethod(description = "For Opening the Application")
	
	public void open()
	{
		
	    WebDriverManager.chromedriver().setup();
	    
	    driver=new ChromeDriver();
	    
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	    driver.manage().window().maximize();
	    
	    driver.get(URL);
		
		Assert.assertTrue(driver.getTitle().contains("Home"),"Failed To Get PageTitle");
		
		System.out.println("Page Title : "+driver.getTitle());
		
		WebElement e=driver.findElement(By.cssSelector(".page-title >h2"));
		
		System.out.println("Home Page Text : "+e.getText());
		
		ScreenshortUtility.takeScreenshortUtility(driver, "ApplicationFrontPage");
		
		
	}
	
	
	@Test(description = "Verify items in Mobile list page Can be Sorted by name")
	
	public void verifyItem()
	{
		
		try
		
		{
			
			WebElement e;
			
			e=driver.findElement(By.cssSelector("#header-nav >nav >ol >li >a[href='http://live.demoguru99.com/index.php/mobile.html']"));
			
			e.click();
			
			Assert.assertTrue(driver.getTitle().contains("Mobile"),"Failed To Get Title After mobile Click");
			
			System.out.println("Mobile Page Title : "+driver.getTitle());
			
			ScreenshortUtility.takeScreenshortUtility(driver, "AfterClickOnMobileTab");
			
			e=driver.findElement(By.cssSelector(".category-products >div >div >div >select"));
			
			Select s = new Select(e);
			
			s.selectByVisibleText("Name");
						
			List<WebElement>itr=driver.findElements(By.cssSelector(".products-grid >li"));
			
			int size=itr.size();
			
			System.out.println("Total Size : "+size);
			
			System.out.println(" ");
			
			for(WebElement web :itr)
			{
				
				System.out.println(web.getText());
				
				
				System.out.println("*************");
			}
			
			System.out.println(" ");
			
			ScreenshortUtility.takeScreenshortUtility(driver, "AllProdSortedByName");
			
			System.out.println(" ");
			
		}
		
		catch(Exception e)
		
		{
			
			e.printStackTrace();
			
		}
		
		
	}
	
	
	@AfterMethod(description = "Close")
	
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

// http://live.demoguru99.com/index.php/
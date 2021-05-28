package projectScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.ScreenshortUtility;

public class BalanceEnquiry {

	
    public WebDriver driver;
	
	public WebDriverWait wait;
	
	public String URL="http://www.demo.guru99.com/V4/index.php";
	
	public WebElement w;
	
	
	@BeforeMethod(description = "Open the Browser")
	
	public void Open()
	{
		
		WebDriverManager.chromedriver().setup();
		
		driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		driver.get(URL);
		
	    w=driver.findElement(By.cssSelector("input[name='uid']"));
		
	    w.sendKeys("mngr242181");
	    
	    w=driver.findElement(By.cssSelector("input[name='password']"));
	    
	    w.sendKeys("Demo@123");
	    
	    w=driver.findElement(By.cssSelector("input[type='submit']"));
	    
	    w.click();
	    
	    Assert.assertTrue(driver.getTitle().contains("Guru"),"~Failed to Get the Page Title~");
	    
	    System.out.println("Title : "+driver.getTitle());
	    
	    w=driver.findElement(By.xpath("//td[text()='Manger Id : mngr242181']"));
	    
	    Assert.assertTrue(w.getText().contains("Manger"));
	    
	    System.out.println("Manager ID : "+w.getText());
	    
	}
	
	
	@Test(description = "BalanceEnquiry",enabled = false)
	
	public void balanceEnquiry()
	{
		
		try
		
		{
			
		
        w=driver.findElement(By.cssSelector(".menusubnav >li:nth-child(12)"));
			
	    w.click();
		
		wait=new WebDriverWait(driver, 10);
		
		w=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Balance Enquiry Form']")));
		
		Assert.assertTrue(w.getText().contains("Balance"));
		
		System.out.println("Text Showing : "+w.getText());
		
		w=driver.findElement(By.cssSelector("input[name='accountno']"));
		
		w.sendKeys("74895");
		
		w=driver.findElement(By.cssSelector("input[type='submit']"));
		
		w.click();
		
		
		Alert a=driver.switchTo().alert();
		
		if(a.getText().contains("Account"))
			
		{
			
			
			wait=new WebDriverWait(driver, 5);
			
			a=wait.until(ExpectedConditions.alertIsPresent());
			
			Assert.assertTrue(a.getText().contains("Account"));
			
			System.out.println("Alert Text : "+a.getText());
			
			Thread.sleep(4000);
			
			a.accept();
			
			w=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Balance Enquiry Form']")));
			
			Assert.assertTrue(w.getText().contains("Balance"));
			
			System.out.println("Page Text After Alert : "+w.getText());
			
			ScreenshortUtility.takeScreenshortUtility(driver, "RedirectBEnquiryAfterDeleteAlert");
			
			
						
		}
		
		
		}
		
		catch (Exception e) {

		       e.printStackTrace();
			
		}
	}
	
	
	@Test(description = "Verify Balance")
	
	public void verifyBalanceAfterWithdrawl()
	{
		
		try
		
		{
			
			    w=driver.findElement(By.cssSelector(".menusubnav >li:nth-child(12)"));
				
			    w.click();
				
				wait=new WebDriverWait(driver, 10);
				
				w=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Balance Enquiry Form']")));
				
				Assert.assertTrue(w.getText().contains("Balance"));
				
				System.out.println("Text Showing : "+w.getText());
				
				w=driver.findElement(By.cssSelector("input[name='accountno']"));
				
				w.sendKeys("75080");
				
				w=driver.findElement(By.cssSelector("input[type='submit']"));
				
				w.click();
			
				w=driver.findElement(By.xpath("//p[text()='Balance Details for Account 75080']"));
				
				Assert.assertTrue(w.getText().contains("Balance"));
				
				System.out.println("Balance Details : "+w.getText());
				
				ScreenshortUtility.takeScreenshortUtility(driver, "BalanceDetails");
				
				
			
		}
		
		catch(Exception e)
		
		{
			
			
			
			
		}
		
		
	}
	
	
	
	
	
@AfterMethod(description = "Clost the Appn and Take Screenshort of Failed Tests")
	
	public void tearCloseDown(ITestResult result)
	
	{
		
		try
		{
			
			if(ITestResult.FAILURE==result.getStatus())
				
			{
				
				ScreenshortUtility.takeScreenshortUtility(driver, "FailedBalanceEnquiry");
				
			}
			
			
			
			Thread.sleep(3000);
			
			driver.quit();
			
			
			
		}
		
		catch(Exception e)
		
		{
			
			e.printStackTrace();
			
		}
	}
	
	
	
	
	
	
	
}

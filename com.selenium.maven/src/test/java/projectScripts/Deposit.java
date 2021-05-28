package projectScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.ScreenshortUtility;

public class Deposit 

{
	


	public WebDriver driver;
	
	public WebDriverWait wait;
	
	public String URL="http://www.demo.guru99.com/V4/index.php";
	
	
	
	@BeforeMethod(description = "For Launching the Appn")
	
	public void open()
	{
		
	
		WebDriverManager.chromedriver().setup();
		
		driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		driver.get(URL);
		
		Assert.assertTrue(driver.getTitle().contains("Guru"));
		
		System.out.println("Page Title : "+driver.getTitle());
		
		WebElement e;
		
		e=driver.findElement(By.cssSelector("input[type='text']"));
		
		e.sendKeys("mngr242181");
		
		e=driver.findElement(By.cssSelector("input[type='password']"));
		
		e.sendKeys("Demo@123");
		
		e=driver.findElement(By.cssSelector("input[type='submit']"));
		
		e.click();
		
		e=driver.findElement(By.xpath("//td[text()='Manger Id : mngr239514']"));
		
		Assert.assertTrue(e.getText().contains("Manger"));
		
		System.out.println("Manager Id : "+e.getText());
		
		
	}
	
	
	@Test(description = "Deposit")
	
	public void depositAndRefresh()
	{
		
		try
		{
		
		WebElement w;
		
	    w=driver.findElement(By.cssSelector(".menusubnav >li:nth-child(8) >a"));
	    
	    //org.openqa.selenium.ElementClickInterceptedException
	    
	    
	    //wait=new WebDriverWait(driver, 10);
	    
	    //w=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".menusubnav >li:nth-child(8) >a")));
		
		//w.click();
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		js.executeScript("arguments[0].click();",w);
		
		
		w=driver.findElement(By.xpath("//p[text()='Amount Deposit Form']"));
		
		Assert.assertTrue(w.getText().contains("Amount"));
		
		System.out.println("Page Text : "+w.getText());
		
		w=driver.findElement(By.cssSelector("input[name='accountno']"));
		
		w.sendKeys("75058");
		
		w=driver.findElement(By.cssSelector("input[name='ammount']"));
		
		w.sendKeys("100");
		
		w=driver.findElement(By.cssSelector("input[name='desc']"));
		
		w.sendKeys("ForPs4");
		
		w=driver.findElement(By.cssSelector("input[name='AccSubmit']"));
		
		w.click();
		
		w=driver.findElement(By.xpath("//p[text()='Transaction details of Deposit for Account 75058']"));
		
		Assert.assertTrue(w.getText().contains("Transaction"));
		
		System.out.println("Details of Deposit for Account : "+w.getText());
		
		ScreenshortUtility.takeScreenshortUtility(driver, "TransactionDetailDeposit");
		
		driver.navigate().refresh();
		
			/*
			 * Alert a =driver.switchTo().alert();
			 * 
			 * if(a.getText().contains("The page")) {
			 * 
			 * 
			 * wait=new WebDriverWait(driver, 4);
			 * 
			 * wait.until(ExpectedConditions.alertIsPresent());
			 * 
			 * a.accept();
			 * 
			 * 
			 * 
			 * }
			 */
			 
		      w=driver.findElement(By.xpath("//p[text()='Amount Deposit Form']"));
			  
			  Assert.assertTrue(w.getText().contains("Amount"));
			  
			  System.out.println("Page Text : "+w.getText());
			  
			  ScreenshortUtility.takeScreenshortUtility(driver,"RedirectToAmmtDepostFormAfterRefreshing");
			 
		
			  
			  
			  
		
		}
		
		catch(Exception e)
		
		{
			
			e.printStackTrace();
			
		}
		
		
	
	}
	
	
	
	
	@AfterMethod(description = "For closing the appn and Taking screenshorts of failed Test Only")
	
	public void tearDown(ITestResult result)
	{
		
		try
		{
			
			if(ITestResult.FAILURE==result.getStatus())
			{
				
				ScreenshortUtility.takeScreenshortUtility(driver, "FailedTest");
				
				
			}
			
			
			Thread.sleep(2000);
			
			driver.quit();
			
		}
		
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
}

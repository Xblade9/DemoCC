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

public class MiniStatement {

	
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
	
	
	@Test(description = "Mini Statement",enabled = false)
	
	public void miniStateMent()
	{
		
		try
		
		{
		
			//wait=new WebDriverWait(driver, 10);
			
			//w=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".menusubnav >li:nth-child(13)")));
			
			w=driver.findElement(By.cssSelector(".menusubnav >li:nth-child(13)"));
			
			w.click();
			
			wait=new WebDriverWait(driver, 10);
			
			w=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Mini Statement Form']")));
			
			Assert.assertTrue(w.getText().contains("Mini"));
			
			System.out.println("Page Text : "+w.getText());
			
			w=driver.findElement(By.cssSelector("input[name='accountno']"));
			
			w.sendKeys("74895");
			
			w=driver.findElement(By.cssSelector("input[type='submit']"));
			
			w.click();
			
			Alert a=driver.switchTo().alert();
			
			if(a.getText().contains("Account does not exist"))
			{
				
				wait=new WebDriverWait(driver, 5);
				
				wait.until(ExpectedConditions.alertIsPresent());
				
				Assert.assertTrue(a.getText().contains("Account does not exist"));
				
				System.out.println("Alert Text : "+a.getText());
				
				a.accept();
				
				Assert.assertTrue(driver.getTitle().contains("Guru"));
				
				System.out.println("Page Title After Account doesnt exists Alert : "+driver.getTitle());

				ScreenshortUtility.takeScreenshortUtility(driver, "RedirectMStatAfterADExist");
				
				
				
			}
			
			
		}
		
		catch(Exception e)
		
		{
			
			e.printStackTrace();
			
			
		}
		
	}
	
	
	
	
	
	@Test(description = "Verify Mini statement")
	
	public void verifyMiniStatementAfterCashWithDrawl()
	
	{
		
		
		try
		{
			
			//w=driver.findElement(By.cssSelector(".menusubnav >li:nth-child(13)"));
			
			/*
			 * JavascriptExecutor js =(JavascriptExecutor)driver;
			 * 
			 * js.executeScript("arguments[0].click();",w);
			 */
			
			wait=new WebDriverWait(driver, 10);
			
			w=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".menusubnav >li:nth-child(13)")));
			
			w.click();
			
            w=driver.findElement(By.cssSelector("input[name='accountno']"));
			
			w.sendKeys("75080");
			
			w=driver.findElement(By.cssSelector("input[type='submit']"));
			
			w.click();
			
			////p[text()='Last Five Transaction Details for Account No: 75080']
			
		    w=driver.findElement(By.xpath("//p[text()='Last Five Transaction Details for Account No: 75080']"));
		    
		    Assert.assertTrue(w.getText().contains("Last"));
		    
		    System.out.println("Details Msg : "+w.getText());
			
		    ScreenshortUtility.takeScreenshortUtility(driver, "LastFiveTransactionDetails");
		    
			
		}
		
		
		catch(Exception e)
		
		{
			
			e.printStackTrace();
			
			
		}
		
	}
	
	
	
	
	
	

	@AfterMethod(description = "Clost the Appn and Take Screenshort of Failed Tests")
	
	public void tearCloseDown(ITestResult result)
	
	{
		
		try
		{
			
			if(ITestResult.FAILURE==result.getStatus())
				
			{
				
				ScreenshortUtility.takeScreenshortUtility(driver, "FailedMiniStatement");
				
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

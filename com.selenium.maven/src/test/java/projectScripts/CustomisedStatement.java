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

public class CustomisedStatement {

	
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
		
	    w.sendKeys("mngr239514");
	    
	    w=driver.findElement(By.cssSelector("input[name='password']"));
	    
	    w.sendKeys("Demo@123");
	    
	    w=driver.findElement(By.cssSelector("input[type='submit']"));
	    
	    w.click();
	    
	    Assert.assertTrue(driver.getTitle().contains("Guru"),"~Failed to Get the Page Title~");
	    
	    System.out.println("Title : "+driver.getTitle());
	    
	    w=driver.findElement(By.xpath("//td[text()='Manger Id : mngr239514']"));
	    
	    Assert.assertTrue(w.getText().contains("Manger"));
	    
	    System.out.println("Manager ID : "+w.getText());
	    
	}
	
	
	@Test(description = "CustomisedStatement")
	
	public void customizedStatement()
	
	{
		try
		{
			
		
		
		w=driver.findElement(By.cssSelector(".menusubnav >li:nth-child(14)"));
		
		w.click();
		
		w=driver.findElement(By.xpath("//p[text()='Customized Statement Form']"));
		
		Assert.assertTrue(w.getText().contains("Customized"));
		
		System.out.println("Page Text : "+w.getText());
		
		w=driver.findElement(By.cssSelector("input[name='accountno']"));
		
		w.sendKeys("7895");
		
		w=driver.findElement(By.cssSelector("input[name='fdate']"));
		
		w.sendKeys("09111998");
		
		w=driver.findElement(By.cssSelector("input[name='tdate']"));
		
		w.sendKeys("09121998");
		
		w=driver.findElement(By.cssSelector("input[name='amountlowerlimit']"));
		
		w.sendKeys("100");
		
		w=driver.findElement(By.cssSelector("input[name='numtransaction']"));
		
		w.sendKeys("10");
		
		w=driver.findElement(By.cssSelector("input[name='AccSubmit']"));
		
		w.click();
		
		
		Alert a=driver.switchTo().alert();
		
		if(a.getText().contains("Account"))
		{
			
			wait=new WebDriverWait(driver, 10);
			
			a=wait.until(ExpectedConditions.alertIsPresent());
			
			Assert.assertTrue(a.getText().contains("Account"));
			
			System.out.println("Alert Text : "+a.getText());

			Thread.sleep(3000);
			
			a.accept();
			
			w=driver.findElement(By.xpath("//p[text()='Customized Statement Form']"));
			
			Assert.assertTrue(w.getText().contains("Customized"));
			
			System.out.println("Page Text After Filling Customized Form : "+w.getText());	
			
			ScreenshortUtility.takeScreenshortUtility(driver, "RedirectCustomizedStatAfterAccDoesntExist");
			
			
			
		}
		

		}
		
		catch (Exception e) {
			
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

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

public class DeleteCustomer {

	public WebDriver driver;
	
	public WebElement e;
	
	public WebDriverWait wait;
	
	public String URL="http://www.demo.guru99.com/V4/index.php";

	
	
	
	@BeforeMethod(description = "Open the Appn")
	
	
	public void open()
	{
		
		WebDriverManager.chromedriver().setup();
		
		driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		driver.get(URL);
		
		e=driver.findElement(By.cssSelector("input[name='uid']"));
		
		e.sendKeys("mngr239514");
		
		e=driver.findElement(By.cssSelector("input[name='password']"));
		
		e.sendKeys("Demo@123");
		
		e=driver.findElement(By.cssSelector("input[type='submit']"));
		
		e.click();
		
		Assert.assertTrue(driver.getTitle().contains("Guru"));
		
		System.out.println("Page Title : "+driver.getTitle());
		
		e=driver.findElement(By.xpath("//td[text()='Manger Id : mngr239514']"));
		    
		Assert.assertTrue(e.getText().contains("Manger"));
		
		System.out.println("Manager ID : "+e.getText());
		
	}
	
	
	@Test(description = "Delete Customer")
	
	public void deleteCustomer()
	{
		
		try
		{
		
		e=driver.findElement(By.xpath("//a[text()='Delete Customer']"));
		
		e.click();
		
		wait= new WebDriverWait(driver, 10);
		
		e=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Delete Customer Form']")));
		
		Assert.assertTrue(e.getText().contains("Delete"),"Failed To get The Text");
		
		System.out.println("Text : "+e.getText());
		
		e=driver.findElement(By.cssSelector("input[name='cusid']"));
		
		e.sendKeys("31300");
		
		e=driver.findElement(By.cssSelector("input[name='AccSubmit']"));
		
		e.click(); 
		
		Alert a=driver.switchTo().alert();
		
		if(a.getText().contains("Do"))
		{
			 
            wait= new WebDriverWait(driver, 10);
            
            wait.until(ExpectedConditions.alertIsPresent());
            
            Assert.assertTrue(a.getText().contains("Do you"),"Failed");
            
            System.out.println("Alert Text : "+a.getText());
		
            Thread.sleep(3000);
                      
            a.accept();
        
            wait.until(ExpectedConditions.alertIsPresent());
            
            a.accept();
            
            Assert.assertTrue(driver.getTitle().contains("Guru"));
            
            System.out.println("Redirect To : "+driver.getTitle());
            
            ScreenshortUtility.takeScreenshortUtility(driver, "RedirectToHomePageAftCustDeleted");
           
		}
		
		//if there will be any account which is not yet deleted then
		//just do one thing ,,, in this code change the else if to 'if' condition
		//here the customer is deleted so there is no need for this peice of code 
		//now , so i have made changes to the script
		
		
            else if(a.getText().contains("Customer"))
            {
            	
            	wait=new WebDriverWait(driver, 10);
            	
            	wait.until(ExpectedConditions.alertIsPresent());
            	
            	Assert.assertTrue(a.getText().contains("Customer"));
            	
            	System.out.println("Alert Text : "+a.getText());
            	
            	Thread.sleep(2000);
            	
            	a.accept();
            	
            	Assert.assertTrue(driver.getTitle().contains("Guru"));
            	
            	System.out.println("Page Title After Alert Text : "+driver.getTitle());
            	
            	ScreenshortUtility.takeScreenshortUtility(driver, "RedirectToDeletCusForm");
            	
            }
		
		
		
            
           
	}
		
		catch (Exception e) 
		
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
				
				ScreenshortUtility.takeScreenshortUtility(driver, "FailedToDeleteCustomer");
				
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

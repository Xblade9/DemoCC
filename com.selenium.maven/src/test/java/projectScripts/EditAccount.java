package projectScripts;

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

public class EditAccount 

{

	
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


	//.menusubnav >li:nth-child(6) >a

	
	@Test(description = "Verify Edit account")
	
	public void verifyEditAccount()
	
	{
		
		try
		
		{
			
			
			w=driver.findElement(By.cssSelector(".menusubnav >li:nth-child(6) >a"));
			
			w.click();
			
			w=driver.findElement(By.xpath("//p[text()='Edit Account Form']"));
			
			Assert.assertTrue(w.getText().contains("Edit"));
			
			System.out.println("Page Text : "+w.getText());
			
			w=driver.findElement(By.cssSelector("input[name='accountno']"));
			
			w.sendKeys("75080");
			
			w=driver.findElement(By.cssSelector("input[name='AccSubmit']"));
			
			w.click();
			
			w=driver.findElement(By.xpath("//p[text()='Edit Account Entry Form']"));
			
			Assert.assertTrue(w.getText().contains("Edit"));
			
			System.out.println("Edit Account Form"+w.getText());
			
			ScreenshortUtility.takeScreenshortUtility(driver, "EditAccountEntryForm");
			
			
			
			
			
		}
		
		
		catch(Exception e)
		
		{
			
			e.printStackTrace();
			
			
		}
		
		
		
	}
	
	
	

	@AfterMethod(description = "close the Appn")

	public void close()
	{
		
		try {
			
			Thread.sleep(3000);
			
			driver.quit();
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		
		
	}

	
	
	
	
	
}

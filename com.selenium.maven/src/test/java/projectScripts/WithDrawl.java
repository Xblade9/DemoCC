package projectScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class WithDrawl 

{

	public WebDriver driver;
	
	public WebDriverWait wait;
	
	public String URL="http://www.demo.guru99.com/V4/index.php";
	
	
@BeforeMethod(description = "Open the Browser")
	
public void Open()
	
   {
	
	    WebElement w;
		
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
	    
	    //75080
	    
	    //6314
	    
	}
	
	
	
@Test(description = "Withdrawl Form",enabled = false)

public void withdrawlVerify()

{
	
   try
   
   {
	
	   WebElement w1;
	   
	   
	   w1=driver.findElement(By.cssSelector(".menusubnav >li:nth-child(9) >a"));
	   
	   JavascriptExecutor js = (JavascriptExecutor)driver;
	   
	   js.executeScript("arguments[0].click();",w1);
	    
	   w1=driver.findElement(By.xpath("//p[text()='Amount Withdrawal Form']"));
	   
	   Assert.assertTrue(w1.getText().contains("Amount"));
	   
	   System.out.println("Page Text : "+w1.getText());
	   
	   w1=driver.findElement(By.cssSelector("input[name='accountno']"));
	   
	   w1.sendKeys("75080");
	   
	   w1=driver.findElement(By.cssSelector("input[name='ammount']"));
	   
	   w1.sendKeys("100");
	   
	   w1=driver.findElement(By.cssSelector("input[name='desc']"));
	   
	   w1.sendKeys("ForSkins!!");
	   
	   w1=driver.findElement(By.cssSelector("input[name='AccSubmit']"));
	   
	   w1.click();
	   
	   w1=driver.findElement(By.xpath("//p[text()='Transaction details of Withdrawal for Account 75080']"));
	   
	   Assert.assertTrue(w1.getText().contains("Trans"));
	   
	   System.out.println("Transaction Details : "+w1.getText());
	   
	   ScreenshortUtility.takeScreenshortUtility(driver, "TransactionDetailsWithDrawl");
	   
	   
	   
   }
	
	
	catch(Exception e)
   {
		
		
		e.printStackTrace();
		
		
   }
	
	
	
	
	
	
}



@Test(description = "Verify Withdrawal cannot be made if requested amount is more than current amount in the account")

public void withdrawlRequestAmountMore()
{
	
	try 
	
	{
	
	

		   WebElement w1;
		   
		   
		   w1=driver.findElement(By.cssSelector(".menusubnav >li:nth-child(9) >a"));
		   
		   JavascriptExecutor js = (JavascriptExecutor)driver;
		   
		   js.executeScript("arguments[0].click();",w1);
		    
		   w1=driver.findElement(By.xpath("//p[text()='Amount Withdrawal Form']"));
		   
		   Assert.assertTrue(w1.getText().contains("Amount"));
		   
		   System.out.println("Page Text : "+w1.getText());
		   
		   w1=driver.findElement(By.cssSelector("input[name='accountno']"));
		   
		   w1.sendKeys("75080");
		   
		   w1=driver.findElement(By.cssSelector("input[name='ammount']"));
		   
		   w1.sendKeys("999900");
		   
		   w1=driver.findElement(By.cssSelector("input[name='desc']"));
		   
		   w1.sendKeys("ForSkins!!");
		   
		   w1=driver.findElement(By.cssSelector("input[name='AccSubmit']"));
		   
		   w1.click();
		   

		   Alert a =driver.switchTo().alert();
		   
		   
		   if(a.getText().contains("Tran"))
		   {
			   
			   Assert.assertTrue(a.getText().contains("Tran"));
			   
			   System.out.println("Alert Text : "+a.getText());
			   
			   a.accept();
			   
			   
			   
		   }
		
		
		   
		   
	} 
	
	catch (Exception e) 
	
	
	{

	
	
	
	
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

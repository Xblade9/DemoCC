package projectScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
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

public class CustomisedStatementAfterDeposit 

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
	
	
	
		@Test(description = "Verify Customized statement",enabled = false)
		
		public void customizedStatementAfterWithDrawl()
		
		{
			
			try
			
			{
				
				w=driver.findElement(By.cssSelector(".menusubnav >li:nth-child(14)"));
				
				w.click();
				
				w=driver.findElement(By.xpath("//p[text()='Customized Statement Form']"));
				
				Assert.assertTrue(w.getText().contains("Customized"));
				
				System.out.println("Page Text : "+w.getText());
				
				w=driver.findElement(By.cssSelector("input[name='accountno']"));
				
				w.sendKeys("75080");
				
				w=driver.findElement(By.cssSelector("input[name='fdate']"));
				
				w.sendKeys("16012020");
				
				w=driver.findElement(By.cssSelector("input[name='tdate']"));
				
				w.sendKeys("17012020");
				
				w=driver.findElement(By.cssSelector("input[name='amountlowerlimit']"));
				
				w.sendKeys("1000");
				
				w=driver.findElement(By.cssSelector("input[name='numtransaction']"));
				
				w.sendKeys("10");
				
				w=driver.findElement(By.cssSelector("input[name='AccSubmit']"));
				
				w.click();
				
				
				w=driver.findElement(By.xpath("//p[text()='Transaction Details for Account No: 75080 from Date: 2020-01-16 to: 2020-01-17']"));
				
				Assert.assertTrue(w.getText().contains("Transaction"));
				
				System.out.println("Transaction Details are : "+w.getText());
				
				ScreenshortUtility.takeScreenshortUtility(driver, "TransactionDetailsCustomizedStatementAfterWithdrawl");
				
				
				
			}
			
			
			catch(Exception e)
			
			{
				
				e.printStackTrace();
				
				
			}
			
			
			
		}
	
	
		
		@Test(description = "Verify Customized statement is not generated when from date is greater than to date")
		
		public void verifyCustomizedStatementisNotGenerated()
		
		{
			
			try
			
			{
				
				
                w=driver.findElement(By.cssSelector(".menusubnav >li:nth-child(14)"));
				
				w.click();
				
				w=driver.findElement(By.xpath("//p[text()='Customized Statement Form']"));
				
				Assert.assertTrue(w.getText().contains("Customized"));
				
				System.out.println("Page Text : "+w.getText());
				
				w=driver.findElement(By.cssSelector("input[name='accountno']"));
				
				w.sendKeys("75080");
				
				w=driver.findElement(By.cssSelector("input[name='fdate']"));
				
				w.sendKeys("16012020");
				
				w=driver.findElement(By.cssSelector("input[name='tdate']"));
				
				w.sendKeys("15012020");
				
				w=driver.findElement(By.cssSelector("input[name='amountlowerlimit']"));
				
				w.sendKeys("1000");
				
				w=driver.findElement(By.cssSelector("input[name='numtransaction']"));
				
				w.sendKeys("10");
				
				w=driver.findElement(By.cssSelector("input[name='AccSubmit']"));
				
				w.click();
				
				
				Alert a = driver.switchTo().alert();
				
				if(a.getText().contains("FromDate"))
				{
					
					
					Assert.assertTrue(a.getText().contains("FromDate"));
					
					System.out.println("Alert Text : "+a.getText());
					
					a.accept();
					
					
				}
				
				
				
				
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

package projectScripts;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.ExcelUtility;
import utility.ScreenshortUtility;

public class FundTransfer 
{
     public WebDriver driver;
     
     public WebElement w;
     
     public WebDriverWait wait;
     
     public String URL="http://www.demo.guru99.com/V4/index.php";
     
     
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
     
     @DataProvider(name="DPFT")
     
     public Object[][] fundTransferDP(Method m)
     {
    	 
    	 
    	 ExcelUtility.excelSheetPath("F:\\MyBench\\com.selenium.maven\\TestData\\G9.xlsx");
    	 
    	 int rowCount=ExcelUtility.getRowCount("FundTransfer");
    	 
    	 int colCount=ExcelUtility.getColCount("FundTransfer");
    	 
    	 Object[][] obj=new Object[rowCount-1][colCount];
    	 
    	 if(m.getName().equalsIgnoreCase("fundTransfer"))

    	 {
    		 
    		 for(int i=1;i<rowCount;i++)
    		 {
    			 
    			 for(int j=0;j<colCount;j++)
    			 {
    				 
    				 obj[i-1][j]=ExcelUtility.getCellData("FundTransfer", i, j);
    				 
    				 
    				 
    				 
    			 }
    			 
    			 
    		 }
    		 
    		  
    	 }
    	 
    	 
    	 
    	 else if(m.getName().equals("fundTransferReloaded"))
    	 {
    	
    		 
    		 for(int i=1;i<rowCount;i++)
    		 {
    			 
    			 for(int j=0;j<colCount;j++)
    			 {
    				 
    				 obj[i-1][j]=ExcelUtility.getCellData("FundTransfer", i, j);
    				 
    				 
    			 }
    			 
    			 
    			 
    		 }
    		 
    		 
    		 
    		 
    		 
    		 
    	 }
    	 
    	 
    	 
    	 return obj;
     }
     
	@Test(description = "FundTransfer",dataProvider = "DPFT",enabled = false)
     
     public void fundTransfer(String payerAcNo,String payeesAcNo,String amm,String des)
     
	 {
		
		try
		{
	    
		wait=new WebDriverWait(driver, 10);	
			
		//w=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".menusubnav >li:nth-child(10) >a")));
			
		//w.click();

//		w=wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".menusubnav >li:nth-child(10) >a")));
//		
//		w.click();
			
		w=driver.findElement(By.cssSelector(".menusubnav >li:nth-child(10) >a"));
			
			
			  JavascriptExecutor js = (JavascriptExecutor)driver;
			  
			  js.executeScript("arguments[0].click();",w);
			 
		
		//w.click();
			
		wait=new WebDriverWait(driver, 10);
		
		w=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Fund transfer']")));
		
		Assert.assertTrue(w.getText().contains("Fund"));
	    	
		System.out.println("Module Text : "+w.getText());
		
		w=driver.findElement(By.cssSelector("input[name='payersaccount']"));
		
		w.sendKeys(payerAcNo);
		
		w=driver.findElement(By.cssSelector("input[name='payeeaccount']"));
		
		w.sendKeys(payeesAcNo);
		
		w=driver.findElement(By.cssSelector("input[name='ammount']"));
		
		w.sendKeys(amm);
		
		w=driver.findElement(By.cssSelector("input[name='desc']"));
		
		w.sendKeys(des);
		
		w=driver.findElement(By.cssSelector("input[name='AccSubmit']"));
		
	    w.click();
		
		w=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Fund Transfer Details']")));
		
		Assert.assertTrue(w.getText().contains("Fund"));
		
		System.out.println("Transfer Details are : "+w.getText());
	    
	    ScreenshortUtility.takeScreenshortUtility(driver, "FundTransferDetails");
		
	    w=driver.findElement(By.xpath("//a[text()='Continue']"));
	    
	    w.click();
	    
	    w=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='Manger Id : mngr239514']")));
	    
	    Assert.assertTrue(w.getText().contains("Manger"));
	    
	    System.out.println("Page Text : "+w.getText());
	    
		}
		
		catch(Exception e)
		{
			
			e.printStackTrace();
			
		}
		
     }
    
	@Test(description = "To verify FT not done Again when page is Loaded",dataProvider = "DPFT",enabled = false)
	
	
	 public void fundTransferWhenPageRefresh(String payerAcNo,String payeesAcNo,String amm,String des)
	{
		
		
		try
		{
	    
		wait=new WebDriverWait(driver, 10);	
			
		//w=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".menusubnav >li:nth-child(10) >a")));
			
		//w.click();

//		w=wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".menusubnav >li:nth-child(10) >a")));
//		
//		w.click();
			
		w=driver.findElement(By.cssSelector(".menusubnav >li:nth-child(10) >a"));
			
			
			  JavascriptExecutor js = (JavascriptExecutor)driver;
			  
			  js.executeScript("arguments[0].click();",w);
			 
		
		//w.click();
			
		wait=new WebDriverWait(driver, 10);
		
		w=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Fund transfer']")));
		
		Assert.assertTrue(w.getText().contains("Fund"));
	    	
		System.out.println("Module Text : "+w.getText());
		
		w=driver.findElement(By.cssSelector("input[name='payersaccount']"));
		
		w.sendKeys(payerAcNo);
		
		w=driver.findElement(By.cssSelector("input[name='payeeaccount']"));
		
		w.sendKeys(payeesAcNo);
		
		w=driver.findElement(By.cssSelector("input[name='ammount']"));
		
		w.sendKeys(amm);
		
		w=driver.findElement(By.cssSelector("input[name='desc']"));
		
		w.sendKeys(des);
		
		w=driver.findElement(By.cssSelector("input[name='AccSubmit']"));
		
	    w.click();
		
        w=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Fund Transfer Details']")));
		
		Assert.assertTrue(w.getText().contains("Fund"));
		
		System.out.println("Transfer Details are : "+w.getText());
	    
	    driver.navigate().refresh();
	    
			/*
			 * Alert a=driver.switchTo().alert();
			 * 
			 * if(a.getText().contains("The")) {
			 * 
			 * wait=new WebDriverWait(driver, 10);
			 * 
			 * a=wait.until(ExpectedConditions.alertIsPresent());
			 * 
			 * Assert.assertTrue(a.getText().contains("The"));
			 * 
			 * System.out.println("Alert is : "+a.getText());
			 * 
			 * a.accept();
			 * 
			 * w=driver.findElement(By.xpath("//p[text()='Fund transfer']"));
			 * 
			 * Assert.assertTrue(w.getText().contains("Fund"));
			 * 
			 * System.out.println("Redirect to : "+w.getText());
			 * 
			 * ScreenshortUtility.takeScreenshortUtility(driver,
			 * "RedirectToFundTransferAfterRefreshing");
			 * 
			 * }
			 */
	    
	    
	      w=driver.findElement(By.xpath("//p[text()='Fund transfer']"));
		  
		  Assert.assertTrue(w.getText().contains("Fund"));
		  
		  System.out.println("Redirect to : "+w.getText());
		  
		  ScreenshortUtility.takeScreenshortUtility(driver,"RedirectToFundTransferAfterRefreshing");
	    
	    
	    
		}
		
		catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		
		
	}
	
	@Test(description = "ForSameAccountNO",enabled = false)
	 public void fundTransferForSameAccNo()

	 {
		 
		 try
			{
		    
			wait=new WebDriverWait(driver, 10);	
				
			w=driver.findElement(By.cssSelector(".menusubnav >li:nth-child(10) >a"));
				
				
		    JavascriptExecutor js = (JavascriptExecutor)driver;
				  
		    js.executeScript("arguments[0].click();",w);
								
			wait=new WebDriverWait(driver, 10);
			
			w=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Fund transfer']")));
			
			Assert.assertTrue(w.getText().contains("Fund"));
		    	
			System.out.println("Module Text : "+w.getText());
			
			w=driver.findElement(By.cssSelector("input[name='payersaccount']"));
			
			w.sendKeys("74952");
			
			w=driver.findElement(By.cssSelector("input[name='payeeaccount']"));
			
			w.sendKeys("74952");
			
			w=driver.findElement(By.cssSelector("input[name='ammount']"));
			
			w.sendKeys("500");
			
			w=driver.findElement(By.cssSelector("input[name='desc']"));
			
			w.sendKeys("For Rakan");
			
			 w=driver.findElement(By.cssSelector("input[name='AccSubmit']"));
			
		     w.click();
			
		     wait=new WebDriverWait(driver, 10);
		     
		     wait.until(ExpectedConditions.alertIsPresent());
		     
		     Alert a =driver.switchTo().alert();
		     
		     if(a.getText().contains("Payers"))
		     {
		    
			 Assert.assertTrue(a.getText().contains("Payers"));
			
			 System.out.println("Transfer Details are : "+a.getText());

			  Thread.sleep(3000);
			 
			  a.accept();
			 
		      w=driver.findElement(By.xpath("//p[text()='Fund transfer']"));
			  
			  Assert.assertTrue(w.getText().contains("Fund"));
			  
			  System.out.println("Redirect to : "+w.getText());
			  
			  ScreenshortUtility.takeScreenshortUtility(driver,"RedirectToFundTransferForSameAccountError");
		    
		     
		     }
		  
			}
			
			catch (Exception e) {
				
				e.printStackTrace();
				
		 
		 
			}
		 
		 
	 }
	
	 @Test(description = "Entering Wrong Acc No During Fund Transfer",enabled = false)
	 public void managerEnterWrongAccountNoDuringFundTransfer()
	 {
		 
		 
		 try
			{
		    
			wait=new WebDriverWait(driver, 10);	
				
			w=driver.findElement(By.cssSelector(".menusubnav >li:nth-child(10) >a"));
				
				
		    JavascriptExecutor js = (JavascriptExecutor)driver;
				  
		    js.executeScript("arguments[0].click();",w);
								
			wait=new WebDriverWait(driver, 10);
			
			w=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Fund transfer']")));
			
			Assert.assertTrue(w.getText().contains("Fund"));
		    	
			System.out.println("Module Text : "+w.getText());
			
			w=driver.findElement(By.cssSelector("input[name='payersaccount']"));
			
			w.sendKeys("74952");
			
			w=driver.findElement(By.cssSelector("input[name='payeeaccount']"));
			
			w.sendKeys("74111");
			
			w=driver.findElement(By.cssSelector("input[name='ammount']"));
			
			w.sendKeys("500");
			
			w=driver.findElement(By.cssSelector("input[name='desc']"));
			
			w.sendKeys("For Rakan");
			
			 w=driver.findElement(By.cssSelector("input[name='AccSubmit']"));
			
		     w.click();
			
		     wait=new WebDriverWait(driver, 10);
		     
		     wait.until(ExpectedConditions.alertIsPresent());
		     
		     Alert a =driver.switchTo().alert();
		     
		     if(a.getText().contains("Account"))
		     {
		    
			 Assert.assertTrue(a.getText().contains("Account"));
			
			 System.out.println("Transfer Details are : "+a.getText());

			  Thread.sleep(3000);
			 
			  a.accept();
			 
		      w=driver.findElement(By.xpath("//p[text()='Fund transfer']"));
			  
			  Assert.assertTrue(w.getText().contains("Fund"));
			  
			  System.out.println("Redirect to : "+w.getText());
			  
			  ScreenshortUtility.takeScreenshortUtility(driver,"RedirectToFundTransferAfterEnteringWrongAccNo");
		    
		     
		     }
		  
			}
			
			catch (Exception e) {
				
				e.printStackTrace();
				
		 
		 
			}
		  
		 
		 
		 
		 
	 }
	 
	 @Test(description = "Verify Fund Transfer When account Balance is Low")
	
	 public void fundTransferWhenAccountBalanceIsLow()
	 {
		 
		 try
			{
		    
			wait=new WebDriverWait(driver, 10);	
				
			w=driver.findElement(By.cssSelector(".menusubnav >li:nth-child(10) >a"));
				
				
		    JavascriptExecutor js = (JavascriptExecutor)driver;
				  
		    js.executeScript("arguments[0].click();",w);
								
			wait=new WebDriverWait(driver, 10);
			
			w=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Fund transfer']")));
			
			Assert.assertTrue(w.getText().contains("Fund"));
		    	
			System.out.println("Module Text : "+w.getText());
			
			w=driver.findElement(By.cssSelector("input[name='payersaccount']"));
			
			w.sendKeys("74941");
			
			w=driver.findElement(By.cssSelector("input[name='payeeaccount']"));
			
			w.sendKeys("74952");
			
			w=driver.findElement(By.cssSelector("input[name='ammount']"));
			
			w.sendKeys("100");
			
			w=driver.findElement(By.cssSelector("input[name='desc']"));
			
			w.sendKeys("For Rakan");
			
			 w=driver.findElement(By.cssSelector("input[name='AccSubmit']"));
			
		     w.click();
			
		     wait=new WebDriverWait(driver, 10);
		     
		     wait.until(ExpectedConditions.alertIsPresent());
		     
		     Alert a =driver.switchTo().alert();
		     
		     if(a.getText().contains("Transfer"))
		     {
		    
			  Assert.assertTrue(a.getText().contains("Transfer"));
			
			  System.out.println("Transfer Details are : "+a.getText());

			  Thread.sleep(3000);
			 
			  a.accept();
			 
		      w=driver.findElement(By.xpath("//p[text()='Fund transfer']"));
			  
			  Assert.assertTrue(w.getText().contains("Fund"));
			  
			  System.out.println("Redirect to : "+w.getText());
			  
			  ScreenshortUtility.takeScreenshortUtility(driver,"RedirectToFundTransferWhenAccBalIsLow");
		    
			  
		     
		     }
		  
			}
			
			catch (Exception e) {
				
				e.printStackTrace();
				
		 
		 
			}
		 
		 
		 
	 }
	 
	 
	 
     @AfterMethod(description = "close")
     
     public void close()
     {
    	 
    	 try {
			Thread.sleep(3000);
			
			driver.quit();
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
			
		}
    	 
    	 
     }
     
     
     
}

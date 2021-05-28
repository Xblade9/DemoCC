package projectScripts;

import java.util.concurrent.TimeUnit;

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

public class CustomizedStatement 

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
     
     @DataProvider(name="DPCS")
     
     public Object[][] customisedStatement()
     {
    	 
    	 ExcelUtility.excelSheetPath("F:\\MyBench\\com.selenium.maven\\TestData\\G9.xlsx");
    	 
    	 int rowCount=ExcelUtility.getRowCount("CustomizedStatement");
    	 
    	 int colCount=ExcelUtility.getColCount("CustomizedStatement");
    	 
    	 
    	 Object[][] obj=new Object[rowCount-1][colCount];
    	 
    	 for(int i=1;i<rowCount;i++)
    	 {
    		 
    		 for(int j=0;j<colCount;j++)
    		 {
    			 
    			 obj[i-1][j]=ExcelUtility.getCellData("CustomizedStatement", i, j);
    			 
    			 
    			 
    		 }
    		 
    		 
    	 }
    	 
    	 
    	 return obj;
    	 
    	 
     }
     
	@Test(description = "For Customise Statement",dataProvider = "DPCS")
	
	 public void customiseStatement(String accNo,String fromDate,String toDate,String minTrans,String numOfTrans)
	{
		try
		
		{
			
			w=driver.findElement(By.cssSelector(".menusubnav >li:nth-child(14) >a"));
			
			JavascriptExecutor js =(JavascriptExecutor)driver;
			
			js.executeScript("arguments[0].click()",w);
			
			
			w=driver.findElement(By.xpath("//p[text()='Customized Statement Form']"));
			
			Assert.assertTrue(w.getText().contains("Customized"));
			
			System.out.println("Page Text : "+w.getText());
			
			w=driver.findElement(By.cssSelector("input[name='accountno']"));
			
			w.sendKeys(accNo);
			
			w=driver.findElement(By.cssSelector("input[name='fdate']"));
			
			w.sendKeys(fromDate);
			
			w=driver.findElement(By.cssSelector("input[name='tdate']"));
			
			w.sendKeys(toDate);
			
			w=driver.findElement(By.cssSelector("input[name='amountlowerlimit']"));
			
			w.sendKeys(minTrans);
			
			w=driver.findElement(By.cssSelector("input[name='numtransaction']"));
			
			w.sendKeys(numOfTrans);
			
			w=driver.findElement(By.cssSelector("input[name='AccSubmit']"));
			
			w.click();
			
			wait=new WebDriverWait(driver, 10);
			
			w=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Transaction Details for Account No: 74952 from Date: 2020-01-10 to: 2020-01-11']")));
			
			Assert.assertTrue(w.getText().contains("Trans"));
			
			System.out.println("Transaction Msg : "+w.getText());
			
			ScreenshortUtility.takeScreenshortUtility(driver, "CustStatement");
					
		}
		
		
		catch(Exception e)
		
		{
			
			e.printStackTrace();
			
			
		}
		
		
		
	}
	
 @AfterMethod(description = "close")
     
     public void close()
     {
    	 
    	 try 
    	 {
			Thread.sleep(3000);
			
			driver.quit();
			
		} catch (Exception e) {
			// TODO: handle exception
			
			System.out.println(e.getMessage());
			
		}
    	 
    	 
     }
     
}

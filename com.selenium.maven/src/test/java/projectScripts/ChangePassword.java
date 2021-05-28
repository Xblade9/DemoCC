package projectScripts;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

import utility.*;

public class ChangePassword {

	public WebDriver driver;
	
	public String URL="http://www.demo.guru99.com/v4/";
	
	
	@BeforeMethod(description = "For Opening the Application Everytime Before the Methods")
	
	public void openBrowser()
	{
		
		WebDriverManager.chromedriver().setup();
		
		driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
		driver.manage().window().maximize();
		
		driver.get(URL);
		
	}
	
	
	@DataProvider(name="DPG9")
	
	public Object[][] credData(Method m)
	{
		
		ExcelUtility.excelSheetPath("F:\\MyBench\\com.selenium.maven\\TestData\\G9.xlsx");
		
		int rowCount=ExcelUtility.getRowCount("LoginCred");
		
		int colCount=ExcelUtility.getColCount("LoginCred");
		
		Object[][] obj= new Object[rowCount-1][colCount];
		
		if(m.getName().equalsIgnoreCase("loginCred"))
			
		{
			for(int i=1;i<rowCount;i++)
			{
				
				for(int j=0;j<colCount;j++)
					
				{
					
					obj[i-1][j]=ExcelUtility.getCellData("LoginCred", i, j);
					
				}
				
			}
			
			
			
		}
		
		
		  else if(m.getName().equalsIgnoreCase("cPass")) 
		  
		  
		  {
		  
		  
		  int rowCount1=ExcelUtility.getRowCount("CPass");
		  
		  int colCount1=ExcelUtility.getColCount("CPass");
		  
		  Object[][] o=new Object[rowCount1-1][colCount1];
		  
		  for(int i=1;i<rowCount1;i++)
		  
		  {
		  
		  for(int j=0;j<colCount1;j++)
		  
		  {
		  
		  o[i-1][j]=ExcelUtility.getCellData("CPass", i, j);
		  
		  }
		  
		  }
		  
		  return o;
		  
		  }
		 
		return obj;
		
	}
	
	
	
	@Test(description = "ManagerLogin",dataProvider = "DPG9",priority = 0,enabled = false)
	
	public void loginCred(String uName,String pWord)
	{
		
	try
	
	{
		
		
		WebElement e;
		
		e=driver.findElement(By.cssSelector("input[name='uid']"));
		
		e.sendKeys(uName);
		
		e=driver.findElement(By.cssSelector("input[name='password']"));
		
		e.sendKeys(pWord);
		
		e=driver.findElement(By.cssSelector("input[name='btnLogin']"));
		
		e.click();
		
		Alert a=driver.switchTo().alert();
		
		String expectResult="User or Password is not valid";
		
        String actuall=a.getText();
		
		Assert.assertEquals(actuall, expectResult);
			
		Thread.sleep(2000);
		
		a.accept();
			
		System.out.println("Alert Handled : "+a);
		
	    Assert.assertTrue(driver.getTitle().contains("Guru99 Bank Manager HomePage"),"~FAILED TO GET THE PAGE TITLE~");
			
        System.out.println("Page Title : "+driver.getTitle());
			
        String expectedResult="Manger Id : mngr239514";
			
	    String actual=driver.findElement(By.xpath("//td[@style='color: green']")).getAttribute("innerHTML");
			
	    Assert.assertEquals(actual, expectedResult);
			
	    System.out.println("Manager Id is Verified : "+actual);
		
		
	}
	
	
	catch(Exception e)
	
	{
		
		e.printStackTrace();
		
	}
	   
	   
	}
	
	
	
	@Test(description = "For changing the Password",dataProvider = "DPG9",priority = 1)

	public void cPass(String oPass,String newPass,String cPass)
	{
		
		
		try
		
		{
		
		WebElement e;
		
        e=driver.findElement(By.cssSelector("input[name='uid']"));
		
		e.sendKeys("mngr239514");
		
		e=driver.findElement(By.cssSelector("input[name='password']"));
		
		e.sendKeys("Demo@1234");
		
		e=driver.findElement(By.cssSelector("input[name='btnLogin']"));
		
		e.click();
		
		Assert.assertTrue(driver.getTitle().contains("Guru99 Bank Manager HomePage"),"~FAILED TO GET THE PAGE TITLE~");
			
	    System.out.println("Page Title : "+driver.getTitle());
		
		e=driver.findElement(By.xpath("//a[text()='Change Password']"));
		
		e.click();
		
		e=driver.findElement(By.xpath("//input[@name='oldpassword']"));
		
		e.sendKeys(oPass);
		
		e=driver.findElement(By.xpath("//input[@name='newpassword']"));
		
		e.sendKeys(newPass);
		
	    e=driver.findElement(By.xpath("//input[@name='confirmpassword']"));
	    
	    e.sendKeys(cPass);
		
		e=driver.findElement(By.xpath("//input[@type='submit']"));
	    
	    e.click();
	    	    
	    Alert a=driver.switchTo().alert();
		
			  if((a.getText().contains("Old")))
			  
			  {
			 			  
			  Assert.assertTrue(a.getText().contains("Old Password"));
				  
			  System.out.println("Alert msg : "+a.getText());
			 					  
			  Thread.sleep(5000);
		
			  a.accept();
			  
			  }
			  
			  else if(a.getText().contains("Password"))
			  
			  {
			 			  
			  Assert.assertTrue(a.getText().contains("Password"));
				  
			  System.out.println("Alert msg : "+a.getText());
			  
			  Thread.sleep(5000);
			  
			  a.accept();
			  
			  }
	
			  			  
		}
		
		catch(Exception e)
		
		{
			
			e.printStackTrace();
			
		}
		
	}
	

	@Test(description = "For Screenshorts of PassTestCases",priority = 2,enabled = false)
	
	public void screenShort()
	
	{
		try
		{
	
		WebElement e;
		
        e=driver.findElement(By.cssSelector("input[name='uid']"));
		
		e.sendKeys("mngr239514");
		
		e=driver.findElement(By.cssSelector("input[name='password']"));
		
		e.sendKeys("Demo@1234");
		
		e=driver.findElement(By.cssSelector("input[name='btnLogin']"));
		
		e.click();
		
		Assert.assertTrue(driver.getTitle().contains("Guru99 Bank Manager HomePage"),"~FAILED TO GET THE PAGE TITLE~");
		
	    System.out.println("Page Title : "+driver.getTitle());
		
		e=driver.findElement(By.xpath("//a[text()='Change Password']"));
		
		e.click();
	
		e=driver.findElement(By.xpath("//p[text()='Change Password']"));
		
		if(e.getText().contains("Change"))
		
		{
			
		Assert.assertTrue(e.getText().contains("Change"));
			
		ScreenshortUtility.takeScreenshortUtility(driver, "ChPass");
		
		
		}
		
		Thread.sleep(3000);
		
		e=driver.findElement(By.xpath("//a[text()='Log out']"));
		
		e.click();
		
		//You Have Succesfully Logged Out!!
		
		Alert y=driver.switchTo().alert();
		
		Thread.sleep(5000);
		
		y.accept();
		
		ScreenshortUtility.takeScreenshortUtility(driver, "BankLogin");
		
		
			
		
		}
		
		catch(Exception e)
		
		{
			
			e.printStackTrace();
			
		}
	}
	
	@Test(description = "with new Login Pass",priority = 3)
	
	public void newPass()
	
	{
		try
	
		{
		
		WebElement r;
		
		r=driver.findElement(By.cssSelector("input[name='uid']"));
		
		r.sendKeys("mngr239514");
		
		r=driver.findElement(By.cssSelector("input[name='password']"));
		
		r.sendKeys("Demo@123");
		
		r=driver.findElement(By.cssSelector("input[name='btnLogin']"));
		
		r.click();
	
        Assert.assertTrue(driver.getTitle().contains("Gur"));
		
        System.out.println("Page titlte : "+driver.getTitle());
		
        
		}
		
		
		catch(Exception e)
		
		{
			
			e.printStackTrace();
			
		}
		
	}
		
	@AfterMethod(description = "Close the Appn and Take the Screenshort")
	
	public void tearDown(ITestResult result)
	
	{

		try
		{
			
			if(ITestResult.FAILURE==result.getStatus())
				
			{
				
				ScreenshortUtility.takeScreenshortUtility(driver, "FailedTest");
				
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

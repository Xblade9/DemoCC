package projectScripts;

import java.lang.reflect.Method;
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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.ExcelUtility;
import utility.ScreenshortUtility;

public class EditCustomer {

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
	
	@Test(description = "editCustomer",enabled = false)
	
	public void editCustomer()

	
	{
		try
		{
		
		e=driver.findElement(By.cssSelector(".menusubnav >li:nth-child(3) >a"));
		
		e.click();
		
		wait=new WebDriverWait(driver, 10);
		
		e=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Edit Customer Form']")));
		
		Assert.assertTrue(e.getText().contains("Edit"));
		
		System.out.println("Page Text : "+e.getText());
		
		e=driver.findElement(By.cssSelector("input[name='cusid']"));
		
		e.sendKeys("31300");
		
		e=driver.findElement(By.cssSelector("input[name='AccSubmit']"));
		
		e.click();
		
		
		Alert a=driver.switchTo().alert();
		
		if(a.getText().contains("Customer"))
		
		{
			
			wait=new  WebDriverWait(driver, 10);
			
			wait.until(ExpectedConditions.alertIsPresent());
			
			Assert.assertTrue(a.getText().contains("Customer"));
			
			System.out.println("Alert Text : "+a.getText());
			
			Thread.sleep(3000);
			
            a.accept();
			
		    Assert.assertTrue(driver.getTitle().contains("Guru"));	
			
		    System.out.println("Redirec to EditCustomer : "+driver.getTitle());
			
		    ScreenshortUtility.takeScreenshortUtility(driver, "RedirectToEditCusAfter");
		    
		}
		
	
		}
		
		
		catch (Exception e) {
			
			System.out.println(e.getMessage());
			
		}
		
	}

	
	@Test(description = "Verify edit customer",dataProvider = "DPVEC")
	
	public void verifyEditCustomer(String custName,String gender,String dob,String add,String city,String state,String pin,String mobNo,String email)
	{
		
		try
		
		{
			
			e=driver.findElement(By.cssSelector(".menusubnav >li:nth-child(3) >a"));
			
			e.click();
			
			wait=new WebDriverWait(driver, 10);
			
			e=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Edit Customer Form']")));
			
			Assert.assertTrue(e.getText().contains("Edit"));
			
			System.out.println("Page Text : "+e.getText());
			
			e=driver.findElement(By.cssSelector("input[name='cusid']"));
			
			e.sendKeys("2527");
				
			e=driver.findElement(By.cssSelector("input[name='AccSubmit']"));
			
			e.click();
			
			e=driver.findElement(By.xpath("//p[text()='Edit Customer']"));
			
			
			Assert.assertTrue(e.getText().contains("Edit"));
			
			System.out.println("page Text : "+e.getText());
			
			
			
			/*
			 * e=driver.findElement(By.cssSelector("input[name='name']"));
			 * 
			 * e.clear();
			 * 
			 * e.sendKeys(custName);
			 * 
			 * e=driver.findElement(By.cssSelector("input[name='gender']"));
			 * 
			 * e.clear();
			 * 
			 * e.sendKeys(gender);
			 * 
			 * e=driver.findElement(By.cssSelector("input[name='dob']"));
			 * 
			 * e.clear();
			 * 
			 * e.sendKeys(dob);
			 * 
			 * e=driver.findElement(By.cssSelector("textarea[name='addr']"));
			 * 
			 * e.clear();
			 * 
			 * e.sendKeys(add);
			 * 
			 * e=driver.findElement(By.cssSelector("input[name='city']"));
			 * 
			 * e.clear();
			 * 
			 * e.sendKeys(city);
			 * 
			 * e=driver.findElement(By.cssSelector("input[name='state']"));
			 * 
			 * e.clear();
			 * 
			 * e.sendKeys(state);
			 * 
			 * e=driver.findElement(By.cssSelector("input[name='pinno']"));
			 * 
			 * e.clear();
			 * 
			 * e.sendKeys(pin);
			 * 
			 * e=driver.findElement(By.cssSelector("input[name='telephoneno']"));
			 * 
			 * e.clear();
			 * 
			 * e.sendKeys(mobNo);
			 * 
			 * e=driver.findElement(By.cssSelector("input[name='emailid']"));
			 * 
			 * e.clear();
			 * 
			 * e.sendKeys(email);
			 * 
			 * e=driver.findElement(By.cssSelector("input[name='sub']"));
			 * 
			 * e.click();
			 */
			
			
			e=driver.findElement(By.xpath("//p[text()='Edit Customer']"));
			
			Assert.assertTrue(e.getText().contains("Edit"));
			
			System.out.println("Edit Customer Details : "+e.getText());
			
		    ScreenshortUtility.takeScreenshortUtility(driver, "EditCustomerDetails");
			
			
		}
		
		catch(Exception e)
		{
			
			e.printStackTrace();
			
			
		}
		
	}
	
	
	@DataProvider(name="DPVEC")

	public Object[][] verifyEditCustomerDataProvider(Method m)

	{
		
        ExcelUtility.excelSheetPath("F:\\MyBench\\com.selenium.maven\\TestData\\G9.xlsx");
		
		int rowCount=ExcelUtility.getRowCount("EditCustomer");
		
		int colCount=ExcelUtility.getColCount("EditCustomer");
		
		Object[][] obj= new Object[rowCount-1][colCount];
		
		if(m.getName().equals("verifyEditCustomer"))
		{
		
		
		
		for(int i=1;i<rowCount;i++)
		{
			
			for(int j=0;j<colCount;j++)
			{
				
				obj[i-1][j]=ExcelUtility.getCellData("EditCustomer", i, j);
				
			}
			
		}
		
		
		
		}
		
		return obj;
		
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

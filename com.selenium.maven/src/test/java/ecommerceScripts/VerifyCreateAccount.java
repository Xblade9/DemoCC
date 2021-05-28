package ecommerceScripts;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.ExcelUtility;
import utility.ScreenshortUtility;

public class VerifyCreateAccount {

	
	public WebDriver driver;
	
	public WebDriverWait wait;
	
	public String URL="http://live.demoguru99.com/index.php/";
	
	
	@BeforeMethod(description = "open the Appn")
	
	public void open()
	{
		
		WebDriverManager.chromedriver().setup();
		
		driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		driver.get(URL);
		
		Assert.assertTrue(driver.getTitle().contains("Home"));
		
		System.out.println("Page Title : "+driver.getTitle());
		
	}
	
	@Test(description = "verify you can create account in E-commerce site",dataProvider = "DP1")
	
	public void verifyAccount(String fname,String mName,String lName,String email,String pass,String cPass)
	{
		
		try
		{
			
			
			WebElement e;
			
			e=driver.findElement(By.cssSelector("div[class='footer-container'] >div >div:nth-child(4) >ul > li:first-child >a"));
			
			e.click();
			
			Assert.assertTrue(driver.getTitle().contains("Customer"));
			
			System.out.println(driver.getTitle());
			
			ScreenshortUtility.takeScreenshortUtility(driver, "createAccount");
			
            e=driver.findElement(By.cssSelector("div[class='col2-set'] >div:first-child >div:nth-child(2) >a >span"));
            
            e.click();
            
            Assert.assertTrue(driver.getTitle().contains("Create"));
			
            System.out.println(driver.getTitle());
			
            ScreenshortUtility.takeScreenshortUtility(driver, "CreateAccountForm");
			
            e=driver.findElement(By.id("firstname"));
            
            e.sendKeys(fname);
            
            e=driver.findElement(By.id("middlename"));
            
            e.sendKeys(mName);
            
            e=driver.findElement(By.id("lastname"));
            
            e.sendKeys(lName);
            
            e=driver.findElement(By.id("email_address"));
            
            e.sendKeys(email);
            
           
            e=driver.findElement(By.id("password"));
            
            e.sendKeys(pass);
            
            e=driver.findElement(By.id("confirmation"));
            
            e.sendKeys(cPass);
            
            
            e=driver.findElement(By.cssSelector("button[type='submit']:nth-child(2)"));
            
            e.click();
            
            Assert.assertTrue(driver.getTitle().contains("My")); 
           
            System.out.println(driver.getTitle());	
            
            
            e=driver.findElement(By.cssSelector("div[class='col-main'] >div >div >ul >li >ul >li >span"));
            
            Assert.assertTrue(e.getText().contains("Thank"));
            
            System.out.println(e.getText());
            
            ScreenshortUtility.takeScreenshortUtility(driver, "Dashboard");
			
            e=driver.findElement(By.cssSelector("div[class='skip-content'] >nav >ol >li:last-child >a"));
            
            e.click();
            
            e=driver.findElement(By.cssSelector("ul[class='products-grid products-grid--max-4-col first last odd'] >li:nth-child(1) >div >div:nth-child(4) >ul >li:nth-child(1) >a"));
            
            e.click();
            
            Assert.assertTrue(driver.getTitle().contains("My"));
            
            System.out.println(driver.getTitle());
            
            ScreenshortUtility.takeScreenshortUtility(driver, "MyWishlist");
            
            e=driver.findElement(By.cssSelector("div[class='buttons-set buttons-set2'] >button:nth-child(1) >span"));
            
            e.click();
            
            Assert.assertTrue(driver.getTitle().contains("Wishlist"));
            
            System.out.println(driver.getTitle());
            
            ScreenshortUtility.takeScreenshortUtility(driver, "ShareYourWishlist");
            
            e=driver.findElement(By.cssSelector("div[class='input-box'] >textarea[name='emails']"));
            
            e.sendKeys("stuart@gmail.com");
            
            e=driver.findElement(By.cssSelector("div[class='input-box'] >textarea[name='message']"));
            
            e.sendKeys("My Name is Sam Fisher");
            
            e=driver.findElement(By.cssSelector("button[title='Share Wishlist']"));
            
            e.click();
            
            e=driver.findElement(By.cssSelector("li[class='success-msg'] >ul >li >span"));
            
            if(e.getText().contains("Your"))
            
            {
            	
            	
            	System.out.println(e.getText());
            	
            	ScreenshortUtility.takeScreenshortUtility(driver, "WishlistShared");
            	
            	
            	
            }
            
            
            else
            {
            	
            	System.out.println("Wishlist Has Not Been Shared");
            	
            }
            
            
            
		}
		
		catch(Exception e)
		
		{
			
			e.printStackTrace();
			
		}
		
		
	}
	
	
	@DataProvider(name = "DP1")
	
	public Object[][] createAccount(Method m)
	{
		
		ExcelUtility.excelSheetPath("F:\\MyBench\\com.selenium.maven\\TestData\\G9.xlsx");
		
		int rowCount=ExcelUtility.getRowCount("CreateAccount");
		
		int colCount=ExcelUtility.getColCount("CreateAccount");
		
		Object[][] obj=new Object[rowCount-1][colCount]; 
		
		if(m.getName().equalsIgnoreCase("verifyAccount"))
		
		{
			
			for(int i=1;i<rowCount;i++)
			{
				for(int j=0;j<colCount;j++)
				{
				
					obj[i-1][j]=ExcelUtility.getCellData("CreateAccount", i, j);
				
				
				}
				
			}
			
			
		
		}
		
		
		return obj;
		
		
	}
	
	
	
	 @AfterMethod(description = "close the Appn")
		
		public void tearDown()
		{
			
			try
			
			{
				
				
				Thread.sleep(3000);
				
				driver.quit();
				
				
				
			}
			
			
			catch(Exception e)
			
			{
				
				e.printStackTrace();
				
			}
			
			
			
		}
	
	
	
	
	
}

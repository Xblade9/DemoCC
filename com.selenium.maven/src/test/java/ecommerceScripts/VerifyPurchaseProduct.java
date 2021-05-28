package ecommerceScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.ScreenshortUtility;

public class VerifyPurchaseProduct

{

	
	public WebDriver driver;
	
	public WebDriverWait wait;
	
	public String URL="http://live.demoguru99.com/index.php/";
	
	public Select s;
	
	public JavascriptExecutor js;

	@BeforeMethod(description = "open")
	
	public void open()
	{
		
		WebDriverManager.chromedriver().setup();
		
		driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		driver.get(URL);
		
		Assert.assertTrue(driver.getTitle().contains("Home"));
		
		System.out.println(driver.getTitle());
		
		
		
	}
	
	
	@Test(description = "verify user is able to purchase product using registered email id")
	
	public void verifyPurchaseProduct()
	{
		
		try
		
		{
			
			WebElement e;
			
			e=driver.findElement(By.cssSelector("div[class='account-cart-wrapper'] >a"));
			
			e.click();
			
			e=driver.findElement(By.cssSelector("#header-account >div >ul >li:last-child"));
			
			e.click();
			
			e=driver.findElement(By.id("email"));
			
			e.sendKeys("stuart@gmail.com");
			
			e=driver.findElement(By.id("pass"));
			
			e.sendKeys("Demo@123");
			
			e=driver.findElement(By.id("send2"));
			
			e.click();
			
			//Login
			
			
			e=driver.findElement(By.cssSelector("div[class='col-main'] >div >div >div >p:last-child"));
			
			Assert.assertTrue(e.getText().contains("From"));
			
			System.out.println(e.getText());
			
			ScreenshortUtility.takeScreenshortUtility(driver, "MyDashBoardAfterLogin");
			
			
			//click on My whishlist link
			
			
			e=driver.findElement(By.cssSelector("div[class='block block-account'] >div:last-child >ul >li:nth-child(8) >a"));
			
			e.click();
			
			Assert.assertTrue(driver.getTitle().contains("My"));
			
			System.out.println(driver.getTitle());
			
			//Add To Cart
			
			e=driver.findElement(By.cssSelector("td[class='wishlist-cell4 customer-wishlist-item-cart'] >div >button >span"));
			
			e.click();
			
			Assert.assertTrue(driver.getTitle().contains("Shopping"));
			
			System.out.println(driver.getTitle());
			
			ScreenshortUtility.takeScreenshortUtility(driver, "ShoppingCart");
			
			
			//PROCEED TO CHECKOUT
			
			e=driver.findElement(By.cssSelector("div[class='page-title title-buttons'] >ul >li >button >span"));
			
			e.click();
			
			Assert.assertTrue(driver.getTitle().contains("Checkout"));
			
			System.out.println(driver.getTitle());
			
			ScreenshortUtility.takeScreenshortUtility(driver, "Checkout");
			
			e=driver.findElement(By.cssSelector("#checkout-step-billing >form >div >ul >li:last-child >input"));
			
			e.click();
			
			e=driver.findElement(By.cssSelector("div[class='buttons-set'] >button:first-child >span"));
			
			e.click();
			
			e=driver.findElement(By.id("shipping:street1"));
			
			e.clear();
			
			e.sendKeys("ADC");
			
			e=driver.findElement(By.id("shipping:city"));
			
			e.sendKeys("New York");
			
			s =  new Select(driver.findElement(By.id("shipping:region_id")));
			
			s.selectByVisibleText("California");
			
			s= new Select(driver.findElement(By.id("shipping:country_id")));
			
			s.selectByVisibleText("United States");
			
			
			e=driver.findElement(By.id("shipping:telephone"));
			
			e.clear();
			
			e.sendKeys("123456788");
			
					
			e=driver.findElement(By.cssSelector("button[onclick='shipping.save()'] >span"));
			
			//e.click();
			
			
			js =(JavascriptExecutor)driver;
			
			js.executeScript("arguments[0].click();",e);
			
			e=driver.findElement(By.cssSelector("#checkout-shipping-method-load >dl"));
			
			Assert.assertTrue(e.getText().contains("Flat"));
			
			System.out.println(e.getText());
			
			
			js=(JavascriptExecutor)driver;
			
			js.executeScript("arguments[0].scrollIntoView(true);",e);
		
			ScreenshortUtility.takeScreenshortUtility(driver, "FlateRate");
			
			e=driver.findElement(By.cssSelector("button[onclick='shippingMethod.save()'] >span"));
			
            js =(JavascriptExecutor)driver;
			
			js.executeScript("arguments[0].click();",e);
			
			
			e=driver.findElement(By.id("p_method_checkmo"));
			
			e.click();
			
			e=driver.findElement(By.cssSelector("button[onclick='shippingMethod.save()'] >span"));
			
            js =(JavascriptExecutor)driver;
			
			js.executeScript("arguments[0].click();",e);
			
			
			//GrandTotal
			
			e=driver.findElement(By.cssSelector("table[id='checkout-review-table'] >tfoot"));
			
			Assert.assertTrue(e.getText().contains("sub"));
			
			System.out.println(e.getText());
			
			ScreenshortUtility.takeScreenshortUtility(driver, "GrandTotal");
			
			
			e=driver.findElement(By.cssSelector("div[id='checkout-review-submit'] >div >button >span"));
			
			e.click();
			
			
			e=driver.findElement(By.cssSelector("div[class='main-container col1-layout'] >div >div >div >h1"));
			
			Assert.assertTrue(e.getText().contains("Your"));
			
			System.out.println(e.getText());
			
			ScreenshortUtility.takeScreenshortUtility(driver, "OrderPlaced");
			
			
			//copy the Order ID
			
			
			e=driver.findElement(By.cssSelector("div[class='main-container col1-layout'] >div >div >p >a[href='http://live.demoguru99.com/index.php/sales/order/view/order_id/11018/']"));
 			
            System.out.println("Your order # is :"+e.getText());
			
            
			
		}
		
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
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

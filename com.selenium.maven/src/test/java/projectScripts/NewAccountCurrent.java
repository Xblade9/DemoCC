package projectScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.ScreenshortUtility;

public class NewAccountCurrent {

	
	public WebDriver driver;
	
	public String URL="http://www.demo.guru99.com/V4/index.php";
	
	public WebDriverWait wait;
	

	@BeforeMethod(description = "Open the Appn")
	
	public void oPen()
	{
		
		
		WebDriverManager.chromedriver().setup();
		
		driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.manage().window().fullscreen();
		
		driver.get(URL);
		
		Assert.assertTrue(driver.getTitle().contains("Guru"),"~FAILED~");
		
		System.out.println("Page Title : "+driver.getTitle());
		
		
	}
	
	@Test(description = "To add new Account")
	
	public void newAccount()
	
	{
		
		try
		{
		
		WebElement w;
		
		w=driver.findElement(By.cssSelector("input[type='text']"));
		
	    w.sendKeys("mngr239514");
		
		w=driver.findElement(By.cssSelector("input[type='password']"));
		
		w.sendKeys("Demo@123");
		
        w=driver.findElement(By.cssSelector("input[type='submit']"));  //submit
		
		w.click();
		
		w=driver.findElement(By.xpath("//td[text()='Manger Id : mngr239514']"));
		
		Assert.assertTrue(w.getText().contains("Manger"));
		
		System.out.println("Manager Id : "+w.getText());
		
		
		//click ON New Account
		
		w=driver.findElement(By.cssSelector(".menusubnav >li:nth-child(5)"));
		
		w.click();
		
		wait=new WebDriverWait(driver, 10);
		
		w=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Add new account form']")));
		
		Assert.assertTrue(w.getText().contains("Add"));
		
		System.out.println("Page Text : "+w.getText());
		
		
		w=driver.findElement(By.cssSelector("input[name='cusid']"));
		
		w.sendKeys("58779");
		
		Select s = new Select(driver.findElement(By.cssSelector("select[name='selaccount']")));
		
		s.selectByValue("Current");
		
		w=driver.findElement(By.cssSelector("input[name='inideposit']"));
		
		w.sendKeys("500");
		
		w=driver.findElement(By.cssSelector("input[name='button2']"));
		
		w.click();
		
		wait=new WebDriverWait(driver, 10);
		
		w=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Account Generated Successfully!!!']")));
		
		Assert.assertTrue(w.getText().contains("Account"));
		
		System.out.println("Page Text : "+w.getText());
		
		ScreenshortUtility.takeScreenshortUtility(driver, "Account");
		
		
		}
		
		
		catch (Exception e)
		
		{

			System.out.println(e.getMessage());
		
			
		}
		
		
		
		
	}
	
	@AfterMethod(description = "Close the Appn")
	
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

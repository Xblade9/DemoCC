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

public class DeleteAccountSavings {

	
public WebDriver driver;
	
	public WebDriverWait wait;
	
	public String URL="http://www.demo.guru99.com/V4/index.php";
	
	public WebElement w;
	
    @BeforeMethod(description = "Open the Appn")
	
	public void oPen()
	{
		
		
		WebDriverManager.chromedriver().setup();
		
		driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();;
		
		driver.get(URL);

		
        w=driver.findElement(By.cssSelector("input[type='text']"));
		
		w.sendKeys("mngr239514");
		
		w=driver.findElement(By.cssSelector("input[type='password']"));
		
		w.sendKeys("Demo@123");
		
		w=driver.findElement(By.cssSelector("input[type='submit']"));  //submit
		
		w.click();
		
		Assert.assertTrue(driver.getTitle().contains("Guru"),"~Failed to get the Page Title ~");
		
		System.out.println("Page Title : "+driver.getTitle());
		
		w=driver.findElement(By.xpath("//td[text()='Manger Id : mngr239514']"));
		
		Assert.assertTrue(w.getText().contains("Manger"),"~Failed~");
		
		System.out.println("Manager id : "+w.getText());
		
		w=driver.findElement(By.cssSelector(".menusubnav >li:nth-child(7) >a"));
		
		w.click();
	
        w=driver.findElement(By.xpath("//p[text()='Delete Account Form']"));

        Assert.assertTrue(w.getText().contains("Delete"));
        
        System.out.println("Page Text : "+w.getText());
	    
	}

	
    @Test(description = "! Delete Account !")
    
    public void deleteAccount()
    {
    	
    	try
    	
    	{
    		
    		w=driver.findElement(By.cssSelector("input[name='accountno']"));
    		
    		w.sendKeys("74895");
    		
    		w=driver.findElement(By.cssSelector("input[type='submit']"));
    		
    		w.click();
    	    		
    		Alert a=driver.switchTo().alert();
    		
    		if(a.getText().contains("Do you really want to delete this Account?"))
    		
    		{
    			
    			Thread.sleep(3000);
    					
    			a.accept();
    	
    			
    			if(a.getText().contains("Account Deleted Sucessfully"))
    			
    			{
    				
    			Thread.sleep(3000);
    			
    			a.accept();
    			
    			//Assert.assertTrue(a.getText().contains("Account"));
    			
    			//System.out.println("Alert Text : "+a.getText());
    			
    			Assert.assertTrue(driver.getTitle().contains("Guru99"));
        		
        		System.out.println("Page Title After Deleting Account : "+driver.getTitle());

    			
    			
    			
    			}
    			
    			
    			
    		}
    		
    		
    		
    		else
    		{
    			
    			System.out.println("Failed");
    			
    		}
    		
    		
    		    		
    		ScreenshortUtility.takeScreenshortUtility(driver, "RedirectHomePageAfterDeleteAccountSavings");
    		
    		
    	}
    	
    	
    	catch(Exception e)
    	
    	{
    		
    		
    		e.printStackTrace();
    		
    	}
    	
    	
    }
	
	
	
@AfterMethod(description = "Close the Appn")
	
	public void close()
	
	{
		
		
		try
		
		{
			
			Thread.sleep(3000);
			
			driver.quit();
			
			
		}
		
		catch (Exception e)
		
		{
		
			System.out.println(e.getMessage());
			
		}
				
	}

	



}

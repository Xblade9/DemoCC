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

public class DeleteAccountCurrent {

	public WebDriver driver;
	
	public WebDriverWait wait;
	
	public String URL="http://www.demo.guru99.com/V4/manager/deleteAccountInput.php";
	
	public WebElement w;
	
    @BeforeMethod(description = "Open the Appn")
	
	public void oPen()
	{
		
		
		WebDriverManager.chromedriver().setup();
		
		driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();;
		
		driver.get(URL);
		
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
    		
    		w.sendKeys("74877");
    		
    		w=driver.findElement(By.cssSelector("input[type='submit']"));
    		
    		w.click();
    	    		
    		Alert a=driver.switchTo().alert();
    		
    		if(a.getText().contains("Do you really want to delete this Account?"))
    		
    		{
    					
    			a.accept();
    	    			
    			System.out.println("Alert Text : "+a.getText());
    
    			if(a.getText().contains("You are not authorize to delete this Account!!"))
    			
    			{
    				 
    				a.accept();
    				
    				System.out.println("Alert Text : "+driver.getTitle());
    			
    			}
    			
    			
    		}
    		
    		
    		
    		else
    		{
    			
    			System.out.println("Failed");
    			
    		}
    		
    		
    		
    		
    		
    		
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

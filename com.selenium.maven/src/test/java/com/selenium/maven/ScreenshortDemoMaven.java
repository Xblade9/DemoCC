package com.selenium.maven;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import utility.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenshortDemoMaven {

	
	public WebDriver driver;
	public String URL="https://www.google.co.in/";
	
	@Test(description = "For Screenshort Test with Maven")
	
	public void takeScreenshort()
	{
		try
		{
		
		WebDriverManager.chromedriver().setup();
		
		driver=new ChromeDriver();
		
		driver.get(URL);
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		
		ScreenshortUtility.takeScreenshortUtility(driver, "Maven1");
		
		Thread.sleep(3000);
		
		driver.quit();
		
		
		}
		
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}
	
	
}

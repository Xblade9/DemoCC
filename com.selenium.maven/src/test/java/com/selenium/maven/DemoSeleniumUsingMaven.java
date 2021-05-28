package com.selenium.maven;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoSeleniumUsingMaven {

	WebDriver driver;
	
	@Test
	public void open()
	{
		
		//System.setProperty("webdriver.chrome.driver");
		
		WebDriverManager.chromedriver().setup(); 
		
		//WebDriverManager.chromedriver().version("2.26").setup();  Force to use version 2.26 of chromedriver 
		
        //WebDriverManager.firefoxdriver().arch32().setup(); Force to use the 32-bit version of geckodriver
		
       //WebDriverManager.chromedriver().proxy("server:port").setup(); Using proxy server:port for the connection
		
		driver=new ChromeDriver();
		
		driver.get("http://facebook.com");
		
		driver.quit();
		
		
	}
}

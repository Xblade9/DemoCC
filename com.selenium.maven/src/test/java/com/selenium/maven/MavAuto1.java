package com.selenium.maven;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MavAuto1 {

	public WebDriver driver;
	
	public String URL="http://demo.automationtesting.in/Register.html";
	
	
	@BeforeTest
	public void open()
	{
		
		WebDriverManager.chromedriver().setup();
		
		driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		driver.get(URL);
		
	}
	
	
	@Test
	public void test1()
	{
		
		WebElement e = driver.findElement(By.id("msdd"));
		
		e.click();
		
		
		//JavascriptExecutor js =(JavascriptExecutor)driver;
		
		WebElement e1=driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[7]/div/multi-select/div[2]/ul/li[7]/a"));
		
		//js.executeScript("arguments[0].scrollIntoView(true);",e1);
		
		e1.click();
		
		
	}
	
	
	
}

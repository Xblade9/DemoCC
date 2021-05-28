package com.prefeasy.clovia;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.prefeasy.clovia.methods.HPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginClovia {

	public String url = "https://www.clovia.com/";

	public WebDriver driver;

	@Test(dataProvider = "CloviaLoginProvider" , dataProviderClass = DProviderClovia.class)
	public void login(String email,String pass) {

		try {
			
			
			HPage hp=PageFactory.initElements(driver, HPage.class);
			
			hp.login(email,pass);
			
			

		} catch (Exception e) {

		}

	}

	@BeforeTest
	public void beforeTest() {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		driver.get(url);

		Assert.assertTrue(driver.getTitle().contains("Buy"), "Page Title Not Matched");

		System.out.println(driver.getTitle());

	}

	
	  @AfterTest public void afterTest() {
	  
	  try { Thread.sleep(3000); driver.quit(); } catch (Exception e) {
	  e.printStackTrace(); }
	  
	  }
	 

}

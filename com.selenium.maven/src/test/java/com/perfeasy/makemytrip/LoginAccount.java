package com.perfeasy.makemytrip;

import org.testng.annotations.Test;

import com.mmt.pages.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.ConfigReader;

import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class LoginAccount {

	public WebDriver driver;

	public WebElement element;

	public WebDriverWait wait;

	@Test(description = "For Login Test", dataProvider = "loginProvider", dataProviderClass = DataProviderForMmtrip.class)
	public void loginAccount(String email, String pass) {

		try {

			LoginPage lp = PageFactory.initElements(driver, LoginPage.class);

			lp.login_mmtrip(email, pass);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@BeforeTest
	public void beforeTest() {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		ConfigReader cfg = new ConfigReader();

		driver.get(cfg.getUrl());

		Assert.assertTrue(driver.getTitle().contains("Make"), "Page Title Not Matched");

		System.out.println(driver.getTitle());

	}

	@AfterTest
	public void afterTest() {

		try {
			Thread.sleep(5000);
			driver.quit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// demotesting9111@gmail.com
}

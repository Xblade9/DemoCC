package com.chqbook.pagefactory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.chqbook.methods.BusinessLoans;

import utility.ConfigReader;
import utility.DriverInit;

public class Loans {

	public WebDriver driver;

	public WebDriverWait wait;

	@Test()
	public void verifyBusinessLoansForSelfEmployed() {

		try {

			BusinessLoans bl =PageFactory.initElements(driver, BusinessLoans.class);
			
			bl.businessLoans();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@BeforeMethod
	public void beforeTest() {

		DriverInit instanceDriver = DriverInit.getInstance();

		driver = instanceDriver.openBrowser();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		ConfigReader cfg = new ConfigReader();

		driver.get(cfg.getChqBookUrl());

		Assert.assertTrue(driver.getTitle().contains("Open"), "Page Title Not Matched");

		System.out.println(driver.getTitle());

	}

	@AfterMethod
	public void tearDown(ITestResult result) {

		try

		{

			Thread.sleep(4000);
			driver.quit();

		}

		catch (Exception e) {

			e.printStackTrace();

		}

	}

}

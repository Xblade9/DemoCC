package com.prefeasy.clovia;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.prefeasy.clovia.methods.SizeNotAvailableMethod;

import utility.ConfigReader;
import utility.DriverInit;

public class SizeNotAvailable {

	public WebDriver driver;

	public WebDriverWait wait;

	@Test(dataProvider = "CloviaProductPincode", dataProviderClass = DProviderClovia.class, priority = 0)
	public void selectSizeChartForItemWithUnavailableSize(String pincode, String email, String password, String name, String mobNo, String altNo,
			String address, String lndMrk, String zipCode) {

		try {

			SizeNotAvailableMethod spc = PageFactory.initElements(driver, SizeNotAvailableMethod.class);

			spc.selectPartCategory(pincode, email, password, name, mobNo, altNo, address, lndMrk, zipCode);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@BeforeMethod
	public void beforeTest() {

		DriverInit instanceDriver = DriverInit.getInstance();

		driver = instanceDriver.openBrowser();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		ConfigReader cfg = new ConfigReader();

		driver.get(cfg.getClovUrl());

		Assert.assertTrue(driver.getTitle().contains("Buy"), "Page Title Not Matched");

		System.out.println(driver.getTitle());

	}

	@AfterMethod
	public void tearDown() {

		try

		{

			Thread.sleep(2000);
			driver.quit();

		}

		catch (Exception e) {

			e.printStackTrace();

		}

	}

}

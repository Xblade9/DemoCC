package com.prefeasy.clovia;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.prefeasy.clovia.methods.SelectAddressTypeCreateNewOnly;

import utility.ConfigReader;
import utility.DriverInit;

public class SelectAddressTypeCreateNew {

	public WebDriver driver;

	public WebDriverWait wait;

	@Test(dataProvider = "CreateNewFromSelectDrpDwn", dataProviderClass = DProviderClovia.class, priority = 0)
	public void selectCreateNewOptionFromDropDownWithAdditionalAddress(String pincode, String email, String password,
			String name, String mobNo, String altNo, String address, String lndMrkk, String zip, String addd2) {

		try {

			SelectAddressTypeCreateNewOnly spc = PageFactory.initElements(driver, SelectAddressTypeCreateNewOnly.class);

			spc.selectCreateNewOptionFromDropDownWithAddressTwo(pincode, email, password, name, mobNo, altNo, address,
					lndMrkk, zip, addd2);

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

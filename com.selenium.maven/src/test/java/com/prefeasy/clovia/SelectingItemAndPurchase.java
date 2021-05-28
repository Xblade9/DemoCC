package com.prefeasy.clovia;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.prefeasy.clovia.methods.SelectParticularCategory;
import com.prefeasy.clovia.methods.SelectParticularItemAndBuyWithDifferentAddressForItems;
import com.prefeasy.clovia.methods.SelectParticularItemAndBuyWithSameAddressForItems;

import utility.ConfigReader;
import utility.DriverInit;

public class SelectingItemAndPurchase {

	public WebDriver driver;

	public WebDriverWait wait;

	@Test(dataProvider = "CloviaProductPincode", dataProviderClass = DProviderClovia.class, priority = 0)
	public void selectParticularCategoryAndItemOverrideWithhNewUserShippingDetails(String pincode, String email,
			String password, String name, String mobNo, String altNo, String address, String lndMrk, String zipCode) {

		try {

			SelectParticularCategory spc = PageFactory.initElements(driver, SelectParticularCategory.class);

			spc.selectParticularCategoryAndItem(pincode, email, password, name, mobNo, altNo, address, lndMrk, zipCode);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test(dataProvider = "CloviaProductPincode", dataProviderClass = DProviderClovia.class, priority = 1)
	public void selectParticularCategoryAndItemWithoutChangingUserShippingDetails(String pincode, String email,
			String password, String name, String mobNo, String altNo, String address, String lndMrk, String zipCode) {

		try {

			SelectParticularItemAndBuyWithSameAddressForItems spc = PageFactory.initElements(driver,
					SelectParticularItemAndBuyWithSameAddressForItems.class);

			spc.selectPartCategory(pincode, email, password, name, mobNo, altNo, address, lndMrk, zipCode);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test(dataProvider = "CloviaProductWithDiffAddress", dataProviderClass = DProviderClovia.class, priority = 2)
	public void selectParticularCategoryAndItemWithNewShippingsDetails(String pincode, String email, String password,
			String name, String mobNo, String altNo, String address, String lndMrk, String zipCode) {

		try {

			SelectParticularItemAndBuyWithDifferentAddressForItems spc = PageFactory.initElements(driver,
					SelectParticularItemAndBuyWithDifferentAddressForItems.class);

			spc.selectPartCategory(pincode, email, password, name, mobNo, altNo, address, lndMrk, zipCode);

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

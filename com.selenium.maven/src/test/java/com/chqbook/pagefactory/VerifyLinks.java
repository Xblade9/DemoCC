package com.chqbook.pagefactory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.chqbook.methods.AllTheLinksInPage;
import utility.ConfigReader;
import utility.DriverInit;

public class VerifyLinks {

	public WebDriver driver;

	public WebDriverWait wait;

	@Test
	public void verifyAllTheLinksInPage() {

		try {
			AllTheLinksInPage hpm = PageFactory.initElements(driver, AllTheLinksInPage.class);

			hpm.getAllTheLinks();
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

package com.perfeasy.makemytrip;

import org.testng.annotations.Test;

import utility.ConfigReader;
import utility.DriverInit;

//import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.mmt.pages.*;

public class FlightSearch {

	public WebDriver driver;

	@Test(description = "For Flight Search", dataProvider = "flightProvider", dataProviderClass = DataProviderForMmtrip.class)
	public void flightSearch(String from, String to, String fname, String lname, String mob, String email) {

		try {

			FlightSearchs fs = PageFactory.initElements(driver, FlightSearchs.class);

			fs.flightSearch_Mmtrip(from, to);

			FlightBooking fb = PageFactory.initElements(driver, FlightBooking.class);

			fb.flightBook();

			ReviewBooking rb = PageFactory.initElements(driver, ReviewBooking.class);

			rb.review_Mmtrip();

		}

		catch (Exception e) {

			e.printStackTrace();

		}

	}

	@Test(description = "For Travler Details", dataProvider = "TravellerDetails", dataProviderClass = DataProviderForMmtrip.class)
	public void travDetails(String fName, String lName, String mob, String email) {

		try {

			TravellerDetail td = PageFactory.initElements(driver, TravellerDetail.class);

			td.travDetails(fName, lName, mob, email);

			TravllerAddons ta = PageFactory.initElements(driver, TravllerAddons.class);

			ta.travlAddons();

		}

		catch (Exception e) {

			e.printStackTrace();

		}

	}

	@BeforeTest
	public void beforeTest() {

		try {
			

			DriverInit di = new DriverInit();

			driver=di.openBrowser();

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			driver.manage().window().maximize();

			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

			ConfigReader cfg = new ConfigReader();

			driver.get(cfg.getUrl());

			Assert.assertTrue(driver.getTitle().contains("Make"), "Page Title Not Matched");

			System.out.println(driver.getTitle());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/*
	 * @AfterTest public void afterTest() {
	 * 
	 * try { Thread.sleep(5000); driver.quit(); } catch (Exception e) {
	 * e.printStackTrace(); }
	 * 
	 * }
	 */

}

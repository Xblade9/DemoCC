package com.mmt.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.mmt.objects.TravellerDetailsObjects;

public class TravellerDetail {

	WebDriver driver;

	WebDriverWait wait;

	public TravellerDetail(WebDriver driver) {

		this.driver = driver;
	}

	public void travDetails(String fname, String lname, String mob, String email) throws Exception {

		try {
			TravellerDetailsObjects tobj = PageFactory.initElements(driver, TravellerDetailsObjects.class);

			Thread.sleep(5000);

			Assert.assertTrue(tobj.getFlightSumText().getText().contains("Departure"), "Failed to get the departure text");

			tobj.getFirstName().sendKeys(fname);

			tobj.getLastName().sendKeys(lname);

			tobj.getMale().click();

			// drpDwn.click();

			tobj.getMobileNumber().sendKeys(mob);

			tobj.getEmail().sendKeys(email);

			tobj.getCountinueButton().click();

			tobj.getPopUp().click();
		} catch (InterruptedException e) {
			e.printStackTrace();
			Assert.fail("Failed To Check Traveller Details");
		}

	}

}
//clobia 

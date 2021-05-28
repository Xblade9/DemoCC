package com.mmt.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.mmt.objects.FlightBookingObjects;

public class FlightBooking {

	WebDriver driver;

	WebDriverWait wait;

	public FlightBooking(WebDriver driver) {

		this.driver = driver;
	}

	public void flightBook() throws Exception {

		try {
			FlightBookingObjects fbo = PageFactory.initElements(driver, FlightBookingObjects.class);

			fbo.getRadioBtnFrom().click();

			wait = new WebDriverWait(driver, 30);

			// wait.until(ExpectedConditions.elementToBeClickable(fbo.getRadioBtnTo())).click();

			// fbo.getRadioBtnTo().click();

			getRadioBtnTo(driver, "37");

			fbo.getClickBookNow().click();

			Thread.sleep(3000);

			fbo.getFareBtnContinue().click();
		} catch (InterruptedException e) {
			e.printStackTrace();
			Assert.fail("Failed To Book Flight");
		}

	}

	public static WebElement getRadioBtnTo(WebDriver driver, String i) {

		return driver.findElement(By.xpath("(//span[@class='customRadioBtn']//span)['" + i + "']"));
	}

}

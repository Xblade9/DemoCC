package com.mmt.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class FlightBookingObjects {

	WebDriver driver;

	public FlightBookingObjects(WebDriver driver) {

		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "(//span[@class='customRadioBtn']//span)[1]")
	WebElement radioBtnFrom;

	public WebElement getRadioBtnFrom() {

		return radioBtnFrom;
	}

	@FindBy(how = How.XPATH, using = "(//span[@class='customRadioBtn']//span)[37]")
	WebElement radioBtnTo;

	public WebElement getRadioBtnTo() {

		return radioBtnTo;
	}

	@FindBy(how = How.XPATH, using = "//button[contains(@id,'book')]")
	WebElement clickBookNow;

	public WebElement getClickBookNow() {

		return clickBookNow;
	}

	@FindBy(how = How.XPATH, using = "//button[text()='Continue']")
	WebElement fareBtnContinue;

	public WebElement getFareBtnContinue() {

		return fareBtnContinue;
	}

}

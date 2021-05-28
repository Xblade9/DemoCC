package com.mmt.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class TravellerDetailsObjects {
	WebDriver driver;

	public TravellerDetailsObjects(WebDriver driver) {

		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//font[contains(text(),'Departure')]")
	WebElement flightSumTxt;

	public WebElement getFlightSumText() {

		return flightSumTxt;
	}

	@FindBy(how = How.XPATH, using = "//input[contains(@placeholder,'First')]")
	WebElement firstName;

	public WebElement getFirstName() {

		return firstName;
	}

	@FindBy(how = How.XPATH, using = "//input[contains(@placeholder,'Last')]")
	WebElement lastName;

	public WebElement getLastName() {

		return lastName;
	}

	@FindBy(how = How.XPATH, using = "//label[@tabindex='0']")
	WebElement male;

	public WebElement getMale() {

		return male;

	}

	@FindBy(how = How.XPATH, using = "//div[text()='Not required']")
	WebElement drpDwn;

	public WebElement getDropDown() {

		return drpDwn;
	}

	@FindBy(how = How.XPATH, using = "//input[contains(@placeholder,'Mob')]")
	WebElement mobNo;

	public WebElement getMobileNumber() {

		return mobNo;
	}

	@FindBy(how = How.XPATH, using = "//input[contains(@placeholder,'Email')]")
	WebElement emaill;

	public WebElement getEmail() {

		return emaill;
	}

	@FindBy(how = How.XPATH, using = "(//span[@class='box'])[2]")
	WebElement gstChkbox;

	public WebElement getGstCheckbox() {
		return gstChkbox;
	}

	@FindBy(how = How.XPATH, using = "//button[@type='button']")
	WebElement cnt;

	public WebElement getCountinueButton() {
		return cnt;
	}

	@FindBy(how = How.XPATH, using = "//a[text()='CONFIRM']")
	WebElement popUp;

	public WebElement getPopUp() {
		return popUp;
	}
	
	@FindBy(how = How.XPATH, using = "//p[text()='Mumbai - New Delhi']")
	WebElement flightSumText;

	public WebElement getFlightSummaryText() {
		return flightSumText;
	}

}

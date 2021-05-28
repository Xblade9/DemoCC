package com.mmt.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class FlightSearchObjects {

	WebDriver driver;

	public FlightSearchObjects(WebDriver driver) {

		this.driver = driver;

	}

	@FindBy(how = How.TAG_NAME, using = "body")
	WebElement clickBdy;

	public WebElement getclickBdy() {

		return clickBdy;
	}

	@FindBy(how = How.ID, using = "fromCity")
	WebElement clickFrom;

	public WebElement getfromState() {

		return clickFrom;
	}

	@FindBy(how = How.XPATH, using = "//input[@placeholder='From']")
	WebElement inputFromField;

	public WebElement getinputFromDataField() {

		return inputFromField;
	}

	@FindBy(how = How.XPATH, using = "//div[@class='makeFlex hrtlCenter']/div[@class='calc60']")
	WebElement clickRecentSeaFrom;

	public WebElement getclickRecentSeaFrom() {
		return clickRecentSeaFrom;
	}

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'To')]")
	WebElement clickTo;

	public WebElement gettoState() {

		return clickTo;
	}

	@FindBy(how = How.XPATH, using = "//input[@placeholder='To']")
	WebElement inputToDataField;

	public WebElement getinputToField() {

		return inputToDataField;
	}

	@FindBy(how = How.XPATH, using = "//div[@class='makeFlex hrtlCenter']/div[@class='calc60']")
	WebElement clickRecentSeaTo;

	public WebElement getclickRecentSeaTo() {

		return clickRecentSeaTo;
	}

	@FindBy(how = How.XPATH, using = "//span[text()='DEPARTURE']")
	WebElement clickDeparture;

	public WebElement getclickDeparture() {

		return clickDeparture;
	}

	@FindBy(how = How.XPATH, using = "//span[text()='RETURN']")
	WebElement clickReturn;

	public WebElement getclickReturn() {

		return clickReturn;
	}

	@FindBy(how = How.XPATH, using = "(//p[text()='28'])[2]")
	WebElement returnDate;

	public WebElement getreturnDate() {

		return returnDate;
	}

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Search')]")
	WebElement search;

	public WebElement getsearch() {

		return search;
	}
	
	
	@FindBy(how = How.XPATH, using = "//div[@role='heading']")
	WebElement dHeading;
	
	public WebElement getDateHeading() {
		return dHeading;
	}

	
	@FindBy(how = How.XPATH, using = "// span[@aria-label='Next Month']")
	WebElement clickArrow;
	
	public WebElement getClickArrow() {
		return clickArrow;
	}
	
	
	
}

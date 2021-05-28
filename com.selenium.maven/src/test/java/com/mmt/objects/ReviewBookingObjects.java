package com.mmt.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ReviewBookingObjects {

	WebDriver driver;

	public ReviewBookingObjects(WebDriver driver) {

		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//span[contains(@style,'font-family')]")  //LKO-DEL
	WebElement flightTxt;

	public WebElement getFlightText() {

		return flightTxt;
	}

	@FindBy(how = How.XPATH, using = "//label[@class='block radio']/input[@value='no']") 
	WebElement noSecureTip;

	public WebElement getNoSecureTip() {

		return noSecureTip;
	}
	
	
	@FindBy(how = How.XPATH, using = "//label[@class='make_flex radio']/input[@value='no']") 
	WebElement noSecureTip2;

	public WebElement getNoSecureTip2() {

		return noSecureTip2;
	}

	@FindBy(how = How.XPATH, using = "//p[contains(@class,'charter')]")
	WebElement textG;

	public WebElement getTextG() {

		return textG;
	}

	@FindBy(how = How.XPATH, using = "//button[@id='review-continue']")//button[@id='review-continue']
	WebElement cntBtn;

	public WebElement getCntBtn() {

		return cntBtn;
	}

	@FindBy(how = How.ID, using = "review-continue")
	WebElement btn;

	public WebElement getButton() {

		return btn;
	}

}
//div[contains(@class,'append_bottom15 make_relative ')]/button[@id='review-continue']
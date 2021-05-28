package com.mmt.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class TravllerAddonsObjects {

	WebDriver driver;

	public TravllerAddonsObjects(WebDriver driver) {

		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//a[text()='OKAY']")
	WebElement popUp;

	public WebElement getPopUp() {

		return popUp;

	}

	@FindBy(how = How.TAG_NAME, using = "body")
	WebElement clickBdy;

	public WebElement getClickOnBody() {

		return clickBdy;

	}

	@FindBy(how = How.XPATH, using = "//h4[text()='Traveller & Addons']")
	WebElement travTxt;

	public WebElement getTravelText() {
		return travTxt;
	}

	@FindBy(how = How.XPATH, using = "//div[@style='background-color: rgb(123, 184, 255);']")
	WebElement bomAmd;

	public WebElement getBomAmd() {
		return bomAmd;
	}

	@FindBy(how = How.XPATH, using = "//div[@style='background-color: rgb(123, 184, 255);']")
	WebElement amdDel;

	public WebElement getAmdDel() {
		return amdDel;
	}

	@FindBy(how = How.XPATH, using = "//div[@style='background-color: rgb(123, 184, 255);']")
	WebElement delBlr;

	public WebElement getDelBlr() {

		return delBlr;
	}

	@FindBy(how = How.XPATH, using = "//div[@style='background-color: rgb(123, 184, 255);']")
	WebElement blrBom;

	public WebElement getBlrBom() {

		return blrBom;
	}

	@FindBy(how = How.ID, using = "ancillary-continue")
	WebElement nxt;

	public WebElement getNext() {
		return nxt;
	}

	@FindBy(how = How.ID, using = "ancillary-continue")
	WebElement nxtMeal;

	public WebElement getNextMeal() {
		return nxtMeal;
	}

	@FindBy(how = How.XPATH, using = "//a[text()='Next']")
	WebElement selectYourMeal;

	public WebElement getSelectYourMeal() {
		return selectYourMeal;
	}
	
	@FindBy(how = How.XPATH, using = "//p[@class='webChkInheaderInfo']")
	WebElement webCheckInPopUp;

	public WebElement getWebCheckInPopUp() {
		return selectYourMeal;
	}
	
	
	
	
	
	//p[text()='Mumbai - New Delhi']
	//p[@class='webChkInheaderInfo']

}

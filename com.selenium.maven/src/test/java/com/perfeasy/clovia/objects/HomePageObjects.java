package com.perfeasy.clovia.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePageObjects {

	WebDriver driver;

	public HomePageObjects(WebDriver driver) {

		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//span[contains(@class,'fa fa-user profileIcon')]")
	WebElement loginHover;

	public WebElement mouseHoverToLogin() {
		return loginHover;
	}

	@FindBy(how = How.XPATH, using = "//span[text()='Login'] ")
	WebElement login;

	public WebElement clickOnLogin() {

		return login;

	}

	@FindBy(how = How.XPATH, using = "//span[text()='Signup'] ")
	WebElement signup;

	public WebElement mouseHoverToSignUp() {

		return signup;

	}

	@FindBy(how = How.XPATH, using = "//span[@class='g-signin2']")
	WebElement googleBtn;

	public WebElement loginWithGoogle() {

		return googleBtn;

	}

	@FindBy(how = How.XPATH, using = "//div[@class='BHzsHc']")
	WebElement useAnotherAccount;

	public WebElement clickOnAnotherAccount() {

		return useAnotherAccount;

	}

	@FindBy(how = How.XPATH, using = " //input[@type='email']")
	WebElement emailGmail;

	public WebElement enterGmailEmailField() {

		return emailGmail;

	}

	@FindBy(how = How.XPATH, using = " //div[@class='VfPpkd-RLmnJb']")
	WebElement nextButtonGmail;

	public WebElement clickOnNextButtonGmail() {

		return nextButtonGmail;

	}

	@FindBy(how = How.XPATH, using = " //input[@type='password']")
	WebElement passGmail;

	public WebElement enterGmailPassField() {

		return passGmail;

	}

	@FindBy(how = How.XPATH, using = " //div[@class='VfPpkd-RLmnJb']")
	WebElement nextButtonGmailPass;

	public WebElement clickOnNextButtonGmailPassword() {

		return nextButtonGmailPass;

	}

	@FindBy(how = How.ID, using = "email_popup")
	WebElement emailId;

	public WebElement emailIdFieldForLogin() {

		return emailId;

	}

	@FindBy(how = How.XPATH, using = "//button[text()='Continue ']")
	WebElement continueBtn;

	public WebElement clickOnContinueBtn() {

		return continueBtn;

	}

	@FindBy(how = How.ID, using = "password_dt_login")
	WebElement pwd;

	public WebElement passwordFieldForLogin() {

		return pwd;

	}

	@FindBy(how = How.XPATH, using = "//button[@value='Submit']")
	WebElement submitBtn;

	public WebElement clickOnSubmitBtn() {

		return submitBtn;

	}
	
	
	@FindBy(how = How.XPATH, using = "//span[@class='fa fa-user profileIcon']")
	WebElement profileIconMouseHover;

	public WebElement getMouseHoverProfileIcon() {

		return profileIconMouseHover;

	}
	
	
	@FindBy(how = How.ID, using = "password_dt_login")
	WebElement accountName;

	public WebElement getAccountNameText() {

		return accountName;

	}
	
	
	@FindBy(how = How.XPATH, using = "//a[text()='My Account']")
	WebElement myAccount;

	public WebElement getMyAccount() {

		return myAccount;

	}
	
	
	@FindBy(how = How.XPATH, using = "//span[@class='labelValue edit-name-display']")
	WebElement personalInfo;

	public WebElement getPersonalInfo() {

		return personalInfo;

	}

}

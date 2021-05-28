package com.mmt.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginObjects {

	WebDriver driver;

	public LoginObjects(WebDriver driver) {

		this.driver = driver;

	}

	@FindBy(how = How.TAG_NAME, using = "body")
	WebElement clickBdy;

	public WebElement clickBdy() {

		return clickBdy;
	}

	@FindBy(how = How.XPATH, using = "//li[@data-cy='account']")
	WebElement loginCreate;

	public WebElement clickLoginOrCreateAccount() {

		return loginCreate;
	}

	@FindBy(how = How.XPATH, using = "//input[@class='font14 fullWidth']")
	WebElement loginField;

	public WebElement loginDataField() {

		return loginField;
	}

	@FindBy(how = How.XPATH, using = "//button[@data-cy='continueBtn']")
	WebElement contBtn;

	public WebElement clickContinue() {
		return contBtn;
	}

	@FindBy(how = How.XPATH, using = "//input[@data-cy='password']")
	WebElement passField;

	public WebElement passDataField() {

		return passField;
	}

	@FindBy(how = How.XPATH, using = "//button[@data-cy='login']")
	WebElement logBtn;

	public WebElement clickLoginBtn() {

		return logBtn;
	}
}

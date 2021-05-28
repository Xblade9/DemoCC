package com.mmt.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.mmt.objects.LoginObjects;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {

		this.driver = driver;

	}

	public void login_mmtrip(String uid, String pass) {

		try {
			LoginObjects lobj = PageFactory.initElements(driver, LoginObjects.class);

			Actions action = new Actions(driver);

			lobj.clickBdy().click();

			action.click(lobj.clickLoginOrCreateAccount()).build().perform();

			lobj.loginDataField().sendKeys(uid);

			lobj.clickContinue().click();

			lobj.passDataField().sendKeys(pass);

			lobj.clickLoginBtn().click();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Faild To Login");
		}

	}

}

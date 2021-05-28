package com.prefeasy.clovia.methods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.perfeasy.clovia.objects.HomePageObjects;

public class HPage {

	WebDriver driver;

	WebDriverWait wait;

	public HPage(WebDriver driver) {

		this.driver = driver;
	}

	public void login(String uid, String pass) {

		HomePageObjects hpo = PageFactory.initElements(driver, HomePageObjects.class);

		Actions action = new Actions(driver);

		action.moveToElement(hpo.mouseHoverToLogin()).perform();

		hpo.clickOnLogin().click();

		hpo.emailIdFieldForLogin().sendKeys(uid);

		hpo.clickOnContinueBtn().click();

		hpo.passwordFieldForLogin().sendKeys(pass);

		hpo.clickOnSubmitBtn().click();

		action.moveToElement(hpo.getMouseHoverProfileIcon()).perform();

		hpo.getMyAccount().click();
		
		Assert.assertTrue(hpo.getPersonalInfo().getText().equals(hpo.getPersonalInfo().getText()));
		
		System.out.println(hpo.getPersonalInfo().getText());

	}

}

package com.mmt.pages;

import java.time.Duration;
//import java.util.Iterator;
//import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.mmt.objects.TravllerAddonsObjects;

public class TravllerAddons {

	WebDriver driver;

	WebDriverWait wait;

	public TravllerAddons(WebDriver driver) {

		this.driver = driver;
	}

	public void travlAddons() throws Exception {

		try {
			TravllerAddonsObjects tao = PageFactory.initElements(driver, TravllerAddonsObjects.class);

			// JavascriptExecutor js = (JavascriptExecutor)driver;

			Actions action = new Actions(driver);

			wait = new WebDriverWait(driver, 20);

			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

			wait.withTimeout(Duration.ofSeconds(20));

			// tao.getPopUp().click();

			Assert.assertTrue(tao.getTravelText().getText().contains("Trav"), "Failed to Get Trav Addons Text");

			Thread.sleep(5000);

			tao.getClickOnBody().click();

			tao.getBomAmd().click();

			tao.getNext().click();

			tao.getAmdDel().click();

			tao.getNext().click();

			tao.getDelBlr().click();

			tao.getNext().click();

			// tao.getBlrBom().click();

			// js.executeScript("arguments[0].scrollIntoView();", tao.getNext());

			action.click(tao.getNext()).build().perform();

			// tao.getNext().click();

			action.click(tao.getNextMeal()).build().perform();

			// tao.getNextMeal().click();

			action.click(tao.getSelectYourMeal()).build().perform();

			// tao.getSelectYourMeal().click();
		} catch (InterruptedException e) {
			e.printStackTrace();
			
			Assert.fail("Failed To Addons on Travller");
		}
	}

}

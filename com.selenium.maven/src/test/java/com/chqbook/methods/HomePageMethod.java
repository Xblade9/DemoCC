package com.chqbook.methods;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.chqbook.objects.HomePage;

public class HomePageMethod {

	WebDriver driver;

	WebDriverWait wait;

	WebElement ele;

	public HomePageMethod(WebDriver driver) {

		this.driver = driver;
	}

	public void verifyMobileFieldAndCategories(String mobNo) {

		try {

			HomePage hp = PageFactory.initElements(driver, HomePage.class);

			JavascriptExecutor js = (JavascriptExecutor) driver;

			hp.getEnterMobileNo().sendKeys(mobNo);

			js.executeScript("arguments[0].click();", hp.getClickOnGetAppLink());

			Assert.assertTrue(hp.getValidationMsg().getText().equals(hp.getValidationMsg().getText()));

			System.out.println("Message Display After Entering Valid/Invalid Or Nothing in Mobile Field : "
					+ hp.getValidationMsg().getText());

			// checking functionality of about us module

			js.executeScript("arguments[0].click();", hp.getAboutUsCategory());

			js.executeScript("arguments[0].click();", hp.getPopUp());

			Assert.assertTrue(hp.getAboutUsText().getText().equals(hp.getAboutUsText().getText()));

			System.out.println("About Company : " + hp.getAboutUsText().getText());

			for (int i = 0; i <= 3;) {

				List<WebElement> compo = driver
						.findElements(By.xpath("//div[@class='Component__AboutUsNavWrapper-sc-1lgdpv7-8 gbKWtA']/div"));

				for (WebElement w : compo) {

					js.executeScript("arguments[0].click();", w);

					Thread.sleep(2000);

				}

				break;
			}

			System.out.println("Investor Text Of About Us Components : " + hp.getOurInvestorText().getText());

			// media Center

			js.executeScript("arguments[0].click();", hp.getMediaCenterCategory());

			// randomly CLicking on button given below : see all news,see all releases,see
			// all articles,dwld our media kit

			ele = hp.getMediaCenterDifferentBtns();

			int totalBtns = ele
					.findElements(By.xpath("//div[@class='Component__MediaCardWrapper-sc-1wvjeoc-2 lgrvZs']//button"))
					.size();

			System.out.println("Total No of Available Buttons in Media Center :" + totalBtns);

			Random rand = new Random();

			List<WebElement> list = ele
					.findElements(By.xpath("//div[@class='Component__MediaCardWrapper-sc-1wvjeoc-2 lgrvZs']//button"));

			js.executeScript("arguments[0].click();", list.get(rand.nextInt(totalBtns)));

			Assert.assertTrue(hp.getMediaCenterDifferentBtnsSelectedText().getText()
					.equals(hp.getMediaCenterDifferentBtnsSelectedText().getText()));

			System.out.println(
					"Text Of The Randomly Selected Button : " + hp.getMediaCenterDifferentBtnsSelectedText().getText());

			// careers

			js.executeScript("arguments[0].click();", hp.getCareersCategory());

			Assert.assertTrue(hp.getCareersCategoryTextShownInPage().getText()
					.equals(hp.getCareersCategoryTextShownInPage().getText()));

			System.out.println("Careers At Cheqbook Text : " + hp.getCareersCategoryTextShownInPage().getText());

			js.executeScript("arguments[0].click();", hp.getExploreOpportunityBtn());

			js.executeScript("arguments[0].click();", hp.getViewOpenings());

			// Randomly selecting any job and click on apply ................

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

}

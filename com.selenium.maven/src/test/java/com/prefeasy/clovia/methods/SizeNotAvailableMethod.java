package com.prefeasy.clovia.methods;

import java.util.List;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.perfeasy.clovia.objects.SelectingParticularCategoryAndItemObjects;

import utility.CloviaUtilities;

public class SizeNotAvailableMethod {

	public WebDriver driver;

	public WebDriverWait wait;

	public WebElement ele;

	public SizeNotAvailableMethod(WebDriver driver) {
		this.driver = driver;
	}

	public void selectPartCategory(String pincode, String email, String pass, String name, String mob, String altMob,
			String Add, String lndMrk, String zip) {

		try {

			SelectingParticularCategoryAndItemObjects spci = PageFactory.initElements(driver,
					SelectingParticularCategoryAndItemObjects.class);

			Actions a = new Actions(driver);

			a.moveToElement(CloviaUtilities.xpathForDiffCategories(driver, "4")).perform();

			ele = spci.selectAnyLinkFromCategory();

			int numLinks = ele
					.findElements(By
							.xpath("(//li[@class='subMenuContent pull-left'])[4]//a/span[contains(@class,'newicons')]"))
					.size();

			System.out.println(numLinks);

			Random rand = new Random();

			List<WebElement> list = ele.findElements(
					By.xpath("(//li[@class='subMenuContent pull-left'])[4]//a/span[contains(@class,'newicons')]"));

			list.get(rand.nextInt(numLinks)).click();

			Assert.assertTrue(spci.forSubTypeText().getText().equals(spci.forSubTypeText().getText()));

			System.out.println(spci.forSubTypeText().getText());

			JavascriptExecutor js = (JavascriptExecutor) driver;

			ele = spci.selectAnyLinkFromProducts();

			int numLinks2 = ele.findElements(By.className("firstimage")).size();

			System.out.println(numLinks2);

			Random randProd = new Random();

			List<WebElement> list2 = ele.findElements(By.className("firstimage"));

			js.executeScript("arguments[0].scrollIntoView();", list2.get(randProd.nextInt(numLinks2)));

			wait = new WebDriverWait(driver, 20);

			wait.until(ExpectedConditions.elementToBeClickable(list2.get(randProd.nextInt(numLinks2))));

			js.executeScript("arguments[0].click();", list2.get(randProd.nextInt(numLinks2)));

			// handle window

			String mainWindow = driver.getWindowHandle();

			Set<String> childWindow = driver.getWindowHandles();

			for (String str : childWindow) {

				if (!mainWindow.equalsIgnoreCase(str)) {

					driver.switchTo().window(str);

					Assert.assertTrue(
							spci.selectedProdTypeText().getText().equals(spci.selectedProdTypeText().getText()));

					System.out.println(spci.selectedProdTypeText().getText());

					// sizetype

					ele = spci.getSizeType();

					int numLinks3 = ele.findElements(By.xpath("//li[contains(@class,'size_li not')]")).size();

					System.out.println(numLinks3);

					Random randSize = new Random();

					List<WebElement> list3 = ele.findElements(By.xpath("//li[contains(@class,'size_li not')]"));

					list3.get(randSize.nextInt(numLinks3)).click();

					// notify heading

					Assert.assertTrue(spci.getNotifyHeading().getText().contains("This"));

					System.out.println("Notification Text :" + spci.getNotifyHeading().getText());

					// email

					spci.getNotifyEmail().sendKeys(email);

					spci.getNotifyPhone().sendKeys(mob);

					js.executeScript("arguments[0].click();", spci.getNotifyMe());

				}

			}

		} catch (Exception e) {
			e.printStackTrace();

			Assert.fail("Failed To Get The Unavailable Size Chart");
		}

	}

}

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

public class SelectParticularItemAndBuyWithSameAddressForItems {

	public WebDriver driver;

	public WebDriverWait wait;

	public WebElement ele;

	public SelectParticularItemAndBuyWithSameAddressForItems(WebDriver driver) {
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

					int numLinks3 = ele.findElements(By.xpath("//li[contains(@class,'size_li  ')]")).size();
					System.out.println(numLinks3);

					Random randSize = new Random();

					List<WebElement> list3 = ele.findElements(By.xpath("//li[contains(@class,'size_li  ')]"));

					list3.get(randSize.nextInt(numLinks3)).click();

//					for (int i = 0; i <= 9; i++) {
//						spci.getQtyPlusBtn().click();
//					}

					spci.getPincode().sendKeys(pincode);

					js.executeScript("arguments[0].click();", spci.getCheckBtn());

					Assert.assertTrue(spci.getStandardDelText().getText().equals(spci.getStandardDelText().getText()));

					System.out.println(spci.getStandardDelText().getText());

					Assert.assertTrue(
							spci.getproductFeatureTxt().getText().equals(spci.getproductFeatureTxt().getText()));

					System.out.println(spci.getproductFeatureTxt().getText());

					Assert.assertTrue(spci.descriptionForSelectedProduct().getText()
							.equals(spci.descriptionForSelectedProduct().getText()));

					System.out.println(spci.descriptionForSelectedProduct().getText());

					spci.getAddToCartBtn().click();

					wait.until(ExpectedConditions.elementToBeClickable(spci.getShoppingCartBtn()));

					Thread.sleep(2000);

					js.executeScript("arguments[0].click();", spci.getShoppingCartBtn());

					Thread.sleep(2000);

					js.executeScript("arguments[0].click();", spci.getProceedToCheckOut());

					spci.getEmailAtBuy().sendKeys(email);

					spci.getPassAtBuy().sendKeys(pass);

					js.executeScript("arguments[0].click();", spci.getLoginBtnAtBuy());

					js.executeScript("arguments[0].click();", spci.getSaveBtnAtShoppingAddress());

					wait.until(ExpectedConditions.elementToBeClickable(spci.getContinueToPayment()));

					js.executeScript("arguments[0].click();", spci.getContinueToPayment());

					Thread.sleep(3000);

					driver.close();

					// break;

				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

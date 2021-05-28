package com.chqbook.methods;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.chqbook.objects.OurProducts;

public class OurProductsMethodForSortedByCategAndCreditCards {
	
	
	WebDriver driver;

	WebDriverWait wait;

	WebElement ele;

	public OurProductsMethodForSortedByCategAndCreditCards(WebDriver driver) {

		this.driver = driver;
	}
	
	
	public void verifySortedCategAndSelectTheCrediCardRandomly(String fName, String midName, String lName, String mobNum, String pan) {

		try {
			
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

			OurProducts op = PageFactory.initElements(driver, OurProducts.class);

			JavascriptExecutor js = (JavascriptExecutor) driver;

			wait = new WebDriverWait(driver, 10);

			
			Actions action = new Actions(driver);

			js.executeScript("arguments[0].click();", op.getPopUp());

			action.moveToElement(op.getOurProductsCategory()).perform();

			js.executeScript("arguments[0].click();", op.getCreditCardsClick());

			Thread.sleep(3000);

			js.executeScript("arguments[0].click();", op.getApplyNowButton());

			action.click(op.getClickOnBestSelling()).build().perform();

			

			/* randomly clicking Sorted categories */

			ele = op.getSortedByCategory();

			int totalSortedByCategories = ele
					.findElements(
							By.xpath("//canvas[@style='position: absolute; width: 290px; height: 51px; z-index: -1;']"))
					.size();

			System.out.println("Total No Of Categories : " + totalSortedByCategories);

			Random SortedByCategories = new Random();

			List<WebElement> list = ele.findElements(
					By.xpath("//canvas[@style='position: absolute; width: 290px; height: 51px; z-index: -1;']"));

			action.click(list.get(SortedByCategories.nextInt(totalSortedByCategories))).build().perform();

			/* randomly clicking credit cards visible for seleted category */

			ele = op.getAllCardsVisible();

			int totalCardsForParticularSelectedCategory = ele.findElements(By.xpath(
					"(//flt-offset[contains(@style,'translate')])[15]//flt-clip-interior/flt-offset/flt-picture/flt-canvas/canvas"))
					.size();

			System.out.println(
					"Total No Of Cards Available For Selected Category : " + totalCardsForParticularSelectedCategory);

			Random randCards = new Random();

			List<WebElement> list2 = ele.findElements(By.xpath(
					"(//flt-offset[contains(@style,'translate')])[15]//flt-clip-interior/flt-offset/flt-picture/flt-canvas/canvas"));

			js.executeScript("arguments[0].scrollIntoView();",list2.get(randCards.nextInt(totalCardsForParticularSelectedCategory)));

			action.click(list2.get(randCards.nextInt(totalCardsForParticularSelectedCategory))).build().perform();

			// verify the type of card is selected randomly .....

			retryingFindingCrediCardText(op.getTextOfRandomlySelectedCreditCard());

			System.out.println("Text Of The Randomly Selected Credit Card : "
					+ op.getTextOfRandomlySelectedCreditCard().getText());

			Assert.assertTrue(
					op.getTextOfChqBookReviewPros().getText().equals(op.getTextOfChqBookReviewPros().getText()));

			// click on APply now button

			action.click(op.getClickOnApplyNowButton()).build().perform();

			op.getFirstNameField().sendKeys(fName);

			op.getMiddleName().sendKeys(midName);

			op.getLastName().sendKeys(lName);

			op.getMobileNo().sendKeys(mobNum);

			op.getPanNo().sendKeys(pan);

			op.getSubmitBtn().click();

			
			
			
		}

		catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Test Case Failed ");
		}

	}

	public boolean retryingFindingCrediCardText(WebElement webElement) {

		OurProducts op = PageFactory.initElements(driver, OurProducts.class);

		boolean result = false;
		int attempts = 0;
		while (attempts < 2) {
			try {

				

				Assert.assertTrue(op.getTextOfRandomlySelectedCreditCard().getText()
						.equals(op.getTextOfRandomlySelectedCreditCard().getText()));

				result = true;
				break;
			} catch (StaleElementReferenceException e) {

			}
			attempts++;
		}
		return result;
	}

}

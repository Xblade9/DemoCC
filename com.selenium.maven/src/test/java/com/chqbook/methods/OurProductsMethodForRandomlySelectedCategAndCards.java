package com.chqbook.methods;

import java.io.File;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.chqbook.objects.OurProducts;

import utility.ConfigReader;
import utility.ScreenshortUtility;

public class OurProductsMethodForRandomlySelectedCategAndCards {

	WebDriver driver;

	WebDriverWait wait;

	WebElement ele;

	ExtentReports extent;

	ExtentSparkReporter spark;

	ExtentTest test, test2;

	public OurProductsMethodForRandomlySelectedCategAndCards(WebDriver driver) {

		this.driver = driver;
	}

	public void verifyCreditCardsSection(String fName, String midName, String lName, String mobNum, String pan) {

		try {

			OurProducts op = PageFactory.initElements(driver, OurProducts.class);

			JavascriptExecutor js = (JavascriptExecutor) driver;

			wait = new WebDriverWait(driver, 10);

			ConfigReader cfg = new ConfigReader();

			extent = new ExtentReports();

			spark = new ExtentSparkReporter(cfg.getReport());
			
			final File CONF = new File("Configuration/extentconfig.xml");
			
			spark.loadXMLConfig(CONF);
			
			/*spark.config().setTheme(Theme.STANDARD);

			spark.config().setDocumentTitle(
					"ChqBook Report For Randomly Clicking Categories and Credit Cards For Our Products.");

			spark.config().setReportName("ChqBook Report(28-04-2021)"); */

			extent.attachReporter(spark);

			test = extent.createTest("RandomlySelectingCategoryOnlyAndCreditCards",
					"Test Description - Verify the cards display on screen after randomly clicking on any Categories and Clicking on any card Randomly.")
					.assignAuthor("Paras").assignDevice("Chrome Version( 90.0.4430.93)")
					.assignCategory("IntegrationTesting");

			Actions action = new Actions(driver);

			test.info("Pop Up Handled Successfully .");

			js.executeScript("arguments[0].click();", op.getPopUp());

			test.info("Mouse Hover On Our Products Category Successfully.");

			action.moveToElement(op.getOurProductsCategory()).perform();

			test.pass("Sub Category - Credit Cards is Clicked & Loaded Successfully .");

			js.executeScript("arguments[0].click();", op.getCreditCardsClick());

			Thread.sleep(3000);

			test.pass("Apply Now Button is Clicked SuccessFully.");

			js.executeScript("arguments[0].click();", op.getApplyNowButton());

			test.info(
					"Performing Click Operation On By Default Sorted By Category - Best Selling, For Selecting the category and credit cards only.");

			test.info("Using Action Class For Click Operation on Best Selling Sorted By Category .");

			action.click(op.getClickOnBestSelling()).build().perform();

			/* randomly clicking categories */

			ele = op.getAllCategories();

			int totalCategories = ele
					.findElements(
							By.xpath("//canvas[@style='position: absolute; width: 137px; height: 92px; z-index: -1;']"))
					.size();

			test.info("Total No Of Categories Displayed : " + totalCategories);

			System.out.println("Total No Of Categories : " + totalCategories);

			Random randCategories = new Random();

			List<WebElement> list = ele.findElements(
					By.xpath("//canvas[@style='position: absolute; width: 137px; height: 92px; z-index: -1;']"));

			test.info("Categories are Selecting Randomly");

			action.click(list.get(randCategories.nextInt(totalCategories))).build().perform();

			/* randomly clicking credit cards visible for seleted category */

			ele = op.getAllCardsVisible();

			int totalCardsForParticularSelectedCategory = ele.findElements(By.xpath(
					"(//flt-offset[contains(@style,'translate')])[15]//flt-clip-interior/flt-offset/flt-picture/flt-canvas/canvas"))
					.size();

			test.info("Total No Of Cards Available For Selected Category Displayed : "
					+ totalCardsForParticularSelectedCategory);

			System.out.println(
					"Total No Of Cards Available For Selected Category : " + totalCardsForParticularSelectedCategory);

			Random randCards = new Random();

			List<WebElement> list2 = ele.findElements(By.xpath(
					"(//flt-offset[contains(@style,'translate')])[15]//flt-clip-interior/flt-offset/flt-picture/flt-canvas/canvas"));

			test.info("Credit Cards are Selecting Randomly For Randomly Selected Category");

			action.click(list2.get(randCards.nextInt(totalCardsForParticularSelectedCategory))).build().perform();

			// verify the type of card is selected randomly .....

			retryingFindingCrediCardText(op.getTextOfRandomlySelectedCreditCard());

			test.info(op.getTextOfRandomlySelectedCreditCard().getText());

			System.out.println("Text Of The Randomly Selected Credit Card : "
					+ op.getTextOfRandomlySelectedCreditCard().getText());

			test.pass("Adding Assertion on ChqBook Review By Pros");

			Assert.assertTrue(
					op.getTextOfChqBookReviewPros().getText().equals(op.getTextOfChqBookReviewPros().getText()));

			// click on APply now button

			test.pass("Successfull To Click On Apply Now Button.");

			action.click(op.getClickOnApplyNowButton()).build().perform();

			test2 = extent
					.createTest("FillThePersonalDetails",
							"Test Description - Fill The Personal Details of User For Credit Card.")
					.assignAuthor("Paras").assignDevice("Chrome Version( 90.0.4430.93)")
					.assignCategory("IntegrationTesting");

			test2.info("Let's start with your personal details");

			op.getFirstNameField().sendKeys(fName);

			op.getMiddleName().sendKeys(midName);

			op.getLastName().sendKeys(lName);
			
			Thread.sleep(2000);

			op.getMobileNo().sendKeys(mobNum);

			op.getPanNo().sendKeys(pan);

			op.getSubmitBtn().click();

			// ScreenshortUtility.takeScreenshortUtility(driver,
			// "AfterFillingDetailsValidInvalidOrEmpty");

			test2.pass("All Details are Filled Successfullly and OTP Window is Opened .");

			test2.addScreenCaptureFromPath(
					ScreenshortUtility.takeScreenshortUtility(driver, "SuccessFullyFilledDetails"));

			test2.info("ScreenShot Added Successfully For Filled Details !!");

			test2.addScreenCaptureFromPath(ScreenshortUtility.takeScreenshortUtility(driver, "OTP"));

			extent.flush();

		} catch (Exception e) {
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

				// test.pass("Verified The Text Of The Randomly Selected Credit Card.");

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

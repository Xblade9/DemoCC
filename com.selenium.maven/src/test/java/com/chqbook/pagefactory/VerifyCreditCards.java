package com.chqbook.pagefactory;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.chqbook.methods.Dataprovider;
import com.chqbook.methods.OurProductsMethodForCategoriesAndSubCategoriesRandomly;
import com.chqbook.methods.OurProductsMethodForRandomlySelectedCategAndCards;
import com.chqbook.methods.OurProductsMethodForRandomlySelectedCategAndViewAll;
import com.chqbook.methods.OurProductsMethodForSortedByCategAndCreditCards;
import utility.ConfigReader;
import utility.DriverInit;
import utility.ScreenshortUtility;

public class VerifyCreditCards {

	public WebDriver driver;

	public WebDriverWait wait;

	ExtentReports extent;

	ExtentSparkReporter spark;

	ExtentTest test;

	@Test(dataProvider = "ChqBookCreditCards", dataProviderClass = Dataprovider.class, priority = 0)
	public void verifyCreditCardSubCategoryOfOurProducts(String fN, String midN, String lN, String mobile,
			String pancard) {

		try {

			OurProductsMethodForRandomlySelectedCategAndCards opm = PageFactory.initElements(driver,
					OurProductsMethodForRandomlySelectedCategAndCards.class);

			opm.verifyCreditCardsSection(fN, midN, lN, mobile, pancard);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test(dataProvider = "ChqBookCreditCards", dataProviderClass = Dataprovider.class, priority = 1, enabled = false)
	public void verifyCreditCardCategoryAndViewAllCards(String fN, String midN, String lN, String mobile,
			String pancard) {

		try {

			OurProductsMethodForRandomlySelectedCategAndViewAll opm = PageFactory.initElements(driver,
					OurProductsMethodForRandomlySelectedCategAndViewAll.class);

			opm.verifyForRandomCategAndViewAll(fN, midN, lN, mobile, pancard);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test(dataProvider = "ChqBookCreditCards", dataProviderClass = Dataprovider.class, priority = 2, enabled = false)
	public void verifySortedByCategoryAndSelectCreditCardsRandomly(String fN, String midN, String lN, String mobile,
			String pancard) {

		try {

			OurProductsMethodForSortedByCategAndCreditCards opm = PageFactory.initElements(driver,
					OurProductsMethodForSortedByCategAndCreditCards.class);

			opm.verifySortedCategAndSelectTheCrediCardRandomly(fN, midN, lN, mobile, pancard);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test(dataProvider = "ChqBookCreditCards", dataProviderClass = Dataprovider.class, priority = 3, enabled = false)
	public void verifyCategoriesAndSortedByCategoriesRandomly(String fN, String midN, String lN, String mobile,
			String pancard) {

		try {

			OurProductsMethodForCategoriesAndSubCategoriesRandomly opm = PageFactory.initElements(driver,
					OurProductsMethodForCategoriesAndSubCategoriesRandomly.class);

			opm.verifyCategoriesAndSortedByCategoriesRandomly(fN, midN, lN, mobile, pancard);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@BeforeMethod
	public void beforeTest() {

		DriverInit instanceDriver = DriverInit.getInstance();

		driver = instanceDriver.openBrowser();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		ConfigReader cfg = new ConfigReader();

		driver.get(cfg.getChqBookUrl());

		Assert.assertTrue(driver.getTitle().contains("Open"), "Page Title Not Matched");

		System.out.println(driver.getTitle());

	}

	@AfterMethod
	public void tearDown(ITestResult result) {

		try

		{

			if (result.getStatus() == ITestResult.FAILURE) {

				ConfigReader cfg = new ConfigReader();

				extent = new ExtentReports();

				spark = new ExtentSparkReporter(cfg.getReport2());

				final File CONF = new File("Configuration/extentfailedconfig.xml");

				spark.loadXMLConfig(CONF);

				extent.attachReporter(spark);

				test = extent.createTest("Failed Cases Screenshots");

				test.fail("Test Case Failed For Invalid and Empty Data in Personal Details Fields ");

				test.addScreenCaptureFromPath(ScreenshortUtility.takeScreenshortUtility(driver, result.getName()));

				test.info("Screenshot for failed test caseonly");

			}

			Thread.sleep(4000);
			driver.quit();

		}

		catch (Exception e) {

			e.printStackTrace();

		}

	}

	@AfterTest
	public void endReport() {

		extent.flush();
	}

}

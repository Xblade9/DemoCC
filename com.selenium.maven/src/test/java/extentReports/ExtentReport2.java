package extentReports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReport2 {

	public WebDriver driver;

	public ExtentReports report;

	public ExtentTest logger;

	@Test
	public void verifyBlogTitle() {

		report = new ExtentReports("F:\\MyBench\\com.selenium.maven\\extentrprt2.html");

		logger = report.startTest("VerifyBlogTitle");

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		logger.log(LogStatus.INFO, "Browser Started");

		driver.get("http://www.learn-automation.com");

		logger.log(LogStatus.INFO, "Application Has Started");

		String title = driver.getTitle();

		Assert.assertTrue(title.contains("Selenium"));

		logger.log(LogStatus.PASS, "Title Verified");

		String img=logger.addScreenCapture(utility.ScreenshortUtility.takeScreenshortUtility(driver, "passTest"));
		
		logger.log(LogStatus.PASS, "Title Verification",img);
	}

	@AfterMethod

	public void tearDown(ITestResult result) {

		if (result.getStatus() == ITestResult.FAILURE) { 

			String screenshort_path = utility.ScreenshortUtility.takeScreenshortUtility(driver, result.getName());

			String image = logger.addScreenCapture(screenshort_path);

			logger.log(LogStatus.FAIL, "Title Verification", image);

		}

		report.endTest(logger);

		report.flush();

		driver.get("F:\\MyBench\\com.selenium.maven\\extentrprt2.html");

	}

}

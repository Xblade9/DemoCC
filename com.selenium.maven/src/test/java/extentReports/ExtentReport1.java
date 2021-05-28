package extentReports;

import org.openqa.selenium.WebDriver;
/*import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;*/
import org.testng.annotations.Test;

public class ExtentReport1 {

	public  WebDriver driver;

	@Test

	public void verifySeleniumBlog() {

		/*
		 * ExtentReports extent = ExtentReports.get(ExtentReport1.class);
		 * 
		 * extent.init("F:\\MyBench\\com.selenium.maven\\extentReport.html", true);
		 * 
		 * extent.startTest("Verify Page Title");
		 * 
		 * WebDriverManager.chromedriver().setup();
		 * 
		 * driver = new ChromeDriver();
		 * 
		 * driver.manage().window().maximize();
		 * 
		 * extent.log(LogStatus.INFO, "Browser Started");
		 * 
		 * driver.get("http://learn-automation.com");
		 * 
		 * extent.log(LogStatus.INFO, "Navigate to www.learn-automation.com");
		 * 
		 * String title = driver.getTitle();
		 * 
		 * extent.log(LogStatus.INFO, "Get the Current Title");
		 * 
		 * Assert.assertTrue(title.contains("Selenium"));
		 * 
		 * extent.log(LogStatus.PASS, "title verified");
		 * 
		 * extent.attachScreenshot("F:\\walls\\batfleck.jpg");
		 * 
		 * driver.quit();
		 * 
		 * extent.log(LogStatus.INFO, "Browser Closed");
		 * 
		 * extent.endTest();
		 */
	}

}

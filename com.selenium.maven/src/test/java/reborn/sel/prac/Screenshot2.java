package reborn.sel.prac;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class Screenshot2 {

	public WebDriver driver;

	public String url = "https://web.whatsapp.com";

	@Test
	public void f() throws Exception {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("./EcomScreenShorts/chat.png"));
		System.out.println("ScreenSHort Taken Succesfully !!!");

	}

	@BeforeTest
	public void beforeTest() {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		driver.get(url);

	}

	@AfterTest
	public void afterTest() {

		try {

			Thread.sleep(3000);

			driver.quit();

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@AfterMethod
	public void tearDown(ITestResult result) throws Exception {

		if (ITestResult.FAILURE == result.getStatus()) {

			TakesScreenshot ts = (TakesScreenshot) driver;

			File file = ts.getScreenshotAs(OutputType.FILE);

			FileUtils.copyFile(file, new File("./Screenshorts/whatsapp.png"));

			System.out.println("Screenshort Taken Successfully For Failed Test Case !!!");

		}

	}

}

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
import org.testng.annotations.AfterTest;

public class Screenshot {

	public WebDriver driver;

	public String url = "https://portal2.passportindia.gov.in/AppOnlineProject/statusTracker/trackStatusForFileNoNew";

	@Test
	public void f() throws Exception {

		try {
			TakesScreenshot ts = (TakesScreenshot) driver;

			File file = ts.getScreenshotAs(OutputType.FILE);

			FileUtils.copyFile(file, new File("./EcomScreenShorts/pass.png"));

			System.out.println("Screenshorts Taken Successfully !!!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

}

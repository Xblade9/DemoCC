package com.grid;

import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DemoGrid2 {

	public WebDriver driver;
	public String url = "http://newtours.demoaut.com/";
	public String nodeUrl = "http://192.168.1.104:4444/wd/hub";

	@BeforeTest

	public void openBrowser() {

		try {

			DesiredCapabilities capabilities = DesiredCapabilities.chrome();

			capabilities.setBrowserName("chrome");
			
			capabilities.setPlatform(Platform.WIN10);

			ChromeOptions options = new ChromeOptions();

			options.merge(capabilities);
			
			options.setHeadless(true);

			driver = new RemoteWebDriver(new URL(nodeUrl), capabilities);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void f() {

		driver.get(url);
		Assert.assertTrue(driver.getTitle().contains("demo"), "Failed");

	}

	@AfterTest
	public void afterTest() throws Exception {

		Thread.sleep(3000);

		driver.quit();

	}

}

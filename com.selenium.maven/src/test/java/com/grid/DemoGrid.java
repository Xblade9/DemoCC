package com.grid;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class DemoGrid {

	public WebDriver driver;
	public String baseUrl = "http://newtours.demoaut.com/";
	public String nodeURL = "http://192.168.1.104:4444/wd/hub";

	@Test
	public void f() {

		driver.get(baseUrl);

		Assert.assertTrue(driver.getTitle().contains("demo"), "Failed ");

	}

	@BeforeTest
	public void beforeTest() throws Exception {

		try {
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();

			capabilities.setBrowserName("chrome");

			capabilities.setPlatform(Platform.WIN10);

			ChromeOptions options = new ChromeOptions();

			options.merge(capabilities);

			driver = new RemoteWebDriver(new URL(nodeURL), capabilities);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

	}

	@AfterTest
	public void afterTest() throws Exception {

		Thread.sleep(3000);

		driver.quit();

	}

}

//java -Dwebdriver.chrome.driver="E:\SOFTWARES\chromedriver_win32\chromedriver.exe" 
//-jar E:\SOFTWARES\CD\selenium-server-standalone-3.141.59.jar -role node -hub 
//http://192.168.1.104:4444/grid/register

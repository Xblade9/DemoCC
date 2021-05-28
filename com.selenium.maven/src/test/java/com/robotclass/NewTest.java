package com.robotclass;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class NewTest {

	public WebDriver driver;

	public String url = "http://spreadsheetpage.com/index.php/file/C35/P10/";

	@Test
	public void f() {

		try {

			Robot robot = new Robot();

			robot.mouseMove(630, 420); // move mouse to specific location

			robot.delay(1500); // delay is to make code wait for mentioned milliseconds before executing next
								// step

			robot.mousePress(InputEvent.BUTTON1_DOWN_MASK); // press left click

			robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK); // release the left click

			robot.delay(1500);

			robot.keyPress(KeyEvent.VK_DOWN); // press keyboard arrow key to select Save radio button

			Thread.sleep(3000);

			robot.keyPress(KeyEvent.VK_ENTER); // press enter key of keyboard to perform above selected action

		} catch (Exception e) {
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

		Assert.assertTrue(driver.getTitle().contains("Excel"), "Failed to get the Page Title");

		System.out.println(driver.getTitle());

	}

	@AfterTest
	public void afterTest() throws Exception {

		Thread.sleep(5000);

		driver.quit();

	}

}

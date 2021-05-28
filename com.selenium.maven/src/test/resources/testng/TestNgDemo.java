package testng;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class TestNgDemo {

	public String url = "http://demo.guru99.com/test/newtours/";

	public WebDriver driver;

	@Test(priority = 0)
	public void register() {

		driver.findElement(By.linkText("REGISTER")).click();

		Assert.assertTrue(driver.getTitle().contains("Reg"), "Not Same");

		System.out.println(driver.getTitle());

	}

	@Test(priority = 1)
	public void support() {

		driver.findElement(By.linkText("SUPPORT")).click();

		Assert.assertTrue(driver.getTitle().contains("Under"), "Failed to get the same title");

	}

	@BeforeMethod
	public void verifyHomePageTitle() {

		Assert.assertTrue(driver.getTitle().contains("Wel"), "Failed to very Title");

	}

	@AfterMethod
	public void afterMethod() {

		driver.findElement(By.linkText("Home")).click();

	}

	@BeforeTest
	public void beforeTest() {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		driver.get(url);

		System.out.println(driver.getTitle());

	}

	@AfterTest
	public void afterTest() {

		try {
			Thread.sleep(3000);
			driver.quit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}

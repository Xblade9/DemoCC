package dataprovider;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class DataProviderParameterUsingMethod {

	public WebDriver driver;

	public String url = "https://google.com";

	@Test(dataProvider = "SearchProvider")
	public void testMethodA(String author, String searchKey) throws Exception {

		WebElement searchText = driver.findElement(By.name("q"));

		searchText.sendKeys(searchKey);

		System.out.println("Welcome ->" + author + "Your Search Key is ->" + searchKey);

		Thread.sleep(3000);

		String testValue = searchText.getAttribute("value");

		System.out.println(testValue + "::::" + searchKey);

		searchText.clear();

		Assert.assertTrue(testValue.equalsIgnoreCase(searchKey));

		System.out.println("Successfull");

	}

	@Test(dataProvider = "SearchProvider")

	public void testMethodB(String searchKey) throws Exception {

		WebElement searchText = driver.findElement(By.name("q"));

		searchText.sendKeys(searchKey);

		System.out.println("Welcome -> Unknown user Your Search Key is ->" + searchKey);

		Thread.sleep(3000);

		String testValue = searchText.getAttribute("value");

		System.out.println(testValue + "::::" + searchKey);

		searchText.clear();

		Assert.assertTrue(testValue.equalsIgnoreCase(searchKey));

		System.out.println("Successfull");

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
		} catch (Exception e) {
			// TODO: handle exception

			e.printStackTrace();
		}
	}

	@DataProvider(name = "SearchProvider")
	public Object[][] getDataFromDataProvider(Method m) {

		if (m.getName().equalsIgnoreCase("testMethodA")) {
			return new Object[][] {

					{ "Guru99", "India" }, { "Krishna", "UK" }, { "Bhupesh", "USA" }

			};

		}

		else

		{
			return new Object[][] {

					{ "Canada" }, { "Russia" }, { "Japan" } };
		}

	}
}
package dataprovider;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class ParameterByDataProvider {

	public WebDriver driver;

	public String url = "https://google.com";

	@DataProvider(name = "SearchProvider")
	public Object[][] getDataFromDataProvider() {
		return new Object[][] {

				{ "Guru99", "India" }, { "Krishna", "UK" }, { "Bhupesh", "USA" }

		};

	}

	@Test(dataProvider = "SearchProvider")
	public void f(String author, String searchKey) {

		try {

			WebElement searchText = driver.findElement(By.xpath("//input[@name='q']"));

			searchText.sendKeys(searchKey);

			System.out.println("Welcome ->" + author + "Your Search Key is ->" + searchKey);

			
			String testvalue=searchText.getAttribute(searchKey);
			
			System.out.println(testvalue+"::::"+searchKey);
			
			//verify
			
			Thread.sleep(3000);
			
			Assert.assertTrue(testvalue.equalsIgnoreCase(searchKey));
			
			System.out.println("Verified");
			
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

}

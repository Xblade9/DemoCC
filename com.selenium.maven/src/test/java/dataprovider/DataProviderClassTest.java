package dataprovider;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class DataProviderClassTest {

	public WebDriver driver;

	public String url = "https://google.com";

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

	@Test(dataProviderClass = DataProviderClass.class, dataProvider = "SearchProvider")
	public void getDataFromDataProviderTest(String author,String searchKey) throws InterruptedException {

		
		WebElement searchText=driver.findElement(By.name("q"));
		
		searchText.sendKeys(searchKey);
		
		System.out.println("Welcome ->" + author + "Your Search Key is ->" + searchKey);

		Thread.sleep(3000);
		
		String testValue=searchText.getAttribute("value");
		
		System.out.println(testValue+"::::"+searchKey);
		
		searchText.clear();
		
		Assert.assertTrue(testValue.equalsIgnoreCase(searchKey));
		
		System.out.println("Successfull");
	}
}

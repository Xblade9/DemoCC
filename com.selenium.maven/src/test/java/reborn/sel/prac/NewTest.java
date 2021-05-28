package reborn.sel.prac;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewTest {

	public WebDriver driver;

	public String URL = "http://www.demo.guru99.com/V4/index.php";

	@BeforeMethod(description = "Open the Appn")

	public void open()

	{

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		driver.get(URL);

	}

	@AfterMethod(enabled = true)

	public void close() {

		try {

			Thread.sleep(5000);

			driver.quit();

		}

		catch (Exception e)

		{

			e.printStackTrace();

		}

	}

	@Test
	public void alert() {

		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("mngr294381");

		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("mepurAb");

		driver.findElement(By.xpath("//input[@type='submit']")).click();

		/*
		 * Alert alert = driver.switchTo().alert();
		 * 
		 * if (alert.getText().contains("User or Password is not valid")) {
		 * 
		 * System.out.println(alert.getText()); alert.accept();
		 * 
		 * 
		 * }
		 */

		if (driver.switchTo().alert().getText().contains("User or Password is not valid")) {

			driver.switchTo().alert().accept();

		}

		else {
			Assert.assertTrue(driver.getTitle().contains("Guru"));

			System.out.println(driver.getTitle());
		}

	}

}

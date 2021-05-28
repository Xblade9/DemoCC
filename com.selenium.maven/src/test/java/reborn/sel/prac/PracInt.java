package reborn.sel.prac;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.io.File;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class PracInt {

	public String url = "http://demo.guru99.com/popup.php";

	public WebDriver driver;

	@Test
	public void f() throws Exception {

		driver.findElement(By.xpath("//a[text()='Click Here']")).click();

		String pW = driver.getWindowHandle();

		Set<String> cW = driver.getWindowHandles();


		for (String string : cW) {

			if (!pW.equalsIgnoreCase(string)) {

				driver.switchTo().window(string);

				driver.findElement(By.xpath("//input[@type='text']")).sendKeys("gaurav.2n@gmail.com");

				driver.findElement(By.xpath("//input[@type='submit']")).click();

				Assert.assertEquals(driver.getTitle(), "Guru99 Bank Home Page");

				TakesScreenshot ts = (TakesScreenshot) driver;

				File src = ts.getScreenshotAs(OutputType.FILE);

				FileUtils.copyFile(src, new File("./ScreenShorts/window.png"));

				System.out.println("Screenshort Taken Successfully !!!");

				Thread.sleep(3000);

				driver.close();

			}

			driver.switchTo().window(pW);

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

			e.printStackTrace();
		}

	}

}

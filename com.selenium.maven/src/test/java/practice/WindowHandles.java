package practice;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class WindowHandles {

	public WebDriver driver;
	public String url = "http://demo.guru99.com/popup.php";

	@Test
	public void f() {

		driver.findElement(By.linkText("Click Here")).click();

		String parentWindow = driver.getWindowHandle();

		// to handle all the window opened

		Set<String> childWindow = driver.getWindowHandles();

		for (String str : childWindow) {

			if (!parentWindow.equalsIgnoreCase(str)) {

				driver.switchTo().window(str);

				driver.findElement(By.xpath("//input[@type='text']")).sendKeys("gaurav.3n@gmail.com");

				driver.findElement(By.name("btnLogin")).click();

				driver.close();
			} else {

				driver.switchTo().window(parentWindow);

			}

		}

	}

	@BeforeTest
	public void beforeTest() {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get(url);

	}

	@AfterTest
	public void afterTest() throws Exception {

		Thread.sleep(2000);
		
		driver.quit();
	}

}

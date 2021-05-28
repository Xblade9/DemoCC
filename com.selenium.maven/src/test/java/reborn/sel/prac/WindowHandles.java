package reborn.sel.prac;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandles {

	public WebDriver driver;
	public String url = "http://demo.guru99.com/popup.php";

	@Test
	public void f() throws Exception {

		driver.findElement(By.xpath("//a[text()='Click Here']")).click();

		// driver.findElement(By.cssSelector("input[type='text']")).sendKeys("gaurav.2n@gmail.com");

		// driver.findElement(By.xpath("//input[@value='Submit']")).submit();

		String parentWindow = driver.getWindowHandle();

		Set<String> childWindow = driver.getWindowHandles();

		for (String string : childWindow) {

			if (!parentWindow.equalsIgnoreCase(string)) {
				driver.switchTo().window(string);

				driver.findElement(By.cssSelector("input[type='text']")).sendKeys("gaurav.2n@gmail.com");

				driver.findElement(By.xpath("//input[@value='Submit']")).click();

				Thread.sleep(3000);
				
				driver.close();
			}

		}	

		driver.switchTo().window(parentWindow);

	}

	@BeforeTest
	public void open() {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		driver.get(url);

	}

	
	@AfterTest
	
	public void close() throws InterruptedException {
		
		Thread.sleep(3000);
		
		driver.quit();
		
	}
	
}

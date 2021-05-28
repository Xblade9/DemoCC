package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.perfeasy.makemytrip.DataProviderForMmtrip;

public class FlightSearchFw {

	public WebDriver driver;

	public WebElement element;

	public WebDriverWait wait;

	@Test(description = "For Flight Search", dataProvider = "flightProvider", dataProviderClass = DataProviderForMmtrip.class)
	public void flightSearch(String from, String to) {

		try {

			wait = new WebDriverWait(driver, 30);

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='From']")));

			driver.findElement(By.id("fromCity")).click();

			driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys(from);

			driver.findElement(By.xpath(
					"//div[@class='makeFlex hrtlCenter']//parent::li[@id='react-autowhatever-1-section-0-item-0']"))
					.click();

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'To')]")));

			driver.findElement(By.xpath("//span[contains(text(),'To')]")).click();

			driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys(to);

			driver.findElement(By.xpath(
					"//div[@class='makeFlex hrtlCenter']//parent::li[@id='react-autowhatever-1-section-0-item-0']"))
					.click();

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='DEPARTURE']")));

			driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();

			String month = "March 2022";

			String exp_date = "8";

			while (true) {

				String text = driver.findElement(By.xpath("//div[@role='heading']")).getText();
				if (text.equals(month)) {

					break;
				}

				else {
					driver.findElement(By.xpath("// span[@aria-label='Next Month']")).click();
				}

			}

			List<WebElement> allDates = driver.findElements(By.cssSelector("div[class='dateInnerCell']"));

			for (WebElement ele : allDates) {

				String dText = ele.getText();

				String date[] = dText.split("\n");

				if (date[0].equals(exp_date)) {

					ele.click();

					break;

				}

			}

			driver.findElement(By.xpath("//span[text()='RETURN']")).click();

			driver.findElement(By.xpath("(//p[text()='28'])[2]")).click();

			driver.findElement(By.xpath("//a[contains(text(),'Search')]")).click();

			driver.findElement(By.xpath("(//span[@class='customRadioBtn']//span)[1]")).click();

			driver.findElement(By.xpath("//button[text()='Book Now']"));

		}

		catch (Exception e) {

			e.printStackTrace();

		}

	}

}

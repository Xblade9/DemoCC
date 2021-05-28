package practice;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utility.DriverInit;

public class DropDownWIthoutSelect {

	static WebDriver driver;

	static WebElement ele;

	public static void main(String[] args) {

		DriverInit d = new DriverInit();

		driver = d.openBrowser();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		driver.get(
				"https://www.makemytrip.com/flight/traveller/?itineraryId=9e475e4417f04a757c408290c63633762f85556f&crId=11e2147f-2d17-4de2-b742-f472b407ddef&cur=INR");

		//JavascriptExecutor js = (JavascriptExecutor) driver;

		Actions action = new Actions(driver);
		
		driver.findElement(By.xpath("//div[@class='dropdown__value-container css-1hwfws3']")).click();

		ele = driver.findElement(By.xpath("//div[@class='dropdown__value-container css-1hwfws3']"));

		int i = ele.findElements(By.xpath(
				"//div[@class='dropdown__value-container css-1hwfws3']/div[@class='dropdown__placeholder css-1wa3eu0-placeholder']"))
				.size();

		System.out.println(i);

		Random rand = new Random();

		List<WebElement> allOptions = ele.findElements(By.xpath(
				"//div[@class='dropdown__value-container css-1hwfws3']/div[@class='dropdown__placeholder css-1wa3eu0-placeholder']"));

		action.click(allOptions.get(rand.nextInt(i)));
		
		
		//js.executeScript("arguments[0].click();", allOptions.get(rand.nextInt(i)));

		// allOptions.get(rand.nextInt(i)).click();

	}

}

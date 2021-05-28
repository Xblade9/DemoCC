package com.mmt.pages;

import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.mmt.objects.ReviewBookingObjects;

public class ReviewBooking {

	WebDriver driver;

	WebDriverWait wait;

	public ReviewBooking(WebDriver driver) {
		this.driver = driver;
	}

	public void review_Mmtrip() throws Exception {

		try {
			ReviewBookingObjects rb = PageFactory.initElements(driver, ReviewBookingObjects.class);

			String mainWindow = driver.getWindowHandle();

			Actions action = new Actions(driver);

			Set<String> childWindow = driver.getWindowHandles();

			for (String str : childWindow) {

				if (!mainWindow.equalsIgnoreCase(str)) {

					driver.switchTo().window(str);

					Assert.assertTrue(rb.getFlightText().getText().equals(rb.getFlightText().getText()),
							"Failed To Get The Ticket Text");

					System.out.println(rb.getFlightText().getText());

					JavascriptExecutor js = (JavascriptExecutor) driver;

					Thread.sleep(12000);

					js.executeScript("arguments[0].scrollIntoView();", rb.getButton());

					action.click(rb.getButton()).build().perform();

				}

			}
		} catch (InterruptedException e) {
			e.printStackTrace();
			Assert.fail("Failed To Review A Booking");
		}

	}

	public static WebElement getNoSecureTipRadioBtn(WebDriver driver, String i) {

		return driver.findElement(By.xpath("//label[@class='" + i + "']/input[@value='no']"));
	}

}

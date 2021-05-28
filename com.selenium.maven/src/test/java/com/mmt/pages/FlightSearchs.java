package com.mmt.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.mmt.objects.FlightSearchObjects;

public class FlightSearchs {

	static WebDriver driver;

	WebDriverWait wait;

	public FlightSearchs(WebDriver driver) {

		FlightSearchs.driver = driver;
	}

	public void flightSearch_Mmtrip(String from, String to) throws Exception {

		try {
			FlightSearchObjects fso = PageFactory.initElements(driver, FlightSearchObjects.class);

			fso.getclickBdy().click();

			wait = new WebDriverWait(driver, 10);

			wait.until(ExpectedConditions.elementToBeClickable(fso.getfromState()));

			fso.getfromState().click();

			// wait.until(ExpectedConditions.elementToBeClickable(fso.getinputFromDataField()));

			fso.getinputFromDataField().sendKeys(from);

			fso.getinputFromDataField().sendKeys(Keys.SPACE);
			
			Thread.sleep(2000);

			getclickRecentSeaFrom(driver,"BOM").click();

			wait.until(ExpectedConditions.elementToBeClickable(fso.gettoState()));

			fso.gettoState().click();

			fso.getinputToField().sendKeys(to);

			Thread.sleep(2000);

			fso.getclickRecentSeaTo().click();

			wait.until(ExpectedConditions.elementToBeClickable(fso.getclickDeparture()));

			fso.getclickDeparture().click();

			selectDate("7", "May", "2021");

			fso.getclickReturn().click();

			selectDateReturn("10", "May", "2021");

			fso.getsearch().click();
		} catch (InterruptedException e) {
			e.printStackTrace();
			Assert.fail("Failed To Search Flight");
		}

	}

	public static String[] getMonthYear(String monthYearVal) {

		return monthYearVal.split(" ");

	}

	public static void selectDate(String exDay, String exMonth, String exYear) {

		FlightSearchObjects fso = PageFactory.initElements(driver, FlightSearchObjects.class);

		String monthYearVal = fso.getDateHeading().getText();

		System.out.println(monthYearVal);

		while (!(getMonthYear(monthYearVal)[0].equals(exMonth) && getMonthYear(monthYearVal)[1].equals(exYear))) {

			fso.getClickArrow().click();

			monthYearVal = fso.getDateHeading().getText();

			System.out.println(monthYearVal);

		}

		driver.findElement(By.xpath("//p[text()='" + exDay + "']")).click();

	}

	public static void selectDateReturn(String exDay, String exMonth, String exYear) {

		FlightSearchObjects fso = PageFactory.initElements(driver, FlightSearchObjects.class);

		String monthYearVal = fso.getDateHeading().getText();

		System.out.println(monthYearVal);

		while (!(getMonthYear(monthYearVal)[0].equals(exMonth) && getMonthYear(monthYearVal)[1].equals(exYear))) {

			fso.getClickArrow().click();

			monthYearVal = fso.getDateHeading().getText();

			System.out.println(monthYearVal);

			break;

		}

		driver.findElement(By.xpath("//p[text()='" + exDay + "']")).click();

	}

	//div[text()='BOM']
	
	public static WebElement getclickRecentSeaFrom(WebDriver driver, String i) {

		return driver.findElement(By.xpath("//div[text()='"+i+"']"));
	}
	
	
	
}

package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.mmt.objects.FlightSearchObjects;

public class DPicker {

	// public static WebDriver driver;

	public static String[] getMonthYear(String monthYearVal) {

		return monthYearVal.split(" ");

	}

	public static void selectDate(WebDriver driver, String exDay, String exMonth, String exYear) {

		try {

			FlightSearchObjects fso = PageFactory.initElements(driver, FlightSearchObjects.class);

			String monthYearVal = fso.getDateHeading().getText();

			System.out.println(monthYearVal);

			while (!(getMonthYear(monthYearVal)[0].equals(exMonth) && getMonthYear(monthYearVal)[1].equals(exYear))) {

				fso.getClickArrow().click();

				monthYearVal = fso.getDateHeading().getText();

				System.out.println(monthYearVal);

			}

			driver.findElement(By.xpath("//p[text()='" + exDay + "']")).click();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void selectDateDeparture(WebDriver driver, String exDay, String exMonth, String exYear) {

		String monthYearVal = driver.findElement(By.xpath("//div[@role='heading']")).getText();

		System.out.println(monthYearVal);

		while (!(getMonthYear(monthYearVal)[0].equals(exMonth) && getMonthYear(monthYearVal)[1].equals(exYear))) {

			driver.findElement(By.xpath("// span[@aria-label='Next Month']")).click();

			monthYearVal = driver.findElement(By.xpath("//div[@role='heading']")).getText();

			System.out.println(monthYearVal);

		}

		driver.findElement(By.xpath("//p[text()='" + exDay + "']")).click();

	}

	public static void selectDateReturn(WebDriver driver, String exDay, String exMonth, String exYear) {

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

	public static void selectDateReturnWithEmpCell(WebDriver driver, String exDay, String exMonth, String exYear) {

		FlightSearchObjects fso = PageFactory.initElements(driver, FlightSearchObjects.class);

		String monthYearVal = fso.getDateHeading().getText();

		System.out.println(monthYearVal);

		while (!(getMonthYear(monthYearVal)[0].equals(exMonth) && getMonthYear(monthYearVal)[1].equals(exYear))) {

			fso.getClickArrow().click();

			monthYearVal = fso.getDateHeading().getText();

			System.out.println(monthYearVal);

			break;

		}

		driver.findElement(By.xpath("(//p[text()='" + exDay + "'])[2]")).click();

	}

}

package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePicker {

	public static String url = "https://www.makemytrip.com";

	public static WebDriver driver;

	public static WebDriverWait wait;

	public static void main(String[] args) throws Exception {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		driver.get(url);

		driver.findElement(By.tagName("body")).click();

		driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();

		// driver.findElement(By.xpath("//span[@class='lbl_input latoBold
		// appendBottom10'][text()='RETURN']")).click();

		// wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("
		// //div[@class='DayPicker-Months']")));

		/*
		 * String monthYearVal =
		 * driver.findElement(By.xpath("//div[@role='heading']")).getText();
		 * 
		 * System.out.println(monthYearVal);
		 * 
		 * String month = monthYearVal.split(" ")[0].trim(); String year =
		 * monthYearVal.split(" ")[1].trim();
		 * 
		 * while (!(month.equals("May") && year.equals("2021"))) {
		 * 
		 * driver.findElement(By.xpath("// span[@aria-label='Next Month']")).click();
		 * 
		 * monthYearVal =
		 * driver.findElement(By.xpath("//div[@role='heading']")).getText();
		 * 
		 * System.out.println(monthYearVal);
		 * 
		 * month = monthYearVal.split(" ")[0].trim(); year =
		 * monthYearVal.split(" ")[1].trim();
		 */

		// DPicker.selectDateDeparture("9", "April", "2021");

		selectDateDeparture("16", "June", "2021");

		driver.findElement(By.xpath("//span[@class='lbl_input latoBold appendBottom10'][text()='RETURN']")).click();

		// Thread.sleep(3000);

		selectDateReturn("28", "June", "2021");
		
		//selectDateReturnWithEmpCell("28", "July", "2021");

	}

	// driver.findElement(By.xpath("//p[text()='2']")).click();

	public static String[] getMonthYear(String monthYearVal) {

		return monthYearVal.split(" ");

	}

	public static void selectDateDeparture(String exDay, String exMonth, String exYear) {

		String monthYearVal = driver.findElement(By.xpath("//div[@role='heading']")).getText();

		System.out.println(monthYearVal);

		while (!(getMonthYear(monthYearVal)[0].equals(exMonth) && getMonthYear(monthYearVal)[1].equals(exYear))) {

			driver.findElement(By.xpath("// span[@aria-label='Next Month']")).click();

			monthYearVal = driver.findElement(By.xpath("//div[@role='heading']")).getText();

			System.out.println(monthYearVal);

		}

		driver.findElement(By.xpath("//p[text()='" + exDay + "']")).click();

	}

	public static void selectDateReturn(String exDay, String exMonth, String exYear) {

		String monthYearVal = driver.findElement(By.xpath("//div[@role='heading']")).getText();

		System.out.println(monthYearVal);

		while (!(getMonthYear(monthYearVal)[0].equals(exMonth) && getMonthYear(monthYearVal)[1].equals(exYear))) {

			driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();

			monthYearVal = driver.findElement(By.xpath("//div[@role='heading']")).getText();

			System.out.println(monthYearVal);

			break;

		}

		driver.findElement(By.xpath("//p[text()='" + exDay + "']")).click();

	}

	public static void selectDateReturnWithEmpCell(String exDay, String exMonth, String exYear) {

		String monthYearVal = driver.findElement(By.xpath("//div[@role='heading']")).getText();

		System.out.println(monthYearVal);

		while (!(getMonthYear(monthYearVal)[0].equals(exMonth) && getMonthYear(monthYearVal)[1].equals(exYear))) {

			driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();

			monthYearVal = driver.findElement(By.xpath("//div[@role='heading']")).getText();

			System.out.println(monthYearVal);

			break;

		}

		driver.findElement(By.xpath("(//p[text()='" + exDay + "'])[2]")).click();

	}

}

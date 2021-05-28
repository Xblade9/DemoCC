package com.chqbook.methods;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.chqbook.objects.OurProducts;

public class BusinessLoans {

	WebDriver driver;

	WebDriverWait wait;

	WebElement ele;

	Actions acton;

	public BusinessLoans(WebDriver driver) {
		this.driver = driver;
	}

	public void businessLoans() {

		try {

			OurProducts op = PageFactory.initElements(driver, OurProducts.class);

			JavascriptExecutor js = (JavascriptExecutor) driver;

			Actions acton = new Actions(driver);

			js.executeScript("arguments[0].click();", op.getPopUp());

			acton.moveToElement(op.getOurProductsCategory()).perform();

			op.getLoans().click();

			Thread.sleep(3000);

			acton.click(op.getApplyNowButton()).build().perform();

			acton.click(op.getBusinessLoanApply()).build().perform();

			driver.navigate().refresh();

			ele = op.getSelfEmpSection();

			/*
			 * int availLoans = ele.findElements(By.xpath(
			 * "//flt-canvas[@style='position: absolute; transform: translate(-1px, 29px);']//p[text()='Details']"
			 * )) .size();
			 * 
			 * System.out.println("Total No of Loans Available in Window :" + availLoans);
			 * 
			 * List<WebElement> loansAvailable = ele.findElements(By.xpath(
			 * "//flt-canvas[@style='position: absolute; transform: translate(-1px, 29px);']//p[text()='Details']"
			 * ));
			 * 
			 * Random loanRandom = new Random();
			 * 
			 * acton.click(loansAvailable.get(loanRandom.nextInt(availLoans))).build().
			 * perform();
			 */

            randLogic("//flt-canvas[@style='position: absolute; transform: translate(-1px, 29px);']//p[text()='Details']");			
 

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	public WebElement randLogic(String xpath1) {

		int size = ele.findElements(By.xpath(xpath1)).size();

		System.out.println("Total No of Loans Available in Window :" + size);

		List<WebElement> loansAvailable = ele.findElements(By.xpath(xpath1));

		Random r = new Random();

		acton.click(loansAvailable.get(r.nextInt(size))).build().perform();
		
		//loansAvailable.get(r.nextInt(size)).click();

		return ele;

	}

}

package practice;

import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.perfeasy.clovia.objects.SelectingParticularCategoryAndItemObjects;

import utility.CloviaUtilities;
import utility.ConfigReader;
import utility.DriverInit;

public class CloChecker {

	public static WebDriver driver;

	public static WebDriverWait wait;

	public static WebElement ele;

	public static void main(String[] args) throws Exception {

		DriverInit instanceDriver = DriverInit.getInstance();

		driver = instanceDriver.openBrowser();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		ConfigReader cfg = new ConfigReader();

		driver.get(cfg.getClovUrl());

		wait = new WebDriverWait(driver, 30);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		SelectingParticularCategoryAndItemObjects spci = PageFactory.initElements(driver,
				SelectingParticularCategoryAndItemObjects.class);

		// JavascriptExecutor js = (JavascriptExecutor) driver;

		Actions a = new Actions(driver);

		a.moveToElement(CloviaUtilities.xpathForDiffCategories(driver, "4")).perform();

		driver.findElement(By.xpath("(//a[@href='/nightwear/feeding-nightwear/s/'])[1]")).click();
		driver.findElement(
				By.xpath("(//img[@title='Feeding Pretty Florals Long Night Dress in Light Green- Rayon'])[2]")).click();

		String mainWindow = driver.getWindowHandle();

		Set<String> childWindow = driver.getWindowHandles();

		for (String str : childWindow) {

			if (!mainWindow.equalsIgnoreCase(str)) {

				driver.switchTo().window(str);

				Assert.assertTrue(spci.selectedProdTypeText().getText().equals(spci.selectedProdTypeText().getText()));

				System.out.println(spci.selectedProdTypeText().getText());

				// sizetype

				ele = spci.getSizeType();

				int numLinks3 = ele.findElements(By.xpath("//li[contains(@class,'size_li not')]")).size();

				System.out.println(numLinks3);

				Random randSize = new Random();

				List<WebElement> list3 = ele.findElements(By.xpath("//li[contains(@class,'size_li not')]"));

				list3.get(randSize.nextInt(numLinks3)).click();

				// notify heading

				Assert.assertTrue(spci.getNotifyHeading().getText().contains("This"));

				System.out.println("Notification Text :" + spci.getNotifyHeading().getText());

				spci.getNotifyEmail().sendKeys("demo@g.com");

				spci.getNotifyPhone().sendKeys("9811223344");

				js.executeScript("arguments[0].click();", spci.getNotifyMe());

				// spci.getNotifyMe().click();

				Assert.assertTrue(spci.descriptionForSelectedProduct().getText()
						.equals(spci.descriptionForSelectedProduct().getText()));

				System.out.println(spci.descriptionForSelectedProduct().getText());

			}

		}

	}

	public static WebElement xpathClovia2(WebDriver xdriver, String i)

	{

		return driver.findElement(By.xpath("//ul[@id='id_all_list']/li[" + i + "]"));

	}

	public static String createXpath(String xpathExp, Object... args) {

		for (int i = 0; i < args.length; i++) {

			xpathExp = xpathExp.replace("{" + i + "}", (CharSequence) args[i]);

		}

		return xpathExp;
	}

	public static WebElement xpathClovia(WebDriver xdriver, String Xpath)

	{

		return driver.findElement(By.xpath(Xpath));

	}

	/*
	 * public static String listValue(String i) {
	 * 
	 * Scanner s = new Scanner(System.in);
	 * 
	 * i=s.nextLine();
	 * 
	 * s.close();
	 * 
	 * return i;
	 * 
	 * 
	 * }
	 */

	// public static By prod = By.xpath(createXpath("ul[@id='id_all_list']/li[{0}]",
	// "12"));

}

//ul[@id='id_all_list']/li[]

/*
 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
 * "//span[@class='prdCount']")));
 * 
 * WebElement
 * prodCount=driver.findElement(By.xpath("//span[@class='prdCount']"));
 * 
 * System.out.println(prodCount.getText());
 */

//WebElement e = driver.findElement(By.xpath("//ul[@id='id_all_list']/li[" + i
// + "]"));

// JavascriptExecutor js = (JavascriptExecutor) driver;

// js.executeScript("arguments[0].scrollIntoView();", e);

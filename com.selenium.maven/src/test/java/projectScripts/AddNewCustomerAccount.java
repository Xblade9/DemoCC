package projectScripts;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.ExcelUtility;
import utility.ScreenshortUtility;

public class AddNewCustomerAccount {

	public WebDriver driver;

	public String URL = "http://www.demo.guru99.com/V4/index.php";

	public WebDriverWait wait;

	@BeforeMethod(description = "Open the Appn")

	public void open()

	{

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		driver.get(URL);

	}

	@Test(description = "Adding the New customer", priority = 0, dataProvider = "DPNC")

	public void addCustomer(String cName, String aDD, String cIty, String sTate, String pIn, String mobileNo,
			String eMail, String pWord)

	{

		try {

			WebElement w;

			w = driver.findElement(By.cssSelector("input[type='text']"));

			w.sendKeys("mngr242181"); // mngr294381

			w = driver.findElement(By.cssSelector("input[type='password']"));

			w.sendKeys("Demo@123"); // mepurAb

			w = driver.findElement(By.cssSelector("input[type='submit']")); // submit

			w.click();

			Assert.assertTrue(driver.getTitle().contains("Guru"), "~Failed to get the Page Title ~");

			System.out.println("Page Title : " + driver.getTitle());

			w = driver.findElement(By.xpath("//td[text()='Manger Id : mngr239514']"));

			Assert.assertTrue(w.getText().contains("Manger"), "~Failed~");

			System.out.println("Manager id : " + w.getText());

			w = driver.findElement(By.cssSelector("div >div >ul>li:nth-child(2) >a"));

			w.click();

			wait = new WebDriverWait(driver, 10);

			w = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Add New Customer']")));

			Assert.assertTrue(w.getText().contains("Add"));

			System.out.println("Page Text : " + w.getText());

			wait = new WebDriverWait(driver, 10);

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='name']")));

			w = driver.findElement(By.cssSelector("input[name='name']"));

			w.sendKeys(cName);

			w = driver.findElement(By.cssSelector("input[value='f']"));

			w.click();

			// span[class^='k'] >span >span >span >span:nth-child(1)

			// span[class^='k'] >span >span >span.k-link-date >span

			w = driver.findElement(By.id("dob"));

			w.sendKeys("04112013");

			w = driver.findElement(By.cssSelector("textarea[name='addr']"));

			w.sendKeys(aDD);

			w = driver.findElement(By.cssSelector("input[name='city']"));

			w.sendKeys(cIty);

			w = driver.findElement(By.cssSelector("input[name='state']"));

			w.sendKeys(sTate);

			w = driver.findElement(By.cssSelector("input[name='pinno']"));

			w.sendKeys(pIn);

			w = driver.findElement(By.cssSelector("input[name='telephoneno']"));

			w.sendKeys(mobileNo);

			w = driver.findElement(By.cssSelector("input[name='emailid']"));

			w.sendKeys(eMail);

			w = driver.findElement(By.cssSelector("input[name='password']"));

			w.sendKeys(pWord);

			w = driver.findElement(By.cssSelector("input[type='submit']"));

			w.click();

			wait = new WebDriverWait(driver, 10);

			w = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//p[text()='Customer Registered Successfully!!!']")));

			// Assert.assertTrue(driver.findElement(By.xpath("//p[text()='Customer
			// Registered Successfully!!!']")).getText().contains("Customer"),"~Failed to
			// get the Text~");

			Assert.assertTrue(w.getText().contains("Customer"));

			System.out.println("Page Text : " + w.getText());

			ScreenshortUtility.takeScreenshortUtility(driver, "addedCustomer3");

		}

		catch (Exception e)

		{

			// System.out.println(e.getMessage());

			e.printStackTrace();
		}

	}

	@DataProvider(name = "DPNC")

	public Object[][] dataProviderForNewCustomer(Method m)

	{

		ExcelUtility.excelSheetPath("F:\\MyBench\\com.selenium.maven\\TestData\\G9.xlsx");

		int rowCount = ExcelUtility.getRowCount("NewCustomer");

		int colCount = ExcelUtility.getColCount("NewCustomer");

		Object[][] obj = new Object[rowCount - 1][colCount];

		if (m.getName().equalsIgnoreCase("addCustomer")) {

			for (int i = 1; i < rowCount; i++)

			{

				for (int j = 0; j < colCount; j++)

				{

					obj[i - 1][j] = ExcelUtility.getCellData("NewCustomer", i, j);

				}

			}

		}

		return obj;

	}

	@AfterMethod(enabled = true)

	public void close() {

		try {

			Thread.sleep(5000);

			driver.quit();

		}

		catch (Exception e)

		{

			e.printStackTrace();

		}

	}

}

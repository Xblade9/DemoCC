package Configuration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.ConfigReader;

public class SeleniumPFile {

	WebDriver driver;
	
	@Test

	public void testConfig() throws Exception {

		// without library or utility ,, u have to hard code the code everytime , which
		// is not handy and good practice to have

		/*
		 * File src = new File("./Configuration/Config.property");
		 * 
		 * FileInputStream fis = new FileInputStream(src);
		 * 
		 * Properties pro = new Properties();
		 * 
		 * pro.load(fis);
		 * 
		 * System.out.println("Chrome path is :=====" + pro.getProperty("ChromePath"));
		 */

		// with

		// System.setProperty("webdriver.chrome.driver", ConfigReader.getChromePath());

		// WebDriver driver = new ChromeDriver();

		// driver.get(ConfigReader.getUrl());

		ConfigReader config = new ConfigReader();

		WebDriverManager.chromedriver().setup();

		 driver = new ChromeDriver();

		driver.get(config.getUrl());

		driver.quit();

	}

}

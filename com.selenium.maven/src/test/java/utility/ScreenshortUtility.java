package utility;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshortUtility {

	// public static WebDriver driver;

	public static String takeScreenshortUtility(WebDriver driver, String screenshortName) {
		try {

			TakesScreenshot ts = (TakesScreenshot) driver; // typecasting

			File src = ts.getScreenshotAs(OutputType.FILE);

			// FileUtils.copyFile(src, new File("./EcomScreenShorts/" + screenshortName +
			// ".png"));

			String dest = "./EcomScreenShorts/" + screenshortName + ".png";

			File destination = new File(dest);

			FileUtils.copyFile(src, destination);

			System.out.println("Screenshort Taken Successfully");

			return dest;

		}

		catch (Exception e) {

			System.out.println(e.getMessage());

			return e.getMessage();

		}

	}

}

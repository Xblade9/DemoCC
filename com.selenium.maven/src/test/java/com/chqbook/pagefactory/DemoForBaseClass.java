package com.chqbook.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.chqbook.methods.Dataprovider;
import com.chqbook.methods.HomePageMethod;
import com.chqbook.objects.BaseClass;

public class DemoForBaseClass extends BaseClass {

	public WebDriver driver;

	public WebDriverWait wait;

	@Test(dataProvider = "ChqBookMobileField", dataProviderClass = Dataprovider.class)
	public void verifyGetAppFieldAndCategories(String mob) {

		try {

			HomePageMethod hpm = PageFactory.initElements(driver, HomePageMethod.class);

			hpm.verifyMobileFieldAndCategories(mob);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

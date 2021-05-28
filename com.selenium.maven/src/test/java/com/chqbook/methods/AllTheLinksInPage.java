package com.chqbook.methods;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AllTheLinksInPage {

	WebDriver driver;

	WebDriverWait wait;

	WebElement ele;

	public AllTheLinksInPage(WebDriver driver) {

		this.driver = driver;
	}

	public void getAllTheLinks() {

		try {
			
			//comment is added

			List<WebElement> links = driver.findElements(By.tagName("a"));

			for (WebElement link : links) {

				System.out.println("Link is  : " + link.getText() + "-" + link.getAttribute("href"));

				String url = link.getAttribute("href");

				verifyLinks(url);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void verifyLinks(String linkUrl) {
		try {
			URL url = new URL(linkUrl);

			// Now we will be creating url connection and getting the response code
			HttpURLConnection httpURLConnect = (HttpURLConnection) url.openConnection();
			httpURLConnect.setConnectTimeout(5000);
			httpURLConnect.connect();
			if (httpURLConnect.getResponseCode() >= 400) {
				System.out.println(linkUrl + " - " + httpURLConnect.getResponseMessage() + "is a broken link");
			}

			// Fetching and Printing the response code obtained
			else {
				System.out.println(linkUrl + " - " + httpURLConnect.getResponseMessage());
			}
		} catch (Exception e) {
		}
	}

}

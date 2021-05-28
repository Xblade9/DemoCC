package com.chqbook.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//input[@type='text']")
	WebElement enterMobileField;

	public WebElement getEnterMobileNo() {
		return enterMobileField;
	}

	@FindBy(how = How.XPATH, using = "//p[text()='GET APP LINK']")
	WebElement getAppLink;

	public WebElement getClickOnGetAppLink() {
		return getAppLink;
	}

	@FindBy(how = How.XPATH, using = "//p[@class='Text-qpxyhr-0 bIHDbh']")
	WebElement getValidationMsg;

	public WebElement getValidationMsg() {
		return getValidationMsg;
	}

	// start about us and his sub categories

	@FindBy(how = How.XPATH, using = "//a[@class='CustomLink__Internal-sc-1usoa9-0 gUaSDW']")
	WebElement randomCategAboutUsMediaCenterCareers;

	public WebElement getAboutUsCategory() {
		return randomCategAboutUsMediaCenterCareers;
	}

	//components of about us
	
	@FindBy(how = How.XPATH, using = "//div[@class='Component__AboutUsNavWrapper-sc-1lgdpv7-8 gbKWtA']/div")
	WebElement aboutUsComponent;

	public WebElement getAboutUsComponent() {
		return aboutUsComponent;
	}

	@FindBy(how = How.XPATH, using = "//div[@class='Component__MissionContainer-sc-1lgdpv7-10 gPEKhV']")
	WebElement aboutUsText;

	public WebElement getAboutUsText() {
		return aboutUsText;
	}

	@FindBy(how = How.XPATH, using = "//h1[text()='Founding Team']")
	WebElement foundingTeam;

	public WebElement getFoundingTeamText() {
		return foundingTeam;
	}

	@FindBy(how = How.XPATH, using = "//h1[text()='Awards and Recognition']")
	WebElement awardRecognition;

	public WebElement getAwardRecognitionText() {
		return awardRecognition;
	}

	@FindBy(how = How.XPATH, using = "//p[contains(text(),'Aavishkaar Capital, a part of the Aavishkaar Group')]")
	WebElement ourInvestor;

	public WebElement getOurInvestorText() {
		return ourInvestor;
	}

	// End of about us and his sub categories
	
	//mediacenter

	@FindBy(how = How.XPATH, using = "//a[text()='Media Center']")
	WebElement mediaCenter;

	public WebElement getMediaCenterCategory() {
		return mediaCenter;
	}
	
	
	@FindBy(how = How.XPATH, using = "//div[@class='Component__MediaCardWrapper-sc-1wvjeoc-2 lgrvZs']//button")
	WebElement diffMediaBtns;

	public WebElement getMediaCenterDifferentBtns() {
		return diffMediaBtns;
	}
	
	@FindBy(how = How.XPATH, using = "//h1[@class='Heading-sc-12r8tup-0 bPLlsf']")
	WebElement diffMediaBtnsSelectedText;

	public WebElement getMediaCenterDifferentBtnsSelectedText() {
		return diffMediaBtnsSelectedText;
	}
	

	//careers
	
	@FindBy(how = How.XPATH, using = "//a[text()='Careers']")
	WebElement careers;

	public WebElement getCareersCategory() {
		return careers;
	}
	
	
	@FindBy(how = How.XPATH, using = "//p[@class='Text-qpxyhr-0 cPgvOg']")
	WebElement careersText;

	public WebElement getCareersCategoryTextShownInPage() {
		return careersText;
	}
	
	
	@FindBy(how = How.XPATH, using = "//span[text()='EXPLORE OPPORTUNITIES']")
	WebElement exploreOpportunity;

	public WebElement getExploreOpportunityBtn() {
		return exploreOpportunity;
	}
	
	
	@FindBy(how = How.XPATH, using = "//a[@class='js-show-openings btn btn-primary btn-main']")
	WebElement viewOpenings;

	public WebElement getViewOpenings() {
		return viewOpenings;
	}
	
	
	
	@FindBy(how = How.XPATH, using = "//button[@onclick='moeRemoveBanner()']")
	WebElement popup;

	public WebElement getPopUp() {
		return popup;
	}
	
	
	//all the links
	
	@FindBy(how = How.TAG_NAME,using = "a")
	WebElement allLinks;
	
	public WebElement getAllLinks() {
		return allLinks;
	}
	
	
	
	
	
	

}

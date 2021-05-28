package com.chqbook.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class OurProducts {

	WebDriver driver;

	public OurProducts(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//a[text()='Our Products']")
	WebElement ourProductsCategory;

	public WebElement getOurProductsCategory() {
		return ourProductsCategory;
	}

	@FindBy(how = How.XPATH, using = "(//div/p[@class='Text-qpxyhr-0 kERnwX'])[4]")
	WebElement creditCardsClick;

	public WebElement getCreditCardsClick() {
		return creditCardsClick;
	}

	@FindBy(how = How.XPATH, using = "//button[@onclick='moeRemoveBanner()']")
	WebElement popup;

	public WebElement getPopUp() {
		return popup;
	}

	// apply now btn

	@FindBy(how = How.XPATH, using = "//span[text()='APPLY NOW']")
	WebElement applyNowBtn;

	public WebElement getApplyNowButton() {
		return applyNowBtn;
	}

	@FindBy(how = How.XPATH, using = "(//flt-offset[contains(@style,'translate')])[4]/flt-clip")
	WebElement categories;

	public WebElement getAllCategories() {
		return categories;
	}

	@FindBy(how = How.XPATH, using = "(//flt-offset[contains(@style,'translate')])[11]/flt-clip")
	WebElement sortedBy;

	public WebElement getSortedByCategory() {
		return sortedBy;
	}

	@FindBy(how = How.XPATH, using = "(//flt-offset[contains(@style,'translate')])[15]/flt-clip")
	WebElement afterSortedBy;

	public WebElement getAllCardsVisible() {
		return afterSortedBy;
	}

	@FindBy(how = How.XPATH, using = "(//flt-offset[contains(@style,'translate')])[11]/flt-clip/flt-clip-interior/flt-offset/flt-picture/flt-canvas/canvas")
	WebElement bestSelling;

	public WebElement getClickOnBestSelling() {
		return bestSelling;
	}

	@FindBy(how = How.XPATH, using = "//flt-clip[@clip-type='rect']//flt-clip-interior/flt-picture/flt-canvas/p[8]")
	WebElement textOfSelectedCard;

	public WebElement getTextOfRandomlySelectedCreditCard() {
		return textOfSelectedCard;
	}

	// view all

	@FindBy(how = How.XPATH, using = "(//flt-picture[@style='position: absolute; transform: translate(0px, 0px);'])[11]//flt-canvas/p[text()='View all']")
	WebElement viewAll;

	public WebElement getViewAllCursorButton() {
		return viewAll;
	}

	// credit card available text

	@FindBy(how = How.XPATH, using = "//flt-picture[@style='position: absolute; transform: translate(0px, 0px);']//flt-canvas/p")
	WebElement creditCardAvailText;

	public WebElement getCreditCardAvailText() {
		return creditCardAvailText;
	}

	// CHQBOOK REVIEWS PROS

	@FindBy(how = How.XPATH, using = "((//flt-clip[@clip-type='rect'])[1]//flt-clip-interior/flt-clip/following-sibling::flt-offset/flt-offset/flt-picture/flt-canvas/canvas)[1]")
	WebElement textOfChqBookReviewsPros;

	public WebElement getTextOfChqBookReviewPros() {
		return textOfChqBookReviewsPros;
	}

	// APPLY NOW BUTTON

	@FindBy(how = How.XPATH, using = "//flt-clip[@clip-type='rect']//flt-clip-interior/flt-clip")
	WebElement clickOnApplyBtn;

	public WebElement getClickOnApplyNowButton() {
		return clickOnApplyBtn;
	}

	// First name

	@FindBy(how = How.XPATH, using = "//input[@name='firstname']")
	WebElement firstName;

	public WebElement getFirstNameField() {
		return firstName;
	}

	// middle name

	@FindBy(how = How.XPATH, using = "//input[@name='middlename']")
	WebElement middleName;

	public WebElement getMiddleName() {
		return middleName;
	}

	// last name

	@FindBy(how = How.XPATH, using = "//input[@name='lastname']")
	WebElement lastName;

	public WebElement getLastName() {
		return lastName;
	}

	// mobile

	@FindBy(how = How.XPATH, using = "//input[@name='mobile']")
	WebElement mobileNo;

	public WebElement getMobileNo() {
		return mobileNo;
	}

	// pan

	@FindBy(how = How.XPATH, using = "//input[@name='pancard']")
	WebElement panNo;

	public WebElement getPanNo() {
		return panNo;
	}

	// checkbox

	@FindBy(how = How.XPATH, using = "//input[@type='checkbox']")
	WebElement checkbox;

	public WebElement getCheckBox() {
		return checkbox;
	}

	// next button

	@FindBy(how = How.XPATH, using = "//button[@tabindex='0']") // button[@tabindex='0'] //button[@type='submit']
	WebElement submitBtn;

	public WebElement getSubmitBtn() {
		return submitBtn;
	}

	/*
	 * FOR LOANS MODULE
	 */

	@FindBy(how = How.XPATH, using = "(//div/p[@class='Text-qpxyhr-0 kERnwX'])[3]")
	WebElement loans;

	public WebElement getLoans() {
		return loans;
	}

	// business loan category

	@FindBy(how = How.XPATH, using = "(//flt-offset[contains(@style,'translate')])[5]/flt-clip")
	WebElement loansCategory;

	public WebElement getLoansCategory() {
		return loansCategory;
	}

	// business loan apply

	@FindBy(how = How.XPATH, using = "((//flt-offset[contains(@style,'translate')])[5]/flt-clip/flt-clip-interior/flt-offset/flt-picture/flt-canvas/p)[2]")
	WebElement businessLoan;

	public WebElement getBusinessLoanApply() {
		return businessLoan;
	}

	// loans available for self employed section

	@FindBy(how = How.XPATH, using = "//flt-clip[@clip-type='rect']")
	WebElement selfEmpSection;

	public WebElement getSelfEmpSection() {
		return selfEmpSection;
	}

	// loantype selected

	@FindBy(how = How.XPATH, using = "//flt-canvas[@style='position: absolute; transform: translate(-1px, 29px);']//p[text()='Details']")
	WebElement loanRandSelect;

	public WebElement getLoanRandSelect() {
		return loanRandSelect;
	}

}

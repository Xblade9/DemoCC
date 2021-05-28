package com.perfeasy.clovia.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SelectingParticularCategoryAndItemObjects {

	WebDriver driver;

	public SelectingParticularCategoryAndItemObjects(WebDriver driver) {
		this.driver = driver;
	}

	
	@FindBy(how = How.TAG_NAME, using = "body")
	WebElement clickBdy;

	public WebElement clickBdy() {

		return clickBdy;
	}
	
	
	
	@FindBy(how = How.XPATH, using = "//h1[@class='countCat ']")
	WebElement subTypeText;

	public WebElement forSubTypeText() {
		return subTypeText;
	}

	@FindBy(how = How.XPATH, using = "//section[@class='rowMisc']")
	WebElement selectedProdText;

	public WebElement selectedProdTypeText() {
		return selectedProdText;
	}

	@FindBy(how = How.XPATH, using = "(//li[@class='subMenuContent pull-left'])[4]")
	WebElement selectAllLinks;

	public WebElement selectAnyLinkFromCategory() {
		return selectAllLinks;
	}

	@FindBy(how = How.XPATH, using = "//section[@class='productList']")
	WebElement selectAllProducts;

	public WebElement selectAnyLinkFromProducts() {
		return selectAllProducts;
	}

	@FindBy(how = How.CLASS_NAME, using = "firstimage")
	WebElement selectByClassProd;

	public WebElement getSelectByClassProd() {
		return selectByClassProd;
	}

	@FindBy(how = How.XPATH, using = "//div[@class='prdetail']")
	WebElement description;

	public WebElement descriptionForSelectedProduct() {
		return description;
	}

	@FindBy(how = How.ID, using = "selectSize1")
	WebElement sizeType;

	public WebElement getSizeType() {

		return sizeType;

	}

	@FindBy(how = How.CLASS_NAME, using = "size_li notAvailable")
	WebElement sizeNotAvailable;

	public WebElement getSizeNotAvailable() {

		return sizeNotAvailable;

	}

	/*
	 * @FindBy(how = How.XPATH, using = "//ul[@id='selectSize1']/li[1]") WebElement
	 * sizeTypeS;
	 * 
	 * public WebElement getSizeTypeS() {
	 * 
	 * return sizeTypeS;
	 * 
	 * }
	 * 
	 * @FindBy(how = How.XPATH, using = "//ul[@id='selectSize1']/li[2]") WebElement
	 * sizeTypeM;
	 * 
	 * public WebElement getSizeTypeM() {
	 * 
	 * return sizeTypeM;
	 * 
	 * }
	 * 
	 * @FindBy(how = How.XPATH, using = "//ul[@id='selectSize1']/li[3]") WebElement
	 * sizeTypeL;
	 * 
	 * public WebElement getSizeTypeL() {
	 * 
	 * return sizeTypeL;
	 * 
	 * }
	 */

	@FindBy(how = How.XPATH, using = "//span[@class='last']")
	WebElement sizeChart;

	public WebElement getSizeChart() {

		return sizeChart;

	}

	@FindBy(how = How.XPATH, using = "//button[@class='close']")
	WebElement closeSizeChart;

	public WebElement getCloseSizeChart() {

		return closeSizeChart;

	}

	@FindBy(how = How.NAME, using = "pincode")
	WebElement pincode;

	public WebElement getPincode() {

		return pincode;

	}

	@FindBy(how = How.XPATH, using = "//button[text()='Check']")
	WebElement checkBtn;

	public WebElement getCheckBtn() {

		return checkBtn;

	}

	@FindBy(how = How.ID, using = "new_add_to_bag_button")
	WebElement addToCart;

	public WebElement getAddToCartBtn() {

		return addToCart;

	}

	@FindBy(how = How.XPATH, using = "//p[@class='wDays']")
	WebElement standardDeliveryText;

	public WebElement getStandardDelText() {

		return standardDeliveryText;

	}

	@FindBy(how = How.XPATH, using = "//div[@Class='tbs']")
	WebElement productFeature;

	public WebElement getproductFeature() {

		return productFeature;

	}

	@FindBy(how = How.XPATH, using = "//p[@class='lineText']/p")
	WebElement productFeatureTxt;

	public WebElement getproductFeatureTxt() {

		return productFeatureTxt;

	}

	@FindBy(how = How.XPATH, using = "//span[@class='notifyHeading']")
	WebElement notifyHeading;

	public WebElement getNotifyHeading() {

		return notifyHeading;

	}

	@FindBy(how = How.XPATH, using = "//input[@class='notifyEmail']")
	WebElement notifyEmail;

	public WebElement getNotifyEmail() {

		return notifyEmail;

	}

	@FindBy(how = How.XPATH, using = "//input[@class='notifyPhone']")
	WebElement notifyPhone;

	public WebElement getNotifyPhone() {

		return notifyPhone;

	}

	@FindBy(how = How.ID, using = "soldout_btn")
	WebElement notifyMe;

	public WebElement getNotifyMe() {

		return notifyMe;

	}

	@FindBy(how = How.XPATH, using = "//span[@class='qtyIcon Plus']")
	WebElement qtyPlusBtn;

	public WebElement getQtyPlusBtn() {

		return qtyPlusBtn;

	}

	@FindBy(how = How.XPATH, using = "//span[@class='CartIcon fa fa-shopping-cart']")
	WebElement shoppingCartBtn;

	public WebElement getShoppingCartBtn() {

		return shoppingCartBtn;

	}
	
	
	@FindBy(how = How.XPATH, using = "//div[@class='cartrg']/a")
	WebElement proceedToCheckOut;

	public WebElement getProceedToCheckOut() {

		return proceedToCheckOut;

	}
	
	
	@FindBy(how = How.ID, using = "login-email")
	WebElement emailAtLoginRegisterBuy;

	public WebElement getEmailAtBuy() {

		return emailAtLoginRegisterBuy;

	}
	
	
	

	@FindBy(how = How.ID, using = "password")
	WebElement passAtLoginRegisterBuy;

	public WebElement getPassAtBuy() {

		return passAtLoginRegisterBuy;

	}
	
	
	@FindBy(how = How.ID, using = "login-submit")
	WebElement loginBtnAtBuy;

	public WebElement getLoginBtnAtBuy() {

		return loginBtnAtBuy;

	}
	
	
	@FindBy(how = How.XPATH, using = "//select[@id='id_ship_addr_type']")
	WebElement selectAddressType;

	public WebElement getSelectAddressType() {

		return selectAddressType;

	}
	
	
	@FindBy(how = How.CLASS_NAME, using = "savecontinue")
	WebElement saveBtnAtShoppingAddress;

	public WebElement getSaveBtnAtShoppingAddress() {

		return saveBtnAtShoppingAddress;

	}
	
	
	
	@FindBy(how = How.XPATH, using = "//div[@class='cartrg']/a")
	WebElement selectRandomValueInDrpDown;

	public WebElement getSelectRandomValueInDrpDown() {

		return selectRandomValueInDrpDown;

	}
	
	
	@FindBy(how = How.XPATH, using = "//button[@id='continue_ship']")
	WebElement continueToPayment;

	public WebElement getContinueToPayment() {

		return continueToPayment;

	}
	
	//shipadress
	
	@FindBy(how = How.ID, using = "fname")
	WebElement nameFieldShipAddress;

	public WebElement getNameFieldShipAddress() {

		return nameFieldShipAddress;

	}
	
	@FindBy(how = How.ID, using = "id_mobile")
	WebElement mobFieldShipAddress;

	public WebElement getMobFieldShipAddress() {

		return mobFieldShipAddress;

	}
	
	
	@FindBy(how = How.ID, using = "id_mobile_alt")
	WebElement altmobFieldShipAddress;

	public WebElement getAltMobFieldShipAddress() {

		return altmobFieldShipAddress;

	}
	
	
	@FindBy(how = How.ID, using = "id_ship_address")
	WebElement addFieldShipAddress;

	public WebElement getAddFieldShipAddress() {

		return addFieldShipAddress;

	}
	
	
	@FindBy(how = How.ID, using = "id_ship_landmark")
	WebElement landmarkFieldShipAddress;

	public WebElement getLandmarkFieldShipAddress() {

		return landmarkFieldShipAddress;

	}
	
	
	@FindBy(how = How.ID, using = "id_ship_postal_code")
	WebElement zipCodeFieldShipAddress;

	public WebElement getZipCodeFieldShipAddress() {

		return zipCodeFieldShipAddress;

	}
	
	
	
	
	//pannelforshipaddress
	
	
	@FindBy(how = How.XPATH, using = "//div[@id='2']")
	WebElement pannelForShipAddress;

	public WebElement getPannelForShipAddress() {

		return pannelForShipAddress;

	}
	
	
	@FindBy(how = How.ID, using = "addressbox_1928505")
	WebElement cardShipAddress;

	public WebElement getCardShipAddress() {

		return cardShipAddress;

	}
	
	
	@FindBy(how = How.XPATH, using = "//button[@class='loginsubmt loginsubmt2  svecont']")
	WebElement addNewAddress;

	public WebElement getNewAddress() {

		return addNewAddress;

	}
	
	
	@FindBy(how = How.ID, using = "edit-2")
	WebElement editBtnShipAddress;

	public WebElement getEditBtnShipAddress() {

		return editBtnShipAddress;

	}
	
	
	@FindBy(how = How.ID, using = "openpopup1")
	WebElement delBtnCard;

	public WebElement getDelBtnCard() {

		return delBtnCard;

	}
	
	
	@FindBy(how = How.XPATH, using = "//span[@class='yesBtn']")
	WebElement popover;

	public WebElement getPopOver() {

		return popover;

	}
	
	
	@FindBy(how = How.XPATH, using = "//ul[@class='forMain']")
	WebElement shipRadioBtnAll;

	public WebElement getAllShippingAddressRadioBtn() {

		return popover;

	}
	
	
	@FindBy(how = How.XPATH, using = "//ul[@class='forMain']//span[@class='selected']")
	WebElement shipRadioBtnForParticularAdd;

	public WebElement getParticularShipAddressRadioBtn() {

		return shipRadioBtnForParticularAdd;

	}
	
	
	@FindBy(how = How.XPATH, using = "//span[@class='edit1']")
	WebElement selectedShipAddText;

	public WebElement getSelectedShipAddText() {

		return selectedShipAddText;

	}
	
	
	@FindBy(how = How.ID, using = "id_type")
	WebElement selectAddressTypeCreateNew;

	public WebElement getAddressOfCreateNewValueOfDrpDown() {

		return selectAddressTypeCreateNew;

	}
	
	@FindBy(how = How.XPATH, using = "//li[contains(@class,'shippingco   activeshipp')]")
	WebElement displayAddressTextFromCard;

	public WebElement getDisplayAddressTextFromCard() {

		return displayAddressTextFromCard;

	}
	
}



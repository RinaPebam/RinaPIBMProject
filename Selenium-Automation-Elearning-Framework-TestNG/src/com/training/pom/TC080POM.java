package com.training.pom;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class TC080POM {

	private WebDriver driver; 
	
	public TC080POM(WebDriver driver) {
		this.setDriver(driver); 
		PageFactory.initElements(driver, this);
	}
		
	
	private void setDriver(WebDriver driver2) {
	
	}


	@FindBy (xpath = "//a[@href='http://uniform.upskills.in/']//img[@class='img-responsive']")
	public WebElement shopUniformBtn;
	
	@FindBy (xpath = "//img[@title='SPORTS T-SHIRTS']")
	public WebElement sportTShirtBtn;
	
	@FindBy (xpath="//select[@id='input-option370']")
	public WebElement chestSizeDD;
	
	@FindBy (id="button-cart")
	public WebElement addToCartBtn;
	
		
	@FindBy (xpath="//button[contains(text(),'1 item(s) - ₹0')]")
	public WebElement addToCartIcon;
	
	@FindBy(xpath="//strong[contains(text(),'View Cart')]")
	public WebElement viewCartBtn;
	
	@FindBy(xpath="//a[contains(text(),'Checkout')]")
	public WebElement checkOutBtn;
	
	@FindBy (xpath="//input[@id=\"input-email\"]")
	public WebElement emailID;
	
	
	@FindBy (xpath="//input[@id=\"input-password\"]")
	public WebElement password;
	
	
	@FindBy (xpath = "//input[@id=\"button-login\"]")
	public WebElement loginBtn;
	
	@FindBy(xpath = "//input[@id=\"button-payment-address\"]")
	public WebElement paymentPageContinueBtn;
	
	@FindBy (xpath="//input[@id=\"button-shipping-address\"]")
	public WebElement shippingPageContinueBtn;
	
	@FindBy (xpath="//div[@class='panel-collapse collapse in']//textarea[@name='comment']")
	public WebElement commentArea;
	
	@FindBy(xpath="//input[@id=\"button-shipping-method\"]")
	public WebElement shippingMethodPageContinueBtn;
	
	
	@FindBy(xpath="//input[@type=\"checkbox\" and @name=\"agree\"]")
	public WebElement iAgreeChkBx;
	
	@FindBy(xpath="//input[@id=\"button-payment-method\"]")
	public WebElement paymentMethodPageContinuebtn;
	
	
	@FindBy(xpath="//input[@id=\"button-confirm\"]")
	public WebElement confirmBtn;
	
	@FindBy (xpath="//a[@class='btn btn-primary']")
	public WebElement orderSuccessPageConfirmBtn;
	
	@FindBy (xpath="//*[@id=\"top\"]/header/div")
	public WebElement wb;
	
	
	
	public void clickshopUniformBtn()
	{
		this.shopUniformBtn.click();
	}
	
	
	
	public void clickSportsTShirtBtn()
	{
		this.sportTShirtBtn.click();
	}
	
	
	/*public void clickchestSizeDD()
	{
		this.chestSizeDD.click();
		//return new Select(chestSizeDD).getOptions();
	}*/
	
	
	public void clickChestSizeDD () {
		  Select chest = new Select(chestSizeDD);
		  chest.selectByVisibleText("42");  	
				 
	}
	
	
	public void clickaddToCartBtn()
	{
		this.addToCartBtn.click();
	}
	
	public void clickaddToCartIcon()
	{
		this.addToCartIcon.click();
	}
	
	
	public void clickviewCartBtn()
	{
		this.viewCartBtn.click();
	}
	
	
	public void clickcheckOutBtn()
	{
		this.checkOutBtn.click();
	}
	
			
	public void enterEmailID(String ch1)
	{
		this.emailID.sendKeys(ch1);
	}
	
	public void enterPassword(String ch2)
	{
		this.password.sendKeys(ch2);
	}
			
	public void clickLoginBtn()
	{
		this.loginBtn.click();
	}
	
	
	public void clickBillingDetailsPageContinueBtn()
	{
		this.paymentPageContinueBtn.click();
	}
	
	public void clickDeliveryDetailsPageContinueBtn()
	{
		this.shippingPageContinueBtn.click();
	}
	
	
	public void enterComment(String ch3)
	{
		this.commentArea.sendKeys(ch3);
	}
	
	
	public void clickDeliveryMethodPageContinueBtn()
	{
		this.shippingMethodPageContinueBtn.click();
	}
	
	public void checkIAgreeChkBx()
	{
		this.iAgreeChkBx.click();
	}
	
	
	public void clickPaymentMethodPageContinuebtn()
	{
		this.paymentMethodPageContinuebtn.click();
	}
	
	public void clickConfirmBtn()
	{
		this.confirmBtn.click();
	}
	
	public void clickOrderSuccessPageConfirmBtn()
	{
		this.orderSuccessPageConfirmBtn.click();
	}


	public void openNewTab()
	{
		this.wb.sendKeys(Keys.chord(Keys.CONTROL,"C"));
	}
	
	
	
}

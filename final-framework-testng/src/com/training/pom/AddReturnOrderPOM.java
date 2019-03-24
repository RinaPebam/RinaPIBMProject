package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddReturnOrderPOM {
	private WebDriver driver; 
	
	public AddReturnOrderPOM(WebDriver driver) {
		this.setDriver(driver); 
		PageFactory.initElements(driver, this);
	}
		
	@FindBy(id="sale")
	public WebElement sale;
	

	@FindBy(xpath ="//li[@id='sale']/ul/li[3]")
	public WebElement returnorder;
	
	@FindBy (xpath = "//i[@class='fa fa-plus']")
	WebElement plusSign;
	
	@FindBy (xpath = "//input[@id='input-order-id']")
	WebElement orderID;
	
	@FindBy (xpath = "//input[@placeholder='Customer']")
	WebElement customerName;
	
	
	@FindBy (xpath = "//input[@id='input-firstname']")
	WebElement firstName;
	
	@FindBy (xpath = "//input[@id='input-lastname']")
	WebElement lastName;
	
	
	@FindBy (xpath = "//input[@id='input-email']")
	WebElement emailID;
	
	
	@FindBy (xpath = "//input[@id='input-telephone']")
	WebElement phoneNumber;
	
	@FindBy (xpath = "//input[@placeholder='Product']")
	WebElement product;
	
	@FindBy (xpath = "//input[@id='input-model']")
	WebElement model;
	
	
	@FindBy (xpath = "//button[@type='submit']")
	WebElement saveBtn;
	
	
	//@FindBy (xpath = "//table/tbody/tr[1[]/td")
	@FindBy (xpath = "//div[@class='table-responsive']/table/tbody/tr[1]/td")
	WebElement firstCheckBox;
	
	
	@FindBy (xpath = "//i[@class='fa fa-trash-o']")
	WebElement deleteBtn;
	
	
	public void clickSale () 
	{
		this.sale.click();
	}
	
	public void clickOrder() 
	{
		this.returnorder.click();
	}
	
	public void clickPlusSign()
	{
		this.plusSign.click();
	}
	

	public void enterOrderID(String ch1)
	{
		this.orderID.sendKeys(ch1);
	}
	
	
	public void enterCustomerName(String ch2)
	{
		this.customerName.sendKeys(ch2);
	}
	
	public void enterFirstName(String ch3)
	{
		this.firstName.sendKeys(ch3);
	}
	
	public void enterLastName(String ch4)
	{
		this.lastName.sendKeys(ch4);
	}
	
	public void enterEmailID(String ch5)
	{
		this.emailID.sendKeys(ch5);
	}
	
	public void enterPhoneNumber(String ch6)
	{
		this.phoneNumber.sendKeys(ch6);
	}
	
	public void enterProduct(String ch7)
	{
		this.product.sendKeys(ch7);
	}
	
	public void enterModel(String ch8)
	{
		this.model.sendKeys(ch8);
	}
	
	
	public void clickSaveBtn()
	{
		this.saveBtn.click();
	}
	
	public void selectReturnOrder()
	{
		this.firstCheckBox.click();
	}

	
	public void clickDeleteBtn()
	{
		this.deleteBtn.click();
	}
	
	
	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}


	
}

	
package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditCustomerDetailsAddRewardPointsPOM {
	private WebDriver driver; 
	
	public EditCustomerDetailsAddRewardPointsPOM(WebDriver driver) {
		this.setDriver(driver); 
		PageFactory.initElements(driver, this);
	}
		
	
	@FindBy(xpath = "//li[@id='customer']//a[@class='parent']")
	public WebElement customer;

	@FindBy(xpath ="//li[@id='customer']/ul/li[1]")
	public WebElement customers1;
	
	@FindBy(xpath = "//table[@class='table table-bordered table-hover']/tbody/tr[1]/td")
	public WebElement checkbox;
	
	@FindBy (xpath = "//*[@id='form-customer']/div/table/tbody/tr[1]/td[8]/a/i")
	public WebElement editBtn;
	
		
	@FindBy (xpath="//*[@id=\"input-firstname\"]")
	public WebElement firstName;
	
	@FindBy (xpath="//*[@id=\"input-lastname\"]")
	public WebElement lastName;
	
	@FindBy (xpath="//a[contains(text(),'Address 1')]")
	public WebElement Address1;
	
	@FindBy (xpath = "//*[@id=\"input-postcode1\"]")
	WebElement postCode;
	
	
	@FindBy (xpath = "//a[@href='#tab-reward']")
	WebElement rewardPoints;
	
	
	@FindBy (xpath = "//input[@id='input-reward-description']")
	WebElement description;
	
	@FindBy (xpath="//input[@id='input-points']")
	WebElement points;
	
	
	@FindBy (xpath = "//button[@id='button-reward']")
	WebElement AddRewardBtn;
	
	@FindBy (xpath = "//button[@type='submit']")
	WebElement saveBtn;
	
	
	public void clickCustomers() 
	{
		this.customer.click();
	}
	
	public void clickCustomers1() 
	{
		this.customers1.click();
	}
	
	
	public void clickcheckbox()
	{
		this.checkbox.click();
	}
	
	
	public void clickEditBtn()
	{
		this.editBtn.click();
	}
	
	public void enterFirstName(String ch1)
	{
		this.firstName.clear();
		this.firstName.sendKeys(ch1);
	}
	
	public void enterLastName(String ch2)
	{
		this.lastName.clear();
		this.lastName.sendKeys(ch2);
	}
	
	
	public void clickAddress1()
	{
		this.Address1.click();
	}
	
	public void enterPostCode(String ch3)
	{
		this.postCode.clear();
		this.postCode.sendKeys(ch3);
		
	}
	
	public void clickRewardPoints()
	{
		this.rewardPoints.click();
	}
	
	
	public void enterDescription(String ch4)
	{
		this.description.clear();
		this.description.sendKeys(ch4);
	}
	
	
	public void enterPoints(String ch5)
	{
		this.points.clear();
		this.points.sendKeys(ch5);
	}
	
	public void clickAddRewardPointsBtn() {
		this.AddRewardBtn.click();
	}
	
	
	public void clickSaveBtn()
	{
		this.saveBtn.click();
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
}




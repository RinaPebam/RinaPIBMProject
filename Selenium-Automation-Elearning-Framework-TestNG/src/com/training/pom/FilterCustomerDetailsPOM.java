package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FilterCustomerDetailsPOM {
	private WebDriver driver; 
	
	public FilterCustomerDetailsPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//li[@id='customer']//a[@class='parent']")
	public WebElement customers;

	@FindBy(xpath ="//li[@id='customer']/ul/li[1]")
	public WebElement customers1;
	
	@FindBy (xpath="//input[@placeholder='Customer Name']")
	WebElement customerName;
	
	@FindBy (xpath = "//input[@id='input-email']")
	WebElement emailID;
	
	@FindBy(xpath = "//button[@id='button-filter']")
	WebElement filterBtn;
	
	public void clickCustomers () 
	{
		this.customers.click();
	}
	
	public void clickCustomers1() 
	{
		this.customers1.click();
	}
	
	public void enterCustomerName(String ch1)
	{
		this.customerName.sendKeys(ch1);
	}

		
	public void enterEmailID(String ch2)
	{
		this.emailID.sendKeys(ch2);
	}
	
	public void clickFilterBtn()
	{
		this.filterBtn.click();
	}
	
	public void clearCustomerNameField()
	{
		this.customerName.clear();
	}
}

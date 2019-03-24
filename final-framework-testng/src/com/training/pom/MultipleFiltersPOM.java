package com.training.pom;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class MultipleFiltersPOM {
	//private static final String element = null;


	private WebDriver driver; 
	
	public MultipleFiltersPOM(WebDriver driver) {
		this.setDriver(driver); 
		PageFactory.initElements(driver, this);
		
		
	}

	
	@FindBy (xpath ="//body/div[@id='container']/nav[@id='column-left']/ul[@id='menu']/li[@id='sale']/a[1]")
	public WebElement sale;
	

	@FindBy (xpath = "//li[@id='sale']/ul/li[1]")
	public WebElement order;
	
	
	@FindBy (xpath = "//input[@placeholder='Order ID']")
	public WebElement orderid;
	
	
	@FindBy (xpath = "//button[contains(text(),'Filter')]")
	public WebElement filterBtn;
	
	
	@FindBy (xpath = "//input[@id='input-date-added']")
	WebElement dateElement;
	
	@FindBy (xpath = "//select[@id='input-order-status']")
	public WebElement orderStatus;
	
	@FindBy (xpath = "//div[@class='row']//div[1]//div[1]//span[1]//button[1]//i[1]")
	public WebElement dateAdded;
	
	@FindBy (xpath = "//input[@placeholder='Customer']")
	public WebElement Customer;
	
	@FindBy (xpath = "//input[@id='input-total']")
	public WebElement total;
	
	@FindBy (xpath = "//div[@class='panel-body']//div[2]//div[1]//span[1]//button[1]")
	public WebElement dateModified;
	
	@FindBy (xpath="//select[@name='filter_order_status']")
	public WebElement status;
	
	
		
	public void clickSale()
	{
		this.sale.click();
	}
	
	
	public void clickOrder()
	{
		this.order.click();
	}
	
	
	public void enterOrderID(String ch1)
	{
		this.orderid.sendKeys(ch1);
	}

	
	public void clickFilterBtn()
	{
		this.filterBtn.click();
	}
	
	
	public void enterCustomerName(String ch2)
	{
		this.Customer.sendKeys(ch2);
	}
	
	public void selectStatus(String ch3)
	{
		@SuppressWarnings("unused")
		
		Select dd = new Select(orderStatus);
		List<WebElement> e = dd.getOptions();
				
		for(WebElement s: e)
		{
			if(s.getText().equalsIgnoreCase(ch3))
			{
				s.click();
			}
		}
		
	}
	
	public void clearFields(WebElement element)
	{
		element.clear();
	}
	
	public void selectDateByJSS(WebDriver driver, WebElement dateElement, String dateValue)
	{
		JavascriptExecutor js = ((JavascriptExecutor) this.driver);
		js.executeScript("arguments[0].setAttribute('value', '"+dateValue+"');", this.dateElement);
	}
	
		
	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

}
	
	

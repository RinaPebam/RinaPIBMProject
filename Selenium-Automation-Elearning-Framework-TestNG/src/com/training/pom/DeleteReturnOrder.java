package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteReturnOrder {
	private WebDriver driver; 
	
	public DeleteReturnOrder(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
		
	@FindBy(id="sale")
	public WebElement sale;
	
	@FindBy(xpath ="//li[@id='sale']/ul/li[1]")
	public WebElement clickorder;
	
	
	@FindBy(xpath="//table/tbody/tr[1]/td[1]")
	public WebElement checkbox;
	
	
	@FindBy(xpath="//div[@class='table-responsive']//tbody//tr[1]//button")
	public WebElement Deletebutton;
	

	
	
	public void clickSale () 
	{
		this.sale.click();
	}
	
	public void clickOrder() 
	{
		this.clickorder.click();
	}
	
	
	public void clickcheckbox()
	{
		this.checkbox.click();
	}
	
	
	public void clickdeletebutton()
	{
		this.Deletebutton.click();
	}
	
	
}

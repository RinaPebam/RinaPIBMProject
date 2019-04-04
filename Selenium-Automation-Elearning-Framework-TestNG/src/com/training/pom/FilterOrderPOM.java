package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FilterOrderPOM {
	private WebDriver driver; 
	
	public FilterOrderPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
		
	
	@FindBy(id="sale")
	public WebElement sale;
	
	@FindBy(xpath ="//li[@id='sale']/ul/li[3]")
	public WebElement clickorder;
	
	
	@FindBy(xpath="//table/tbody/tr[1]/td[1]")
	public WebElement checkbox;
	
	
	@FindBy(xpath="//div[@class='table-responsive']//tbody//tr[1]//button")
	public WebElement EditButton;
	

	@FindBy(id = "input-return-id")
	public WebElement ReturnID;
	
	@FindBy(xpath = "//button[contains(text(),'Filter')]")
	public WebElement FilterBtn;
	
	@FindBy(id="input-customer")
	public WebElement CustomerName;
	
	
	@FindBy (xpath="//div[@class='pull-right']//button[@type='button']")
	public WebElement deleteBtnFltPage;
	
	
	public void clickSale () 
	{
		this.sale.click();
	}
	
	public void clickReturnOrder() 
	{
		this.clickorder.click();
	}
	
	
	public void clickcheckbox()
	{
		this.checkbox.click();
	}
	
	
	public void clickdeletebutton()
	{
		this.EditButton.click();
	}
	
	
	public void enterReturnID(String ch1)
	{
		this.ReturnID.sendKeys(ch1);
	}
	
	
	public void enterCustomerName(String ch2)
	{
		this.CustomerName.sendKeys(ch2);
	}
	
	public void clickFilterBtn()
	{
		this.FilterBtn.click();
	}
	
	public void clearFields()
	{
		this.ReturnID.clear();
	}
	
	public void clickDeleteBtnFltPage()
	{
		this.deleteBtnFltPage.click();
	}
}

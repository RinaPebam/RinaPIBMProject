package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class MovingOrderToCompleteStatusPOM {
	//private WebDriver driver; 
	private WebDriver driver = new ChromeDriver();
		
	public MovingOrderToCompleteStatusPOM(WebDriver driver) {
		this.driver = driver; 
		System.setProperty("chrome.driver.exe","C:\\IBM_Selenium\\driver\\chromedriver.exe");
		
		this.driver.get("http://uniform.upskills.in/admin/");
		this.driver.manage().window().maximize();

	}
		
	@FindBy(id="sale")
	public WebElement sale;
	
	@FindBy(xpath ="//li[@id='sale']/ul/li[1]")
	public WebElement clickorder;
	
	
	@FindBy(xpath="//table/tbody/tr[1]/td[1]")
	public WebElement checkbox;
	
	
	@FindBy (xpath="//tr[1]//td[8]//a[1]")
	public WebElement viewBtn;
	
	
	@FindBy(xpath="//select[@id='input-order-status']")
	public WebElement orderStatus;
	
	@FindBy (xpath="//button[@id='button-history']//i[@class='fa fa-plus-circle']")
	public WebElement addHistoryBtn;

	
	
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
	
	
	public void clickViewBtn()
	{
		this.viewBtn.click();
	}

	public void selectOrderStatus()
	{
		  Select s_dd = new Select(orderStatus);
		  s_dd.selectByVisibleText("Complete");  					 
	}
	
	public void clickAddHistoryBtn()
	{
		this.addHistoryBtn.click();
	}
	
}

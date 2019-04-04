package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LoginToUniformUrlPOM {
	private WebDriver driver; 
	
	public LoginToUniformUrlPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
		
	@FindBy (xpath="//span[@class='caret']")
	public WebElement myAccount;
	
	
	@FindBy (xpath="//a[contains(text(),'Login')]")
	public WebElement loginBtn01;
	
	@FindBy (xpath="//input[@id=\"input-email\"]")
	public WebElement emailID;
	
	
	@FindBy (xpath="//input[@id=\"input-password\"]")
	public WebElement password;
	
	
	@FindBy (xpath = "//input[@id=\"button-login\"]")
	public WebElement loginBtn02;
	
	@FindBy (xpath="//a[contains(text(),'View your order history')]")
	public WebElement viewHistoryLink;
	
	@FindBy (xpath="//tbody//tr[1]//td[4]")
	public WebElement status;
	
	
	public void clickMyAccount()
	{
		this.myAccount.click();
	}
	
	public void clickLoginBtn01()
	{
		this.loginBtn01.click();
	}


	public void enterEmailID(String ch1)
	{
		this.emailID.clear();
		this.emailID.sendKeys(ch1);
	}
	
	public void enterPassword(String ch2)
	{
		this.password.clear();
		this.password.sendKeys(ch2);
	}
			
	public void clickLoginBtn02()
	{
		this.loginBtn02.click();
	}
	
	
	public void clickViewHistoryLink()
	{
		this.viewHistoryLink.click();
	}

	public String getStatus()
	{
		return this.status.getText();
	}
}

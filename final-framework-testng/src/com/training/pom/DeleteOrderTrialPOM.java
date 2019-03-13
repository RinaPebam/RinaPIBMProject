package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class DeleteOrderTrialPOM {
	private WebDriver driver; 
	
	public DeleteOrderTrialPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="sale")
	public WebElement sale;
	
	@FindBy(how=How.XPATH, using ="//li[@id='sale']/ul/li[3]")
	public WebElement returnproduct;
	
	@FindBy(id="input-return-id")
	public WebElement returnId;
	
	@FindBy (how=How.XPATH, using = "//button[contains(text(),'Filter')]")
	public WebElement filterBtn;
	
		

	
	
	public void sendFilterCriteria(FilterCriteria) {
		this.returnId.clear(); 
		this.password.sendKeys(FilterCriteria); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
}

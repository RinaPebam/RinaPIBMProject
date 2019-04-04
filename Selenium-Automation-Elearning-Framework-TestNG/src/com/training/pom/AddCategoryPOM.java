package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCategoryPOM {
	private WebDriver driver; 
	
	public AddCategoryPOM(WebDriver driver) {
		this.setDriver(driver); 
		PageFactory.initElements(driver, this);
		
		
	}

	
	@FindBy (id="catalog")
	public WebElement catalog;
	

	@FindBy (xpath ="//li[@id='catalog']/ul/li[1]")
	public WebElement categories;
	
	
	@FindBy(xpath="//i[@class='fa fa-plus']")
	public WebElement addSign;
	
	
	@FindBy(xpath="//input[@placeholder='Category Name']")
	public WebElement categoryName;
	
	
	@FindBy (xpath="//div[@class='note-editable panel-body']")
	public WebElement description;
	
	
	@FindBy (xpath="//input[@id='input-meta-title1']")
	public WebElement metaTitle;
	
	
	//@FindBy (xpath ="//input[@placeholder='Meta Tag Title']")
	@FindBy (xpath="//textarea[@id='input-meta-description1']")
	public WebElement metaTagDescription;
	
	
	@FindBy (xpath = "//a[contains(text(),'Data')]")
	public WebElement dataTab;
	
		
	@FindBy (xpath = "//a[contains(text(),'Design')]")
	public WebElement designTab;	
	

	@FindBy(xpath = "//button[@type='submit']")
	public WebElement saveButton;
	
	
	public void clickCatalog() 
	{
		this.catalog.click();
	}
	
	public void clickCategories() 
	{
		this.categories.click();
	}
	
	
	public void clickAddSign()
	{
		this.addSign.click();
	}
	
	
	public void enterCategoryName(String ch1)
	{
		this.categoryName.sendKeys(ch1);
	}
	
	
	public void enterDescription(String ch2)
	{
		this.description.sendKeys(ch2);
	}
	
	
	public void entermetaTitle(String ch3)
	{
		this.metaTitle.sendKeys(ch3);
	}
	
	
	public void entermetaTagDescription(String ch4)
	{
		this.metaTagDescription.sendKeys(ch4);
	}
	
	public void clickdataTab()
	{
		this.dataTab.click();
	}
	
	
	public void clickdesignTab()
	{
		this.designTab.click();
	}
	
	public void clicksaveButton()
	{
		this.saveButton.click();
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
}
	
	

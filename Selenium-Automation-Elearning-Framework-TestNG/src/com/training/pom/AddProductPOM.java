package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddProductPOM {
	private WebDriver driver; 
	
	List <WebElement> dd_menu;
	
	public AddProductPOM(WebDriver driver) {
		this.setDriver(driver); 
		PageFactory.initElements(driver, this);
		
		
	}

	
	@FindBy (id="catalog")
	public WebElement catalog;
	

	@FindBy (xpath ="//li[@id='catalog']/ul/li[2]")
	public WebElement product;
	
	
	@FindBy(xpath="//i[@class='fa fa-plus']")
	public WebElement addSign_p;
	
	
	@FindBy(xpath="//input[@id='input-name1']")
	public WebElement productName;
	

	@FindBy (xpath="//input[@id='input-meta-title1']")
	public WebElement metaTitle;
	
	
	@FindBy (xpath = "//a[contains(text(),'Data')]")
	public WebElement dataTab_p;
	
	@FindBy (xpath = "//input[@placeholder='Model']")
	public WebElement model;
		
	@FindBy (xpath = "//a[contains(text(),'Links')]")
	public WebElement links;
	
	@FindBy (xpath = "//input[@id='input-category']")
	public WebElement categories_p;
	
	@FindBy (xpath ="//a[@href='#tab-attribute']")
	public WebElement attribute;
	
	@FindBy (xpath ="//a[@href='#tab-option']")
	public WebElement option;
	
	@FindBy (xpath="//a[@href='#tab-recurring']")
	public WebElement recurring;
	
	@FindBy (xpath="//a[contains(text(),'Discount')]")
	public WebElement discount;
	
	
	@FindBy (xpath ="//a[contains(text(),'Special')]")
	public WebElement special;
	
	
	@FindBy (xpath ="//a[contains(text(),'Image')]")
	public WebElement image;
	
	@FindBy (xpath = "//a[@href='#tab-reward']")
	public WebElement reward;
	
	
	@FindBy (xpath = "//a[contains(text(),'Design')]")
	public WebElement design;
	

	@FindBy(xpath = "//i[@class='fa fa-save']")
	public WebElement saveButton;
	
	
	public void clickCatalog() 
	{
		this.catalog.click();
	}
	
	public void clickCategories() 
	{
		this.product.click();
	}
	
	
	public void addSign()
	{
		this.addSign_p.click();
	}
	
	
	public void enterProductName(String ch1)
	{
		this.productName.sendKeys(ch1);
	}
	
	
	public void entermetaTitle(String ch2)
	{
		this.metaTitle.sendKeys(ch2);
	}
	

	public void clickdataTab()
	{
		this.dataTab_p.click();
	}
	
	
	public void enterModelName(String ch3)
	{
		this.model.sendKeys(ch3);
	}
	
	
	public void clickLinksTab()
	{
		this.links.click();
	}
	
	
	public void selectCategory()
	{
		this.categories_p.click();
		dd_menu = driver.findElements(By.xpath("//ul[@class='dropdown-menu']//li/a"));
		
		for(int i=0; i<dd_menu.size();i++)
		{
		WebElement e = dd_menu.get(i);
		String innerhtml = e.getAttribute("innerHTML");
		if(innerhtml.equalsIgnoreCase("Sports Uniform"))
				{
					e.click();
				}
		}
	}
	
		
	public void clickAttributeTab()
	{
		this.attribute.click();
	}
	
	
	public void clickOptionTab()
	{
		this. option.click();
	}
	
	
	public void clickRecurring()
	{
		this.recurring.click();
	}
	
	
	public void clickDiscountTab()
	{
		this.discount.click();
	}
	
	
	public void clickSpecialTab()
	{
	this.special.click();
	}
	
	
	
	public void clickImage()
	{
		this.image.click();
	}
	
	
	public void clickReward()
	{
		this.reward.click();
	}
	
	
	public void clickDesign()
	{
		this.design.click();
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
	
	

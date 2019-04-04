package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.internal.WrapsElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditOrderPOM {
	private WebDriver driver; 
	
	public EditOrderPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
		
	@FindBy(id="sale")
	public WebElement sale;
	
	@FindBy(xpath ="//li[@id='sale']/ul/li[1]")
	public WebElement order;
	
	@FindBy(xpath="//table/tbody//tr[1]/td[1]")
	public WebElement order1;
	
	@FindBy (xpath = "//tr[1]//td[8]//a[2]//i[1]")
	public WebElement editBtn;
	
	@FindBy (xpath = "//button[@id='button-customer']")
	//@FindBy (xpath = "//*[@id=\"button-customer\"]")
	public WebElement customerPageContinueBtn;
	
	
	//@FindBy (xpath = "//button[@data-original-title=\"Remove\"]")
	@FindBy (xpath = "//tbody[@id=\"cart\"]/tr/td[6]/button")
	public WebElement removeBtn;
	
		
	@FindBy (xpath = "//input[@id='input-product']")
	public WebElement chooseProduct;
	
	@FindBy (id = "input-quantity")
	public WebElement quantity;
	
	
	//@FindBy (xpath = "//select[@id='input-option370']")
	@FindBy (xpath="//div[@id=\"option\"]/fieldset/div/div[1]/select[@class=\"form-control\"]")
	public WebElement chestSize;
	
	@FindBy (xpath = "//button[contains(text(),'Add Product')]")
	public WebElement addProductBtn;
	
	
	@FindBy (xpath="//ul[@class='dropdown-menu']//li")
	public List<WebElement> ProductList;
	
	
	@FindBy (xpath="//*[@id='button-cart']")
	public WebElement productsPageContinueBtn;
	
	@FindBy (xpath="//button[@id='button-payment-address']")
	public WebElement paymentPageContinueBtn;
	

	@FindBy (xpath = "//button[@id='button-shipping-address']")
	public WebElement shippingPageContinueBtn;
	
	@FindBy (xpath="//select[@id='input-shipping-method']")
	public WebElement shippingMethodDD;
	
	
	@FindBy (xpath = "//button[@id='button-shipping-method']")
	public WebElement applyBtn;
	
	
	@FindBy (xpath = "//select[@id='input-payment-method']")
	public WebElement paymentMethodDD;
	
	
	@FindBy (xpath = "//button[@id='button-save']")
	public WebElement saveBtn;
	
		
	//@FindBy (xpath = "//*[@class='dropdown-menu']/li")
	//public List<WebElement> prodName;
	
	
	
	public void clickSale () 
	{
		this.sale.click();
	}
	
	public void clickOrder() 
	{
		this.order.click();
	}
	
	public void clickorder1()
	{
		this.order1.click();
	}
	
	public void clickEditBtn()
	{
		this.editBtn.click();
	}
	
	public void clickCustomerPageContinueBtn()
	{
		this.customerPageContinueBtn.click();
	}
	
	public void clickProductsPageContinueBtn()
	{
		this.productsPageContinueBtn.click();
	}
	
	public void clickPaymentPageContinueBtn()
	{
		this.paymentPageContinueBtn.click();
	}
	
	public void clickShippingPageContinueBtn()
	{
		this.shippingPageContinueBtn.click();
	}
	
	public void clickAddProductBtn()
	{
		this.addProductBtn.click();
	}
	
	public void clickRemoveBtn()
	{
		this.removeBtn.click();
	}
	
	public void clickSelectedProduct(String ch5)
	{
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfAllElements(ProductList));
		ProductList.get(1).click();
	}
	
	/*public void selectChestSize5()
	{
		
		List <WebElement> s = new Select(chestSize).getOptions();
		for(WebElement s1: s)
		{
			if(s1.getText().equalsIgnoreCase("40"))
			{
				s1.click();
			}
		}
		
	}*/
	
	public List<WebElement> clickChestSize () {
		  return new Select(chestSize).getOptions();
	}
	
	
	public void enterProduct(String ch5)
	{
		this.chooseProduct.sendKeys(ch5);
	}	
//		
//		//WebElement chest = this.driver.findElement(By.id("input-option368"));
//		//this.chooseProduct.click();
//		//Select dd = new Select(chest);
//		//dd.selectByVisibleText("SPORTS T-SHIRTS");
//
//	}
	
	
	
	public void enterQuantity(String ch2)
	{
		this.quantity.clear();
		this.quantity.sendKeys(ch2);
	}
	
	
	public void selectChestSize()
	{
		
//		this.chestSize.click();
		WebElement chest = this.driver.findElement(By.id("input-option368"));
		//WebElement chest = this.chestSize;		
		Select dd = new Select(chest);
	}
	
		//List<WebElement> options = dd.getOptions();
		//for(WebElement s: options) 
			//{
				//if(s.getText().equalsIgnoreCase("40")) 
				//{
					//s.click();
				//}
			//}
	//}
	

	public void clickAddBtn()
	{
		this.addProductBtn.click();
	}
	
	

	
	
	public void selectShippingMethod()
	{
		this.shippingMethodDD.click();
		Select dd1 = new Select(shippingMethodDD);
		dd1.selectByValue("free.free");
		
	}
	
	
	public void clickApplyBtn()
	{
		this.applyBtn.click();
	}
	
	public void selectPaymentMethod()
	{
		this.paymentMethodDD.click();
		Select dd2 = new Select(paymentMethodDD);
		dd2.selectByValue("cod"); 
	}
	
		
    public void clickSaveBtn()
    {
    	this.saveBtn.click();
    }
	
	
}

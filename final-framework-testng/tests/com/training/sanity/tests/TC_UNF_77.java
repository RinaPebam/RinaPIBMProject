package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.dataproviders.AllTCsDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.AddCategoryPOM;
import com.training.pom.AddProductPOM;
import com.training.pom.EditOrderPOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;


/*TC_UNF_77: To verify whether application allows admin to change multiple order placed by the customer */
/* reading inputs from excel sheet */


public class TC_UNF_77{

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private EditOrderPOM editorderPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		editorderPOM = new EditOrderPOM (driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	@Test(dataProvider = "xls-inputsTC77", dataProviderClass = AllTCsDataProviders.class)
	public void AddCategoryAddProductTest(String productName, int quantity ) throws InterruptedException {
		
		//enters the login credentials
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");		
		loginPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("TC_UNF_077");		
		Thread.sleep(1000);
		
		
		//edits an existing order by removing existing product and adding a different product Sports T Shirt of specific quantity and size
		editorderPOM.clickSale();
		editorderPOM.clickOrder();
		editorderPOM.clickorder1();
		editorderPOM.clickEditBtn();
		Thread.sleep(1000);
		editorderPOM.clickCustomerPageContinueBtn();
		Thread.sleep(1000);
		editorderPOM.clickRemoveBtn();
		Thread.sleep(1000);
		editorderPOM.enterProduct(productName);
		editorderPOM.clickSelectedProduct(productName);		
		editorderPOM.enterQuantity("quantity");
		editorderPOM.clickAddProductBtn();
		editorderPOM.clickProductsPageContinueBtn();
		editorderPOM.clickPaymentPageContinueBtn();
		editorderPOM.clickShippingPageContinueBtn();
		editorderPOM.selectShippingMethod();
		editorderPOM.clickSaveBtn();
		
		
		//checks if the message displayed after adding category matches the expected one
		String expectedMessage = "Success: You have modified orders!";
		String actualMessage = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();  
	    System.out.println("Actual Message: "  +actualMessage);
	    boolean b1 = actualMessage.contains(expectedMessage);
	    Assert.assertEquals(b1,true);
		    
	    driver.close();
	    
	    
	}
	
}


	    
	
		
		




	
	

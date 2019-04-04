package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.dataproviders.AllTCsDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.AddCategoryPOM;
import com.training.pom.AddProductPOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;


/*TC_UNF_79: To verify whether application allows admin to create multiple category & add product on the created category*/


public class TC_UNF_79{

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private AddCategoryPOM addcategory;
	private AddProductPOM addproduct;
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
		addcategory = new AddCategoryPOM (driver);
		addproduct = new AddProductPOM (driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	@Test(dataProvider = "xls-inputsTC79", dataProviderClass = AllTCsDataProviders.class)
	public void AddCategoryAddProductTest(String categoryName, String description, String metaTagTitle, String metaTagDescription, String productName, String metaTite, String category) throws InterruptedException {
		
		//enters the login credentials
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");		
		loginPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("TC_UNF_078");		
		Thread.sleep(1000);
		
		
		//creates a new Category
		addcategory.clickCatalog();
		addcategory.clickCategories();
		addcategory.clickAddSign();
		addcategory.enterCategoryName(categoryName);
		addcategory.enterDescription(description);
		addcategory.entermetaTitle(metaTagTitle);
		addcategory.entermetaTagDescription(metaTagDescription);
		addcategory.clickdataTab();
		addcategory.clickdesignTab();
		addcategory.clicksaveButton();

		if(categoryName == null || description == null || metaTagTitle == null || metaTagDescription == null)
		{
			String expectedMessage = "Warning: Please check the form carefully for errors!";
			String actualMessage = driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText();  
		    System.out.println("Actual Message: "  +actualMessage);
		    boolean b1 = actualMessage.contains(expectedMessage);
		    Assert.assertEquals(b1,true);
		    
		    break;
		}
		
		else
		{
		
		
		//checks if the message displayed after adding category matches the expected one
		String expectedMessage = "Success: You have modified categories!";
		String actualMessage = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();  
	    System.out.println("Actual Message: "  +actualMessage);
	    boolean b1 = actualMessage.contains(expectedMessage);
	    Assert.assertEquals(b1,true);
	    
	    
	    //adds a product to the newly created category
	    addproduct.clickCatalog();
	    addproduct.clickCategories();
	    addproduct.addSign();
	    addproduct.enterProductName(productName);
	    addproduct.entermetaTitle(metaTite);
	    addproduct.clickdataTab();
	    addproduct.enterModelName(category);
	    addproduct.clickLinksTab();
	    addproduct.selectCategory();
	    addproduct.clickAttributeTab();
	    addproduct.clickOptionTab();
	    addproduct.clickRecurring();
	    addproduct.clickDiscountTab();
	    addproduct.clickSpecialTab();
	    addproduct.clickImage();
	    addproduct.clickReward();
	    addproduct.clickDesign();
	    addproduct.clicksaveButton();	    
	    
	    
	    //checks if the message displayed after adding product matches the expected one
		String expectedMessage1 = "Success: You have modified products!";
		String actualMessage1 = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();  
	    System.out.println("Actual Message: "  +actualMessage1);
	    boolean b2 = actualMessage1.contains(expectedMessage1);
	    Assert.assertEquals(b2,true);
	    
		}
		
	    driver.close();
	    
	    
	}
	
}


	    
	
		
		




	
	

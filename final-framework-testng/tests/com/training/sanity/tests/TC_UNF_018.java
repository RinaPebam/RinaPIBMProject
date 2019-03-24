package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.training.generics.ScreenShot;
import com.training.pom.FilterOrderPOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;


/*To Verify whether application allows the admin to filter the Product Return List details*/


public class TC_UNF_018 {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private FilterOrderPOM filterPOM;
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
		filterPOM = new FilterOrderPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	
	@Test
	public void FilterReturnOrder() throws InterruptedException {
		
		//logins by entering the login credentials
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("TC_UNF_018");
		

		//clicks Sales->Returns->filters by return ID
	    filterPOM.clickSale();
	    filterPOM.clickReturnOrder();
	    filterPOM.enterReturnID("120");
	    filterPOM.clickFilterBtn();
	    Thread.sleep(1000);
	    
    	//clears the return ID fields   
	    filterPOM.clearFields();
	    
	    
	    //filters by customer name 
	    filterPOM.enterCustomerName("r");
	    filterPOM.clickFilterBtn();
	    JavascriptExecutor je = (JavascriptExecutor) driver;
	    je.executeScript("scroll(0,300)");
	    Thread.sleep(1000);
	    
	    
	
	}
}

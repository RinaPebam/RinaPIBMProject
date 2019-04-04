package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.training.generics.ScreenShot;
import com.training.pom.FilterCustomerDetailsPOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;


/*To Verify whether application allows the admin to filter the customer details in Customer List*/



public class TC_UNF_020 {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private FilterCustomerDetailsPOM filtercustomerdetailsPOM;
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
		filtercustomerdetailsPOM = new FilterCustomerDetailsPOM (driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	@Test
	public void FilterCustomerDetailsTest() throws InterruptedException {
		
		
		//logins by entering the login credentials
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("First");
		
		
		//clicks Customers->Customers link and filters by customer name
		filtercustomerdetailsPOM.clickCustomers();
		filtercustomerdetailsPOM.clickCustomers1();
		filtercustomerdetailsPOM.enterCustomerName("Neha");
		filtercustomerdetailsPOM.clickFilterBtn();
		
		
		//clears the customer name field
		filtercustomerdetailsPOM.clearCustomerNameField();
		
		
		//filters by email ID
		filtercustomerdetailsPOM.enterEmailID("neha1@gmail.com");
		filtercustomerdetailsPOM.clickFilterBtn();
	       
	    
	}

}

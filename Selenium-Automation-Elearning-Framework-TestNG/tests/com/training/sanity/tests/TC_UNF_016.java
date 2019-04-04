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

import com.training.generics.ScreenShot;
import com.training.pom.DeleteOrderPOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;


/*To Verify whether application allows the admin to delete a order from order list*/


public class TC_UNF_016{

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private DeleteOrderPOM deleteorderPOM;
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
		deleteorderPOM = new DeleteOrderPOM(driver);
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
	public void DeleteOrderTest() throws InterruptedException {
		
		//enters login credentials
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");		
		loginPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("TC_UNF_016");		
		Thread.sleep(1000);
		
		
		//clicks Sales->Orders link	and deletes the order
		deleteorderPOM.clickSale();
		deleteorderPOM.clickOrder();
	    deleteorderPOM.clickcheckbox();
	    deleteorderPOM.clickdeletebutton();

    
	    //captures the pop-up message and checks if it matches the expected 	
	    String ActualMessage = driver.switchTo().alert().getText();    
	    String ExpectedMessage = "Are you sure?";
	    Assert.assertEquals(ActualMessage,ExpectedMessage,"ActualResult does not match ExpectedResult");
	    System.out.println("ActualResult matches ExpectedResult");
	    
	    
	    //clicks on the OK button of the alert pop-up
	    driver.switchTo().alert().accept();
	    
	    
		
	}
	
}


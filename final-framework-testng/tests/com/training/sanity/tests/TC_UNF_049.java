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
import com.training.pom.AddReturnOrderPOM;
import com.training.pom.DeleteOrderPOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;


/* To verify whether application allows admin to return product of customer & delete from return list */


public class TC_UNF_049{

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private AddReturnOrderPOM addreturnanddeleteit;
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
		addreturnanddeleteit = new AddReturnOrderPOM(driver);
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
	public void AddReturnOrderNDeleteItTest() throws InterruptedException {
		
		//enters the login credentials
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");		
		loginPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("TC_UNF_049");		
		Thread.sleep(1000);
		
		//adds a return order by filling up the mandatory fields
		addreturnanddeleteit.clickSale();
		addreturnanddeleteit.clickOrder();
		addreturnanddeleteit.clickPlusSign();
		addreturnanddeleteit.enterOrderID("152");
		addreturnanddeleteit.enterCustomerName("Rina");
		addreturnanddeleteit.enterFirstName("Rina");
		addreturnanddeleteit.enterLastName("Pebam");
		addreturnanddeleteit.enterEmailID("rina.pebam@gmail.com");
		addreturnanddeleteit.enterPhoneNumber("9900106418");
		addreturnanddeleteit.enterProduct(" Blazer Girls");
		addreturnanddeleteit.enterModel("BLG-112");
		addreturnanddeleteit.clickSaveBtn();
		
		
		//checks if the message displayed after adding return order matches the expected 
	    String expectedMessage_afteraddreturn = "Success: You have modified returns!";
	    String actualMessage_afteraddreturn= driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();  
	    System.out.println("Actual Message: "  +actualMessage_afteraddreturn);
	    boolean b1 = actualMessage_afteraddreturn.contains(expectedMessage_afteraddreturn);
	    Assert.assertEquals(b1,true);
	    
	    
	    
	    //deletes the newly added return order
	    addreturnanddeleteit.selectReturnOrder();
	    addreturnanddeleteit.clickDeleteBtn();
	    
	    
	    //clicks the OK button on the pop-up message
	    driver.switchTo().alert().accept();
	    
	    
		//checks if the message displayed after deleting return order matches the expected 
	    String expectedMessage_afterdeleteReturn = "Success: You have modified returns!";
	    String actualMessage_afterdeleteReturn  = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();  
	    System.out.println("Actual Message: "  +actualMessage_afterdeleteReturn );
	    boolean b2 = actualMessage_afterdeleteReturn .contains(expectedMessage_afterdeleteReturn );
	    Assert.assertEquals(b2,true);
	    
	    
	}
}

    
		 
		
		
		
		
		
	

	
	
	




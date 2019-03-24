package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.training.generics.ScreenShot;
import com.training.pom.FilterOrderPOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

/*To Verify whether application allows the admin to delete Returned product details from Product Return list*/



public class TC_UNF_019 {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private FilterOrderPOM deleteOrderfltPOM;
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
		baseUrl = properties.getProperty("baseURL");
		deleteOrderfltPOM = new FilterOrderPOM(driver);
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
	public void DeleteReturnProduct() throws InterruptedException {
		
		//logins by entering the valid credentials
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");		
		loginPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("First");
		
		deleteOrderfltPOM.clickSale();
		deleteOrderfltPOM.clickReturnOrder();
		Thread.sleep(1000);
		deleteOrderfltPOM.clickcheckbox();
		deleteOrderfltPOM.clickDeleteBtnFltPage();	
		Thread.sleep(1000);
		
			    
	    	    
	    //captures the pop-up message and checks if it matches the expected pop-up message
		String expectedMessage1 = "Are you sure?";
	    String actualMessage1 = driver.switchTo().alert().getText();
	    Assert.assertEquals(actualMessage1,expectedMessage1);
	    System.out.println("Actual pop-up message matches with the expected message.");
	    
	    
	    //clicks OK button on the alert pop-up	    
	    driver.switchTo().alert().accept();
	    Thread.sleep(1000);
	     
	    //captures the message displayed after deleting the item and checks if it matches the expected
	    String expectedMessage2 = "Success: You have modified returns!";
	    String actualMessage2 = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();  
	    System.out.println("Actual Message: "  +actualMessage2);
	    boolean b1 = actualMessage2.contains(expectedMessage2);
	    Assert.assertEquals(b1,true);
    
	    
	    
	    //scrolls the view vertically down by 100 pixels so that we can view that the deleted item is no longer visible in the return list
	    JavascriptExecutor je = (JavascriptExecutor) driver;
	    je.executeScript("scroll(0,200)");
	    Thread.sleep(1000);
	

	 
	    }
}

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
import com.training.pom.EditCustomerDetailsAddRewardPoints;
import com.training.pom.EditCustomerDetailsAddRewardPointsPOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;


/*   To verify whether application allows admin to edit Customer details & add reward points    */


public class TC_UNF_050{

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private EditCustomerDetailsAddRewardPointsPOM editcustomerdetailsaddrewardPOM;
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
		editcustomerdetailsaddrewardPOM = new EditCustomerDetailsAddRewardPointsPOM(driver);
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
	public void EditCustomerDetailsAddRewardPointsTest() throws InterruptedException {
		
		//enters the login credentials
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");		
		loginPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("TC_UNF_050");		

		
		//edits customer details by clicking Customers->Customers->selecting the customer->Edit button->editing the fields
		editcustomerdetailsaddrewardPOM.clickCustomers();
		editcustomerdetailsaddrewardPOM.clickCustomers1();
		editcustomerdetailsaddrewardPOM.clickcheckbox();
		editcustomerdetailsaddrewardPOM.clickEditBtn();
		editcustomerdetailsaddrewardPOM.enterFirstName("Rina");
		editcustomerdetailsaddrewardPOM.enterLastName("Pebam");
		editcustomerdetailsaddrewardPOM.clickAddress1();
		editcustomerdetailsaddrewardPOM.enterPostCode("560017");
		
		//adds reward points 
		editcustomerdetailsaddrewardPOM.clickRewardPoints();
		editcustomerdetailsaddrewardPOM.enterDescription("bonus");
		editcustomerdetailsaddrewardPOM.enterPoints("20");	    
		editcustomerdetailsaddrewardPOM.clickAddRewardPointsBtn();
		
		
		//checks if the message after adding reward points matches the expected
	    String expectedMessage_afterclickaddreward = "Success: You have modified customers!";
	    String actualMessage_afterclickaddreward= driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();  
	    System.out.println("Actual Message: "  +actualMessage_afterclickaddreward);
	    boolean b1 = actualMessage_afterclickaddreward.contains(expectedMessage_afterclickaddreward);
	    Assert.assertEquals(b1,true);
	    
	    
	    //clicks Save button
	    editcustomerdetailsaddrewardPOM.clickSaveBtn();
	    
	    
	  //checks if the message after clicking save button matches the expected
	    String expectedMessage_afterclickSaveBtn = "Success: You have modified customers!";
	    String actualMessage_afterclickSaveBtn= driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();  
	    System.out.println("Actual Message: "  +actualMessage_afterclickSaveBtn);
	    boolean b2 = actualMessage_afterclickSaveBtn.contains(expectedMessage_afterclickSaveBtn);
	    Assert.assertEquals(b2,true);
	    
			    
	}
}

    
		 
		
		
		
		
		
	

	
	
	




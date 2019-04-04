package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
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
import com.training.pom.LoginToUniformUrlPOM;
import com.training.pom.MovingOrderToCompleteStatusPOM;
import com.training.pom.TC080POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;


/*TC_UNF_80: To verify whether application allows to place an order by logging in while checking out and admin to change the status to complete*/


public class TC_UNF_80{

	private WebDriver driver;
	private String baseUrl;
	//private LoginPOM loginPOM;
	private TC080POM tc080POM;
	private MovingOrderToCompleteStatusPOM movingOrderToComplete;
	private LoginToUniformUrlPOM loginToUniformUrlPOM;
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
		//loginPOM = new LoginPOM(driver); 
		tc080POM = new TC080POM(driver);
		movingOrderToComplete = new MovingOrderToCompleteStatusPOM(driver);
		loginToUniformUrlPOM = new LoginToUniformUrlPOM(driver);
		//baseUrl = properties.getProperty("baseURL");
		baseUrl = "http://uniform.upskills.in/";
		screenShot = new ScreenShot(driver); 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	@SuppressWarnings("unused")
	@Test
	public void AddCategoryAddProductTest() throws InterruptedException {
		
		tc080POM.clickshopUniformBtn();
		Thread.sleep(1000);
		tc080POM.clickSportsTShirtBtn();
		Thread.sleep(1000);
		tc080POM.clickChestSizeDD();
		Thread.sleep(1000);		
		tc080POM.clickaddToCartBtn();
			    
	    
	    //checks if the message displayed after adding product matches the expected one
		String expectedMessage1 = "Success: You have added";
		String actualMessage1 = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();  
	    System.out.println("Actual Message: "  +actualMessage1);
	    boolean b2 = actualMessage1.contains(expectedMessage1);
	    Assert.assertEquals(b2,true);
	    
	    tc080POM.clickaddToCartIcon();	
	    tc080POM.clickviewCartBtn();
	    tc080POM.clickcheckOutBtn();
	    tc080POM.enterEmailID("rina.pebam@gmail.com");
	    tc080POM.enterPassword("rina12345");
	    tc080POM.clickLoginBtn();
	    tc080POM.clickBillingDetailsPageContinueBtn();

	    
	    tc080POM.clickDeliveryDetailsPageContinueBtn();
	    tc080POM.clickDeliveryMethodPageContinueBtn();
	    tc080POM.enterComment("Value for money");
	    tc080POM.checkIAgreeChkBx();
	    tc080POM.clickPaymentMethodPageContinuebtn();
	    tc080POM.clickConfirmBtn();	    
		    
	    //checks if the message displayed after adding product matches the expected one
		String expectedMessage2 = "YOUR ORDER HAS BEEN PLACED!";
		String actualMessage2 = driver.findElement(By.xpath("//h1[contains(text(),'Your order has been placed!')]")).getText();  
	    System.out.println("Actual Message: "  +actualMessage2);
	    boolean b3 = actualMessage2.contains(expectedMessage2);
	    Assert.assertEquals(b3,true);
	    
	    
	    tc080POM.clickOrderSuccessPageConfirmBtn();
	    Thread.sleep(1000);
	    
		@SuppressWarnings("unused")
		String windowHandle = driver.getWindowHandle();
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
	    driver.get("http://uniform.upskills.in/admin/");
	    
	    
	    movingOrderToComplete.clickSale();
	    movingOrderToComplete.clickOrder();
	    movingOrderToComplete.clickViewBtn();
	    movingOrderToComplete.selectOrderStatus();
	    movingOrderToComplete.clickAddHistoryBtn();
	    
	    
	    loginToUniformUrlPOM.enterEmailID("admin");
	    loginToUniformUrlPOM.enterPassword("admin@123");
	    loginToUniformUrlPOM.clickLoginBtn02();
	    loginToUniformUrlPOM.clickViewHistoryLink();
	    String actualStatus = loginToUniformUrlPOM.getStatus();
	    assert.assertEquals(actualStatus, "Complete");
	    
	    driver.close();    
	    
	    
	    
	}
}

	


	    
	    
	
		
	
	
	    
	    

	


	    
	
		
		




	
	

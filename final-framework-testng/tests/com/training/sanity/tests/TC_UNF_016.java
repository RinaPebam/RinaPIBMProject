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
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;


/*To Verify whether application allows the admin to delete a order from order list*/


public class TC_UNF_016{

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
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
	public void validLoginTest() throws InterruptedException {
		
		//enters the login credentials
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");		
		loginPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("TC_UNF_016");		
		Thread.sleep(3000);
		
		
		//clicks the Sales->Orders link		
	    driver.findElement(By.id("sale")).click();
	    driver.findElement(By.xpath("//li[@id='sale']/ul/li[1]")).click();
	    Thread.sleep(3000);
	    
	    
	    //checks the check box of the order to be deleted and clicks Delete button	    
	    driver.findElement(By.xpath("//table/tbody/tr[1]/td[1]")).click();
	    driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[8]/button[1]")).click();
	    Thread.sleep(3000);
	    
	    
	    //captures the actual alert message and assigns it to a string variable named ActualMessage   	
	    String ActualMessage = driver.switchTo().alert().getText();
	    
	    
	    //assigns the actual message to a string variable named ExpectedMessage
	    String ExpectedMessage = "Are you sure?";
	    
	    
	    //clicks on the OK button of the alert pop-up
	    driver.switchTo().alert().accept();
	    
	    
	    
	    //checks if the actual message is equal to the expected one or not
	    Assert.assertEquals(ActualMessage,ExpectedMessage,"ActualResult does not match ExpectedResult");
	    System.out.println("ActualResult matches ExpectedResult");
	    Thread.sleep(3000);   
	    	   
	    
	    //unable to capture the xpath of the message "Success: You have modified orders!" as it disappears quickly
		
	}
	
	
	

	private void sleep(int i) {
		// TODO Auto-generated method stub
		
	}

	private Object action() {
		// TODO Auto-generated method stub
		return null;
	}
}

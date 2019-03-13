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
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

/*To Verify whether application allows the admin to delete Returned product details from Product Return list*/



public class TC_UNF_019 {

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
		
		//logins by entering the valid credentials
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");		
		loginPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("First");
		
		
		
		
		//clicks on Sales->Returns link		
	    driver.findElement(By.id("sale")).click();
	    driver.findElement(By.xpath("//li[@id='sale']/ul/li[3]")).click();
	    Thread.sleep(3000);
	    
	    
	    
	    
	    //locates the item to be deleted and deletes it
	    driver.findElement(By.xpath("//table/tbody/tr[1]/td[1]")).click();
	    driver.findElement(By.xpath("//div[@class='pull-right']//button[@type='button']")).click();
	    Thread.sleep(5000);
	    
	    
	    	    
	    //captures the message displayed in the pop-up 	    
	    String ActualMessage = driver.switchTo().alert().getText();
	    String ExpectedMessage = "Are you sure?";
	    
	    
	    
	    //checks if actual message matches the expected one
	    Assert.assertEquals(ActualMessage,ExpectedMessage,"Actual pop-up message does not match with the expected");
	    System.out.println("Actual pop-up message matches with the expected message.");
	    
	    
	    //clicks OK button on the alert pop-up	    
	    driver.switchTo().alert().accept();
	    Thread.sleep(3000);
	     
	    //captures the message displayed after deleting the item	  
	    String ActualFinalMessage = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();  
	    String ExpectedFinalMessage = " Success: You have modified returns!      ";
	    
	    
	    
	    //scrolls the view vertically down by 100 pixels so that we can view that the deleted item is no longer visible in the return list
	    JavascriptExecutor je = (JavascriptExecutor) driver;
	    je.executeScript("scroll(0,100)");
	    Thread.sleep(3000);
	
	    
	    //checks if actual final message displayed after deleting the item matches the expected one
	    SoftAssert sa=new SoftAssert();
	    sa.assertEquals(ActualFinalMessage,ExpectedFinalMessage, "Actual final message does not match with the expected.");
	    System.out.println("Actual final message matches with the expected message. Selected order is removed from returned list successfully.");
	    Thread.sleep(3000);   

	 
	    }
		
	

	private void sleep(int i) {
		// TODO Auto-generated method stub
		
	}

	private Object action() {
		// TODO Auto-generated method stub
		return null;
	}
}

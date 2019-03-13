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


/*To Verify whether application allows the admin to filter the customer details in Customer List*/



public class TC_UNF_020 {

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
		
		
		//logins by entering the login credentials
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("First");
		
		
		//clicks on Customers->Customers link
	    driver.findElement(By.id("customer")).click();
	    driver.findElement(By.xpath("//li[@id='customer']/ul/li[1]")).click();
	    
	    
	    //declares and initializes the filter input and output variables
	    String FilterCriteria = "Neha";
	    String FilteredName = null;
	    
	    
	    //locates the customer name field, enters the filter criteria and clicks Filter button
	    driver.findElement(By.xpath("//input[@id='input-name']")).sendKeys(FilterCriteria);
	    driver.findElement(By.xpath("//button[@id='button-filter']")).click(); 
	    Thread.sleep(3000);
	   
	    
	    //scrolls the view vertically down by 420 pixels so that major portion of the result is visible
	    JavascriptExecutor je = (JavascriptExecutor) driver;
	    je.executeScript("scroll(0,420)");

	 
	    //prints the filter criteria on the eclipse console
	    System.out.println("Filter by name:Criteria = " +FilterCriteria);
	    
	    
	    
	    //locates and prints each and every filtered product	  
	    for(int i=1; i<=8; i++)
	    {
		    FilteredName= driver.findElement(By.xpath("//table/tbody/tr["+ i + "]")).getText();
		    System.out.println("Filtered Product: "  +FilteredName);
	    }

	    System.out.println("");
	    
	    //checks if the system has filtered all the customer names starting with Neha followed by any character
	    SoftAssert sa=new SoftAssert();
	    sa.assertEquals(FilterCriteria, FilteredName, "Product Return List does NOT match the filter criteria");
	    System.out.println("Product Return List matches the filter criteria");
	    Thread.sleep(3000);   	
	    
	    
	    //clears the text entered in the Input name textbox
	    driver.findElement(By.xpath("//input[@id='input-name']")).clear();
	    
	    
	    
	  //declares and initializes the filter input and output variables
	    FilterCriteria = "neha@gmail.com";
	    FilteredName = null;
	    
	    
	    //prints the filter criteria on the eclipse console	    
	    System.out.println("-------------------------------------------------------------------");
	    System.out.println("Filter by email:Criteria = " +FilterCriteria);
	    
	    
	    
	  //locates the customer email field, enters the filter criteria and clicks Filter button	    
	    driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(FilterCriteria);
	    driver.findElement(By.xpath("//button[@id='button-filter']")).click(); 
	    Thread.sleep(3000);
	   
	    
	    
	  //scrolls the view vertically down by 420 pixels so that major portion of the result is visible	    
	    JavascriptExecutor je2 = (JavascriptExecutor) driver;
	    je2.executeScript("scroll(0,420)");

	 
	    //locates and prints each and every filtered product
	    FilteredName= driver.findElement(By.xpath("//table/tbody/tr[1]")).getText();
		System.out.println("Filtered Product: "  +FilteredName);
	    

	    System.out.println("");
	    
	    //checks if the system has filtered all the customer whose email is neha@gmail.com
	    SoftAssert sa2=new SoftAssert();
	    sa2.assertEquals(FilterCriteria, FilteredName, "Product Return List does NOT match the filter criteria");
	    System.out.println("Product Return List matches the filter criteria");
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

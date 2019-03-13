package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;


/*To Verify whether application allows the admin to filter the Product Return List details*/


public class TC_UNF_018 {

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
		screenShot.captureScreenShot("TC_UNF_018");
		
		
		
		//clicks on Sales->Returns link
	    driver.findElement(By.id("sale")).click();
	    driver.findElement(By.xpath("//li[@id='sale']/ul/li[3]")).click();   
	    

	    //inputs the filter criteria (return ID)
	    String FilterCriteria = "36";	      
	    Thread.sleep(3000);
	    
	    
	    //locates the return id field, enters the filter criteria there and filters it	    
	    driver.findElement(By.id("input-return-id")).sendKeys(FilterCriteria);
	    driver.findElement(By.xpath("//button[contains(text(),'Filter')]")).click();
	    
	    
	    //scrolls the view vertically down by 400 pixels so that major portion of the result is visible
	    JavascriptExecutor je = (JavascriptExecutor) driver;
	    je.executeScript("scroll(0,450)");
	    Thread.sleep(3000);
	
	    
	    
	    //prints the filter criteria on the console	    
	    System.out.println("Filter by return id:Criteria =  "  +FilterCriteria);
	    
	    
	    
	    //locates and prints each and every filtered product on the console
	    String FilteredName= driver.findElement(By.xpath("//table/tbody/tr[1]")).getText();
		System.out.println("Filtered Product: "  +FilteredName);

		
		//prints a blank line on the console
		System.out.println("");
		
		
	    //checks if the system has filtered all the customer names starting with s followed by any character
	    SoftAssert sa=new SoftAssert();
	    sa.assertEquals(FilterCriteria, FilteredName, "Product Return List does NOT match the filter criteria");
	    System.out.println("Product Return List matches the filter criteria");
	    
	    System.out.println("-------------------------------------------------------------------------------------------");
	    
	     
	    
	    //clears the text entered in the Return ID textbox
	    driver.findElement(By.id("input-return-id")).clear();
	        
	    
	  //inputs the filter criteria (customer name)
	    FilterCriteria = "s";	      
	    Thread.sleep(3000);
	    
	    
	    //locates the customer name field, enters the filter criteria and clicks Filter button	    
	    driver.findElement(By.id("input-customer")).sendKeys(FilterCriteria);
	    driver.findElement(By.xpath("//button[contains(text(),'Filter')]")).click();
	    
	    
	    //scrolls the view vertically down by 400 pixels so that major portion of the result is visible
	    JavascriptExecutor je2 = (JavascriptExecutor) driver;
	    je2.executeScript("scroll(0,450)");
	    Thread.sleep(3000);
	
	    
	    System.out.println("Filter by name:Criteria = "  +FilterCriteria);
	    
	    
	    //locates and prints each and every filtered product on the console    
	    for(int i=1; i<=12; i++)
	    {
		    FilteredName= driver.findElement(By.xpath("//table/tbody/tr["+ i + "]")).getText();
		    System.out.println("Filtered Product: "  +FilteredName);
	    }
  

	    
	    System.out.println("");
	    
	    
	    //checks if the system has filtered all the customer names starting with s followed by any character
	    SoftAssert sa2=new SoftAssert();
	    sa2.assertEquals(FilterCriteria, FilteredName, "Product Return List does NOT match the filter criteria");
	    System.out.println("Product Return List matches the filter criteria");
	    
	      
	    System.out.println("-------------------------------------------------------------------------------------------");
	    
	      	    
	}
	

	private void sleep(int i) {
		// TODO Auto-generated method stub
		
	}

	private Object action() {
		// TODO Auto-generated method stub
		return null;
	}
}

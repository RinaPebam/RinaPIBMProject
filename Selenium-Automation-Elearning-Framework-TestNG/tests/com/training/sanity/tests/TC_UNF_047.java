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
import com.training.pom.MultipleFiltersPOM;
import com.training.pom.MultipleFiltersPOM_old;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;


/* To Verify whether application allows admin to filter details of order placed by the user */


public class TC_UNF_047{

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private MultipleFiltersPOM multipleFiltersPOM;
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
		multipleFiltersPOM = new MultipleFiltersPOM(driver);
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
	public void MultipleFilterTest() throws InterruptedException {
		
		//enters the login credentials
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");		
		loginPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("TC_UNF_047");		
		
		
		//clicks Sales->Orders->filter by orderID ->clears the field
		multipleFiltersPOM.clickSale();
		multipleFiltersPOM.clickOrder();
		multipleFiltersPOM.enterOrderID("160");
		multipleFiltersPOM.clickFilterBtn();
		multipleFiltersPOM.clearFields(driver.findElement(By.xpath("//input[@id='input-order-id']")));

		
		//filters by status ->clears the field
		multipleFiltersPOM.selectStatus("Pending");
		multipleFiltersPOM.clickFilterBtn();
		multipleFiltersPOM.selectStatus("");
		
		
		//filters by date added ->clears the field
		WebElement dateElement = driver.findElement(By.xpath("//input[@id='input-date-added']"));
		multipleFiltersPOM.selectDateByJSS(driver, dateElement, "2019-03-20");
		multipleFiltersPOM.clickFilterBtn();
		multipleFiltersPOM.clearFields(driver.findElement(By.xpath("//input[@id='input-date-added']")));

		
		//filters by customer name ->clears the field
		multipleFiltersPOM.enterCustomerName("Rina");
		multipleFiltersPOM.clickFilterBtn();
		multipleFiltersPOM.clearFields(driver.findElement(By.xpath("//input[@placeholder='Customer']")));
		
		
		//filters by date modified	->clears the field	
		WebElement dateElement2 = driver.findElement(By.xpath("//input[@placeholder='Date Modified']"));
		multipleFiltersPOM.selectDateByJSS(driver, dateElement2, "2019-03-19");
		multipleFiltersPOM.clickFilterBtn();
		multipleFiltersPOM.clearFields(driver.findElement(By.xpath("//input[@placeholder='Date Modified']")));
	

		driver.close();

	}
	
		
}

		
	
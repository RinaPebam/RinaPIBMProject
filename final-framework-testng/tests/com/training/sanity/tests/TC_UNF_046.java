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


/*To Verify whether application allows the admin to delete a order from order list*/


public class TC_UNF_046{

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
		// open the browser 
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
		screenShot.captureScreenShot("TC_UNF_046");		
		//Thread.sleep(1000);
		
		
		multipleFiltersPOM.clickSale();
		multipleFiltersPOM.clickOrder();
		multipleFiltersPOM.enterOrderID("160");
		multipleFiltersPOM.clickFilterBtn();
		multipleFiltersPOM.clearFields(driver.findElement(By.xpath("//input[@id='input-order-id']")));
		Thread.sleep(1000);
		
		multipleFiltersPOM.selectStatus("Pending");
		multipleFiltersPOM.clickFilterBtn();
		Thread.sleep(1000);
		multipleFiltersPOM.clearFields(driver.findElement(By.xpath("//select[@name='filter_order_status']")));
		
		
		
		
		
			
		WebElement dateElement = driver.findElement(By.xpath("//input[@id='input-date-added']"));
		multipleFiltersPOM.selectDateByJSS(driver, dateElement, "2019-03-20");
		multipleFiltersPOM.clickFilterBtn();
		Thread.sleep(1000);
		//multipleFiltersPOM.scroll("0","400");
		multipleFiltersPOM.clearFields(driver.findElement(By.xpath("//input[@id='input-date-added']")));
		

		
		WebElement dateElement2 = driver.findElement(By.xpath("//input[@id='input-date-modified']"));
		multipleFiltersPOM.selectDateByJSS(driver, dateElement2, "2019-03-23");
		multipleFiltersPOM.clickFilterBtn();
		//multipleFiltersPOM.scroll("0","400");		
		multipleFiltersPOM.clearFields(driver.findElement(By.xpath("//input[@id='input-date-modified']")));
		
		
		multipleFiltersPOM.enterCustomerName("Neha");
		multipleFiltersPOM.clickFilterBtn();
		Thread.sleep(1000);
		multipleFiltersPOM.clearFields(driver.findElement(By.xpath("//input[@placeholder='Customer']")));
		
	
		multipleFiltersPOM.enterTotal("320");
		multipleFiltersPOM.clickFilterBtn();
		Thread.sleep(1000);

		driver.close();

	}
	
		
}

		
	
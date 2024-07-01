package com.sauce.testcases;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.sauce.browserselection.BrowserFactory;
import com.sauce.pageelements.InventoryElements;
import com.sauce.pageelements.loginElements;

/*Assignment 4
 * Write a Test Script to automate www.saucedemo.com send SMS Module and
Logout using Page Object Model
● Create Maven Project
● Use TestNG
● Use properties files to store Data and Objects
*/
public class TestInventoryPrp {
	WebDriver driver;
	Properties po;
	
	@BeforeTest
	public void startTheBrowser() throws Exception {
		File src=new File("./Configuration/Config.property");
		FileInputStream fis=new FileInputStream(src);
		po = new Properties();
		po.load(fis);
		driver=BrowserFactory.startBrowser(po.getProperty("browser"),po.getProperty("URL"));
		System.out.println("Browser Started");
	}
	
	@Test
	public void ProductDetails() throws Exception {
		loginElements lo =PageFactory.initElements(driver, loginElements.class);
		
		//Passing the username and password from property file
		lo.loginTheApp(po.getProperty("uName"), po.getProperty("passW"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Used Pagefactory for selecting the product and click on add to cart
		InventoryElements ie=PageFactory.initElements(driver, InventoryElements.class);
		ie.selectTheProduct();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		ie.logOutBtn();
		
		String aUrl = driver.getCurrentUrl();
		Assert.assertEquals(aUrl, "https://www.saucedemo.com/");
		System.out.println("Url Matched after logout");
		
	}
	
	@AfterTest
	public void tearDown() throws Exception {
		System.out.println("Browser closed");
		Thread.sleep(3000);
		driver.quit();
	}

}

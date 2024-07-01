package com.sauce.testcases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.sauce.browserselection.BrowserFactory;
import com.sauce.pageelements.InventoryElements;
import com.sauce.pageelements.loginElements;

/*Assignment 2
 * Write a Test Script to automate www.saucedemo.com send SMS Module and
Logout using Page ObjectModel
● Create Maven Project
● Use TestNG
● Create Repository in Class File*/
public class TestInventory {
	WebDriver driver;
	
	@BeforeTest
	public void startTheBrowser() {
		driver=BrowserFactory.startBrowser("chrome", "https://www.saucedemo.com/");
		System.out.println("Browser Started");
	}
	
	@Test
	public void ProductDetails() throws Exception {
		//Used Pagefactory for login using the hardcode values to the method
		loginElements lo =PageFactory.initElements(driver, loginElements.class);
		lo.loginTheApp("standard_user", "secret_sauce");
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

package com.sauce.testcases;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.sauce.browserselection.BrowserFactory;
import com.sauce.pageelements.loginElements;

/*Assignment 3
 * Write a Test Script to automate www.saucedemo.com Login using Page Object
Model
● Create Maven Project
● Use TestNG
● Use properties files to store Data and Objects*/
public class TestLoginPrp {

	WebDriver driver;
	Properties po;
	
	@BeforeTest
	public void openBrowser() throws Exception {
		//Property file configuration
		File src=new File("./Configuration/Config.property");
		FileInputStream fis=new FileInputStream(src);
		po = new Properties();
		
		//Loading the Property file
		po.load(fis);
		
		//Passing the browser and url from property file
		driver=BrowserFactory.startBrowser(po.getProperty("browser"),po.getProperty("URL"));
		 System.out.println("Opening Browser and pass URL");
		
	}
	
	@Test
	public void StartApp() {
		
		//Used Page Factory concept
		loginElements lo =PageFactory.initElements(driver, loginElements.class);
		
		//Passing the username and password from property file
		lo.loginTheApp(po.getProperty("uName"), po.getProperty("passW"));
		System.out.println("Credentials Passed");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	@AfterTest
	public void tearDown() {
		System.out.println("Test Successful");
		//Browser Close
		driver.quit();
	}

}

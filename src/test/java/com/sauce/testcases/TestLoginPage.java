package com.sauce.testcases;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Helper.ExcelDataConfig;
import com.sauce.browserselection.BrowserFactory;
import com.sauce.pageelements.loginElements;


/*Assignment 1
 * Write a Test Script to automate www.saucedemo.com using Page Object Model
● Create Maven Project
● Use TestNG
● Create Repository in Class File*/


public class TestLoginPage {

	WebDriver driver;
	ExcelDataConfig fil;
	@BeforeTest
	public void openBrowser() {
		//Used BrowserSelection class to select the browser and url
		 driver=BrowserFactory.startBrowser("chrome","https://www.saucedemo.com/");
		 System.out.println("Opening Browser and pass URL");
		
	}
	
	@Test
	public void StartApp() {
		//Fetch the credentials from a excel sheet by passing the path of the excel
		fil = new ExcelDataConfig("C:\\Users\\Aravind Raj\\Documents\\TestData.xlsx");	
		
		//Used Page factory concept
		loginElements lo =PageFactory.initElements(driver, loginElements.class);
		
		//Used the fetched test data from excel and pass it to the method
		lo.loginTheApp(fil.getData(1, 0, 0), fil.getData(1, 0, 1));
		System.out.println("Credentials Passed");
	}
	
	@AfterTest
	public void tearDown() {
		System.out.println("Test Successful");
		//Browser close
		driver.quit();
	}

}

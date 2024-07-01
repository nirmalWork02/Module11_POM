package com.sauce.pageelements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class loginElements {
	
	WebDriver driver;
	
	//Create a constructor for webdriver
	public loginElements(WebDriver driver) {
		this.driver = driver;
	}
	
	//Finding the page elements by using findby
	
	@FindBy(how =How.XPATH, using="//input[@id='user-name']")
	@CacheLookup
	WebElement uName;
	
	@FindBy(how=How.XPATH, using="//*[@name='password']")
	WebElement passW;
	
	@FindBy(how=How.ID, using="login-button")
	WebElement submit;
	
	public void loginTheApp(String usrName, String passWord) {
		uName.sendKeys(usrName);
		passW.sendKeys(passWord);
		submit.click();
	}

}

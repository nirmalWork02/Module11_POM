package com.sauce.pageelements;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class InventoryElements {
	
WebDriver driver;
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	
	//Create a constructor for webdriver
	public InventoryElements(WebDriver driver) {
		this.driver = driver;
	}
	@FindBy(how=How.XPATH, using="//div[normalize-space()='Sauce Labs Backpack']")
	@CacheLookup
	WebElement item1;
	
	@FindBy(how=How.XPATH, using="//button[@id='react-burger-menu-btn']")
	@CacheLookup
	WebElement burgerMenu;
	
	@FindBy(how=How.XPATH, using="//a[contains(text(),'Logout')]")
	@CacheLookup
	WebElement btnLogout;
	
	public void selectTheProduct() {
		item1.click();
		String cUrl=driver.getCurrentUrl();
		String eUrl = "https://www.saucedemo.com/inventory-item.html?id=4";
		Assert.assertEquals(cUrl, eUrl,"Failed");
		System.out.println("Inventory item Url matched");
	}
	
	public void logOutBtn() {
		burgerMenu.click();
		wait.until(ExpectedConditions.elementToBeClickable(btnLogout));
		btnLogout.click();
		
	}
	
}

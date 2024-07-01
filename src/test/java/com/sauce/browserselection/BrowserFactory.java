package com.sauce.browserselection;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactory {
	
	static WebDriver driver;
	
	 public static WebDriver startBrowser(String browserName, String baseUrl) {
		 if(browserName.equalsIgnoreCase("chrome")) {
			 driver=new ChromeDriver();
		 }
		 else if (browserName.equals("chrome")){
				driver = new ChromeDriver();
				
			}
			
			driver.manage().window().maximize();
			driver.get(baseUrl);
			return driver;
	 }

}

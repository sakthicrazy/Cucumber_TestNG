package com.sauce.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class DriverManager 
{
public static WebDriver driver = null;
	

	
	public static WebDriver getDriver() {
		return driver;
	}
	
	public static WebDriver setDriver(WebDriver dir) {
	
				driver = dir;
				return  driver;
	}
	
	public static void setImplicitWait()
	{
		DriverManager.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public static void closeDriver(WebDriver driver) {
		driver.quit();
	}

}

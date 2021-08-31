package com.sauce.utils;

import java.io.File;
import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.cucumber.java.After;



public class BaseSteps{

	static WebDriver driver;
	static Logger logger = Logger.getLogger("GetLogger");
	public static Properties configProperty;

	public void initializeTheDriver() throws MalformedURLException {
		try {
			FileInputStream config = new FileInputStream(new File(System.getProperty("user.dir")+Constants.configFilePath));
			configProperty = new Properties();
			configProperty.load(config);


		} catch (Exception e) {
			e.printStackTrace();
		}


		driver = new DriverFactory().createDriverInstance(configProperty.getProperty("browserName"),configProperty.getProperty("baseUrl"));
		DriverManager.setDriver(driver);
		DriverManager.setImplicitWait();
	}

	/*
	 * This method used for enter value in text field
	 */

	public static void sendKeys(WebElement elem, String input) {
		try {
			elem.clear();
			elem.sendKeys(input);
		} catch (Exception e) {
			logger.error("Error in sendKeys:"+ e.getMessage());
		}
	}

	/*
	 * This method used for mouse hover to the element and click
	 */
	public static void mouseMoveAndClick(WebDriver driver, WebElement elem) {
		try {
			Actions action = new Actions(driver);
			action.moveToElement(elem).click().build().perform();
		} catch (Exception e) {
			logger.error("Error in mouseMoveAndClick:"+ e.getMessage());
		}
	}

	/*
	 *  This method used for element to be clickable
	 */
	public static void waitForElementToBeClickable(WebDriver driver, By by) {
		try {
			(new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(by));
		}
		catch (Exception e) {
			logger.error("The element was not clickable with in the wait time:" + e.getMessage());
		}
	}

	/*
	 * This method used for element to be visible
	 */

	public static void waitForElementToBeVisible(WebDriver driver, By by) {
		try {
			(new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOfElementLocated(by));
		}
		catch (Exception e) {
			logger.error("The element was not visible with in the wait time:"+ e.getMessage());
		}
	}

	/*
	 * This method used for element to be loaded
	 */

	public static void waitForElementToBeLoaded(WebDriver driver, By by) {
		try {
			(new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(by));
		}
		catch (Exception e) {
			logger.error("The element was not loaded with in the wait time:"+ e.getMessage());
		}
	}

	/*
	 * This method used for element is present or not
	 */

	public static boolean isElementPresent(WebDriver driver, By by){
		try{
			driver.findElement(by);
			return true;
		}
		catch(Exception e){
			logger.error("Element is Not Present:"+ e.getMessage());
			return false;
		}
	}

	/*
	 * this method used for element is enabled or not
	 */

	public static boolean isElementEnabled(WebDriver driver, By by) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		boolean val = false;
		try {
			if (driver.findElement(by).isEnabled() == true) {
				val = true;
			}
		} 
		catch (Exception e) {
			logger.error("Element is Not Enabled:"+ e.getMessage());
		} 
		return val;
	}

	/*
	 * This method used for element is displayed or not 
	 */

	public static boolean isElementDisplayed(WebDriver driver, By by) {

		BaseSteps.waitForElementToBeVisible(driver, by);

		boolean val = false;
		try {
			if (driver.findElement(by).isDisplayed() == true) {
				val = true;
			}
			else {
				val = false;
			} 
		} 
		catch (Exception e) {
			logger.error("Element is Not Displayed:"+ e.getMessage());
		} 
		return val;
	}

	/*
	 * This function is used to select value from drop down box based on visible text
	 */

	public static void selectFromDropDownByVisibleText(WebDriver driver, By by, String value) {

		try {

			BaseSteps.waitForElementToBeClickable(driver, by);

			driver.findElement(by).click();

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			Select sel = new Select(driver.findElement(by));

			sel.selectByVisibleText(value);

		} 
		catch (Exception e) {
			logger.error("Could not select value from dropdown by visible text:"+ e.getMessage());
		} 
	}

	/*
	 * this method used to select the dropdown value by using index
	 */

	public static void selectFromDropDownByIndex(By by, int value) {

		try {
			BaseSteps.waitForElementToBeClickable(driver, by);

			driver.findElement(by).click();

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			Select sel = new Select(driver.findElement(by));

			sel.selectByIndex(value);
		} 
		catch (Exception e) {
			logger.error("Could not select value from dropdown by index:"+ e.getMessage());
		} 
	}

	protected void teardownTheDriver() {

		try {
			DriverManager.closeDriver(DriverManager.getDriver());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}


}

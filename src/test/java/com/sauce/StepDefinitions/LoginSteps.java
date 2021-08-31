package com.sauce.StepDefinitions;

import java.net.MalformedURLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.sauce.pageObjects.HomePage;
import com.sauce.pageObjects.LoginPage;
import com.sauce.utils.BaseSteps;
import com.sauce.utils.DriverManager;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class LoginSteps extends BaseSteps{
	
	private static Logger logger = LogManager.getLogger(LoginSteps.class.getSimpleName());
	LoginPage LoginPage = new LoginPage();
	HomePage Homepage = new HomePage();
	String actualname;
	
    @Given("^Login into the sites$")
    public void loginIntoTheSites() throws MalformedURLException {
    	try {
			initializeTheDriver();
			LoginPage.enterUsername(configProperty.getProperty("username"));
			LoginPage.enterPassword(configProperty.getProperty("password"));
			LoginPage.clickSubmit();
			logger.info("Logged into application");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error occured in logintoApplicationFunction");
			Assert.fail("Error occured in logging into Application Function");
		}

    }

    @Then("^Add the product to the cart$")
    public void addTheProductToTheCart() {
    	try {
			actualname = DriverManager.getDriver().findElements(Homepage.ProductNames).get(0).getText();
			DriverManager.getDriver().findElements(Homepage.AddToCart).get(0).click();
			logger.info("Product Added to Cart");
		} catch (Exception e) {
			logger.error("Product Not Added to the Cart");
		}
    }

    @And("^Checkout and validate the product details whether you are ordered the correct product$")
    public void checkoutAndValidateTheProductDetailsWhetherYouAreOrderedTheCorrectProduct() throws InterruptedException {
    	try {
			DriverManager.getDriver().findElement(HomePage.ShoppingCart).click();
			String expectedName = DriverManager.getDriver().findElement(Homepage.ProductNames).getText();
			Assert.assertEquals(actualname, expectedName);
			logger.info("Ordered the correct Product");
			Assert.assertTrue(true);
			DriverManager.closeDriver(DriverManager.getDriver());
		} catch (Exception e) {
			
			logger.error("Ordered Product is incorrect");
			Assert.assertTrue(false);
		}
    }


}

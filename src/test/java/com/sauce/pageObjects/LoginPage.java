package com.sauce.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.sauce.utils.BaseSteps;
import com.sauce.utils.DriverManager;

public class LoginPage extends BaseSteps{

	


    public void enterUsername(String strUsername){
        DriverManager.getDriver().findElement(By.id("user-name")).sendKeys(strUsername);
    }

    public void enterPassword(String strPassword){
    	DriverManager.getDriver().findElement(By.id("password")).sendKeys(strPassword);
    }

    public void clickSubmit(){
    	DriverManager.getDriver().findElement(By.id("login-button")).click();
    }

    public void verifyTitle(String title){
        Assert.assertTrue(DriverManager.getDriver().getTitle().equals(title));
    }

}

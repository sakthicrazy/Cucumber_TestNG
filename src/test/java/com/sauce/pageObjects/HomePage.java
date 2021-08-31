package com.sauce.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.sauce.utils.BaseSteps;
import com.sauce.utils.DriverManager;

public class HomePage extends BaseSteps {


	 public By AddToCart = By.xpath("//button[text()='Add to cart']");
	 public By ProductNames = By.xpath("//div[@class='inventory_item_name']");
	 public static By ShoppingCart = By.xpath("//div[@id='shopping_cart_container']//span"); 

	 
//	    public static void validateProduct(String productName){
//	    	List<WebElement> itemNames = DriverManager.getDriver().findElements(By.xpath("//div[@class='inventory_list']//div[@class='inventory_item_name']"));
//	    	for(WebElement itemName:itemNames) {
//	    		String text = itemName.getText();
//	    		if(text.equalsIgnoreCase(productName)) {
//	    			DriverManager.getDriver().findElement(By.xpath("//div[@class='inventory_list']//div[text()='" + productName + "']/ancestor::div[@class='inventory_list']//div[@class='pricebar']//button"));
//	    		}
//	    	}
//	    }
	    
	    
}

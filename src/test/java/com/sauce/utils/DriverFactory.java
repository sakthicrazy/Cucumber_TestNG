package com.sauce.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import io.github.bonigarcia.wdm.WebDriverManager;



public class DriverFactory 
{
	public WebDriver createDriverInstance(String browserName,String url) 
	{

		WebDriver driver = null;

		if(browserName.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options=new FirefoxOptions();
			options.addArguments("--disable-notifications");
			driver=new FirefoxDriver(options);

		}else if(browserName.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			//disbaling the notification alert popup
			options.addArguments("--disable-notifications");
			driver = new ChromeDriver(options);
		}else if(browserName.equalsIgnoreCase("opera"))
		{
			WebDriverManager.operadriver().setup();
			OperaOptions options = new OperaOptions();
			//disbaling the notification alert popup
			options.addArguments("--disable-notifications");
			driver = new OperaDriver(options);

		}else if(browserName.equalsIgnoreCase("edge")){
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			
		}

		driver.manage().window().maximize();
		driver.get(url);
		return driver;

	}
		
	


}

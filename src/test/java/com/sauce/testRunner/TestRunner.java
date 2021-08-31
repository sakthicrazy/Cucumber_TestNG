package com.sauce.testRunner;

import org.testng.annotations.BeforeSuite;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions; 


@CucumberOptions( features = {"src/test/resources/features"},
glue = {"com.sauce.StepDefinitions"},
		dryRun=false,
		monochrome=true,
		//plugin = {"pretty", "io.qameta.allure.cucumber5jvm.AllureCucumber5Jvm"},
tags = "@web")

public class TestRunner extends AbstractTestNGCucumberTests{
	
	@BeforeSuite
	public  void setup() {
		
		}

}

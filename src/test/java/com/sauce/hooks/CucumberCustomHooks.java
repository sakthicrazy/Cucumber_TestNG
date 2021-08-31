package com.sauce.hooks;

import com.sauce.utils.BaseSteps;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class CucumberCustomHooks extends BaseSteps{

	
	@Before
	public void initiateFramework() {
		System.out.println("Started Running...");
		
	}
	
	@After
	public void teardown() {
		System.out.println("Closing the driver...");

	}
	
}

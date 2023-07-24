package com.stepdefinition;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.base.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class HooksClass extends BaseClass {

	@Before
	public void beforeScenario() throws FileNotFoundException, IOException {
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		getDriver(getPropertyFileValue("browserName"));
		launchURL(getPropertyFileValue("url"));
		maximizeWindow();
	}

	@After
	public void afterScenario(Scenario scenario) {
		scenario.attach(cucumberScreenShot(), "images/png", "Every Scenario");
		driver.quit();
	}

}

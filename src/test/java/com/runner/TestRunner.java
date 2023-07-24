package com.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(tags = "", monochrome = true, dryRun = false, publish = true,
					features = {"src\\test\\resources\\FeatureFiles"}, glue = {"com.stepdefinition"},
					 stepNotifications = true, plugin = {"pretty"})
public class TestRunner {

}

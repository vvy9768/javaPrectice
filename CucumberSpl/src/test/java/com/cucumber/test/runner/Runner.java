package com.cucumber.test.runner;

import org.junit.runner.RunWith;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", glue = { "com/cucumber/test/stepdefinations",
		"com/cucumber/page/base" }, tags = "", monochrome = true, plugin = { "pretty",
				"html:" + "target/Destination"})
public class Runner {
	
	
}
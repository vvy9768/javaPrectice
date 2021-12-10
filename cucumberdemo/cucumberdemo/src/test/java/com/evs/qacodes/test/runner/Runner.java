package com.evs.qacodes.test.runner;

import org.junit.runner.RunWith;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/feature", glue = { "com/evs/qacodes/stepdefination",
		"com.evs.qacodes.pages.base" }, tags = "", monochrome = true, plugin = { "pretty",
				"html:" + "target/Destination"})
public class Runner {

	
	
	
}
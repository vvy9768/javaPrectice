package classes;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;




@RunWith(Cucumber.class)
@CucumberOptions(features = "DemoCucumber/src/main/java/pages",glue= {"src/main/java/classes"},
				 tags = "", monochrome = true, plugin = { "pretty",
							"html:" + "target/Destination"})
	
		




public class TestRunner {

}

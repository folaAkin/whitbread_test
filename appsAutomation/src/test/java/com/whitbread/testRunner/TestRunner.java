package com.whitbread.testRunner;



import org.junit.runner.RunWith;



import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty", "html:target/site/cucumber-pretty",
		"json:target/cucumber.json","com.cucumber.listener.ExtentCucumberFormatter:output/report.html" }, 
glue = { "com.whitebread.apps.stepDefs" }, strict = false,
		features = "src/test/resources", 
		tags = {} 
																										
																										
																										
)

public class TestRunner {
	
	

	

}

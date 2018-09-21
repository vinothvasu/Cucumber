package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/featureFiles/dryRun.feature",
glue="testCases", monochrome=true,plugin= {"html:reports/cucumber","json:reports/cucumber.json"})
public class plugin_RunCuck {
	

}
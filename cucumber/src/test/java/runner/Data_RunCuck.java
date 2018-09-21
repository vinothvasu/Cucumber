package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="./src/test/resources/featureFiles/LoginData.feature",
glue="testCases", monochrome=true)
public class Data_RunCuck {
	

}

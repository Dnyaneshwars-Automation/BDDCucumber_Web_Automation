package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(
		dryRun=false,
		monochrome=true,
		features="src/test/resources/Features",
		glue={"stepdefination","hooks"},
		tags= ("@DiscountSearchDate"),
		plugin= {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		)


public class TestRunner {

}
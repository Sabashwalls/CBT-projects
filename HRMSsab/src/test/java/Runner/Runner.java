package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = {".//Feature/Loginpage.feature"}, 
		glue = "Stepdefiniction",
		plugin = {"pretty",
				//"html:reports/myreport.html",
				"html:target/cucumber-reports/report.html"},
		monochrome = true,
		dryRun=false
		)

public class Runner {
	
}

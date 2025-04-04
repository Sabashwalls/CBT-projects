package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {".//Feature/Codeboard.feature"}, 
		glue = "Stepdefiniction",
		plugin = {"pretty", "json:reports/myreport.json", "html:reports/myreport.html"},
		monochrome = true,
		dryRun=false//,
		//tags = "@smoke123"
		)
public class Runner {
}
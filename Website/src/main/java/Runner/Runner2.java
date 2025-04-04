package Runner;

import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;

import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)
@CucumberOptions(
		features = {".//Feature/Codeboard.feature"}, 
		glue = "Stepdefiniction",
		plugin = {"pretty", "json:reports/myreport.json", "html:reports/myreport.html"},
		monochrome = true,
		dryRun=false,
		tags = "@Parallel"
		)
public class Runner2 extends AbstractTestNGCucumberTests{
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios(){
		return super.scenarios();
	}
}
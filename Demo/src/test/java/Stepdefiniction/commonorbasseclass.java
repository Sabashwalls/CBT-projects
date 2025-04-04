package Stepdefiniction;

import org.apache.hc.core5.reactor.Command;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.apache.logging.log4j.Logger;

import com.lao.constant.constant;

import Utilities.Commonutiles;
import Webdrivermanager.Webdrivermanager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import pageobjectmomdel.Loginpage;

public class commonorbasseclass {
	
	//WebDriver driver = Webdrivermanager.getDriver(); //--> added line
	
	private static final Logger LOGGER = LogManager.getLogger(commonorbasseclass.class);
	
	private static String Scenarioname=null;
	
	public static String getScenarioname() {
		return Scenarioname;
	}

	@Before
	public void beforescenario(Scenario Scenario) {
		
		LOGGER.info("execution start");
		try {
			
			Scenarioname=Scenario.getName();
			Commonutiles.getinstance().loadproperties();
			if (Webdrivermanager.getDriver()==null) {
				Webdrivermanager.launchbrowser();
				Commonutiles.getinstance().initwebelements();
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@After
	public void afterscenario() {
		Webdrivermanager.getDriver().close();
		
	}
}

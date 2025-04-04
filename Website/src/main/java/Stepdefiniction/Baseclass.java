package Stepdefiniction;
import Utilities.Commonutilities;
import Webdrivermanager.Webdrivermanager;
import io.cucumber.java.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {

	private static String Scenarioname=null;

	public static String getScenarioname() {
		return Scenarioname;
	}
	@Before
	public void Before(Scenario Scenario) {
		try {
			Scenarioname=Scenario.getName();
			//Commonutilities.getinstance().loadproperties();
			if (Webdrivermanager.getDriver()==null) {
				Webdrivermanager.launchbrowser();
				Commonutilities.getinstance().initelements();
			}
		} catch (Exception e) {
			e.getMessage();
			System.out.println(e);
		}
	}
	@After
	public void After() {
		if (Webdrivermanager.getDriver() != null) {
			Webdrivermanager.getDriver().quit();
			Webdrivermanager.setDriverNull();	
		}
	}
}

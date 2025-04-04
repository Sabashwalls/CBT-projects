package Stepdefiniction;
import Utilities.Commonutils;
import Webdrivermanager.Webdrivermanager;
import io.cucumber.java.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {

	
	@Before
	public void Before() {
		
		try {
			
			Commonutils.getinstance().loadproperties();
			if (Webdrivermanager.getDriver()==null) {
				Webdrivermanager.launchbrowser();
				Commonutils.getinstance().initelements();
			}
		} catch (Exception e) {
			e.printStackTrace();
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

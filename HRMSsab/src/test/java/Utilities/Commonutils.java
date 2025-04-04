package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;

import Contatnt.Constant;
import Pageobjectmodule.LoginpageHRMSElement;
import Webdrivermanager.Webdrivermanager;

public class Commonutils {
	
	private static Commonutils commoninstance=null;
	
	private Commonutils() {
		
	}
	
	public static Commonutils getinstance() {
		
		if (commoninstance==null) {
			commoninstance= new Commonutils();
		}
		return commoninstance;
	}


	public void loadproperties() {

		Properties prop = new Properties();
		
		try {
			
			prop.load(getClass().getResourceAsStream("/config.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Constant.url= prop.getProperty("APP_URL");
		Constant.browser=prop.getProperty("Browser");
		Constant.username=prop.getProperty("Username");
		Constant.password=prop.getProperty("Password");
		Constant.invalidusername=prop.getProperty("invalidusername");
		Constant.invalidpassword=prop.getProperty("invlaidpassword");
	}
	
	
	public void initelements() {
		PageFactory.initElements(Webdrivermanager.getDriver(), LoginpageHRMSElement.getinstance());
		
	}
	
	public static void screenshot() {
		
		File screenshot = ((TakesScreenshot)Webdrivermanager.getDriver()).getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(screenshot, new File(".//screenshot/screenshot.png"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}

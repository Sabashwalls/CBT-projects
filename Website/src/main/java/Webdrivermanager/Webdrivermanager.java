package Webdrivermanager;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import Utilities.Commonutilities;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Webdrivermanager {
	
private static WebDriver driver;

	
public static void launchbrowser() {
	
		try {
			
			switch (Commonutilities.readExcelData("Browser").get(0).get(0)) {
			case "chrome":
				ChromeOptions options = new ChromeOptions();
//				options.setExperimentalOption("prefs", 
//			            "{\"download.default_directory\":\"C:\\\\Users\\\\CBT\\\\Downloads\",\"download.prompt_for_download\":true}");
//				options.addArguments("--no-proxy-server");
//				options.addArguments("--headless");
//		        options.addArguments("--disable-extensions");
//		        options.addArguments("--disable-browser-side-navigation");
//		        options.addArguments("--disable-gpu");
//		        options.addArguments("--safebrowsing-disable-download-protection");
//		        options.addArguments("--allow-running-insecure-content");
		        options.addArguments("--disable-features=InsecureDownloads");
//		        options.setExperimentalOption("prefs", "{\"download.default_directory\": \"C:\\\\Users\\\\CBT\\\\Downloads\\\"}");
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver(options);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
				driver.manage().window().maximize();
				break;
			case "edge":
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
				driver.manage().window().maximize();
				break;
			default:
				driver = new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				driver.manage().window().maximize();
				break;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

public static  WebDriver getDriver() {
	return driver;
}

public static  WebDriver setDriverNull() {
	return driver=null;
}



}
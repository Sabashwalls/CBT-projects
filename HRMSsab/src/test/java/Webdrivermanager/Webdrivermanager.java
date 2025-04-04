package Webdrivermanager;

import java.time.Duration;

//import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

//import com.lao.constant.constant;

import Contatnt.Constant;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Webdrivermanager {
	
	private static WebDriver driver;
		
	
public static void launchbrowser() {
		
		try {
			switch (Constant.browser) {
			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
				break;
			case "Edge":
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
				break;
			default:
				driver = new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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

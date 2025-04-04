package Framework;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClassFRM {

	static {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
	}
	static WebDriver sabash;
	static FileInputStream data;
	static Properties pro;
	static String url,un,pass,invalid;
	static Timeouts timeout;

	//@BeforeClass
	@BeforeSuite
	public void Openbrowser() throws IOException, InterruptedException {


		data = new FileInputStream("./Datafile/Shoppersstack DDF.txt");
		pro = new Properties();
		pro.load(data);

		url = pro.getProperty("URL");
		un = pro.getProperty("Usern");
		pass = pro.getProperty("Password");
		invalid = pro.getProperty("invalid");
		
		/*ChromeOptions options = new ChromeOptions();
		HashMap<String, Integer> timeouts = new HashMap<String, Integer>();
		timeouts.put("script", 10000);
		options.setCapability("timeouts", timeouts);*/
		
		sabash= new ChromeDr
		timeout = sabash.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		sabash.manage().window().maximize();
		sabash.get(url);
		Thread.sleep(7000);
		sabash.findElement(By.xpath("(//button)[1]")).click();
		sabash.findElement(By.id("Email")).sendKeys(un);
		sabash.findElement(By.id("Password")).sendKeys(pass);
		sabash.findElement(By.id("Login")).click();
	}
	
	//@AfterClass
	@AfterSuite
	public void Closebrowser() throws InterruptedException {
		
		//timeout.implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(5000);
		sabash.findElement(By.xpath("(//button[@type='button'])[1]")).click();
		sabash.findElement(By.xpath("//li[text()='Logout']"));
		sabash.close();
	}
}
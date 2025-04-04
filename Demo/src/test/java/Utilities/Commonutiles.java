package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.checkerframework.common.reflection.qual.GetClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.lao.constant.constant;

import Stepdefiniction.commonorbasseclass;
import Webdrivermanager.Webdrivermanager;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjectmomdel.Loginpage;

public class Commonutiles {
	
	private static Commonutiles commoninstance=null;
	
	private Commonutiles () {
		
	}
	
	public static Commonutiles getinstance() {
		
		if (commoninstance==null) {
			commoninstance = new Commonutiles();
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
		
		constant.url=prop.getProperty("APP_URL");
		constant.brower=prop.getProperty("BROWSER");
		
	}
	
	public void initwebelements() {
		PageFactory.initElements(Webdrivermanager.getDriver(), Loginpage.getinstance());
	}
	
	public void takescreenshot() {
		
		File screenshot =((TakesScreenshot)Webdrivermanager.getDriver()).getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(screenshot, new File(commonorbasseclass.getScenarioname()+".png"));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void elementhighlight(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor)Webdrivermanager.getDriver();
		executor.executeScript("arguments[0].setAttributes('Style','Border: 3px solid red');", element);
		
	}
	
	public void selectformdropdown(WebElement element1, WebElement element2, String option, String Value) {
		
			Select select = new Select(element1);
			Select select1 = new Select(element2);
		switch (option) {
		case "text":
			select.selectByVisibleText(Value);
			break;
		case "index":
			select.selectByIndex(Integer.parseInt(Value));
			break;
		case "value":
			select.selectByValue(Value);
			break;
		default:
			System.out.println("Please select the text,value,text");
			break;
		}
	}
	
	
	public static List<List<String>> readexcel(String sheet) throws IOException{
		
		List<List<String>> exceldata= new ArrayList<>();
		
		FileInputStream fis = new FileInputStream("filepath");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
//		Sheet sheets=workbook.getSheet(sheet);
//		
		
		return exceldata;
	}

}

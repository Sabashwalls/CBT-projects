package Utilities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pageobjectmodule.CodeboardtechElements;
import Resourcespackage.Excelnames;
import Stepdefiniction.Baseclass;
import Webdrivermanager.Webdrivermanager;

public class Commonutilities {
	
	private static Commonutilities Commonutilities=null;

	private Commonutilities() {

	}

	public static Commonutilities getinstance() {

		if (Commonutilities==null) {
			Commonutilities= new Commonutilities();
		}
		return Commonutilities;
	}
	
	public void initelements() {
		PageFactory.initElements(Webdrivermanager.getDriver(), CodeboardtechElements.getprojectinstance());
	}
	
	public static void screenshot() {

		File screenshot = ((TakesScreenshot)Webdrivermanager.getDriver()).getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(screenshot, new File(Baseclass.getScenarioname()+".png"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	
	public static List<List<String>> readExcelData(String sheetName) throws IOException {
		List<List<String>> excelData = new ArrayList<>();
		FileInputStream fis = new FileInputStream(".//Datafile/Website.xlsx");
		Workbook workbook = new XSSFWorkbook(fis);
		Sheet sheet = workbook.getSheet(sheetName);

		for (Row row : sheet) {
			List<String> rowData = new ArrayList<>();
			for (Cell cell : row) {
				rowData.add(getCellValue(cell));
			}
			excelData.add(rowData);
		}

		workbook.close();
		fis.close();
		return excelData;
	}

	public static String getCellValue(Cell cell) {
		switch (cell.getCellType()) {
		case STRING:
			return cell.getStringCellValue();
		case NUMERIC:
			double numericValue = cell.getNumericCellValue();
            if (numericValue == (int) numericValue) {
                return String.valueOf((int) numericValue);
            } else {
                return String.valueOf(numericValue);
            }
		case BOOLEAN:
			return String.valueOf(cell.getBooleanCellValue());
		case BLANK:
			return "";
		default:
			return "";
		}
	}
	
	public static void waitforelement(WebElement webElement) {
		WebDriverWait wait = new WebDriverWait(Webdrivermanager.getDriver(), Duration.ofSeconds(7));
		wait.until(ExpectedConditions.presenceOfElementLocated((By) webElement));
	}
	
	public static void Dynamicscrolldown(int scrollrange) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) Webdrivermanager.getDriver();
			js.executeScript("window.scrollBy(0, "+scrollrange+");");
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	
	public static void navigatesuccessfullornot(String str) {
		try {
			Thread.sleep(3000);
			String user = Webdrivermanager.getDriver().getCurrentUrl();
			System.err.println(user);
			if (user.contains(str)) {
				System.err.println("The user is navigate to "+ str +" page");
			}else {
				System.err.println("The user is not navigate to "+ str +" page");
				fail();
			}
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	
	
	public static void HeadingPicandContextvalidatorincasestudies(String str) {
		try {	
	    	String actual1 = CodeboardtechElements.getHeadingcontent().getText();
			System.err.println(actual1);
			String Expected1 = Commonutilities.readExcelData(str).get(0).get(0);
			System.err.println(Expected1);
			assertEquals(actual1,Expected1);
			
			String actual2 = CodeboardtechElements.getIframecontent().getText();
			System.out.println(actual2);
			String Expected2 = Commonutilities.readExcelData(str).get(0).get(1);
			System.err.println(Expected2);
			assertEquals(actual2,Expected2);
			
			String actual3 = CodeboardtechElements.getImageincasestudies().getAttribute("src");
			System.err.println(actual3);
			String Expected3 = Commonutilities.readExcelData(str).get(0).get(2);
			assertEquals(actual3,Expected3);
			
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	
	public static void switchtoIDframe() {
		Webdrivermanager.getDriver().switchTo().frame(CodeboardtechElements.getIDframe());
	}
	
	public static void Headingcontentonpage(String Str) {
		try {
			String use = CodeboardtechElements.getHeadingcontent().getText();
			System.err.println(use);
			String used = Commonutilities.readExcelData(Str).get(0).get(0);
			System.err.println(used);
			assertEquals(use,used);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
		
	}
	
	public static void Headingcontentwith00(String str) {
		try {
			String Actual = CodeboardtechElements.getHeadingcontent().getText();
			System.err.println(Actual);
			String Expected = Commonutilities.readExcelData(str).get(0).get(0);
			System.err.println(Expected);
			assertEquals(Actual,Expected);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	
	public static void Headingcontentwith01(String str) {
		try {
			String Actual = CodeboardtechElements.getHeadingcontent().getText();
			System.err.println(Actual);
			String Expected = Commonutilities.readExcelData(str).get(0).get(1);
			System.err.println(Expected);
			assertEquals(Actual,Expected);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	
	public static void Bodycontent101(String str) {
		try {
			String Actual = CodeboardtechElements.getBodycontent1().getText();
			System.err.println(Actual);
			String Expected = Commonutilities.readExcelData(str).get(0).get(1);
			System.err.println(Expected);
			assertEquals(Actual,Expected);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	
	public static void Bodycontent102(String str) {
		try {
			String Actual = CodeboardtechElements.getBodycontent1().getText();
			System.err.println(Actual);
			String Expected = Commonutilities.readExcelData(str).get(0).get(2);
			System.err.println(Expected);
			assertEquals(Actual,Expected);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	
	public static void Bodycontent100(String str) {
		try {
			String Actual = CodeboardtechElements.getBodycontent1().getText();
			System.err.println(Actual);
			String Expected = Commonutilities.readExcelData(str).get(0).get(0);
			System.err.println(Expected);
			assertEquals(Actual,Expected);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	
	public static void Bodycontent110(String str) {
		try {
			String Actual = CodeboardtechElements.getBodycontent1().getText();
			System.err.println(Actual);
			String Expected = Commonutilities.readExcelData(str).get(1).get(0);
			System.err.println(Expected);
			assertEquals(Actual,Expected);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	
	public static void Bodycontent201(String str) {
		try {
			String Actual = CodeboardtechElements.getBodycontent2().getText();
			System.err.println(Actual);
			String Expected = Commonutilities.readExcelData(str).get(0).get(1);
			System.err.println(Expected);
			assertEquals(Actual,Expected);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	
	public static void Bodycontent210(String str) {
		try {
			String Actual = CodeboardtechElements.getBodycontent2().getText();
			System.err.println(Actual);
			String Expected = Commonutilities.readExcelData(str).get(1).get(0);
			System.err.println(Expected);
			assertEquals(Actual,Expected);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	
	public static void Bodycontent200(String str) {
		try {
			String Actual = CodeboardtechElements.getBodycontent2().getText();
			System.err.println(Actual);
			String Expected = Commonutilities.readExcelData(str).get(0).get(0);
			System.err.println(Expected);
			assertEquals(Actual,Expected);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	
	public static void Image02(String str) {
		try {
			String Actual = CodeboardtechElements.getImage().getAttribute("src");
			System.err.println(Actual);
			String Expected = Commonutilities.readExcelData(str).get(0).get(2);
			assertEquals(Actual,Expected);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	
	public static void Image01(String str) {
		try {
			String Actual = CodeboardtechElements.getImage().getAttribute("src");
			System.err.println(Actual);
			String Expected = Commonutilities.readExcelData(str).get(0).get(1);
			assertEquals(Actual,Expected);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	
	public static void Image202(String str) {
		try {
			String Actual = CodeboardtechElements.getImage2().getAttribute("src");
			System.err.println(Actual);
			String Expected = Commonutilities.readExcelData(str).get(0).get(2);
			assertEquals(Actual,Expected);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	
	public static void Image201(String str) {
		try {
			String Actual = CodeboardtechElements.getImage2().getAttribute("src");
			System.err.println(Actual);
			String Expected = Commonutilities.readExcelData(str).get(0).get(1);
			assertEquals(Actual,Expected);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}

	public static void Dynamicscrollandsubmodules(int scroll,int count) {
		try {
			Commonutilities.Dynamicscrolldown(scroll);
			Thread.sleep(1000);
			CodeboardtechElements.getsubmodulescount(count).click();
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	
	public static void MicrosericeContainer(String src) {
		try {
			String s12 = CodeboardtechElements.getMicrosercontainer().getText();
			System.err.println(s12);
			String sss12 = Commonutilities.readExcelData(src).get(0).get(1);
			System.err.println(sss12);
			assertEquals(s12,sss12);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	
	public static void Relaventcontentisshowing(String src) {
		try {
			String use2 = CodeboardtechElements.getPictures().getAttribute("src");
			System.err.println(use2);
			String used23 = Commonutilities.readExcelData(src).get(0).get(1);
			System.err.println(used23);
			assertEquals(use2,used23);
			System.err.println("all relevant pictures are displaying");
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	
	public static void Dynamictextcontent(String src) {
		try {
			int i=0;
			for (WebElement element : CodeboardtechElements.getDynamiccontent()) {
				String s12 = element.getText();
				System.err.println(s12);
				String sss12 = Commonutilities.readExcelData(src).get(i).get(0);
				System.err.println(sss12);
				assertEquals(s12,sss12);
				i++;
			}
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	
	public static void Multiplewrongcontainer(String src) {
		try {
			int i=1;
			for (WebElement element : CodeboardtechElements.getMultiplewrongcontainer()) {
				String data = element.getText();
				System.err.println(data);
				String data1 = Commonutilities.readExcelData(Excelnames.TestingandServices).get(i).get(0);
				System.err.println(data1);
				i++;
			}
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
}

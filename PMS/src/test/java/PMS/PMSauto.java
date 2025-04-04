package PMS;

import java.awt.Robot;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.Select;

import ch.qos.logback.core.recovery.ResilientSyslogOutputStream;
import io.cucumber.java.it.Date;

public class PMSauto {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		try {

			String Value = readExcelData("PMSData1").get(0).get(6);
			double doubleValue = Double.parseDouble(Value);
			int Totaldate = (int) doubleValue;
			System.out.println(Totaldate); 

			

			driver.get("https://www.pms.codeboardtech.com/projects");
			driver.findElement(By.xpath("//div[@class='button-login-text']")).click();
			driver.findElement(By.xpath("//input[@name='loginfmt']")).sendKeys(readExcelData("Logindata").get(1).get(0));
			driver.findElement(By.xpath("//input[@name='loginfmt']")).sendKeys(Keys.ENTER);
			driver.findElement(By.id("i0118")).sendKeys(readExcelData("Logindata").get(1).get(1));
//			Thread.sleep(2000);
//			driver.findElement(By.id("i0118")).sendKeys(Keys.ENTER);
			
//			try {
//				if (driver.findElement(By.xpath("//div[@id='passwordError']")).isDisplayed()) {
//					driver.findElement(By.id("i0118")).sendKeys(readExcelData("Logindata").get(1).get(1));
//					Thread.sleep(2000);
//					driver.findElement(By.id("i0118")).sendKeys(Keys.ENTER);
//				}
//			} catch (Exception e) {
//				driver.findElement(By.id("i0118")).sendKeys(readExcelData("Logindata").get(1).get(1));
//				Thread.sleep(2000);
//				driver.findElement(By.id("i0118")).sendKeys(Keys.ENTER);
//			}
			Thread.sleep(1400);
			driver.findElement(By.id("i0118")).sendKeys(Keys.ENTER);
			driver.findElement(By.xpath("//input[@id='idSIButton9']")).click();
			driver.findElement(By.xpath("//a[text()='Spent time' and @class='time-entries']")).click();
			// select the log time///
			driver.findElement(By.xpath("//a[text()='Log time' and @class='icon icon-time-add']")).click();

int Totalcolumn = 0;

			for (int i = 1; i < Totaldate; i++) {
				for (int k = 1; k <= 2; k++) {
					String Value1 = readExcelData("PMSData"+k).get(1).get(6);
					double doubleValue1 = Double.parseDouble(Value1);
					Totalcolumn = (int) doubleValue1;
					System.out.println(Totalcolumn);	
					for (int j = 0; j < Totalcolumn; j++) {
						Select se = new Select(driver.findElement(By.xpath("//select[@id='time_entry_project_id']")));
						se.selectByVisibleText(readExcelData("PMSData"+k).get(j+1).get(0));
						driver.findElement(By.xpath("//input[@id='time_entry_spent_on']")).sendKeys(readExcelData("PMSData"+k).get(j+1).get(1));
						driver.findElement(By.xpath("//input[@id='time_entry_hours']")).sendKeys(readExcelData("PMSData"+k).get(j+1).get(2));
						driver.findElement(By.xpath("//input[@id='time_entry_comments']")).sendKeys(readExcelData("PMSData"+k).get(j+1).get(3));
						driver.findElement(By.xpath("//select[@id='time_entry_activity_id']")).sendKeys(readExcelData("PMSData"+k).get(j+1).get(4));
						driver.findElement(By.xpath("//input[@id='time_entry_custom_field_values_4']")).sendKeys(readExcelData("PMSData"+k).get(j+1).get(2));
						driver.findElement(By.xpath("//input[@value='Create and add another']")).click();
						Thread.sleep(2000);
					}
				}
				
			}	
			//			////click  the create button
			//			driver.findElement(By.xpath("//input[@value='Create']")).click();		
			

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}





































	public static Workbook workbook;

	public static List<List<String>> readExcelData(String sheetName) throws IOException {
		List<List<String>> excelData = new ArrayList<>();
		FileInputStream fis = new FileInputStream(".//Datafolder/PMSData.xlsx");
		workbook = new XSSFWorkbook(fis);
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
	            if (DateUtil.isCellDateFormatted(cell)) {
	                java.util.Date date = cell.getDateCellValue();
	                SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	                return dateFormat.format(date);
	            } else {
	                return String.valueOf(cell.getNumericCellValue());
	            }
	        case BOOLEAN:
	            return String.valueOf(cell.getBooleanCellValue());
	        case BLANK:
	            return "";
	        case FORMULA:
	            FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
	            CellValue cellValue = evaluator.evaluate(cell);
	            switch (cellValue.getCellType()) {
	                case STRING:
	                    return cellValue.getStringValue();
	                case NUMERIC:
	                    if (DateUtil.isCellDateFormatted(cell)) {
	                        java.util.Date date = cell.getDateCellValue();
	                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	                        return dateFormat.format(date);
	                    } else {
	                        return String.valueOf(cellValue.getNumberValue());
	                    }
	                case BOOLEAN:
	                    return String.valueOf(cellValue.getBooleanValue());
	                default:
	                    return "";
	            }
	        default:
	            return "";
	    }
	}}

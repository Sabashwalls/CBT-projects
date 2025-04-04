package DemoforICON;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelReader {

    public static List<List<String>> readExcelData(String sheetName) throws IOException {
        List<List<String>> excelData = new ArrayList<>();
        FileInputStream fis = new FileInputStream(".//Data/Book1.xlsx");
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
                return String.valueOf(cell.getNumericCellValue());
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case BLANK:
                return "";
            default:
                return "";
        }
    }
    
    public static void main(String[] args) throws IOException {
    	String ser = readExcelData("Sheet1").get(1).get(1).toString();
    	System.out.println(ser);
//    	System.out.println(ser.get(1).get(0));
//    	System.out.println(ser.get(1).get(1));
		}
	}

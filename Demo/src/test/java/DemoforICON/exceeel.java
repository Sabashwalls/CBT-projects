package DemoforICON;
	 
	import java.io.File;
	import java.io.IOException;
	import java.util.ArrayList;
	import java.util.LinkedHashMap;
	import java.util.List;
	import java.util.Map;
	 
	import org.apache.poi.ss.usermodel.Cell;
	import org.apache.poi.ss.usermodel.CellType;
	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.ss.usermodel.Sheet;
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.ss.usermodel.WorkbookFactory;
	import com.fasterxml.jackson.databind.exc.InvalidFormatException;
	 
	public class exceeel {
	 
		public static int totalRow;
		public static String excelFilePath;
	 
		public static List<Map<String, String>> getData(String sheetName) throws InvalidFormatException, IOException {
	 
			excelFilePath = ".//Data/Book1.xlsx";
			Workbook workbook = WorkbookFactory.create(new File(excelFilePath));
			Sheet sheet = workbook.getSheet(sheetName);
			workbook.close();
			return readSheet(sheet);
		}
	 
		
		
		
		
		public static List<Map<String, String>> readSheet(Sheet sheet) {
	 
			totalRow = sheet.getLastRowNum();
	 
			List<Map<String, String>> excelRows = new ArrayList<>();
			LinkedHashMap<String, String> columnMapdata = new LinkedHashMap<>();
			
			for (int currentRow = 1; currentRow <= totalRow; currentRow++) {
				Row row = sheet.getRow(currentRow);
	 
				if (row != null) {
					int totalColumn = row.getLastCellNum();
					
					
	 
					for (int currentColumn = 0; currentColumn < totalColumn; currentColumn++) {
						Cell cell = row.getCell(currentColumn);
	 
						String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(currentColumn)
								.getStringCellValue();
	 
						String cellValue = "";
						if (cell != null) {
							if (cell.getCellType() == CellType.STRING) {
								cellValue = cell.getStringCellValue();
							} else if (cell.getCellType() == CellType.NUMERIC) {
								cellValue = String.valueOf(cell.getNumericCellValue());
							} else if (cell.getCellType() == CellType.BOOLEAN) {
								cellValue = String.valueOf(cell.getBooleanCellValue());
							} else if (cell.getCellType() == CellType.BLANK) {
								cellValue = "";
							}
						}
						columnMapdata.put(columnHeaderName, cellValue);
					}
					excelRows.add(columnMapdata);
				}
			}
			return excelRows;
		}
	 
		
		
		
		public int countRow() {
	 
			return totalRow;
		}
		
		public static void main(String[] args) throws InvalidFormatException, IOException {
		List<Map<String, String>> ring = getData("Sheet1");
		System.out.println(ring);
		}
	 
	}

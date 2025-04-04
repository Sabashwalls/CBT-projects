package DemoforICON;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.*;

public class ExcelDataReader {

    public static String exceldatas(String sheetname, int rownumber, int columnumber) throws EncryptedDocumentException, IOException {
       
         // Load the Excel file
            FileInputStream file = new FileInputStream("./Data/Datafile.xlsx");
            Workbook workbook = WorkbookFactory.create(file);
            Sheet sheet1 = workbook.getSheet(sheetname);
            	Row row = sheet1.getRow(rownumber);
            	for (int i = 0; i < 2; i++) {
            		String colum = row.getCell(i).getStringCellValue();
            		System.out.println(colum);
				}
				return sheetname;
            

//            System.out.println(colum);
//            String var=csolumns;
//			return varcolumns;
            
        }
//            // Iterate through rows and columns to read data
//            for (Row row : sheet) {
//                for (Cell cell : row) {
//                    // Assuming all data is string type for simplicity
//                    String cellValue = cell.getStringCellValue();
//                    System.out.print(cellValue + "\t");
//                }
//                System.out.println(); // Move to the next row
//            }
//            
//            workbook.close();
//            file.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
    
    public static void main(String[] args) throws EncryptedDocumentException, IOException {
    	exceldatas("Logindata",2,0);
    	System.out.println();
    }
}

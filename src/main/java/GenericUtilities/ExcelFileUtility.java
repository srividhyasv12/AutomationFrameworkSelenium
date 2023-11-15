package GenericUtilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.eventusermodel.dummyrecord.LastCellOfRowDummyRecord;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * this method will read data from excel file based on sheet name,rowno and cellno
 * and return the value to caller
 * This class consist of generic methods related to excel file
 * 
 * @author srividhya
 * @param rowno 
 * @param cellno 
 *
 */

public class ExcelFileUtility
{
	
public String readDataFromExcel(String sheetname, int rowno, int cellno) throws IOException {
	FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
String value = wb.getSheet(sheetname).getRow(rowno).getCell(cellno).getStringCellValue();
return value;

	
	
}
/**
 * This method will read multiple data from excel and helps toprovide data DataProvider
 * @param sheetname
 * @return
 * @throws EncryptedDocumentException
 * @throws IOException
 */
public Object[][] readMultipledataFromExcel(String sheetname) throws EncryptedDocumentException, IOException
{
	FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
 Sheet sh = wb.getSheet(sheetname);
int lastRow = sh.getLastRowNum();
 int lastCell = sh.getRow(0).getLastCellNum();
 
 Object [][] data=new Object[lastRow][lastCell]; 
 for(int i=0;i<lastRow;i++)
 {
	 for(int j=0;j<lastCell;j++)
	 {
		 data[i][j] =sh.getRow(i+1).getCell(j).getStringCellValue();  
	 }
 }
 return data;
}
}

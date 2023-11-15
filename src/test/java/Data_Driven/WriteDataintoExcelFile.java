package Data_Driven;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataintoExcelFile {
public static void main(String[] args) throws EncryptedDocumentException, IOException {

	FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
	Workbook book =WorkbookFactory.create(fis);
	 Sheet sheet = book.getSheet("Contacts");
	Row row = sheet.createRow(8);
	 Cell cel = row.createCell(10);
	cel.setCellValue("Hello");
	
	FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\TestData.xlsx");
	book.write(fos);
	book.close();
	System.out.println("Data got inserted in excel");

//or

	/*FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\WriteData.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet("Name");
	Row rw = sh.createRow(0);
	Cell cl = rw.createCell(0);
	cl.setCellValue("vidhya");
	
	FileOutputStream fos=new FileOutputStream(".\\src\\test\\resources\\WriteData.xlsx");
	wb.write(fos);*/

}
}

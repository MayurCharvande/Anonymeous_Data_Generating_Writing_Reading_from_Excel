package FileConnectionCode;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelFileReader 
{	


	@Test(priority=1)
	public void write() throws InvalidFormatException, IOException
	{
		File f = new File("D:\\Mayur\\New Microsoft Excel Worksheet.xlsx");
		FileInputStream fis = new FileInputStream(f);
		XSSFWorkbook wwk = new XSSFWorkbook(f);
		XSSFSheet ss1 = wwk.getSheet("Sheet1"); //.createSheet("Testing");
		XSSFRow rr1 = ss1.createRow(0);
		XSSFCell cc1 = rr1.createCell(0);
		cc1.setCellValue("mayur1");
	    // Save the changes back to the Excel file
	    FileOutputStream fos = new FileOutputStream(f);
	    wwk.write(fos);
	    fos.close();
	    // Close the input stream and workbook
	    fis.close();
	    wwk.close();

	}
	/*By using below code you can read the Data with from excel file and print on the console*/
	@Test(priority=2, enabled=false)
	public void read() throws InvalidFormatException, IOException
	{
		File f = new File("D:\\Mayur\\Anonymous Users Data.xlsx");
		XSSFWorkbook wk = new XSSFWorkbook(f);
		XSSFSheet s1 = wk.getSheet("Sheet1");
		int r = s1.getPhysicalNumberOfRows();
		for(int i=0;i<r;i++) 
		{
			XSSFRow r1 = s1.getRow(i);
				int c = r1.getPhysicalNumberOfCells();
				for(int j=0;j<c;j++) 
				{
					XSSFCell c1 = r1.getCell(j);
					System.out.println(c1.getStringCellValue());
				}
		}
	}
}

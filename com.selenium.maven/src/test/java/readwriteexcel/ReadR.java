package readwriteexcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadR {

	public static File src=null;

	public static FileInputStream fis=null;

	public static FileOutputStream fos=null;

	public static XSSFWorkbook workbook=null;

	public static XSSFSheet sheet=null;

	public static XSSFRow row=null;

	public static XSSFCell cell=null;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		src = new File("F:\\Servlet\\Selenium\\Reborn.xlsx");

		fis = new FileInputStream(src);

		workbook = new XSSFWorkbook(fis);

		System.out.println(workbook.getSheet("Sheet1").getRow(1).getCell(0).getStringCellValue() + " "
				+ workbook.getSheet("Sheet1").getRow(1).getCell(1).getStringCellValue());

		System.out.println(workbook.getSheet("Sheet1").getRow(2).getCell(1).getStringCellValue());
		
		
		
		int rowcount=workbook.getSheet("Sheet1").getLastRowNum()+1;
		
		System.out.println(rowcount);
		
		
		for(int i=0;i<rowcount;i++)
		{
			
			System.out.println(workbook.getSheet("Sheet1").getRow(i).getCell(0).getStringCellValue());
			
		}
		
		
		//write excel
		
       workbook.getSheet("Sheet1").getRow(0).createCell(2).setCellValue("Status");	
       workbook.getSheet("Sheet1").getRow(1).createCell(2).setCellValue("Pass");	
       workbook.getSheet("Sheet1").getRow(2).createCell(2).setCellValue("Fail");	
       workbook.getSheet("Sheet1").getRow(3).createCell(2).setCellValue("Pass");	
       workbook.getSheet("Sheet1").getRow(4).createCell(2).setCellValue("Fail");	
       
       System.out.println("Success ");
		
		fos= new FileOutputStream(src);
		
		workbook.write(fos);
		
		fos.close();
		
		
		
	}

}

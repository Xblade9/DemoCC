package excelCode;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilityPractice 

{

	public static File src=null;
	
	public static XSSFWorkbook workbook=null;
	
	public static XSSFSheet sheet=null;
	
	public static XSSFRow row=null;
	
	public static XSSFCell cell=null;
	
	public static FileInputStream fis=null;
	
	public static FileOutputStream fos=null;
	
	
	
	public static void excelSheetPath(String sheetPath)
	
	
	{
		try
		{
	
		src=new File(sheetPath);
		
		fis=new FileInputStream(src);
		
		workbook=new XSSFWorkbook(fis);
		
		fis.close();
		
		
		}
		
		catch(Exception e)
		
		{
			
			e.printStackTrace();
			
		}
		
	}
	
	
	public static String getCellData(String sheetname,int r,String c)
	
	{
		
		try 
		
		{
			int colNumber=0;
		
			sheet=workbook.getSheet(sheetname);
			
			row=sheet.getRow(0);
			
			
			//int rowCount=sheet.getLastRowNum()+1;
			
			
			for(int i=0;i<row.getLastCellNum();i++)
				
			{
				
				if(row.getCell(i).getStringCellValue().trim().equals(c))
				{
					
					colNumber=i;
					
					
				}
				
			}
			
			
			row=sheet.getRow(r-1);  //1-1 =0 ..First Row of the Excel sheet  2-1=1...Hence it will take the value from the Cell of excel
			
			cell=row.getCell(colNumber);
			
			
			if(cell.getCellType()==CellType.STRING)
			{
				
				
				return cell.getStringCellValue();
				
				
				
			}
			
			
			else if(cell.getCellType()==CellType.NUMERIC || cell.getCellType()==CellType.FORMULA)
				
			{
				
				String cellValue=String.valueOf(cell.getNumericCellValue());
				
				
				if(DateUtil.isCellDateFormatted(cell))
				{
					
					DateFormat df = new SimpleDateFormat("dd-MM-yy");
					
					Date dt=cell.getDateCellValue();
					
					cellValue=df.format(dt);
					
				}
				
				return cellValue;
				
			}
			
			
			
			else if(cell.getCellType()==CellType.BLANK)
			{
				
			
				return "";
				
				
			}
			
			else 
			{
				
				return String.valueOf(cell.getBooleanCellValue());
				
			}
			
			
		} 
		
		catch (Exception e) 
		
		{
		
			e.printStackTrace();
			
			return "";
			
			
		}
		
		
	
	}
	
	
	
	
	
}

package practice;

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

public class EUB {

	
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static File src;
	public static FileInputStream fis;
	public static FileOutputStream fos;
	
	
	
	
	public static void excelPath(String excelPath)
	{
		
		try
		{
			
			src= new File(excelPath);
			
			fis= new FileInputStream(src);
			
			workbook = new XSSFWorkbook(fis);
			
			fis.close();
			
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}
	
	
	public static String getCellData(String sheetname,int r,String col)
	{
		
		
		try
		
		{
			
			int colNum=0;
			
			sheet=workbook.getSheet(sheetname);
			
			row=sheet.getRow(0);
			
			
			for(int i=0;i<row.getLastCellNum();i++)
			{
				
				if(row.getCell(i).getStringCellValue().trim().contains(col))
				{
					colNum=i;
				}
				
			}
		
			row=sheet.getRow(r);
			
			cell=row.getCell(colNum);
			
			if(cell.getCellType()==CellType.STRING)
			{
				
				return cell.getStringCellValue();
				
				
			}
			
			
			else if(cell.getCellType()==CellType.NUMERIC || cell.getCellType()==CellType.FORMULA)
			{
				
				
				String cellNum=String.valueOf(cell.getNumericCellValue());
				
				
				if(DateUtil.isCellDateFormatted(cell))
				{
					
					DateFormat df = new SimpleDateFormat("dd/MM/yy");
					
					Date dt=cell.getDateCellValue();
					
					cellNum=df.format(dt);
				
				
				}
				
				
				return cellNum;
				
			}
			
			
			else if(cell.getCellType()==CellType.BOOLEAN)
			{
				return String.valueOf(cell.getBooleanCellValue());
			}
			
			else 
			{
				return " ";
			}
			
			
			
			
		}
		
		catch(Exception e)
		{
			
			e.printStackTrace();
			
			return "";
		}
		
		
		
		
	}
	
	
	
}

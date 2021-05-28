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

public class EU {

	
	public static XSSFWorkbook workbook=null;
	
	public static XSSFSheet sheet=null;
	
	public static XSSFRow row=null;
	
	public static XSSFCell cell=null;
	
	public static File src=null;
	
	public static FileInputStream fis=null;
	
	public static FileOutputStream fos=null;
	
	
	
	public static void excelFilePath(String pathname)
	{
		try
		{
		
		src=new File(pathname);
		
		fis=new FileInputStream(src);
		
		workbook=new XSSFWorkbook(fis);
		
		fis.close();
	
		}
		
		
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		
		
	}
	
	
	public static String getDataByColName(String sheetname,int r,String colName)
	
	{
		
		try 
	
		{
			int colNum=0;
		
			sheet=workbook.getSheet(sheetname);
			
			row=sheet.getRow(0);  //for heading row
			
			
			for(int i=0;i<row.getLastCellNum();i++)
			{
				
				if(row.getCell(i).getStringCellValue().trim().equals(colName))
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
					
					DateFormat df=new SimpleDateFormat("dd-MM-yy");
					
					Date dt=cell.getDateCellValue();
					
					cellNum=df.format(dt);
					
				}
				
				return cellNum;
				
				
				
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
	
	
	public static boolean setCellData(String sheetname,int r,int c,String status)
	
	{
		
		try
		
		{
			
		     sheet=workbook.getSheet(sheetname);
			
		     row=sheet.getRow(r);
			
		     if(row==null)
		    	 
		     {
		    	 
		    	 row=sheet.createRow(r);
		    	 
		    	 
		     }
		     
			
		     cell=row.getCell(c);
		     
		     if(cell==null)
		     {
		    	 
		    	 cell=row.createCell(c);
		    	 
		     }
		     
		     
		     cell.setCellValue(status);
		     
		     fos=new FileOutputStream(src);
		     
		     workbook.write(fos);
		     
		     fos.close();
		     
		     
		     
		}
		
		catch(Exception e)
		{
			
			e.printStackTrace();
			
			return false;
			
		}

		return true;
		
	}
	
	
	
	public static int rowCount(String sheetName)
	
	{
		
		sheet=workbook.getSheet(sheetName);
		
		int rowCount=sheet.getLastRowNum()+1;
		
		return rowCount;
		
	}
	
	
	
	public static int colCount(String sheetName)
	
	{
		
		sheet=workbook.getSheet(sheetName);
		
		row=sheet.getRow(0);
		
		int colCount=row.getLastCellNum();
		
		return colCount;
	}
	
	
	
}

package practice;
//"F:\\MyBench\\SeleniumProject\\TestData\\InputData.xlsx"

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;
public class ReadWrite 


{

	public XSSFWorkbook workbook;
	
	public XSSFSheet sheet;
	
	public XSSFRow row;
	
	public XSSFCell cell;
	
	public File src;
	
	public FileInputStream fis;
	
	public FileOutputStream fos;
	
	
	@Test(description = "For Reading the Data From Excel")

	public void read()
	{
		
		try
		{
		
		src= new File("F:\\MyBench\\SeleniumProject\\TestData\\InputData.xlsx");
		
		fis= new FileInputStream(src);
		
		workbook= new XSSFWorkbook(fis);
		
	    fis.close();
	
	    
	    sheet=workbook.getSheet("Sheet1");
	    
	    row=sheet.getRow(1);
	    
	    if(row==null)
	    	
	    {
	    	
	    	row=sheet.createRow(1);
	    	
	    }
	    
	    
	    cell=row.getCell(0);
	    
	    if(cell==null)
	    	
	    {
	    	cell=row.createCell(0);
	    	
	    }
	    
	    
	    
	    System.out.println(cell.getStringCellValue());
	    
	    
	    System.out.println(sheet.getRow(1).getCell(1).getStringCellValue());
	    
	    System.out.println(sheet.getRow(1).getCell(2).getDateCellValue());
	    
	    System.out.println(sheet.getRow(1).getCell(3).getNumericCellValue());
	    
	    
	    
	    //sheet.getRow(1).getCell(4).setCellValue("PASS");
	    
	    sheet.getRow(1).createCell(4).setCellValue("Pass");
	    
	    
	    fos= new FileOutputStream(src);
	    
	    workbook.write(fos);
	    
	    fos.close();
	    
	    
	   
	    
	    
	    
	    
	    
	    
	    
	    
	    
			/*
			 * if(cell.getCellType()==CellType.STRING)
			 * 
			 * 
			 * {
			 * 
			 * System.out.println(cell.getStringCellValue());
			 * 
			 * 
			 * }
			 * 
			 * else if(cell.getCellType()==CellType.NUMERIC ||
			 * cell.getCellType()==CellType.FORMULA)
			 * 
			 * {
			 * 
			 * 
			 * 
			 * String cellValue=String.valueOf(cell.getNumericCellValue());
			 * 
			 * 
			 * 
			 * if(DateUtil.isCellDateFormatted(cell))
			 * 
			 * {
			 * 
			 * DateFormat df= new SimpleDateFormat("dd-MM-yy");
			 * 
			 * java.util.Date dt=cell.getDateCellValue();
			 * 
			 * cellValue=df.format(dt);
			 * 
			 * 
			 * }
			 * 
			 * System.out.println("Cell Value : "+cellValue);
			 * 
			 * }
			 * 
			 * 
			 * 
			 * else if(cell.getCellType()==CellType.BLANK)
			 * 
			 * {
			 * 
			 * 
			 * }
			 * 
			 * else
			 * 
			 * { cell.getBooleanCellValue();
			 * 
			 * }
			 */
	  
	    //System.out.println(cell.getStringCellValue());
	    
	    //System.out.println(cell.getNumericCellValue());
	    
	    //System.out.println(String.valueOf(cell.getNumericCellValue()));
	    
	    //System.out.println(cell.getDateCellValue());
	    
		}
		
		
		catch(Exception e)
		
		{
			
			System.out.println(e.getMessage());
			
		}
		
		
	}
	
	

	/*
	 * @Test(description = "For Test")
	 * 
	 * public void test()
	 * 
	 * {
	 * 
	 * 
	 * 
	 * 
	 * 
	 * }
	 */
	
	
	
	
	
	
	
}

package excelCode;
import utility.*;
public class ReadWriteExcelMaven {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ExcelUtility.excelSheetPath("F:\\Selenium\\TestData.xlsx");
		
		//System.out.println(ExcelUtility.getCellData("Sheet3", 2, "USERNAME"));
		
		System.out.println(ExcelUtility.setCellValue("Sheet2", 2, "RESULT", "Pass"));
//		
		System.out.println(ExcelUtility.setCellValue("Sheet2", 3, "RESULT", "FALSE"));
		
		
	}

}

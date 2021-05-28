package excelCode;

import org.testng.annotations.Test;

public class ExcelUtilityPracticeRW 

{

	@Test
	
	public void rW()
	{
		
		
		ExcelUtilityPractice.excelSheetPath("F:\\MyBench\\SeleniumProject\\TestData\\InputData.xlsx");
		
		System.out.println(ExcelUtilityPractice.getCellData("Sheet1", 1, "USERNAME"));
		
		System.out.println(ExcelUtilityPractice.getCellData("Sheet1", 1, "Password"));
		
		System.out.println(ExcelUtilityPractice.getCellData("Sheet1", 1, "Date"));
		
		System.out.println(ExcelUtilityPractice.getCellData("Sheet1", 1, "Times"));
		
		
		System.out.println(" ");
		
		System.out.println(" ");
		
		
	}
	
	
	
	
	
}

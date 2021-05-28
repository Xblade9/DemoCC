package readwriteexcel;

public class UtilityCheck {

	public static void main(String[] args) {

		
		UtilityExcel.excelSheetPath("F:\\Servlet\\Selenium\\Reborn.xlsx");
		
		System.out.println(UtilityExcel.getCellData("Sheet1", 1, 1));

		System.out.println(UtilityExcel.getCellData("Sheet1", 1, 0));
		
		
		
	}

}

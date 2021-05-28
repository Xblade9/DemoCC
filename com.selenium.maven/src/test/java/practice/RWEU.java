package practice;

public class RWEU {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		EU.excelFilePath("F:\\MyBench\\SeleniumProject\\TestData\\InputData.xlsx");
		
		System.out.println(EU.getDataByColName("Sheet1", 1, "UserName"));
		
		System.out.println(EU.getDataByColName("Sheet1", 1, "Password"));
		
		System.out.println(EU.getDataByColName("Sheet1", 1, "Date"));
		
		System.out.println(EU.getDataByColName("Sheet1", 1, "Times"));
		
		
		System.out.println("******************************************");
		
		
		System.out.println(EU.setCellData("Sheet1", 2, 4, "FAIL"));
		
	}

}

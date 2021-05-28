package com.prefeasy.clovia;

import org.testng.annotations.DataProvider;

import utility.ConfigReader;
import utility.ExcelUtility;

public class DProviderClovia {

	@DataProvider(name = "CloviaLoginProvider")

	public static Object[][] dataProviderLogin() {

		ConfigReader cfg = new ConfigReader();

		ExcelUtility.excelSheetPath(cfg.getExcelPath());

		int row = ExcelUtility.getRowCount("CloviaLogin");
		int col = ExcelUtility.getColCount("CloviaLogin");

		Object[][] obj = new Object[row - 1][col];

		for (int i = 1; i < row; i++) {

			for (int j = 0; j < col; j++) {

				obj[i - 1][j] = ExcelUtility.getCellData("CloviaLogin", i, j);
			}

		}

		return obj;

	}
	
	@DataProvider(name = "CloviaProductProvider")

	public static Object[][] dataProviderProduct() {

		ConfigReader cfg = new ConfigReader();

		ExcelUtility.excelSheetPath(cfg.getExcelPath());

		int row = ExcelUtility.getRowCount("CloviaProduct");
		int col = ExcelUtility.getColCount("CloviaProduct");

		Object[][] obj = new Object[row - 1][col];

		for (int i = 1; i < row; i++) {

			for (int j = 0; j < col; j++) {

				obj[i - 1][j] = ExcelUtility.getCellData("CloviaProduct", i, j);
			}

		}

		return obj;

	}
	
	
	
	@DataProvider(name = "CloviaProductPincode")

	public static Object[][] dataProviderProductPincode() {

		ConfigReader cfg = new ConfigReader();

		ExcelUtility.excelSheetPath(cfg.getExcelPath());

		int row = ExcelUtility.getRowCount("CloviaPincode");
		int col = ExcelUtility.getColCount("CloviaPincode");

		Object[][] obj = new Object[row - 1][col];

		for (int i = 1; i < row; i++) {

			for (int j = 0; j < col; j++) {

				obj[i - 1][j] = ExcelUtility.getCellData("CloviaPincode", i, j);
			}

		}

		return obj;

	}
	
	
	@DataProvider(name = "CloviaProductWithDiffAddress")

	public static Object[][] dataProviderProductDiffAddress() {

		ConfigReader cfg = new ConfigReader();

		ExcelUtility.excelSheetPath(cfg.getExcelPath());

		int row = ExcelUtility.getRowCount("CloviaDiffAdd");
		int col = ExcelUtility.getColCount("CloviaDiffAdd");

		Object[][] obj = new Object[row - 1][col];

		for (int i = 1; i < row; i++) {

			for (int j = 0; j < col; j++) {

				obj[i - 1][j] = ExcelUtility.getCellData("CloviaDiffAdd", i, j);
			}

		}

		return obj;

	}
	
	
	@DataProvider(name = "CreateNewFromSelectDrpDwn")

	public static Object[][] dataProviderCreateNewFromSelectDropDown() {

		ConfigReader cfg = new ConfigReader();

		ExcelUtility.excelSheetPath(cfg.getExcelPath());

		int row = ExcelUtility.getRowCount("CloviaCreateNewDrpDown");
		int col = ExcelUtility.getColCount("CloviaCreateNewDrpDown");

		Object[][] obj = new Object[row - 1][col];

		for (int i = 1; i < row; i++) {

			for (int j = 0; j < col; j++) {

				obj[i - 1][j] = ExcelUtility.getCellData("CloviaCreateNewDrpDown", i, j);
			}

		}

		return obj;

	}
	
	
	
	
	
	

}

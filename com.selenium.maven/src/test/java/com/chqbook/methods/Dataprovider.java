package com.chqbook.methods;

import org.testng.annotations.DataProvider;

import utility.ConfigReader;
import utility.ExcelUtility;

public class Dataprovider {

	@DataProvider(name = "ChqBookMobileField")

	public static Object[][] dataProviderLogin() {

		ConfigReader cfg = new ConfigReader();

		ExcelUtility.excelSheetPath(cfg.getExcelPath());

		int row = ExcelUtility.getRowCount("ChqBookHomePage");
		int col = ExcelUtility.getColCount("ChqBookHomePage");

		Object[][] obj = new Object[row - 1][col];

		for (int i = 1; i < row; i++) {

			for (int j = 0; j < col; j++) {

				obj[i - 1][j] = ExcelUtility.getCellData("ChqBookHomePage", i, j);
			}

		}

		return obj;

	}
	
	
	@DataProvider(name = "ChqBookCreditCards")

	public static Object[][] dataProviderForCreditCard() {

		ConfigReader cfg = new ConfigReader();

		ExcelUtility.excelSheetPath(cfg.getExcelPath());

		int row = ExcelUtility.getRowCount("ChqBookCreditCardPersonalDetail");
		int col = ExcelUtility.getColCount("ChqBookCreditCardPersonalDetail");

		Object[][] obj = new Object[row - 1][col];

		for (int i = 1; i < row; i++) {

			for (int j = 0; j < col; j++) {

				obj[i - 1][j] = ExcelUtility.getCellData("ChqBookCreditCardPersonalDetail", i, j);
			}

		}

		return obj;

	}
	

}

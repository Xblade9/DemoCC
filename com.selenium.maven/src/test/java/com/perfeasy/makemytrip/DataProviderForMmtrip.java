package com.perfeasy.makemytrip;

import utility.ConfigReader;
import utility.ExcelUtility;

import org.testng.annotations.DataProvider;

public class DataProviderForMmtrip {

	@DataProvider(name = "loginProvider")
	public static Object[][] dataProviderLogin() {

		ConfigReader cfg = new ConfigReader();

		ExcelUtility.excelSheetPath(cfg.getExcelPath());

		int rowcount = ExcelUtility.getRowCount("LoginCred");

		int colcount = ExcelUtility.getColCount("LoginCred");

		Object[][] obj = new Object[rowcount - 1][colcount];

		for (int i = 1; i < rowcount; i++) {

			for (int j = 0; j < colcount; j++) {

				obj[i - 1][j] = ExcelUtility.getCellData("LoginCred", i, j);

			}
		}
		return obj;
	}

	@DataProvider(name = "flightProvider")
	public static Object[][] dataProviderFlightSearch() {

		ConfigReader cfg = new ConfigReader();

		ExcelUtility.excelSheetPath(cfg.getExcelPath());

		int rowcount = ExcelUtility.getRowCount("FlightSearch");

		int colcount = ExcelUtility.getColCount("FlightSearch");

		Object[][] obj = new Object[rowcount - 1][colcount];

		for (int i = 1; i < rowcount; i++) {

			for (int j = 0; j < colcount; j++) {

				obj[i - 1][j] = ExcelUtility.getCellData("FlightSearch", i, j);

			}
		}
		return obj;
	}

	@DataProvider(name = "TravellerDetails")
	public static Object[][] dataProviderTravellerDetails() {

		ConfigReader cfg = new ConfigReader();

		ExcelUtility.excelSheetPath(cfg.getExcelPath());

		int rowcount = ExcelUtility.getRowCount("TravellerDetails");

		int colcount = ExcelUtility.getColCount("TravellerDetails");

		Object[][] obj = new Object[rowcount - 1][colcount];

		for (int i = 1; i < rowcount; i++) {

			for (int j = 0; j < colcount; j++) {

				obj[i - 1][j] = ExcelUtility.getCellData("TravellerDetails", i, j);

			}
		}
		return obj;
	}

}
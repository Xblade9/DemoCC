package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	public static File src = null;

	public static FileInputStream fis = null;

	public static FileOutputStream fos = null;

	public static XSSFWorkbook workbook = null;

	public static XSSFSheet sheet = null;

	public static XSSFRow row = null;

	public static XSSFCell cell = null;

	public static XSSFFont font = null;

	public static XSSFCellStyle style = null;

	public static void excelSheetPath(String excelPath) {
		try {

			src = new File(excelPath);

			fis = new FileInputStream(src);

			workbook = new XSSFWorkbook(fis);

			fis.close();

		}

		catch (Exception e) {

			e.printStackTrace();
		}

	}

	public static String getCellData(String sheetname, int rowno, int colno) {

		try {

			sheet = workbook.getSheet(sheetname);

			row = sheet.getRow(rowno);

			if (row == null) {

				row = sheet.createRow(rowno);
			}

			cell = row.getCell(colno);

			if (cell == null) {

				cell = row.createCell(colno);
			}

			if (cell.getCellType() == CellType.STRING)

			{
				return cell.getStringCellValue();
			}

			else if (cell.getCellType() == CellType.NUMERIC || cell.getCellType() == CellType.FORMULA) {

				String cellValue = String.valueOf(cell.getNumericCellValue()); // converting numeric value to string ,
																				// we will use String.valueOf()

				if (DateUtil.isCellDateFormatted(cell)) {

					DateFormat df = new SimpleDateFormat("dd-MM-yy"); // date to string conversion.. here dateformat is
																		// abstract class and simple date format is
																		// child class .. we know that we cant
																		// instantiate an abstract class

					Date dt = cell.getDateCellValue();

					cellValue = df.format(dt);
				}

				return cellValue;
			}

			else if (cell.getCellType() == CellType.BLANK) {
				return "";
			}

			else {

				return String.valueOf(cell.getBooleanCellValue());
			}

		}

		catch (Exception e) {

			e.printStackTrace();

			return "";
		}

	}

	// i want to get colNumber using Colname
	// using colname will be more reliable for us to identify our code in future
	// that
	// for what colname we are making our script

	public static String getCellData(String sheetname, int rowno, String colname) {

		try {
			int colNumber = 0;

			sheet = workbook.getSheet(sheetname);

			row = sheet.getRow(0); // for Heading in excelsheet

			for (int i = 0; i < row.getLastCellNum(); i++) {

				if (row.getCell(i).getStringCellValue().trim().equals(colname)) {

					colNumber = i;
				}
			}

			row = sheet.getRow(rowno - 1); // 1-1=0;

			cell = row.getCell(colNumber);

			if (cell.getCellType() == CellType.STRING) {

				return cell.getStringCellValue();

			}

			else if (cell.getCellType() == CellType.NUMERIC || cell.getCellType() == CellType.FORMULA) {

				String cellValue = String.valueOf(cell.getNumericCellValue());

				// The type HSSFDateUtil is deprecated . it will throw an error

				/*
				 * if(HSSFDateUtil.isCellDateFormatted(cell)) {
				 * 
				 * }
				 */

				// time for new logic then

				if (DateUtil.isCellDateFormatted(cell)) {

					DateFormat df = new SimpleDateFormat("dd-MM-yy");

					Date dt = cell.getDateCellValue();

					cellValue = df.format(dt);

				}

				return cellValue;

			}

			else if (cell.getCellType() == CellType.BLANK) {

				return "";
			}

			else {

				return String.valueOf(cell.getBooleanCellValue());
			}

		}

		catch (Exception e) {

			e.printStackTrace();

			return "";
		}

	}

	public static boolean setCellValue(String sheetname, int rowno, String collname, String value) {

		try {

			int colNumber = 0;

			sheet = workbook.getSheet(sheetname);

			row = sheet.getRow(0);

			for (int i = 0; i < row.getLastCellNum(); i++) {

				if (row.getCell(i).getStringCellValue().trim().equals(collname)) {

					colNumber = i;

				}
			}

			row = sheet.getRow(rowno - 1);

			if (row == null) {
				row = sheet.createRow(rowno - 1);
			}

			cell = row.getCell(colNumber);

			if (cell == null) {

				cell = row.createCell(colNumber);
			}

			font = workbook.createFont();

			style = workbook.createCellStyle();

			if (value.equals("PASS"))

			{

				font.setFontName("Jokerman");

				font.setFontHeight(11);

				font.setBold(true);

				font.setColor(HSSFColor.HSSFColorPredefined.WHITE.getIndex());

				style.setFont(font);

				style.setFillForegroundColor(HSSFColor.HSSFColorPredefined.GOLD.getIndex());

				style.setFillPattern(FillPatternType.BRICKS);

				cell.setCellStyle(style);

				cell.setCellValue(value);

				fos = new FileOutputStream(src);

				workbook.write(fos);

				fos.close();

			}

			else if (value.equals("FALSE")) {

				font.setFontName("Jokerman");

				font.setFontHeight(11);

				font.setBold(true);

				font.setColor(HSSFColor.HSSFColorPredefined.WHITE.getIndex());

				style.setFont(font);

				style.setFillForegroundColor(HSSFColor.HSSFColorPredefined.DARK_RED.getIndex());

				style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

				cell.setCellStyle(style);

				cell.setCellValue(value);

				fos = new FileOutputStream(src);

				workbook.write(fos);

				fos.close();

			}

		}

		catch (Exception e) {
			e.printStackTrace();

			return false;
		}

		return true;

	}

	public static int getRowCount(String sheetname) {

		sheet = workbook.getSheet(sheetname);

		int rowCount = sheet.getLastRowNum() + 1;

		return rowCount;

	}

	public static int getColCount(String sheetname) {
		sheet = workbook.getSheet(sheetname);

		row = sheet.getRow(0);

		int cellCount = row.getLastCellNum();

		return cellCount;

	}

}

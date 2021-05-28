package reborn.sel.prac;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUt {

	public static File src = null;

	public static FileInputStream fis = null;

	public static FileOutputStream fos = null;

	public static XSSFWorkbook workbook = null;

	public static XSSFSheet sheet = null;

	public static XSSFRow row = null;

	public static XSSFCell cell = null;

	public static XSSFFont font = null;

	public static XSSFCellStyle style = null;

	public static void excelPath(String sheetname) throws Exception {

		src = new File(sheetname);

		fis = new FileInputStream(src);

		workbook = new XSSFWorkbook(fis);

		fis.close();

	}

	public static String getSheet(String sheetname, int rowNo, String colName) {

		int colNumber = 0;

		sheet = workbook.getSheet(sheetname);

		row = sheet.getRow(0);

		for (int i = 0; i < row.getLastCellNum(); i++) {

			if (row.getCell(i).getStringCellValue().trim().equals(colName)) {

				colNumber = i;

			}

		}

		row = sheet.getRow(rowNo - 1);

		cell = row.getCell(colNumber);

		if (cell.getCellType() == CellType.STRING) {

			return cell.getStringCellValue();

		}

		else if (cell.getCellType() == CellType.NUMERIC || cell.getCellType() == CellType.FORMULA) {

			String cellValue = String.valueOf(cell.getNumericCellValue());

			if (DateUtil.isCellDateFormatted(cell)) {

				DateFormat dt = new SimpleDateFormat("dd-MM-yy");

				Date d = cell.getDateCellValue();

				cellValue = dt.format(d);

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

	public static boolean getCellData(String sheetname, int rowNo, String colName, String value) throws Exception {

		int colNumber = 0;

		sheet = workbook.getSheet(sheetname);

		row = sheet.getRow(0);

		for (int i = 0; i < row.getLastCellNum(); i++) {

			if (row.getCell(i).getStringCellValue().trim().equals(colName)) {

				colNumber = i;

			}

		}

		row = sheet.getRow(rowNo - 1);

		if (row == null) {

			sheet.createRow(rowNo - 1);

		}

		cell = row.getCell(colNumber);

		if (cell == null) {

			row.createCell(colNumber);

		}

		if (value.equals("PASS")) {

			fos = new FileOutputStream(src);

			workbook.write(fos);

			fos.close();

		}

		else if (value.equals("FAIL")) {

			fos = new FileOutputStream(src);

			workbook.write(fos);

			fos.close();

		}

		
		return true;
		
	}

}

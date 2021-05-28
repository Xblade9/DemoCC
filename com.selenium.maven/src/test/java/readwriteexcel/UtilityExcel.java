package readwriteexcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class UtilityExcel {

	public static File src = null;

	public static FileInputStream fis = null;

	public static FileOutputStream fos = null;

	public static XSSFWorkbook workbook = null;

	public static XSSFSheet sheet = null;

	public static XSSFRow row = null;

	public static XSSFCell cell = null;

	public static void excelSheetPath(String path) {

		try {

			src = new File(path);

			fis = new FileInputStream(src);

			workbook = new XSSFWorkbook(fis);

			fis.close();

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public static String getCellData(String sheetname, int rowno, int colno) {

		try {

			sheet = workbook.getSheet(sheetname);

			row = sheet.getRow(rowno);

			if (row == null) {

				sheet.createRow(rowno);

			}

			cell = row.getCell(colno);

			if (cell == null) {

				row.createCell(colno);

			}

			if (cell.getCellType() == CellType.STRING) {

				return cell.getStringCellValue();

			}

			else if (cell.getCellType() == CellType.NUMERIC || cell.getCellType() == CellType.FORMULA) {

				String cellValue = String.valueOf(cell.getNumericCellValue());

				if (DateUtil.isCellDateFormatted(cell)) {

					DateFormat df = new SimpleDateFormat("dd-MM-yy");

					Date dt = cell.getDateCellValue();

					cellValue = df.format(dt);

				}

				return cellValue;

			}

			else if (cell.getCellType() == CellType.BLANK) {

				return " ";

			}

			else {

				return String.valueOf(cell.getBooleanCellValue());

			}

		} catch (Exception e) {
			// TODO: handle exception

			e.printStackTrace();

			return "";
		}

	}

	public static String getCellData(String sheetname, int rowno, String colName) {

		try {

			int colNumber = 0;

			sheet = workbook.getSheet(sheetname);

			row = sheet.getRow(0);

			if (row == null) {

				sheet.createRow(rowno);

			}

			for (int i = 0; i < row.getLastCellNum(); i++) {

				if (row.getCell(i).getStringCellValue().trim().equals(colName)) {

					colNumber = i;

				}

			}

			row = sheet.getRow(rowno - 1);

			cell = row.getCell(colNumber);

			if (cell.getCellType() == CellType.STRING) {

				return cell.getStringCellValue();

			}

			else if (cell.getCellType() == CellType.NUMERIC || cell.getCellType() == CellType.FORMULA) {

				String cellValue = String.valueOf(cell.getNumericCellValue());

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

		} catch (Exception e) {
			// TODO: handle exception

			e.printStackTrace();

			return " ";

		}

	}

	public static String getCellDataa(String sheetname, int rown, String columName) {

		try {

			int colNumber = 0;

			sheet = workbook.getSheet(sheetname);

			row = sheet.getRow(0);

			for (int i = 0; i < row.getLastCellNum(); i++) {

				if (row.getCell(i).getStringCellValue().trim().equals(columName))

				{

					colNumber = i;

				}

			}

			cell = sheet.getRow(rown - 1).getCell(colNumber);

			if (cell.getCellType() == CellType.STRING) {

				return cell.getStringCellValue();

			}

			else if (cell.getCellType() == CellType.NUMERIC || cell.getCellType() == CellType.FORMULA) {

				String cellValue = String.valueOf(cell.getNumericCellValue());

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

		} catch (Exception e) {

			return " ";

		}

	}

}

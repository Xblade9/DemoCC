package utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

	// using constructor for initializing purpose

//this will load the file and create an obj

	public Properties pro;

	public ConfigReader() {

		try {

			File src = new File("./Configuration/Config.properties");

			FileInputStream fis = new FileInputStream(src);

			pro = new Properties();

			pro.load(fis);

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	public String getChromePath() {

		return pro.getProperty("ChromePath");

	}

	public String getUrl() {

		return pro.getProperty("Url");

	}

	public String getExcelPath() {

		return pro.getProperty("ExcelPath");

	}

	public String getCloviaUrl() {

		return pro.getProperty("CloviaUrl");

	}

	public String getClovUrl() {

		return pro.getProperty("ClovUrl");

	}

	public String getChqBookUrl() {
		return pro.getProperty("ChqBook");
	}

	public String getReport() {
		return pro.getProperty("Report");
	}

	public String getReport2() {
		return pro.getProperty("Report2");
	}

}

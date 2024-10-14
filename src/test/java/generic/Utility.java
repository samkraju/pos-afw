package generic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

//Copied the program from demo1 and made changes,, also goto testNG and add parameters environemnt value either QA/staging
//Demo1 //WAP to access data from a file
//create a new file config.properties, use p.load and getProperty method
//Add data url, ITO,ETO
//after this create a method under generic with this program and make changes in basetest file
//after which i will be copying this file to Selenium workspace

//also add a method to read from excel
public class Utility {
	public static String getData(String path, String key) {
		String value = "";
		try {
			Properties p = new Properties();
			p.load(new FileInputStream(path));
			value = p.getProperty(key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

	public static String readFromExcel(String path, String sheet, int r, int c) {
		String value = "";
		try {
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			value = wb.getSheet(sheet).getRow(r).getCell(c).getStringCellValue();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

	public static void writeIntoExcel(String path, String sheet, int r, int c, String value, String path2) {

		try {
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			wb.getSheet(sheet).getRow(r).getCell(c).setCellValue(value);
			wb.write(new FileOutputStream(path2));
		} catch (Exception e) {

		}
	}

}

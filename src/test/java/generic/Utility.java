package generic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

//Copied the program from demo1 and made changes,, also goto testNG and add parameters environemnt value either QA/staging
//Demo1 //WAP to access data from a file
//create a new file config.properties, use p.load and getProperty method
//Add data url, ITO,ETO
//after this create a method under generic with this program and make changes in basetest file
//after which i will be copying this file to Selenium workspace

//also add a method to read from excel, make the class abstract as all methods are static

public abstract class Utility {
	public static String getDatafromProperty(String path, String key) {
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
		Workbook wb = null;
		try {
			wb = WorkbookFactory.create(new FileInputStream(path));
			value = wb.getSheet(sheet).getRow(r).getCell(c).getStringCellValue();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (wb != null) {
				try {
					wb.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return value;
	}

	public static void writeIntoExcel(String path, String sheet, int r, int c, String value, String path2) {
		Workbook wb = null;
		try {
			wb = WorkbookFactory.create(new FileInputStream(path));
			wb.getSheet(sheet).getRow(r).getCell(c).setCellValue(value);
			wb.write(new FileOutputStream(path2));
		} catch (Exception e) {

		} finally {
			if (wb != null) {
				try {
					wb.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static int getRowCount(String path, String sheet) {
		int r = 0;
		Workbook wb = null;
		try {
			wb = WorkbookFactory.create(new FileInputStream(path));
			r = wb.getSheet(sheet).getLastRowNum();
			r = r + 1;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (wb != null)

			{
				try {
					wb.close();
				} catch (IOException e) {

					e.printStackTrace();
				}
			}
		}
		return r;
	}

	public static int getCellCount(String path, String sheet) {
		int c = 0;
		Workbook wb = null;
		try {
			wb = WorkbookFactory.create(new FileInputStream(path));
			c = wb.getSheet(sheet).getRow(0).getLastCellNum();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (wb != null) {
				try {
					wb.close();
				} catch (IOException e) {

					e.printStackTrace();
				}

			}
		}
		return c;

	}
}

package generic;

import java.io.FileInputStream;
import java.util.Properties;

//Copied the program from demo1 and made changes,, also goto testNG and add parameters environemnt value either QA/staging
//Demo1 //WAP to access data from a file
//create a new file config.properties, use p.load and getProperty method
//Add data url, ITO,ETO
//after this create a method under generic with this program and make changes in basetest file
//after which i will be copying this file to Selenium workspace
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

}

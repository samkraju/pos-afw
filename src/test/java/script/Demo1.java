package script;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

//WAP to access data from a file
//create a new file config.properties, use p.load and getProperty method
//Add data url, ITO,ETO
//after this create a method under generic with this program and make changes in basetest file
//after which i will be copying this file to Selenium workspace

public class Demo1 {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Properties p = new Properties();
		p.load(new FileInputStream("./config.properties"));
		String value = p.getProperty("url");// case sensitive
		System.out.println(value);

	}

}

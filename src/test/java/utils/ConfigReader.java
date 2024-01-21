package utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

	public static Properties initializeProperties() {
		
		Properties prop= new Properties();
		File src = new File(System.getProperty("C:\\Users\\monal\\git\\Dnyaneshwars-Automation-Lab\\src\\test\\java\\utils\\ConfigReader.java"));
	
		try {
			FileInputStream fis = new FileInputStream(src);
			prop.load(fis);
			}
		catch(Exception e) {
		e.printStackTrace();	
			}
		return prop;
	}

}

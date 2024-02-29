package utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

	public static Properties initializeProperties() {
		
		Properties prop= new Properties();
		
		File src = new File("C:\\Users\\monal\\git\\BDDCucumber_Web_Automation\\src\\main\\resources\\config.properties");
	
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

package com.qa.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	private Properties prop ;
	
	public ConfigReader() {
		
		prop = new Properties();
		
		try {
			FileInputStream fis = new FileInputStream("src/test/resources/Configurations/config.properties");
			prop.load(fis);
		}catch (IOException e) {		
			e.printStackTrace();
			System.err.println("File was not found at given path"+e.getMessage());
		}			
	}
	
	public String getURL() {
		return prop.getProperty("URL");
	}
	
	public String getBrowser() {
		return prop.getProperty("BROWSER");
	}
	
	public Long getGlobalWaitInLongFormat() {
		return Long.parseLong(prop.getProperty("GLOBALWAIT"));
	}

	public String getFieldsVerificationExcelName() {
		return prop.getProperty("FIELDS_VERIFICATION_EXCEL");
	}

}

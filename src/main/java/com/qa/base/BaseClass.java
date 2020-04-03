package com.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseClass {

	public static String baseURL;
	public static Properties prop;
	public static String tokenId;
	public static String phoneNo;
	

//This is the baseclass constructor which will load the properties file, so whichever class extends this baseclass 
//will have to create a default constructor to call the super class constructor.
	public BaseClass() throws IOException {
		String fileLoc = System.getProperty("user.dir")+"\\src\\main\\java\\com\\qa\\config\\config.properties";
		prop = new Properties();
		FileInputStream fis = new FileInputStream(new File(fileLoc)); //loading the properties file
		prop.load(fis);
		baseURL = prop.getProperty("baseUrl");
		

	}
}


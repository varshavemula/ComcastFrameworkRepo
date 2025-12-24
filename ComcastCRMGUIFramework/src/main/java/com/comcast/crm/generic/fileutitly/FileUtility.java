package com.comcast.crm.generic.fileutitly;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class FileUtility {

	public String getDataFromPropertyFile(String key) throws Exception
	{
		FileInputStream fis = new FileInputStream("./configAppData/commondata.properties");
		Properties prop=new Properties();
		prop.load(fis);
		String data = prop.getProperty(key);
		return data;
	}
}

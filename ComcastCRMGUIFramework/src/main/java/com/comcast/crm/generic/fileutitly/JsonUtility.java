package com.comcast.crm.generic.fileutitly;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonUtility {

	public String getDataFromJsonFile(String key) throws Exception
	{
		FileReader fr=new FileReader("./configAppData/appcommondata.json");
		JSONParser parser=new JSONParser();
		Object obj=parser.parse(fr);
		JSONObject jobj=(JSONObject)obj;
		String data=(String)jobj.get(key);
		return data;
		
	}
}

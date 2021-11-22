package com.mindtree.utilities;

import java.io.FileInputStream;

import java.util.Properties;



public class ReadProperty {
	public static Properties get;

	public ReadProperty() throws Exception {
		if (get == null) {
			
				get = new Properties();
				FileInputStream fis = new FileInputStream(".//src//test//resources//config.properties");
				get.load(fis);
			} 
		 
			}
	public String getUrl() throws Exception
	   {
		   String url = get.getProperty("url");
		   if(url==null)
			   throw new Exception("url not found in property file"); 
		   
		   return url;
	   }
	public String getDriverPath() throws Exception
	   {
		   String path =  get.getProperty("browserpath");
		   if(path==null)
			   throw new Exception("password not found in property file"); 
		   
		   return path;
	   }
	   
	   public String getBrowser() throws Exception
	   {
		   String browser =  get.getProperty("browser");
		   if(browser==null)
			   throw new Exception("browser not found in property file"); 
		   
		   return browser;
	   } 
	   
	   
	   
	   public String getExcelSheetPath()
	   {
		   String path =  get.getProperty("excel");
		   
		   return path;
	   }
	
		
	
}

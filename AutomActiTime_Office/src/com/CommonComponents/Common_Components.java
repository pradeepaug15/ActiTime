package com.CommonComponents;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

public class Common_Components {
	
		
	/**
	 * @param args
	 * @throws IOException 
	 * @throws InvalidFormatException 
	 */
	public void waitToPageLoad()
	{
		Objects.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@SuppressWarnings("rawtypes")
	public static Logger getlogs(Class classname){
		Logger log = Logger.getLogger(classname);
		BasicConfigurator.configure();
		return log;		
	}
		

	}



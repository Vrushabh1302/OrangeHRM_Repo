package com.OrangeHRM.Utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

public class ScreeShot extends Reports{
	
	public static String snapshot() {
		
		TakesScreenshot scrshot=(TakesScreenshot) driver;
		//for take screenshot interface
			
       String Dateformat=new SimpleDateFormat("YYMMDDHHMMSS").format(new Date());	
       
		 
         File sourcsfile= scrshot.getScreenshotAs(OutputType.FILE);    //sources
                 
           
          File files=new File( file.getPath() +"/"+Dateformat+".png");     //destination
         
         try {
			FileUtils.copyFile(sourcsfile, files);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
         return Dateformat+".png";
          
	}
	
	
	
	
}

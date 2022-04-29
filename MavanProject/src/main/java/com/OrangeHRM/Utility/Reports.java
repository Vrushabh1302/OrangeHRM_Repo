package com.OrangeHRM.Utility;



import java.io.File;

import java.util.Date;

import org.openqa.selenium.remote.ScreenshotException;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reports extends BaseClass {

	public static ExtentSparkReporter sparkreport;
	public static ExtentReports extreport;
	public static ExtentTest test;
	public static File file;
	
	@BeforeTest(alwaysRun=true)
	public  void MultipleReport() {
 		
		Date date=new Date();
		String format=date.toString().replaceAll(":", "-");
		
		 file=new File("Result/"+format);
		 file.mkdir();
	
		 //This is responsible for generating the report
	  	 sparkreport=new ExtentSparkReporter(file.getPath()+"/Result.html");
	  	//Below code will tell Extend Report that in which format he has to generate report
	  	 extreport=new ExtentReports();
		  	//join both object
		  extreport.attachReporter(sparkreport);
	  	sparkreport.config().setTheme(Theme.DARK);  //set them of report
	  	sparkreport.config().setDocumentTitle("OrangeHRM Test Report");
         //set document Title Name 
	  	sparkreport.config().setReportName("Clint name - Kalpesh");
	  	//set client name 
	}
	
	public void InfoSteps(String Steps ) {
		test.log(Status.INFO, Steps);
	}
	public void Creattest(String discription ,String Author, String Category ) {
		test=extreport.createTest(discription).assignAuthor(Author).assignCategory(Category);
	}
	public void Pass(String Actual) {
		test.log(Status.PASS, Actual);
		test.addScreenCaptureFromPath(ScreeShot.snapshot());
	}
	public void Fail(String Actual) {
		test.log(Status.FAIL, Actual);
		test.addScreenCaptureFromPath(ScreeShot.snapshot());
		
	}
	
	
	
	
}

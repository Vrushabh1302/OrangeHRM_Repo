package com.OrangeHRM.TestCases;

import javax.xml.transform.Result;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.reporters.jq.INavigatorPanel;

import com.OrangeHRM.Utility.BaseClass;
import com.OrangeHRM.Utility.Reports;
import com.OrangeHRM.pages.A_ForgetPassewordpage;
import com.OrangeHRM.pages.B_LogIn;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class A_ForgetPasswordTestCases extends Reports {
   
	
	
	//for click on forgetpassword
	@Test(priority=1,groups= {"Smoke"})
	public void TestCaselinkfrgtpassword() {
		
				//Create testCases description
			Creattest("User Should be able to click on ForgetPassword link", "Vrushabh", "smoke");
					
					 InfoSteps("Launch Browser");
					 InfoSteps("provide URL of OrangeHRM");
					InfoSteps("click on ForgetPassword Link");
					
		B_LogIn forget=new B_LogIn();
		forget.Forgetpassword();
		if(driver.findElements(By.id("btnSearchValues")).size()>0) {
			Pass("user is able to click on forgtpassword btn");
		}else Fail("user is unable to click on forgtpassword btn");
		
		
	}
	
	@AfterMethod
	public void flush() {
		extreport.flush();
	}
	
	//for invalid
	@Test (priority=2,description="user unable to reste pasword with Invalid username")
	public void TestCaseRestvalid() {
		ExtentSparkReporter spark1=new ExtentSparkReporter("Result/Result.html");
		
		 ExtentReports report1=new ExtentReports();
		 report1.attachReporter(spark1);
		 
		Creattest("user should be unable to resetpassword by invalid username ", "Vrushabh", "Negative");
				 
				 
				 InfoSteps("Launch Browser");
				 InfoSteps("provide URL of OrangeHRM");
				 InfoSteps("click on ForgetPassword btn");
				 InfoSteps("send Invalid User Name");
				 InfoSteps("click on ResetPassword button");
		         
		A_ForgetPassewordpage reset=new A_ForgetPassewordpage();
		reset.Resetpassword(read.getProperty("InvalidUsername"));
		if (!driver.findElement(By.xpath("//div[@class=\"message warning fadable\"]")).getText().equalsIgnoreCase("\r\n" + 
				"Please contact HR admin in order to reset the password   \r\n" + 
				"    ")) {
			Pass("user unable to reset password with invalid creditonals");
		}else Fail("user able to reset password with invalid creditonals");
		reset.cleartxt();
		
		
	}
	
	//for valid
	@Test(priority=3,description="user able to reste pasword with valid username")
	public void TestCaseRestInvalid() {	
		Creattest("user should be able to resetpassword by valid username ", "Vrushabh", "Sanity");
		 
		 
		 InfoSteps("Launch Browser");
		 InfoSteps("provide URL of OrangeHRM");
		 InfoSteps("click on ForgetPassword btn");
		 InfoSteps("send valid User Name");
		 InfoSteps("click on ResetPassword button");
		
		A_ForgetPassewordpage reset=new A_ForgetPassewordpage();
		reset.Resetpassword(read.getProperty("ValidUsername"));
		if (driver.findElement(By.xpath("//div[@class=\"message warning fadable\"]")).isDisplayed()) {
             Pass("user able to rest password with valid creditionlas");

		}else Fail("user unable to rest password with valid creditionlas");
		reset.cleartxt();
	}
	
	//for cancel
	@Test(priority=4,description="user able to click on cancel button")
	public void TestCaseRestcancel() {
		Creattest("user should be unable to click on cancel ", "Vrushabh", "smoke");
		 
		 
		 InfoSteps("Launch Browser");
		 InfoSteps("provide URL of OrangeHRM");
		 InfoSteps("click on ForgetPassword btn");
		 InfoSteps("click on Cancel button");

	A_ForgetPassewordpage reset =new A_ForgetPassewordpage();
		reset.cancelbutton();
	
		if (driver.findElements(By.id("btnLogin")).size()>0) {
			Pass(" use able to click on cnacel button");
		}else Fail(" use able to click on cnacel button");
	}
	
	
}

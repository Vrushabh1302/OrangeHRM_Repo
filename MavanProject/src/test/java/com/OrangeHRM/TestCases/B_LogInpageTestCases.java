package com.OrangeHRM.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.OrangeHRM.Utility.BaseClass;
import com.OrangeHRM.Utility.Reports;
import com.OrangeHRM.pages.B_LogIn;
import com.aventstack.extentreports.Status;

 public class B_LogInpageTestCases extends Reports {
	  
	
    
    
	//for invalid 
	@Test (priority=5, description= "User should be not able to login with invalid creditionls ")
	public void TestCaseInvalid() {
		Creattest("User should be able to login with Invalid creditionls", "Dinesh", "Nigative");
		InfoSteps("Launch Browser");	
		InfoSteps("Provide Url");
		InfoSteps("provide InValid Username");
		InfoSteps("provide InValid Password");
		InfoSteps("Click on Log In button");
		B_LogIn firstpage=new B_LogIn();
		
		firstpage.Login(read.getProperty("InvalidUsername"), read.getProperty("InvalidPassword"));
		if (BaseClass.driver.findElements(By.xpath("//span[@id=\"spanMessage\"]")).size()>0) {
			
			Pass("User not able to login with invalid creditionls ");
		}else Fail("User able to login with invalid creditionls ");
	
	}
	

	//for valid 
	@Test (priority=6, description= "User should be able to login with valid creditionls ",groups= {"Smoke"})
	public void TestCaseValid() {
		Creattest("User should be able to login with valid creditionls", "Dinesh", "Smoke");
			InfoSteps("Launch Browser");	
			InfoSteps("Provide Url");
			InfoSteps("provide Valid Username");
			InfoSteps("provide Valid Password");
			InfoSteps("Click on Log In button");
		B_LogIn firstpage=new B_LogIn();
		firstpage.Login(read.getProperty("ValidUsername"), read.getProperty("ValidPassword"));
		
		if (BaseClass.driver.findElements(By.id("menu_dashboard_index")).size()>0) {
			Pass("user able to login with valid creditonals");
		}else Fail("user not able to login with valid creditonals");
		
		
	}
	
	@AfterMethod
	public void Flush() {
		extreport.flush();
	}
	

}

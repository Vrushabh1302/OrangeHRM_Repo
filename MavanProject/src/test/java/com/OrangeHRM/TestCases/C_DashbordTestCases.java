package com.OrangeHRM.TestCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.OrangeHRM.Utility.BaseClass;
import com.OrangeHRM.Utility.Reports;
import com.OrangeHRM.pages.C_Dashbord;
import com.aventstack.extentreports.Status;
import com.OrangeHRM.pages.B_LogIn;

public class C_DashbordTestCases extends Reports{

	@BeforeClass (enabled=false)
	public void Login() {
		B_LogIn login=new B_LogIn();
		login.Login(read.getProperty("ValidUsername"), read.getProperty("ValidPassword"));
	}
	
	@Test(priority=7,groups={"Smoke"})
	public void Logout() {
		Creattest("User Should able to LogOut", "Kalpesh", "smoke");
				
		 InfoSteps("Launch Browser");
		 
			InfoSteps("Provide Url");
			InfoSteps("provide InValid Username");
			InfoSteps("provide InValid Password");
			InfoSteps("Click on Log In button");
			InfoSteps("click on Dropdown Arrow");
			InfoSteps("click on logout in button");

	 C_Dashbord dashbord=new C_Dashbord();
	 dashbord.clickonlogout();
	 if (driver.findElements(By.id("btnLogin")).size()>0) {
		 Pass("User able to LogOut");
	 }
	 else Fail("User Unable to LogOut");
	}
	
@AfterMethod
public void Flush() {
	extreport.flush();
}
	
}

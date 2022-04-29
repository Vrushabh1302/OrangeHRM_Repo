package com.OrangeHRM.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.OrangeHRM.Utility.BaseClass;

public class C_Dashbord extends BaseClass{

	
	@FindBy (xpath="//a[@id=\"welcome\"]")
	WebElement logoutdrop;
	
	@FindBy (xpath="//a[text()='Logout']")
	WebElement logoutbtn;
	
	public C_Dashbord() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickonlogout() {
		
		logoutdrop.click();
		logoutbtn.click();
	}
	
	
}

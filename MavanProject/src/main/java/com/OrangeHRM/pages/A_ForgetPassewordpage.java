package com.OrangeHRM.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.OrangeHRM.Utility.BaseClass;

public class A_ForgetPassewordpage extends BaseClass {
	
    public A_ForgetPassewordpage() {
	PageFactory.initElements(driver , this);
}
    //for resetpassword
	@FindBy(xpath="//input[@id=\"securityAuthentication_userName\"]")
	WebElement txtUsernameforget;
	 
	@FindBy(id="btnSearchValues")
	
	WebElement btnResetpassword;
	
	public void Resetpassword(String username) {
		txtUsernameforget.sendKeys(username);
		btnResetpassword.click();
	}
	public void cleartxt() {
		txtUsernameforget.clear();
	}
	
	//for cancel button
	@FindBy(id="btnCancel")
	WebElement cancelbtn;
	public void cancelbutton() {
		cancelbtn.click();
	}
	
}

package com.OrangeHRM.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.OrangeHRM.Utility.BaseClass;

public class B_LogIn extends BaseClass {
 

	@FindBy(id="txtUsername")
	WebElement txtusernamebox;
	
	@FindBy (id="txtPassword")
	WebElement txtpasswordbox;
	
	@FindBy (id ="btnLogin")
	public static
	WebElement loginbuttn;
	
	//Create page factory class
	public B_LogIn(){
		PageFactory.initElements(driver, this);
	}
	
	public void Login(String Username , String Password) {
		txtusernamebox.sendKeys(Username);
		txtpasswordbox.sendKeys(Password);
		loginbuttn.click();
	}
	
	//for forget password
			@FindBy(xpath="//a[text()='Forgot your password?']")
			WebElement forgetpaswordlink;
			
			public void Forgetpassword() {
				forgetpaswordlink.click();
			}
			
	//for social media
			//linkdin
			@FindBy (xpath="//img[@alt=\"LinkedIn OrangeHRM group\"]")
			WebElement getlinkdinbtn;
			
			public void clickLinkdinbtn() {
				getlinkdinbtn.click();
			}
			//facebook
			@FindBy(xpath="//img[@alt=\"OrangeHRM on Facebook\"]")
			WebElement getfacebookbtn;
			public void clickFacebookbtn() {
				getfacebookbtn.click();
			}
			//twitter
			@FindBy(xpath="//img[@alt=\"OrangeHRM on twitter\"]")
			WebElement gettwitterbtn;
			public void clickTwitterbtn() {
				gettwitterbtn.click();
			}
			//youtube
			@FindBy(xpath="//img[@alt=\"OrangeHRM on youtube\"]")
			WebElement getyoutubebtn;
			public void clikcyoutubebtn() {
				getyoutubebtn.click();
			}
			
}

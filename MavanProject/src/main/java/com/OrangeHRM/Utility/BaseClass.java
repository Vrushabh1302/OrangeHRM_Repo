package com.OrangeHRM.Utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.xml.transform.Result;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class BaseClass  {

	public static Properties read;
	public static WebDriver driver;
	
	
  //before test case this method execute 
	
	@BeforeSuite (alwaysRun=true)
	public void ReadFile() {
	  read=new Properties();
	  try {
		read.load(new FileInputStream("Resources/Confi.properties"));
	} catch (IOException e) {
		e.printStackTrace();
	}
	  	BrowserLaunch();
	  	
	  	
	}
	
	
	
	public static void BrowserLaunch() {
		if (read.getProperty("NameofBrowser").equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "Resources/chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if (read.getProperty("NameofBrowser").equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "Resources/geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if (read.getProperty("NameofBrowser").equalsIgnoreCase("edge")){
			System.setProperty("webdriver.edge.driver", "Resources/msedgedriver.exe");
			driver=new EdgeDriver();
		}
		
		driver.manage().window().maximize();

	}
	
	@BeforeTest(alwaysRun=true)
	public void loadUrl(){
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		
	}
	
	
	
	//after test case execute this method call
	@AfterSuite(enabled= true)
	public void BrowserClose() {
		driver.close();
	}
	
	
	public void Back() {
		driver.navigate().back();
	}
	
	//for switch window
	public static String Parent;
	public static void Switchtowindow() {
		Parent= driver.getWindowHandle();
		Set<String> child=driver.getWindowHandles();
		Iterator<String>getchild=child.iterator();
		while(getchild.hasNext()) {
			getchild.next();
			if (!getchild.next().equalsIgnoreCase(Parent)) {
				driver.switchTo().window(getchild.next());
			}
		}
	}
	public static void Switchtoparentwindow() {
		driver.switchTo().window(Parent);
	}
	
	
}

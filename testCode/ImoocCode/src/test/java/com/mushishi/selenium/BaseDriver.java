package com.mushishi.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseDriver {
	public WebDriver driver;
	
	public WebDriver GetDriver(){
		return driver;
	}
	@BeforeClass
	public void test01(){
		System.setProperty("webdriver.chrome.driver", "D:\\java\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("BeforeClass---->test01");
	}
	
	@BeforeMethod
	public void test02(){
		System.out.println("BeforeMethod------>test02");
	}
	
	@AfterMethod
	public void test03(){
		System.out.println("AfterMethod------>test03");
	}
	@AfterClass
	public void test04(){
		System.out.println("AfterClass----->test04");
		driver.close();
	}
}

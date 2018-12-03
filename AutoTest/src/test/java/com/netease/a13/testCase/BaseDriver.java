package com.netease.a13.testCase;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;

public class BaseDriver {
	WebDriver driver;
	public BaseDriver() {
		System.setProperty("webdriver.chrome.driver","E:\\autosoftware\\Seleniumdriver\\Chromedriver2.41\\chromedriver.exe");
        driver = new ChromeDriver();		
		
	}
	
	/*
	   * 截图
	   */
	  public void takeScreenshot() {
			long date = System.currentTimeMillis(); // 获取当前的时间 ，长整型
			String path = String.valueOf(date); // 长整型转换成String类型
			String currentpath = System.getProperty("user.dir"); // 获取当前系统路径
			path = path+".png";
			String screenpath = currentpath+"/"+path;
			File Screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); // 截图
			try {
				FileUtils.copyFile(Screen,new File(screenpath));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
	    }
	  

}

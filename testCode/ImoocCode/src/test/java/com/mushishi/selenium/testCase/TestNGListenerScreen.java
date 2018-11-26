package com.mushishi.selenium.testCase;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.mushishi.selenium.BaseDriver;

public class TestNGListenerScreen extends TestListenerAdapter{
	//public static WebDriver driver;
	@Override
	public void onTestSuccess(ITestResult tr){
		super.onTestSuccess(tr);
	}
	
	  @Override
	  public void onTestFailure(ITestResult tr){
		  System.out.println(tr.getInstance());
		  BaseDriver base = (BaseDriver)tr.getInstance();
		  WebDriver driver = base.GetDriver();
		  takeScreenShot(driver);
		  super.onTestFailure(tr);
		  
	 }
  
	  @Override
	  public void onTestSkipped(ITestResult tr){
		  super.onTestSkipped(tr);
	  }
		/**
		 * 自动截图
		 * */
		public void takeScreenShot(WebDriver driver) {
		    SimpleDateFormat sf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		    Calendar cal = Calendar.getInstance();
		    Date date = cal.getTime();
		    String dateStr = sf.format(date);
		    String path = this.getClass().getSimpleName() + "_" + dateStr + ".png";
		    takeScreenShot((TakesScreenshot) driver, path);
		    //takeScreenShot((TakesScreenshot) driver, path);
		}
		
		/**
		 * 传入参数截图
		 * */
		public void takeScreenShot(TakesScreenshot drivername, String path) {
		    String currentPath = System.getProperty("user.dir"); // get current work
		    File scrFile = drivername.getScreenshotAs(OutputType.FILE);
		    try {
		        FileUtils.copyFile(scrFile, new File(currentPath + "\\" + path));
		    } catch (Exception e) {
		        e.printStackTrace();
		    } finally {
		    	System.out.println("截图成功");
		    }
		}

}

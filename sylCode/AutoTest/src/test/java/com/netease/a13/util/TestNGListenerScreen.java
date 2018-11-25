package com.netease.a13.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.netease.a13.testCase.BaseDriver;

public class TestNGListenerScreen extends TestListenerAdapter{
	
	  @Override
	  public void onTestSuccess(ITestResult tr) {
		  super.onTestSuccess(tr);
	
	  }

	  @Override
	  public void onTestFailure(ITestResult tr) {
	      System.out.println("这个测试方法执行失败");
	      super.onTestFailure(tr);
	      takeScreenshot(tr);
	  }

	  @Override
	  public void onTestSkipped(ITestResult tr) {
	  super.onTestSkipped(tr);
	  }
	  
	public void takeScreenshot(ITestResult tr) {
	BaseDriver b = (BaseDriver) tr.getInstance();  // 获取对象tr的所有实例b,强制转换成BaseDriver
		b.takeScreenshot();
	}
			  
	  
	  
	  
		 /**
		  * 自动截图 
		  */
	     public void takeScreenshot(WebDriver driver) {
	    	 SimpleDateFormat sf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss"); // 格式化时间
	    	 Calendar cal = Calendar.getInstance(); // 初始化日历
	    	 Date date = cal.getTime();
	    	 String dateStr = sf.format(date); // 装换成指定的时间格式
	    	 String path = this.getClass().getSimpleName() + "_" + dateStr + ".png";
	    	 takeScreenshot((TakesScreenshot) driver,path);
	    	 
	     }

	     /***
	      * 传入参数截图
	      * @param drivername
	      * @param path
	      */


	     	public void takeScreenshot(TakesScreenshot drivername, String path) {
	     	    String currentpath = System.getProperty("user.dir"); // 获取当前系统路径
	     	    File scrFile = drivername.getScreenshotAs(OutputType.FILE);
	     		    try {
	     				FileUtils.copyFile(scrFile, new File(currentpath + "\\"+ path));
	     			} catch (IOException e) {
	     				// TODO Auto-generated catch block
	     				e.printStackTrace();
	     			}
	     	}

	  
	  
	  
}


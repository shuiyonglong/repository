package com.netease.a13.base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DriverBase {
	public WebDriver driver;
	public DriverBase(String browser) {
		SelectDriver selectdriver = new SelectDriver();
		this.driver = selectdriver.driverName(browser);
		
	}
	
	public void stop() {
		System.out.println("stop webdriver");
		driver.close();
		
	}
	/***
	 * 获取driver
	 */
	public WebDriver getDriver() {
		return driver;
	}
	
	/***
	 * 封装element
	 */

	public WebElement findElement(By by) {

		WebElement element = driver.findElement(by);
		return element;
	}
	 /**
	  * get封装
	  * @param url
	  */
	public void get(String url) {
		driver.get(url);
	}
	
	public void sleep(int sleep) {
		try {
			Thread.sleep(sleep);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
  /**
   * 窗口最大化
   */
	public void manage() {
		// TODO Auto-generated method stub
		 driver.manage().window().maximize();
	}
    /**
     * 模拟返回方法
     */
	public void back() {
		driver.navigate().back();
			
	}
	/***
	 * 封装点击的方法
	 */
	public void click(WebElement element) {
		if(element != null) {
		element.click();
		}else {
			System.out.println(element + "定位没有元素，点击失败");
		}
			
	}
	/**
	 * 关闭浏览器
	 */
	public void close() {
		driver.close();
	}
	/***
	 *获取当前系统窗口list 
	 */
	public List<String> getWindowsHandles(){
		Set<String> windowsHandles = driver.getWindowHandles();
		List<String> handles = new ArrayList<String>(windowsHandles);
		return handles;
	}
	/***
	 * 获取当前窗口
	 */
	public String getWindowHandle() {
		return driver.getWindowHandle();
	}
	/***
	 * 切换windows窗口
	 */
	public void SwitchWindows(String name) {
		driver.switchTo().window(name);
	}
	
	/***
	 * 切换alter窗口
	 */
	public void SwitchAlter() {
		driver.switchTo().alert();
	}
	/***
	 * 模态框的切换
	 */
	public void SwitchToMode() {
		driver.switchTo().activeElement();
	}
	/***
	 * actionMoveElement
	 */
	public void actionMove(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
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

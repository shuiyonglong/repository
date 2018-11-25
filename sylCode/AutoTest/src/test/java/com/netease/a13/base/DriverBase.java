package com.netease.a13.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.netease.a13.util.ProUtil;

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
	 * 封装element
	 */

	public WebElement element(By by) {

		WebElement element = driver.findElement(by);
		return element;
	}
	
	/**
	 * 封装By， by
	 * @return 
	 */
   public By byStr(String Key) {
	   
	 ProUtil properties = new ProUtil("element.properties");
	 String avator = properties.getPro(Key); // 获取key值
	 String avatortype = avator.split(">")[0]; // 获取key的第一个定位类型
	 String avatorValue = avator.split(">")[1]; // 获取key的第二个定位值
	    
	if(avatortype.equals("id"))
		return By.id(avatorValue);
	else if(avatortype.equals("name"))
		return By.name(avatorValue);
	else if(avatortype.equals("xpath"))
		return By.xpath(avatorValue);
	else if(avatortype.equals("className"))
		return By.className(avatorValue);
	else
		return By.linkText(avatorValue);
	  
   }
	
	
	

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
   /**
    * 封装点击方法
    */
	public void click(WebElement element) {
      		element.click();
	}

}

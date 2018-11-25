package com.netease.a13.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.netease.a13.base.DriverBase;

public class BasePage {
	public DriverBase driver;
	public BasePage(DriverBase driver) {
		this.driver = driver;
	
	}

	/**
	 * 定位element
	 * @param By by 
	 */
	public WebElement element(By by) {
		
	WebElement element = driver.element(by);
	return element;
		
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
	 * 封装输入的方法
	 */
	public void sendkeys(WebElement element, String value) {
		if(element != null) {
		element.sendKeys(value);
		}else {
			System.out.println(element + "元素没有定位到" + value + "输入失败");
		}
		
	}
	/**
	 * 判断元素是否显示
	 */
	
   public boolean assertElement(WebElement element) {
	   return element.isDisplayed();
	    
   }
	
}


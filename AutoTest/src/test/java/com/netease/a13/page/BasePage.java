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
		
	WebElement element = driver.findElement(by);
	return element;
		
	}
	 /***
	    * 层级定位，通过父节点定位到子节点
		 * 需要传入父节点和子节点的by
	    */
	public WebElement nodeElement(By by,By nodeBy) {
		WebElement el = this.element(by); // 获取父节点el
		return el.findElement(nodeBy); // 返回获取的子节点
		
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
   /**
    * 获取文本信息
    */
  public String getText(WebElement element) {
	  return element.getText();
  }
   
	
}


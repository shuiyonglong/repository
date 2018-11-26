package com.netease.a13.util;
import org.openqa.selenium.By;

public class getByLocator {
	public static By getLocator(String Key) {
		   
		 ProUtil properties = new ProUtil("element.properties");
		 String avator = properties.getPro(Key); // 获取key值
		 String avatortype = avator.split(">")[0]; // 获取key的第一个定位类型
		 String avatorValue = avator.split(">")[1]; // 获取key的第二个定位值
		    
		if(avatortype.equals("id")) {
			return By.id(avatorValue);
		}else if(avatortype.equals("name")) {
			return By.name(avatorValue);
		}else if(avatortype.equals("xpath")) {
			return By.xpath(avatorValue);
		}else if(avatortype.equals("className")) {
			return By.className(avatorValue);
		}else {
			return By.linkText(avatorValue);
		}
		  
	   }

}

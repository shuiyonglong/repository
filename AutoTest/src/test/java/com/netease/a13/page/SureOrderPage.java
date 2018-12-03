package com.netease.a13.page;

import org.openqa.selenium.WebElement;

import com.netease.a13.base.DriverBase;
import com.netease.a13.util.getByLocator;

public class SureOrderPage extends BasePage{
     public SureOrderPage(DriverBase driver) {
		super(driver);
	}
    
	/***
     * 获取提交订单的按钮
     */
     public WebElement SureOrderElement() {
    	 return element(getByLocator.getLocator("sureOrder"));
     }
     
     
}

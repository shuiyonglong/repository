package com.netease.a13.page;

import org.openqa.selenium.WebElement;

import com.netease.a13.base.DriverBase;
import com.netease.a13.util.getByLocator;

public class LoginPage extends BasePage{
	public LoginPage(DriverBase driver) {
		super(driver);
	}
	/**
	 * 获取用户名输入框
	 */
	
	public WebElement getUserElement() {
	  return element(getByLocator.getLocator("loginName"));
		
	}
	/***
	 * 获取密码输入框
	 */
	public WebElement getPasswordElement() {
		return element(getByLocator.getLocator("passWord"));
	}
	/***
	 * 获取登录按钮
	 */
	public WebElement getButtonElement() {
		return element(getByLocator.getLocator("LoginButton"));
		
			
	}
	/**
	 * 获取自动登录element
	 */
	public WebElement getAutoLoin() {
		return element(getByLocator.getLocator("autoElement"));
	}
	
	
	public WebElement sendkeys() {
		
		return element(getByLocator.getLocator("loginName"));
	}
	
		
}

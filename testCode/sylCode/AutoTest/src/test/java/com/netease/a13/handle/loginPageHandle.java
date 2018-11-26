package com.netease.a13.handle;

import org.openqa.selenium.WebElement;

import com.netease.a13.base.DriverBase;
import com.netease.a13.page.BasePage;
import com.netease.a13.page.LoginPage;

public class loginPageHandle{
	public DriverBase driver;
	public LoginPage lp;

	public loginPageHandle(DriverBase driver) {
		this.driver = driver;
		lp = new LoginPage(driver);
	}
	/***
	 * 输入用户名
	 */
	public void senkeysUser(String loginName) {
		lp.sendkeys(lp.getUserElement(), loginName);
	}
	/***
	 * 输入密码
	 */
	public void sendkeysPassword(String password ) {
		lp.sendkeys(lp.getPasswordElement(), password);
	}
	/**
	 * 点击登录
	 */
   public void clickLoginButton() {
	   lp.click(lp.getButtonElement());
   }
   
   /**
    * 点击自动登录
    */
   public void clickAutoLogin() {
	   lp.click(lp.getAutoLoin());
   }
   /**
	 * 判断是否是登录页面
	 */
	
  public boolean assertLoginPage() {
	   return lp.assertElement(lp.getUserElement());
	    
  }
   
   
   
   
   
   
	
	
}

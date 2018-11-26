package com.netease.a13.business;

import com.netease.a13.base.DriverBase;
import com.netease.a13.handle.loginPageHandle;

public class LoginPro {
	public loginPageHandle lph;
	public LoginPro(DriverBase driver) {
		lph = new loginPageHandle(driver);
	}
public void login(String loginName,String password) {
		
		if(lph.assertLoginPage()) {
		lph.senkeysUser(loginName);
		lph.sendkeysPassword(password);
		lph.clickAutoLogin();
		lph.clickLoginButton();
		}else {
	      System.out.println("页面不存在或者状态不正确");
		}
		
				
		}
		
}

package com.netease.a13.business;

import com.netease.a13.base.DriverBase;
import com.netease.a13.handle.SureOrderHandle;

public class SureOrderPro {
	DriverBase driver;
	SureOrderHandle sureorderhandle;
	public SureOrderPro(DriverBase driver) {
		this.driver = driver;
		sureorderhandle = new SureOrderHandle(driver);
	}
	/**
	 * 确认订单
	 */
	public void SureOrder() {
		sureorderhandle.clickSureOrderElement();
	}
	

}

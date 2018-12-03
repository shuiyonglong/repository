package com.netease.a13.handle;

import com.netease.a13.base.DriverBase;
import com.netease.a13.page.SureOrderPage;

public class SureOrderHandle {
	 public DriverBase driver;
	 public SureOrderPage sureorderpage;
	 public SureOrderHandle(DriverBase driver) {
		this.driver = driver;
		sureorderpage = new SureOrderPage(driver);
	 }
		/**
		 * 点击提交订单按钮
		 */
		public void clickSureOrderElement() {
			driver.click(sureorderpage.SureOrderElement());
		}
	
	
        
}

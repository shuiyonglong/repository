package com.netease.a13.handle;

import org.openqa.selenium.WebElement;

import com.netease.a13.base.DriverBase;
import com.netease.a13.page.coursePage;

public class coursePageHandle {
	public DriverBase driver;
	public coursePage coursepage;
	public coursePageHandle(DriverBase driver) {
		this.driver = driver;
		coursepage = new coursePage(driver);
	}
	/***
	 * 点击立即购买按钮
	 */
	public void clickBuyNow() {
		coursepage.click(coursepage.getBuyriggerElement());
	}
	/**
	 * 点击添加购物车按钮
	 */
    
	public void clickAddCart() {
		coursepage.click(coursepage.getAddCartElement());
	}
	/**
	 * 
	 * 点击右上角购物车
	 */
	public void clickShopCart() {
		driver.click(coursepage.getShopCartElement());
//		driver.actionMove(coursepage.getShopCartElement());
	}
	/***
	 * 获取购物车数量
	 */
	public String getShopCartNum() {
		WebElement element = coursepage.getShopCartNumElement();
		return coursepage.getText(element);
 
	}
	/**
	 * 获取课程名称
	 */
	
	public String getCourseName() {
		WebElement element = coursepage.getCourseNameElement();
		return coursepage.getText(element);
	}
	/***
	 * 点击已购买弹框中的确定按钮
	 */
	public void clickReadBuySure() {
		
		coursepage.getReadBuy();
	}
	
	/****
	 * 点击购物车页面去结算按钮
	 */
	public void clickGoPayElement() {
		driver.click(coursepage.getGoPayElement());
	}
	
	
	
	
	
	
	
	
	
	
}

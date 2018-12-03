package com.netease.a13.page;

import org.openqa.selenium.WebElement;

import com.netease.a13.base.DriverBase;
import com.netease.a13.util.getByLocator;

public class coursePage extends BasePage{

	public coursePage(DriverBase driver) {
		super(driver);
	}
	
	/**
	 * 获取立即购买的element
	 */
	
	public WebElement getBuyriggerElement() {
		return element(getByLocator.getLocator("buyNow"));
		
	}
	/***
	 * 获取添加购物车element
	 */
	
	public WebElement getAddCartElement() {
		return element(getByLocator.getLocator("addCart"));
		
	}
	
	/***
	 * 获取右上角购物车element
	 */
	public WebElement getShopCartElement() {
		return element(getByLocator.getLocator("shopCart"));
	}
	
	/***
	 * 获取购物车数量element
	 */
	public WebElement getShopCartNumElement() {
		return element(getByLocator.getLocator("shopCart"));
		
	}
	/***
	 * 获取课程详情页面左上角课程名element
	 */
	public WebElement getCourseNameElement() {
		return nodeElement(getByLocator.getLocator("courseInfo"),getByLocator.getLocator("courseInfoText"));
		
	}
	/***
	 * 购物车页面去结算
	 */
	public WebElement getGoPayElement() {
		return nodeElement(getByLocator.getLocator("shopGoPay"),getByLocator.getLocator("shopGoPayNode"));
		
	}
	/***
	 * 通过子父节点定位已购买弹窗确定按钮
	 */
	public WebElement getReadBuy() {
//		return element(getByLocator.getLocator("readBuySure"));
		return nodeElement(getByLocator.getLocator("readBuy"),getByLocator.getLocator("readBuySure"));
		
	}

}

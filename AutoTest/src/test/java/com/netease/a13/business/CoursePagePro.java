package com.netease.a13.business;

import com.netease.a13.base.DriverBase;
import com.netease.a13.handle.coursePageHandle;

public class CoursePagePro {
	DriverBase driver;
	coursePageHandle coursepagehandle;
	public CoursePagePro(DriverBase driver) {
		this.driver = driver;
		coursepagehandle = new coursePageHandle(driver);
	}
	/***
	 * 添加购物车
	 */
	public void AddCart() {
		int beforeNum;
		int afterNum;
		String afterCourseNum;
		String courseNum = coursepagehandle.getShopCartNum();
		try {
		    beforeNum = Integer.valueOf(courseNum); // coursrNum的值转换为整型
		    System.out.println(beforeNum);
		}catch(Exception e){
			
			beforeNum = 0;
		}
		coursepagehandle.clickAddCart();  
		driver.sleep(2000);
		try {
			driver.SwitchToMode();
//			coursepagehandle.clickBuyNow();
			coursepagehandle.clickReadBuySure();
		}catch(Exception e) {
			
		}
		driver.sleep(2000);
		 afterCourseNum = coursepagehandle.getShopCartNum(); // 点击添加购物车后再获取最新的购物车数量
		try {
			afterNum = Integer.valueOf(afterCourseNum);
			System.out.println(afterNum);
			
		}catch(Exception e) {
			afterNum = beforeNum;
		}
	    driver.sleep(2000);
		
		if(afterNum == beforeNum + 1) {
			System.out.println("添加购物车成功");
			coursepagehandle.clickShopCart();
		}else if(afterNum > 0){
			coursepagehandle.clickShopCart();

		}else {
			coursepagehandle.clickShopCart();
		}

		
	}
	/**
	 * 点击立即购买
	 */
    public void buyNow(){
	  coursepagehandle.clickBuyNow();
   }
    
   
 
}

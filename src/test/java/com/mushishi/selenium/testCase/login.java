package com.mushishi.selenium.testCase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mushishi.selenium.base.DriverBase;
import com.mushishi.selenium.business.CourseListPagePro;
import com.mushishi.selenium.business.CoursePagePro;
import com.mushishi.selenium.business.HomePagePro;
import com.mushishi.selenium.business.LoginPro;
import com.mushishi.selenium.business.OrderPayPagePro;
import com.mushishi.selenium.business.SureOrderPagePro;
import com.mushishi.selenium.util.getByLocator;


public class login extends CaseBase{
	public DriverBase driver;
	public LoginPro loginpro;
	public HomePagePro homepagepro;
	
	@Test
	public void testLoginHome(){
		this.driver = InitDriver("chrome");
		driver.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		loginpro = new LoginPro(driver);
		homepagepro = new HomePagePro(driver);
		driver.get("http://coding.imooc.com/");
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		homepagepro.clickLoginButton();
	}
	@Test(dependsOnMethods={"testLoginHome"})
	public void testLogin(){
		String username = "18513199586";
		String pass = "111111";
		loginpro.login(username, pass);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	/**
	 * 下单流程
	 * */
	@Test(dependsOnMethods={"testLogin"})
	public void downOrder(){
		driver.get("http://coding.imooc.com/class/105.html");
		String currentText = this.buyCourseNow();
		System.out.println("当前课程信息"+currentText);
		this.sureOrder();
		this.getOrder();
		String orderCourseText = this.getOrderCourse();
		System.out.println("订单页面课程信息"+orderCourseText);
		if(currentText.equals(orderCourseText)){
			System.out.println("下单成功");
		}
	}
	
	
	
	
	
	/**
	 * 获取element
	 * 也可以是父element
	 * */
	public WebElement getElement(By by){
		return driver.findElement(by);
	}
	/**
	 * 通过父节点，获取子节点
	 * */
	public WebElement getElement(WebElement element,By by){
		return element.findElement(by);
	}
	/**
	 * 获取课程信息
	 * */
	public String getCourseText(WebElement element){
		return element.getText();
	}
	
	/**
	 * 立即购买，然后返回课程信息
	 * */
	public String buyCourseNow(){
		WebElement element = this.getElement(getByLocator.getLocator("courseInfo"));
		WebElement elementNode = this.getElement(element, getByLocator.getLocator("courseInfoText"));
		String currentText = this.getCourseText(elementNode);
		driver.click(this.getElement(getByLocator.getLocator("buyNow")));
		return currentText;
	}
	
	/**
	 * 点击确定订单
	 * */
	public void sureOrder(){
		driver.click(this.getElement(getByLocator.getLocator("sureOrder")));
	}
	
	/**
	 * 获取订单号text
	 * 
	 * */
	public String getOrder(){
		String orderText = this.getCourseText(this.getElement(getByLocator.getLocator("order")));
		return orderText;
	}
	
	/**
	 * 获取支付中心商品信息
	 * */
	public String getOrderCourse(){
		WebElement element = this.getElement(getByLocator.getLocator("orderCourse"));
		WebElement elementNode = this.getElement(element,getByLocator.getLocator("orderCourseNode"));
		return this.getCourseText(elementNode);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/***
	 *
	 * 下单流程
	 * */
	public void buyCourse(){
		driver.get("http://coding.imooc.com/class/105.html");
		String courseDetil = driver.findElement(By.className("path")).findElement(By.tagName("span")).getText();
		driver.findElement(By.id("buy-trigger")).click();
		driver.findElement(By.linkText("提交订单")).click();
		String ordertext = driver.findElement(By.className("order")).getText();
		if(ordertext != null){
			String orderString = driver.findElement(By.className("item")).findElement(By.tagName("dt")).getText();
			Assert.assertEquals(courseDetil,orderString,"不一样");
		}
		driver.close();
	}
	
	
	
	
}

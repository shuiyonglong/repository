package com.netease.a13.testCase;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.netease.a13.base.DriverBase;
import com.netease.a13.business.CoursePagePro;
import com.netease.a13.business.LoginPro;
import com.netease.a13.business.SureOrderPro;
import com.netease.a13.util.getByLocator;


public class Login extends casebase{
	public DriverBase driver;
	public LoginPro lp;
	public CoursePagePro cpp;
	public SureOrderPro sop;
	static Logger logger = Logger.getLogger(Login.class);
	public Login() {
	         this.driver = InitDriver("chrome");
		     lp = new LoginPro(driver);
		     cpp = new CoursePagePro(driver);
		     
	}
	
	@Test
	public void getloginHome() {
	driver.get("http://www.imooc.com");	
	driver.manage(); 
	driver.findElement((By.linkText("登录"))).click();
	driver.sleep(5000);
		
	}
    @Test(dependsOnMethods={"getloginHome"})
	public void testlogin() {
    	logger.debug("第一次打印log4j日志");
    	logger.error("打印错误信息");
		lp.login("2357895363@qq.com","lulisyl19920918@");
		driver.sleep(3000);
		driver.get("https://coding.imooc.com/class/74.html");

	}
    /***
     * 获取element，也可以是父element
     */
    
    public WebElement getElement(By by) {
    	return driver.findElement(by);
    }
    
    /**
     * 通过父节点，获取子节点
     */
    public WebElement getElement(WebElement element,By by) {
    	return element.findElement(by);
    }
    
    /**
     * 获取课程信息
     */
  public String getCourseText(WebElement element) {
	  
	return element.getText();
	
  } 
  
  /**
   * 点击立即购买，返回课程信息
   */
  public String BycourseNow() {
	  WebElement element = this.getElement(getByLocator.getLocator("courseInfo")); // 获取父节点
	  WebElement elementNode = this.getElement(element, getByLocator.getLocator("courseInfoText")); // 获取子节点
	  String CurrentText = this.getCourseText(elementNode);
	  driver.click(this.getElement(getByLocator.getLocator("byNow")));
	  return CurrentText;
	   }
  
  /**
   * 点击确定订单
   */
  public void SureOrder() {
	  driver.click(this.getElement(getByLocator.getLocator("sureOrder"))); 
  }
  /**
   * 获取订单号text
   */
  public String getOrder() {
	String orderText = this.getCourseText(this.getElement(getByLocator.getLocator("order")));
	return orderText;
  }
  /***
   * 获取支付中心的商品信息
   */
  public String getOrderCourse() {
	 WebElement oc = this.getElement(getByLocator.getLocator("orderCourse"));
	 WebElement oct =  this.getElement(oc, getByLocator.getLocator("orderCourseText"));
	return this.getCourseText(oct);
	  
  }
  
  /***
   * 下单流程
   */
//  @Test(dependsOnMethods= {"testlogin"})
 
  public void downOrder() {
	  driver.get("https://coding.imooc.com/class/74.html");
	  driver.sleep(5000);
	  String currentText = this.BycourseNow();
	  System.out.println("当前课程信息为：" + currentText);
	  driver.sleep(3000);
      this.SureOrder();
	  this.getOrder();
	  String orderCourseText = this.getOrderCourse();
	  System.out.println("订单页面的课程信息为：" + orderCourseText);
	  if(orderCourseText.equals(currentText)) {
		  System.out.println("下单成功了");
	  }

	  
  }
  
  
  /***
   * 添加购物车
   */
  @Test(dependsOnMethods= {"testlogin"})
  public void testAddCart() {
	  cpp.AddCart();	  
	  
  }
  
  
  
  
//  
//  /***
//   * 下单流程
//   */
//	public void buyCourse() {
//		driver.get("https://coding.imooc.com/class/74.html");
//		driver.sleep(3000);
//		String courseDetail = driver.findElement(By.className("path")).findElement(By.tagName("span")).getText();
//		driver.findElement(By.id("buy-trigger")).click();
//		driver.findElement(By.linkText("提交订单")).click();
//		String orderText = driver.findElement(By.className("order")).getText();
//		if(orderText !=null) {
//		       String orderString = driver.findElement(By.className("left")).findElement(By.tagName("dt")).getText();
//		       Assert.assertEquals(courseDetail,orderString,"购买的商品信息不一样");
//		}	
//	}

}

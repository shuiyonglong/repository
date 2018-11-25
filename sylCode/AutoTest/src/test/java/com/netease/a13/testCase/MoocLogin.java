package com.netease.a13.testCase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.netease.a13.util.ProUtil;
import com.netease.a13.util.TestNGListenerScreen;

@Listeners({TestNGListenerScreen.class})

public class MoocLogin extends BaseDriver {
  @Test
  public void InitDriver() {
	
	System.setProperty("webdriver.chrome.driver","E:\\autosoftware\\Seleniumdriver\\Chromedriver2.41\\chromedriver.exe");
	driver = new ChromeDriver();
	String geturl = "https://www.imooc.com/user/newlogin/from_url/1005/";
	driver.get(geturl);
//	driver.manage().window().maximize();
    }
  
  
  
  
  @Test(dependsOnMethods= {"InitDriver"})
  
  public void MoocLogin() {
	 //   Assert.assertEquals(1, 2);
	    this.InitDriver();
        this.sleep(1000); 
        String loginName = "23578953623@qq.com";
        String passWord = "lulisyl19920918@";
		WebElement Loginaccount = this.element(this.byStr("loginName"));   // 用户名输入定位
		WebElement Loginpassword = this.element(this.byStr("passWord"));   // 用户密码输入定位
		WebElement check_element = this.element(this.byStr("autoElement")); // 七天内自动登录按钮定位
		Loginaccount.click();
		Loginaccount.sendKeys(loginName);
		Loginpassword.click();
		Loginpassword.sendKeys(passWord);
		boolean is_select = check_element.isSelected();  // 自动登录按钮是否选中
		boolean is_enable = check_element.isEnabled();   // 自动登录按钮是否有效
		check_element.click();  
		System.out.println(is_select);
		System.out.println(is_enable);
    	this.element(this.byStr("LoginButton")).click();    //点击登录
//        driver.findElement(this.byStr(buttonby, buttonElement)).click(); //xpath��λ--�����¼
		this.sleep(3000);
		/**
		 * 判断是否登录成功
		 */
		WebElement avator1 = this.element(this.byStr("avatorElement"));
		Actions action = new Actions(driver);
		action.moveToElement(avator1).perform();
		String username = this.element(this.byStr("userElement")).getText();
		if(username.equals("avg123456")) {
			this.takeScreenshot();
			System.out.println("登录成功");
		}else {
			System.out.println("登录失败");
		}
	    driver.close();
  }
  
	/**
	 * 封装By， by
	 * @return 
	 */
	
   public By byStr(String Key) {
	   
	 ProUtil properties = new ProUtil("element.properties");
	 String avator = properties.getPro(Key); // 获取key值
	 String avatortype = avator.split(">")[0]; // 获取key的第一个定位类型
	 String avatorValue = avator.split(">")[1]; // 获取key的第二个定位值
	    
	if(avatortype.equals("id"))
		return By.id(avatorValue);
	else if(avatortype.equals("name"))
		return By.name(avatorValue);
	else if(avatortype.equals("xpath"))
		return By.xpath(avatorValue);
	else if(avatortype.equals("className"))
		return By.className(avatorValue);
	else
		return By.linkText(avatorValue);
	  
   }
   /**
    * element封装 
    * 
    */
   public WebElement element(By by) {
	   
	  WebElement ele = driver.findElement(by);
	  return ele;
	   
   }
   
  
  
  public void sleep(int sleeptime) {
	  
	  
	  try {
		Thread.sleep(sleeptime);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
  
  /**
   * 截图
   */
  public void takeScreenshot() {
		long date = System.currentTimeMillis(); // 获取当前的时间 ，长整型
		String path = String.valueOf(date); // 长整型转换成String类型
		String currentpath = System.getProperty("user.dir"); // 获取当前系统路径
		path = path+".png";
		String screenpath = currentpath+"/"+path;
		File Screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); // 截图
		try {
			FileUtils.copyFile(Screen,new File(screenpath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
    }
  
  
	 /**
	  * 自动截图 
	  */
  public void takeScreenshot(WebDriver driver) {
 	 SimpleDateFormat sf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss"); // 格式化时间
 	 Calendar cal = Calendar.getInstance(); // 初始化日历
 	 Date date = cal.getTime();
 	 String dateStr = sf.format(date); // 装换成指定的时间格式
 	 String path = this.getClass().getSimpleName() + "_" + dateStr + ".png";
 	 takeScreenshot((TakesScreenshot) driver,path);
 	 
  }

/***
 * 传入参数截图
 * @param drivername
 * @param path
 */


	public void takeScreenshot(TakesScreenshot drivername, String path) {
	    String currentpath = System.getProperty("user.dir"); // 获取当前系统路径
	    File scrFile = drivername.getScreenshotAs(OutputType.FILE);
		    try {
				FileUtils.copyFile(scrFile, new File(currentpath + "\\"+ path));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}


//	public static <Interator> void main(String[] args) {
//     Login action = new Login();
////     action.MoocLogin("2357895363@qq.com","lulisyl19920918@");
//     /**
//      * 登录账号参数化 
//      * key-Value
//      * username-password 
//      */
//     
//     HashMap<String,String> user = new HashMap<String,String>(); // 声明对象并初始化
//     
//     user.put("2357895363@qq.com", "lulisyl19920918@"); // HashMap中存数据
//     user.put("18720994412","64570829syl");
//     Iterator<Entry<String, String>> us = user.entrySet().iterator(); // 读取这两组值---把HashMap弄成一个迭代器
//     /*
//      * while循环进行迭代
//      */
//     while(us.hasNext()) {
//    	 Map.Entry entry = (Map.Entry)us.next();
//    	 String username = entry.getKey().toString();
//    	 String password = entry.getValue().toString();
//    	 action.MoocLogin(username,password );
//
//    	 
//    	 
//    	 
//     }
//     
//     
//     
//	}

}

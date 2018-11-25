package com.netease.a13.testCase;

import java.io.IOException;
import java.util.List;
import java.util.Set;

//import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;




//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.*;

public class elementLogcat {
	public WebDriver driver; // driver全局声明
	public WebElement WindowHandle;   
	/**
	 * 初始化driver
	 * 
	 */  

	public void InitDriver() {
//		System.setProperty("webdriver.firefox.bin","E:\\Firefox\\firefox.exe");  
//	    driver=new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver","E:\\autosoftware\\Seleniumdriver\\Chromedriver2.41\\chromedriver_2.41//chromedriver.exe");// 设置driver驱动
		driver = new ChromeDriver();//实例化driver
//		String Testurl="http://testing.avg.163.com";
//		driver.get(Testurl);
	    //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 

		
          
	}
	
	public void InputBox(){
		
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // ������ʽ�ȴ�ʱ��5s
	
		driver.findElement(By.xpath("//*[@id=\"react-root\"]/div[1]/div/div[3]/div[2]/button[2]/span")).click();    //�����ҳ��¼��ť
		String getAt=driver.findElement(By.name("mobile")).getAttribute("placeholder");
		System.out.println(getAt);
		    WebElement LoginAccount = driver.findElement(By.name("mobile"));
		    WebElement LoginPassword = driver.findElement(By.name("password")); 
		    WebElement LoginButton = driver.findElement(By.className("na-button"));
		   
		      LoginAccount.sendKeys("18720994412");
		      String accountvalue = LoginAccount.getAttribute("value");  // ��ȡ�˻������������Ϣ
		      System.out.println(accountvalue);
		  
		      LoginPassword.sendKeys("avg123456");
		      LoginButton.click();
		      this.sleep(3000);
		      driver.get("http://testing.avg.163.com/home");
		      WebElement game= driver.findElement(By.className("na-input"));
		      WebElement SearchButton= driver.findElement(By.xpath("//*[@id=\"react-root\"]/div[1]/div/div[3]/div[1]/span/span/button"));
		     // WebElement gamezhuye=driver.findElement(By.linkText("Gif测试"));
		      game.sendKeys("gif测试");	                      //������Ʒ
		      SearchButton.click();
              this.sleep(3000);
				 
			
//	          gamezhuye.click(); // ����gif������Ʒ��ҳ
//		     driver.findElement(By.linkText("������")).click();  // ������������ҳ��
//		     driver.findElement(By.xpath("//*[@id=\"react-root\"]/div[1]/div/div[3]/div[2]/div[1]")).click();
	}
	
	/***
	 * 慕课网登录
	 */
	
	public void MoocLogin() {
//		driver.get("https://www.imooc.com/user/newlogin/from_url/1005/");
		driver.get("https://www.imooc.com/");
		driver.findElement(By.linkText("��¼")).click();
		this.sleep(3000);
		WebElement Loginaccount = driver.findElement(By.name("email"));
		WebElement Loginpassword = driver.findElement(By.name("password"));
		WebElement check_element = driver.findElement(By.id("auto-signin")); //��λ�Ƿ��������Զ���¼��
		Loginaccount.click();
		Loginaccount.sendKeys("2357895363@qq.com");
		Loginpassword.click();
		Loginpassword.sendKeys("lulisyl19920918@");
		boolean is_select = check_element.isSelected();  // �ж��Ƿ�ѡ��
		boolean is_enable = check_element.isEnabled();   // �ж�Ԫ���Ƿ���Ч
		check_element.click();  // ȡ��ѡ��
		System.out.println(is_select);
		System.out.println(is_enable);
//		driver.findElement(By.className("moco-btn")).click();    //�����¼   
        driver.findElement(By.xpath("//*[@id=\"signup-form\"]/div[5]/input")).click(); //xpath��λ--�����¼
		this.sleep(3000);
		/**
		 * �ж��û��Ƿ��¼�ɹ�
		 */
		WebElement avator = driver.findElement(By.id("header-avator"));
		Actions action = new Actions(driver);
		action.moveToElement(avator).perform();
		String username = driver.findElement(By.linkText("weixin_梦幻的白夜_0")).getText();
		if(username.equals("weixin_梦幻的白夜_0")) {
			System.out.println("登陆成功");
		}else {
			System.out.println("登录失败");
		}
		
		
		
		
	}
	   /***
	    * 鼠标悬停事件
	    */
	public void moseAction() {
		WebElement avator = driver.findElement(By.linkText("��ά / ���� / ���ݿ�"));
		Actions actions = new Actions(driver); 
		actions.moveToElement(avator).perform();
		String WindowHandle = driver.getWindowHandle();  // 获取当前窗口
		driver.findElement(By.linkText("���ܲ���")).click(); //������ܲ��ԣ������ܲ�����ҳ��
		
		
	}
	
	/**
	 * 窗口切换
	 */
	public void windowsHandle() {
		
		Set<String> Handles = driver.getWindowHandles(); // 获取所有的窗口
		for(String a:Handles) {
			if(a.equals(WindowHandle)) {
				continue;  // 
			}else {
				System.out.println(a);
				driver.switchTo().window(a);
				
			}
			
		}
		
		driver.findElement(By.linkText("�߼�")).click();  //�ڴ򿪵���ҳ���ж�λԪ��	
		
		
		
		
		
	}
	
	
	
	/**
	 * 编辑个人信息
	 */
	
	public void redioBox(){
		driver.get("https://www.imooc.com/user/setprofile");
//		driver.manage().window().maximize(); // 窗口最大化
	    this.sleep(3000);
		/**
		 * 隐藏悬浮窗，
		 */
//		String jscript = "document.getElementsById(\"J_GotoTop\").style.display=\"none\"";   
//		JavascriptExecutor js = (JavascriptExecutor) driver;         // driver对象转换为js
//		js.executeScript(jscript);
		
		driver.findElement(By.className("pull-right")).click(); //点击编辑按钮，进入编辑页面
		this.sleep(2000);
		WebElement nick = driver.findElement(By.xpath("//*[@id=\"profile\"]/div[1]/div"));
		WebElement name = nick.findElement(By.id("nick"));    // ��λ�ǳ������
		
		System.out.println(name.getAttribute("placeholder")); // ��ӡ���ǳ������Ĭ������
	    name.click();
	    name.clear();
		name.sendKeys("avg��");
		
		/**
		 * 下拉框操作 Select
		 */
	    WebElement form = driver.findElement(By.id("profile"));   // form表单，父节点
	    WebElement job = form.findElement(By.id("job"));  //定位到职位
	    Select downlist = new Select(job);        //下拉框操作 Select
//	    downlist.selectByIndex(9);    // 通过index定位 
//	    downlist.selectByValue("21"); // 通过value定位
		downlist.selectByVisibleText("测试工程师"); //通过VisibleText定位
		List<WebElement> lists = downlist.getAllSelectedOptions();
		for(WebElement option:lists) {
			System.out.println(option.getText());	
			
		}
		System.out.println(downlist.getFirstSelectedOption().getText());	
		
		
	
		/**
		 * 选择性别
		 */
		WebElement sex_node = driver.findElement(By.xpath("//*[@id=\"profile\"]/div[4]/div"));
		List<WebElement> list_sex = sex_node.findElements(By.tagName("input"));
		for(WebElement sex:list_sex) {             // 遍历循环
		boolean flag = sex.isSelected(); //判断是否选中
			if(flag==true) {
				continue;
			}else
				sex.click();
		}
		
		driver.findElement(By.className("moco-icon-close")).click(); // �ص�������Ϣ����
		
		
	}
	
	/**
	 *上传文件
	 */
   public void up_Header() {
	   /***
	    *更改隐藏的更换头像按钮的样式，使头像显示出来
	    *
	    */
//	          String jsScript = "document.getElementsByClassName(\"update-avator\")[0].style.bottom='0'"; // ����jsScript���޸ĸ���ͷ��ť��λ��Ϊ0px,�����Ϳ��Զ�λ�����Ԫ��
//	          JavascriptExecutor js = (JavascriptExecutor) driver; // driver转换成js
//	          js.executeScript(jsScript);
	   
	    
	   /**
	    * 鼠标悬停  actions 
	    */	   
	
		       WebElement avator = driver.findElement(By.className("avator-img"));
			   Actions actions = new Actions(driver);  // actions实例化
			   actions.moveToElement(avator).perform(); // 鼠标悬停到avator
		   
	           this.sleep(3000);
//	           driver.findElement(By.className("update-avator")).click();  //  更换头像
	           driver.findElement(By.className("js-avator-link")).click(); //  上传头像
	           this.sleep(3000);
	           driver.findElement(By.id("upload")).sendKeys("D:\\�ز�\\����\\������.png");   // sendkeys��ʽ�ϴ�ͷ��ֻ�����input��ǩ 
	           this.sleep(3000);
	           driver.findElement(By.linkText("ȷ��")).click();
   }
   
   /**
    * �ļ��ϴ�����һ�ַ��� --autoit
    */
   
   public void up_Header1() {
	   
	   WebElement avator = driver.findElement(By.className("avator-img"));
	   Actions actions = new Actions(driver);  // ����һ������¼� �� actions����,��driverת��Ϊactions
	   actions.moveToElement(avator).perform(); // �����ͣ��avator���Ԫ���ϣ����ύ
	   this.sleep(3000);
       driver.findElement(By.className("js-avator-link")).click(); //  ��λ������ͷ�񲢵��������¼�Ԫ�ض�λ
       driver.findElement(By.className("avator-btn-fake")).click(); // ����λ���ϴ�ͷ�񣬲����
	  /**
	   * �򿪱�����sci�����exe�ļ�
	   */
       try {
		Runtime.getRuntime().exec("D:\\SciTEScript\\testau1.exe");  
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}   
       this.sleep(3000);
       driver.findElement(By.linkText("ȷ��")).click();
       
   }
   
   
	/****
	 * 
	 * @param ��װ�ȴ�ʱ��ķ���sleep
	 */
   public void sleep(int sleeptime) {
	   try {
			Thread.sleep(sleeptime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
   } 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		elementLogcat action = new elementLogcat();
		
	    action.InitDriver();
	    action.MoocLogin();
//	    action.InputBox();
//	    action.redioBox();
//	    action.up_Header();
//	    action.up_Header1();
	    action.moseAction();
	    action.windowsHandle();
		
	}

}

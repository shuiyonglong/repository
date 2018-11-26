package com.mushishi.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Login {
	public WebDriver driver;
	/**
	 * 初始化driver，并且打开地址
	 * */
	@Test
	public void InitDriver(){
		System.setProperty("webdriver.chrome.driver", "D:\\java\\chromedriver_win32\\chromedriver.exe");
		//System.setProperty("webdriver.firefox.marionette","D:\\java\\geckodriver\\geckodriver-v0.14.0-win64\\geckodriver.exe");
		driver = new ChromeDriver();
		//driver = new FirefoxDriver();
		driver.get("http://www.imooc.com");
		driver.manage().window().maximize();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test(dependsOnMethods={"InitDriver"})
	public void userLogin() throws Exception{
		driver.findElement(By.id("js-signin-btn")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("email")).sendKeys("18513199586");
		driver.findElement(By.name("password")).sendKeys("111111");
		driver.findElement(By.className("btn-red")).click();
		driver.close();
	}
	
/*	public static void main(String[] args) throws Exception{
		Login testLogin = new Login();
		testLogin.InitDriver();
		testLogin.userLogin();
	}*/
}

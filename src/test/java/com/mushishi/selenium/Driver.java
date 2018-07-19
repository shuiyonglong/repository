package com.mushishi.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {
	public static void main(String args[]) throws Exception{
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver","D:\\java\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.imooc.com/user/newlogin/from_url/");
		Thread.sleep(5000);
		//driver.findElement(By.id("js-signin-btn")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("email")).sendKeys("18513199586");
		driver.findElement(By.className("inputbox")).findElement(By.name("email")).sendKeys("mushishi_xu");
		driver.findElement(By.name("password")).sendKeys("xu221168");
		driver.findElement(By.id("dologin")).click();
		driver.close();
	}

}

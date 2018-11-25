package com.netease.a13.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SelectDriver {

	public WebDriver driverName(String browser) {
		
		if(browser.equalsIgnoreCase("firefox")) {
		
			System.setProperty("Webdriver.firefox.bin","E:\\Firefox\\firefox.exe");
			return new FirefoxDriver();
		}else {
			System.setProperty("webdriver.chrome.driver","E:\\autosoftware\\Seleniumdriver\\Chromedriver2.41\\chromedriver.exe");// 设置driver驱动
            return new ChromeDriver();
		}
		
	}

}

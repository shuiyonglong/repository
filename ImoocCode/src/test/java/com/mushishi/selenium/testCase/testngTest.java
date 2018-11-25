package com.mushishi.selenium.testCase;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.mushishi.selenium.BaseDriver;


@Listeners({TestNGListenerScreen.class})
public class testngTest extends BaseDriver{	
	
	@Test
	public void test(){
		driver.get("http://www.imooc.com");
		System.out.println("Test------>test");	
	}
	@Test
	public void test002(){
		driver.get("http://www.imooc.com");
		driver.findElement(By.className("user"));
		//Assert.assertEquals(1,2);
		System.out.println("Test------>test002");
	}


}

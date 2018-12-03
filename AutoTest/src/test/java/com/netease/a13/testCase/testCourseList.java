package com.netease.a13.testCase;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.netease.a13.base.DriverBase;

public class testCourseList extends casebase {
	public DriverBase driver;
	public testCourseList(String browser) {
		
		this.driver = InitDriver(browser);
	}
	@Test
	public void CourseTest() {		
	   driver.get("https://coding.imooc.com/");
	  // driver.manage();
       List<String> listString = this.listElement();
       for(int i=0;i<listString.size();i++) {
    	   driver.findElement(By.xpath("//*[contains(text(),'"+listString.get(i)+"')]")).click();
    	   driver.back();
    	   
       }
       
	}
	/**
	 * 获取所有课程的list
	 */
	public List<String> listElement(){
		List<String> listString = new ArrayList<String>();
		   WebElement element = driver.findElement(By.className("shizhan-course-list"));
		   List<WebElement> listElement = element.findElements(By.className("shizhan-course-box"));
		   for(WebElement course:listElement) {
			  listString.add(course.findElement(By.className("shizan-desc")).getText());   
		   }
		
		return listString;
		
	}
	

}

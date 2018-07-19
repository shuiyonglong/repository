package com.mushishi.selenium.testCase;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CourseList {
	public WebDriver driver;
	@Test
	public void course() throws Exception{	
		System.setProperty("webdriver.chrome.driver","D:\\java\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://coding.imooc.com");
		List<String> listString = this.listElement();
		for(int i=0;i<listString.size();i++){
			String courseName = listString.get(i);
			Thread.sleep(2000);
			System.out.println(listString.get(i));
/*			if(listString.get(i).indexOf(" ")>0){
				courseName = listString.get(i).replace(" ", "\b");
			}*/
			//driver.findElement(By.xpath("normalize-space(//*[contains(text(),'"+listString.get(i)+"')])")).click();
			driver.findElement(By.xpath("//*[contains(text(),'"+courseName+"')]")).click();

			driver.navigate().back();
		}
		
		
	}
	public List<String> listElement(){
		List<String> listString = new ArrayList<String>();
		WebElement element = driver.findElement(By.className("shizhan-course-list"));
		List<WebElement> listElement = element.findElements(By.className("shizhan-course-box"));
		for(WebElement el:listElement){
			listString.add(el.findElement(By.className("shizan-desc")).getText());
		}
		return listString;
	}

}

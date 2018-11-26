package com.netease.a13.util;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ProUtil {
	private String filepath;
	private Properties Prop;
	
	/**
	 * 构造配置文件路径方法
	 */
	public ProUtil(String filepath) {
		
		this.filepath = filepath;
		this.Prop = readProperties();
		
	}
	/**
	 * 读取配置文件
	 */
	
	private Properties readProperties() {
		
		Properties properties = new Properties();
		try {
			InputStream inputStream = new FileInputStream(filepath); // 通过FileInputStream这个类读取配置文件
			BufferedInputStream in = new BufferedInputStream(inputStream);  // 把这个文件放到缓存BufferedInputStream 这个类中

			properties.load(in); // 下载配置文件进来
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
		return properties;
		
	}
	public String getPro(String key){
		if(Prop.containsKey(key)) {
		String userpass = Prop.getProperty(key);
		return userpass;
		}else {
			System.out.println("你获取的K值不对");
			return "key";
		}
			
		
		
	}
	 
}
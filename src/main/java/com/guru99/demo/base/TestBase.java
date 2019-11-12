package com.guru99.demo.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
 
	static WebDriver driver;
    static Properties prop;
	public TestBase() {
		try {
			prop= new Properties();
			FileInputStream ip= new FileInputStream(
					System.getProperty("user.dir")+"/src/main/java/com/guru99/demo/config"
							+ "/config.properties");
			prop.load(ip);
			
		}catch(FileNotFoundException  e) {
			e.printStackTrace();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public static void initialiazation() {
		String browserName=prop.getProperty("browser");//reading property browser from config.properties
	    if(browserName.equals("chrome")) {
	    	System.setProperty("webdriver.chrome.driver", "/demoguru99pom/chromedriver.exe");
	    	driver = new ChromeDriver();
	    }else if(browserName.equals("FF")) {
	    	System.setProperty("webdriver.gecko.driver", "/demoguru99pom/geckodriver.exe");
	    	driver = new FirefoxDriver();
	    }
	}
 
}
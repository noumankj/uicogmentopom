package com.guru99.demo.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.guru99.demo.utilities.PageWaitUtil;

public class TestBase {
 
	public static WebDriver driver;
    public static Properties prop;
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
	    	System.setProperty("webdriver.chrome.driver", "D:\\Users\\MNoumanK\\eclipse-workspace\\demoguru99pom\\chromedriver.exe");
	    	driver = new ChromeDriver();
	    }else if(browserName.equals("FF")) {
	    	System.setProperty("webdriver.gecko.driver", "/demoguru99pom/geckodriver.exe");
	    	driver = new FirefoxDriver();
	    }
	    driver.manage().window().maximize();// auto maximizing windows according to screen size
	    driver.manage() .deleteAllCookies();
	    driver.manage() .timeouts().pageLoadTimeout(
	    		PageWaitUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	    driver.manage().timeouts().implicitlyWait(
	    		PageWaitUtil.IMPLICIT_TIME, TimeUnit.SECONDS);
	    
	    driver.get(prop.getProperty("url"));
	    
	}
 
}

package com.cogmento.ui.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.cogmento.ui.utilities.PageWaitUtil;

public class TestBase {
 
	public static WebDriver driver;
    public static Properties prop;
    public  static EventFiringWebDriver e_driver;
	public static WebDriverEventListener eventListener;
	
	public TestBase() {
		try {
			prop= new Properties();
			FileInputStream ip= new FileInputStream(
					System.getProperty("user.dir")+"/src/main/java/com/cogmento/ui/config"
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
	    	System.setProperty("webdriver.chrome.driver", "D:\\Users\\mnoum\\Documents\\Github\\uicogmentopom\\chromedriver.exe");
	    	driver = new ChromeDriver();
	    }else if(browserName.equals("FF")) {
	    	System.setProperty("webdriver.gecko.driver", "/uicogmentopom/geckodriver.exe");
	    	driver = new FirefoxDriver();
	    }
	    
		/*
		 * e_driver = new EventFiringWebDriver(driver); // Now create object of
		 * EventListerHandler to register it with EventFiringWebDriver eventListener =
		 * new WebDriverEventListener(); e_driver.register(eventListener); driver =
		 * e_driver;
		 */
	    driver.manage().window().maximize();// auto maximizing windows according to screen size
	    driver.manage() .deleteAllCookies();
	    driver.manage() .timeouts().pageLoadTimeout(
	    		PageWaitUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	    driver.manage().timeouts().implicitlyWait(
	    		PageWaitUtil.IMPLICIT_TIME, TimeUnit.SECONDS);
	    
	    driver.get(prop.getProperty("url"));
	    
	}
 
}

package com.guru99.demo.pagestests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.guru99.demo.base.TestBase;
import com.guru99.demo.pages.LoginPage;
import com.guru99.demo.pages.SuccessPage;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	SuccessPage successPage;
	public LoginPageTest() {
		super(); // it will call the Base Class constructor to initiliaze properties
	}
	
	@BeforeMethod()
	public void setUp() {
		initialiazation();
		loginPage = new LoginPage();
		
	}
	@Test()
	public void loginPageTitleTest(){
		String title=loginPage.validatePageTitle();
		Assert.assertEquals(title, "Login Page");
	}
	
	@Test()
	public void loginLogoImageTest() {
		boolean flag= loginPage.validateLogoPresent();
		Assert.assertTrue(flag);
	}
	
	@Test()
	public void loginTest() {
		successPage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	
	@AfterMethod()
	public void tearDown() {
		driver.quit();
	}

}

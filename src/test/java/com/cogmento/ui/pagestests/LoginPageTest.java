package com.cogmento.ui.pagestests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cogmento.ui.base.TestBase;
import com.cogmento.ui.pages.LoginPage;
import com.cogmento.ui.pages.HomePage;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
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
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	
	@AfterMethod()
	public void tearDown() {
		driver.quit();
	}

}

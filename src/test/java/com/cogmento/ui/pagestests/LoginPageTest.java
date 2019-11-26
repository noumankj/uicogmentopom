package com.cogmento.ui.pagestests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cogmento.ui.base.TestBase;
import com.cogmento.ui.pages.LoginPage;
import com.cogmento.ui.pages.RegisterPage;
import com.cogmento.ui.pages.HomePage;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	RegisterPage registerPage;
	public LoginPageTest() {
		super(); // it will call the Base Class constructor to initiliaze properties
	}
	
	@BeforeMethod()
	public void setUp() {
		initialiazation();
		loginPage = new LoginPage();//object initialization to access all funcitons
		                                              //variables of LoginPage
		
	}
	@Test()
	public void loginPageTitleTest(){
		String title=loginPage.validatePageTitle();
		Assert.assertEquals(title, "Cogmento CRM");
	}
	
	
	/*@Test()
	public void loginLogoImageTest() {
		boolean flag= loginPage.validateLogoPresent();
		Assert.assertTrue(flag);
	}*/
	
	@Test()
	public void loginTest() {
		
		homePage=loginPage.login
				(prop.getProperty("username"), prop.getProperty("password"));//login is redirecting to homePage,
		//so it is returning homePage
		
	}
	
	@Test()
	public void signUpLink() {
		registerPage=loginPage.signUpLink();
	}
	
	
	
	@AfterMethod()
	public void tearDown() {
		driver.quit();
	}

}

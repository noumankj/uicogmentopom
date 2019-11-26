package com.cogmento.ui.pagestests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cogmento.ui.base.TestBase;
import com.cogmento.ui.pages.ConactsPage;
import com.cogmento.ui.pages.HomePage;
import com.cogmento.ui.pages.LoginPage;
import com.cogmento.ui.pages.RegisterPage;

public class HomePageTest extends TestBase{
    LoginPage loginPage;
    HomePage homePage;
    ConactsPage contactsPage;
	public HomePageTest() {
		super();
		
	}
	
	@BeforeMethod()
	public void setUp() {
		initialiazation();
		loginPage = new LoginPage();//object initialization to access all funcitons
		                                              //variables of LoginPage
		homePage = loginPage.login
		(prop.getProperty("username"), prop.getProperty("password"));//to reach homepage we have to login
	}
	
	@Test()
	public void logoImageTest() {
		boolean flag= homePage.validateLogoPresent();
		Assert.assertTrue(flag);
	}
	@Test()
	public void clickOnContactsLinkTest() {
		contactsPage = homePage.clickOnContactsLink();
	}
	
	@AfterMethod()
	public void tearDown() {
		driver.quit();
	}

	
}

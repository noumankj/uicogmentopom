package com.cogmento.ui.pagestests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cogmento.ui.base.TestBase;
import com.cogmento.ui.pages.ConactsPage;
import com.cogmento.ui.pages.DealsPage;
import com.cogmento.ui.pages.HomePage;
import com.cogmento.ui.pages.LoginPage;
import com.cogmento.ui.pages.RegisterPage;
import com.cogmento.ui.pages.TasksPage;

public class HomePageTest extends TestBase{
    LoginPage loginPage;
    HomePage homePage;
    ConactsPage contactsPage;
    DealsPage dealsPage;
    TasksPage tasksPage;
	public HomePageTest() {
		super();
		
	}
	
	@BeforeMethod()
	public void setUp() {
		initialiazation();
		loginPage = new LoginPage();//object initialization to access all funcitons
		                                              //variables of LoginPage
		contactsPage= new ConactsPage();
		dealsPage=new DealsPage();
		tasksPage= new TasksPage();
		//homePage= new HomePage();
		
		homePage = loginPage.login
		(prop.getProperty("username"), prop.getProperty("password"));//to reach homepage we have to login
	   // loginPage.loginButton.submit();
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
	@Test()
	public void clickOnDealsLinkTest() {
		dealsPage = homePage.clickOnDealsLink();
	}
	@Test()
	public void clickOnTasksLinkTest() {
		tasksPage = homePage.clickOnTasksLink();
	}
	
	@AfterMethod()
	public void tearDown() {
		driver.quit();
	}

	
}

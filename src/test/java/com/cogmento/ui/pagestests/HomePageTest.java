package com.cogmento.ui.pagestests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cogmento.ui.base.TestBase;
import com.cogmento.ui.pages.ContactsPage;
import com.cogmento.ui.pages.DealsPage;
import com.cogmento.ui.pages.HomePage;
import com.cogmento.ui.pages.LoginPage;
import com.cogmento.ui.pages.RegisterPage;
import com.cogmento.ui.pages.TasksPage;
import com.cogmento.ui.utilities.TestUtilities;

public class HomePageTest extends TestBase{
    LoginPage loginPage;
    HomePage homePage;
    ContactsPage contactsPage;
    DealsPage dealsPage;
    TasksPage tasksPage;
    //TestUtilities testUtilities;
	public HomePageTest() {
		super();
		
	}
	
	@BeforeMethod()
	public void setUp() {
		initialiazation();
		loginPage = new LoginPage();//object initialization to access all funcitons
		                                              //variables of LoginPage
		contactsPage= new ContactsPage();
		dealsPage=new DealsPage();
		tasksPage= new TasksPage();
	//	testUtilities=new TestUtilities();
		//homePage= new HomePage();
		
		homePage = loginPage.login
		(prop.getProperty("username"), prop.getProperty("password"));//to reach homepage we have to login
	   // loginPage.loginButton.submit();
	}
	///TestCases should be independent with each other
	// before each  test case launch browser and login 
	// and perform test and then close browser
	
	
	@Test(priority=1)
	public void logoImageTest() {
		boolean flag= homePage.validateLogoPresent();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=2)
	public void verifyUserNameTest() {
		//testUtilities.switchToFrame();
		boolean flag= homePage.verifyUserName();
		Assert.assertTrue(flag);
	}

	
	@Test(priority=3)
	public void clickOnContactsLinkTest() {
		contactsPage = homePage.clickOnContactsLink();
	}
	@Test(priority=4)
	public void clickOnDealsLinkTest() {
		dealsPage = homePage.clickOnDealsLink();
	}
	@Test(priority=5)
	public void clickOnTasksLinkTest() {
		tasksPage = homePage.clickOnTasksLink();
	}
	
	@AfterMethod()
	public void tearDown() {
		driver.quit();
	}

	
}

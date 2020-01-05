package com.cogmento.ui.pagestests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.cogmento.ui.base.TestBase;
import com.cogmento.ui.pages.ContactsPage;
import com.cogmento.ui.pages.HomePage;
import com.cogmento.ui.pages.LoginPage;
import com.cogmento.ui.utilities.ExcelUtilities;
public class ContactsPageTest  extends  TestBase{
	ContactsPage contactsPage;
	LoginPage loginPage;
	HomePage homePage;
	String sheetName="Contacts";
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod()
	public void setUp() throws InterruptedException{
		initialiazation();
		loginPage = new LoginPage();//object initialization to access all funcitons
		                                              //variables of LoginPage
		contactsPage= new ContactsPage();
		homePage = loginPage.login
				(prop.getProperty("username"), prop.getProperty("password"));//to reach homepage we have to login
		contactsPage = homePage.clickOnContactsLink();
	}
	
	@Test()
	@Ignore()
	public void verifypageLabelTest() {
		Assert.assertTrue(contactsPage.verifyPageLabel(), "Looks like Not on Home Page or other problem");
		//Assert.assertEquals(actual, "Home");
	}
	
	@Test(priority=3)
	public void selectContactByNameTest() {
		contactsPage.selectContactsByName("Mr Farhan Ali");
	}
	
	@DataProvider()
	public Object[][] getCRMTestData(){
			
			Object data[][] = ExcelUtilities.getTestData(sheetName);//
			return data;//return the complete data inside a particular sheet
		}	
	@Test(priority=4, dataProvider="getCRMTestData")
	public void validateAddNewContact(String firstName, String lastName, String email, String company) {
		try {
			contactsPage.addNewContact(firstName,lastName,email,company);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@AfterMethod()
	public void tearDown() {
		//driver.quit();
	}
}

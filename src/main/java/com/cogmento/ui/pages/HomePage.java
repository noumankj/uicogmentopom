package com.cogmento.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cogmento.ui.base.TestBase;

public class HomePage  extends TestBase{
	
	//@FindBy(xpath="//img[@src='img/logo.png']")//finding logoImg
	@FindBy(xpath="//div[@class='header item']")//finding logoImg
	WebElement logoImg;
	
	@FindBy(xpath="//div/span[@class='user-display']")//,contains(text,'User:Muhammad Nouman')]")
	WebElement userNameLabel;
	
	//@FindBy(xpath="//a[@href=\"/calendar\"]")//finding calendar link
	@FindBy(linkText="Calendar")
	WebElement calendarLink;
	
	//@FindBy(xpath="//a[@href=\"/contacts\"]")
	@FindBy(linkText="Contacts")
	 WebElement contactsLink;
	
	//@FindBy(xpath="//a[@href=\"/companies\"]")
	@FindBy(linkText="Companies")
	 WebElement companiesLink;
	
	//@FindBy(xpath="//a[@href=\"/deals\"]")
	@FindBy(linkText="Deals")
	 WebElement dealsLink;
	
	//@FindBy(xpath="//a[@href=\"/tasks\"]")
	@FindBy(linkText="Tasks")
	 WebElement tasksLink;
	
	//@FindBy(xpath="//a[@href=\"/cases\"]")
	@FindBy(linkText="Cases")
	 WebElement casesLink;
	
	//@FindBy(xpath="//a[@href=\"/calls\"]")
	@FindBy(linkText="Calls")
	 WebElement callsLink;
	
	//@FindBy(xpath="//a[@href=\"/documents\"]")
	@FindBy(linkText="Documents")
	 WebElement documentsLink;
	
	//@FindBy(xpath="//a[@href=\"/email\"]")
	@FindBy(linkText="Email")
	 WebElement emailLink;
	
	//@FindBy(xpath="//a[@href=\"/compaigns\"]")
	@FindBy(linkText="Compaigns")
	 WebElement compaignsLink;
	
	//@FindBy(xpath="//a[@href=\"/forms\"]")
	@FindBy(linkText="Forms")
	 WebElement formsLink;
	
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}


	public boolean validateLogoPresent() {
	return logoImg.isDisplayed();
    }
	
	public boolean verifyUserName() {
		return userNameLabel.isDisplayed();
	}
	
	
	
	public ContactsPage clickOnContactsLink() {//clicking on ContactsPage
		contactsLink.click();
		return new ContactsPage();//returning contactsPage object,i.e landing on ContactsPage
	}
	
	public DealsPage clickOnDealsLink() {
		dealsLink.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTasksLink() {
		tasksLink.click();
		return new TasksPage();
	}
	
}

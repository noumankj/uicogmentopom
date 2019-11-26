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
	
	@FindBy(xpath="//a[@href=\"/calendar\"]")//finding calendar link
	WebElement calendarLink;
	
	@FindBy(xpath="//a[@href=\"/contacts\"]")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[@href=\"/companies\"]")
	WebElement companiesLink;
	
	@FindBy(xpath="//a[@href=\"/deals\"]")
	WebElement dealsLink;
	
	@FindBy(xpath="//a[@href=\"/tasks\"]")
	WebElement tasksLink;
	
	@FindBy(xpath="//a[@href=\"/cases\"]")
	WebElement casesLink;
	
	@FindBy(xpath="//a[@href=\"/calls\"]")
	WebElement callsLink;
	
	@FindBy(xpath="//a[@href=\"/documents\"]")
	WebElement documentsLink;
	
	@FindBy(xpath="//a[@href=\"/email\"]")
	WebElement emailLink;
	
	@FindBy(xpath="//a[@href=\"/compaigns\"]")
	WebElement compaignsLink;
	
	@FindBy(xpath="//a[@href=\"/forms\"]")
	WebElement formsLink;
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}


	public boolean validateLogoPresent() {
	return logoImg.isDisplayed();
    }
	
	public ConactsPage clickOnContactsLink() {//clicking on ContactsPage
		contactsLink.click();
		return new ConactsPage();//returning contactsPage object,i.e landing on ContactsPage
	}
	
	public DealsPage clickOnDealsLink() {
		dealsLink.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTasksLink() {
		dealsLink.click();
		return new TasksPage();
	}
	
}

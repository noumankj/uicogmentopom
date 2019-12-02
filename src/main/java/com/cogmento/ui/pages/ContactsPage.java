package com.cogmento.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cogmento.ui.base.TestBase;

public class ContactsPage  extends TestBase{
	@FindBy(xpath="//div[ contains(@class, 'ui header item mb5 light-black') and contains(text() ,'Contacts')]")
	WebElement pageLabel;
	
	@FindBy(xpath="//button[contains(text(),'New')]")
	WebElement addNewContact;
	
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyPageLabel() {
	return pageLabel.isDisplayed();
	}
	
	public void selectContactsByName(String name) {
		WebElement checkContactByName= driver.findElement(By.xpath("//td[contains(text(),'+ name +')])"));
	      checkContactByName.click();
	}
	
	public void addNewContact() {
		addNewContact.click();
	}
}

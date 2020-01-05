package com.cogmento.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cogmento.ui.base.TestBase;
import com.cogmento.ui.utilities.*;

public class ContactsPage  extends TestBase{
	@FindBy(xpath="//div[ contains(@class, 'ui header item mb5 light-black') and contains(text() ,'Contacts')]")
	WebElement pageLabel;
	
	@FindBy(xpath="//button[contains(text(),'New')]")
	WebElement addNewContactButton;
	
	@FindBy(name="first_name")
	WebElement firstName;
	
	@FindBy(name="last_name")
	WebElement lastName;
	
	@FindBy(css="div.three.fields > div.ui.right.corner.labeled.input > input")//(xpath="//div[@class='three fields']//div[@class='ui right corner labeled input']")
	WebElement eMail;
	
	@FindBy(css="[name=\"company\"] > input")
	WebElement company;
	
	@FindBy(xpath="//button[@class='ui linkedin button']")
	WebElement saveButton;
	
	/*
	 * @FindBy(class="ui linkedin button") WebElement saveNewContact;
	 */
	
	@FindBy(xpath="//button[@class=\"ui linkedin button\"]")
	WebElement saveNewContact;
	
	@FindBy(css="tbody > tr:nth-of-type(2) > td:nth-of-type(2)")
	WebElement nameFromList;
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyPageLabel() {
	return pageLabel.isDisplayed();
	}
	
	public void selectContactsByName(String name) {
		/*
		 * WebElement checkContactByName=
		 * driver.findElement(By.xpath("//td[contains(text(),'+ name +')])"));
		 * checkContactByName.click();
		 */
		nameFromList.click();
	}
	
	public void addNewContact(String fName,String lName, String email, String compny) throws Exception {
		addNewContactButton.click();
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		eMail.sendKeys(email);
		company.sendKeys(compny);
		System.out.println("Data entered in fields"+fName+"::"+lName+"::"+email+"::"+compny);
		saveButton.click();
		System.out.println("Save (Contacts) Button Pressed");
		
	}
}

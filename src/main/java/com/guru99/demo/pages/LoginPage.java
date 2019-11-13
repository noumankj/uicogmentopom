package com.guru99.demo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.guru99.demo.base.TestBase;

public class LoginPage extends TestBase {
	
	//Page Factory - Object Repository
	@FindBy(id="email") //Finding email input field
	WebElement email;
	
	@FindBy(name="passwd") //password input field
	WebElement password;
	
	@FindBy(name="SubmitLogin")//Sign-In button
	WebElement signInButton;
	
	@FindBy(xpath="//img[@src='img/logo.png']")//finding logoImg
	WebElement logoImg;
	
	//Initialization of Page Objects
	public LoginPage() {
		PageFactory.initElements(driver,this); // for the initializiation of Elements/variables
		// on LoginPage with driver
		// keyword this can also be replaced with LoginPage.class	
		}
	 // Actions performing on the LoginPage
	public String validatePageTitle() {
		return driver.getTitle();
	   }
	
	public void validateLogoPresent() {
		logoImg.isDisplayed();
	}
	
}

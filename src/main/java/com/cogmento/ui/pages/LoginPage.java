package com.cogmento.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cogmento.ui.base.TestBase;

public class LoginPage extends TestBase {
	
	//Page Factory - Object Repository
	@FindBy(name="email") //Finding email input field
	WebElement email;
	
	@FindBy(name="password") //password input field
	WebElement password;
	
	@FindBy(xpath="//div[@class ='ui fluid large blue submit button']")//Sign-In button
	WebElement loginButton;
	
	@FindBy(partialLinkText="password")
	WebElement forgetPasswordLink;
	
	@FindBy(linkText="Sign Up")//Sign Up link redirects to Register Page
	WebElement signUpLink;
	
	/*@FindBy(xpath="//img[@src='img/logo.png']")//finding logoImg
	WebElement logoImg;*/
	
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
	
	/*public boolean validateLogoPresent() {
		return logoImg.isDisplayed();
	}*/
	public HomePage login(String eml, String pwd) {
		email.sendKeys(eml);
		password.sendKeys(pwd);
		loginButton.submit();//clicking on loginButton redirects to HomePage
		return new HomePage();//return object of HomePage 
	}
	public ResetPasswordPage forgetPasswordLink() {
		forgetPasswordLink.click();
		return new ResetPasswordPage();
		
	}
	public RegisterPage signUpLink() {
		signUpLink.click();//clicking on signUpLink redirects to RegisterPage
		return new RegisterPage();// return object of RegisterPage
	}
}

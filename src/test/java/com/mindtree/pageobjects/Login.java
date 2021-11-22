package com.mindtree.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mindtree.reusablecomponent.Base;
import com.mindtree.uistore.LoginLocators;

public class Login extends Base {

	WebDriver driver=null;
	
	public Login(WebDriver driver) {
		this.driver=driver;	
	}
	
	public WebElement getLogin() {
		return driver.findElement(LoginLocators.login);
	}
	public WebElement getUserElement() {
		return driver.findElement(LoginLocators.userElement);
	}

	public WebElement getUserPass() {
		
		return driver.findElement(LoginLocators.userPass);
	}

	public WebElement getSignin() {
		
		return driver.findElement(LoginLocators.signin);
	}

	public WebElement getMyAccount() {
		
		return driver.findElement(LoginLocators.myaccount);
	}

	
}

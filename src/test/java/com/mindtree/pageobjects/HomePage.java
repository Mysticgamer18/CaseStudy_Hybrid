package com.mindtree.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mindtree.reusablecomponent.Base;
import com.mindtree.uistore.HomePageLocators;

	public class HomePage extends Base {

	WebDriver driver=null;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;	
	}
	
	
	public WebElement getTitleImg() {
		return driver.findElement(HomePageLocators.titleImg);
	}
	public WebElement getNavBar() {
		return driver.findElement(HomePageLocators.navigationBar);
	}


	
	
}

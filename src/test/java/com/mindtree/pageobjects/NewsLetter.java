package com.mindtree.pageobjects;

import org.openqa.selenium.WebElement;

import com.mindtree.reusablecomponent.Base;
import com.mindtree.uistore.NewsLetterLocators;

public class NewsLetter extends Base {
	
//	public NewsLetter (WebDriver driver) {
//		this.driver=driver;
//	}
	
	public WebElement getNewsLetter() {
		return driver.findElement(NewsLetterLocators.newsletter);
		
	}

	public WebElement getSignup() {
		
		return driver.findElement(NewsLetterLocators.signupnow);
	}
	

}

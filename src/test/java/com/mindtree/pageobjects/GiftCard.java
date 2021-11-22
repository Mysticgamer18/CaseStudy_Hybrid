package com.mindtree.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mindtree.reusablecomponent.Base;
import com.mindtree.uistore.GiftCardLocators;

public class GiftCard extends Base{
	
	public GiftCard(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement getGiftCard() {
		return driver.findElement(GiftCardLocators.giftCard);
	}
	public WebElement getPostCode() {
		return driver.findElement(GiftCardLocators.postcode);
	}
	public WebElement getCodeCheck() {
		return driver.findElement(GiftCardLocators.codeCheck);
	}
	public WebElement getCodeText() {
		return driver.findElement(GiftCardLocators.codeText);
	}
	
	
	

}

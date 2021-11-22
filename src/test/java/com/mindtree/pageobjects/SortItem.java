package com.mindtree.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mindtree.reusablecomponent.Base;
import com.mindtree.uistore.sortItemLocators;

public class SortItem extends Base{
	
	public SortItem(WebDriver driver) {
		this.driver=driver;
	}

	public WebElement getSecretSantaGifts() {
		return driver.findElement(sortItemLocators.secretSanta);
	}
	public WebElement getSortItem() {
		return driver.findElement(sortItemLocators.sortItem);
	}
	public WebElement getSortCheck() {
		return driver.findElement(sortItemLocators.sortCheck);
	}
}

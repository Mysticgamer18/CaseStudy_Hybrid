package com.mindtree.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mindtree.reusablecomponent.Base;
import com.mindtree.uistore.SearchBarLocators;

public class SearchItem extends Base {

	WebDriver driver=null;
	
	public SearchItem(WebDriver driver) {
		this.driver=driver;	
	}
	
	public WebElement getSearchBar() {
		return driver.findElement(SearchBarLocators.searchBox);
	}
	public WebElement getSearchItem() {
		return driver.findElement(SearchBarLocators.searchItem);
	}
}
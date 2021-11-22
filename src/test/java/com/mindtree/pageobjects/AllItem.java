package com.mindtree.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mindtree.reusablecomponent.Base;
import com.mindtree.uistore.AllItemLinkLocators;

public class AllItem extends Base{

	public AllItem(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement getAllofIt() {
		return driver.findElement(AllItemLinkLocators.AllofIt);
		
	}
	public WebElement getNextPage() {
		return driver.findElement(AllItemLinkLocators.nextPage);
		
	}
	public WebElement getNewItem() {
		return driver.findElement(AllItemLinkLocators.newItem);
		
	}
	
	
}

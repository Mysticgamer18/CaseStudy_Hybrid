package com.mindtree.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mindtree.reusablecomponent.Base;
import com.mindtree.uistore.AddToCartLocators;

public class AddToCart extends Base{
	
	
	
	public AddToCart(WebDriver driver) {
		this.driver=driver;
	}
	public WebElement clickCart() {
		
		return driver.findElement(AddToCartLocators.clickOnCart);
		
	}
	public WebElement getSelectedItem() {
		
		return driver.findElement(AddToCartLocators.selItem);
		
	}
	public WebElement AddItem() {
	
	return driver.findElement(AddToCartLocators.AddItem);
	
	}
	public WebElement getCheckout() {
		
		return driver.findElement(AddToCartLocators.checkOut);
		
	}
	public WebElement closeWAPopup() {
		
		return driver.findElement(AddToCartLocators.WApopup);
		
	}
	public WebElement getSummary() {
		
		return driver.findElement(AddToCartLocators.orderSummary);
		
	}

}

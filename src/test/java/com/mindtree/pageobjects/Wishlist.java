package com.mindtree.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mindtree.reusablecomponent.Base;
import com.mindtree.uistore.WishlistLocators;

public class Wishlist extends Base {

	public Wishlist(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement getSearchResult() {
		return driver.findElement(WishlistLocators.search);
		
	}
	public WebElement addToWishlist() {
		return driver.findElement(WishlistLocators.addToWishlist);
		
	}
	public WebElement viewWishList() {
		return driver.findElement(WishlistLocators.viewWishlist);
		
	}
	public WebElement getWishlist() {
		return driver.findElement(WishlistLocators.wishlist);
		
	}

	public WebElement selectWishlistItem() {
		
		return driver.findElement(WishlistLocators.selectWishlistItem);
	}
public WebElement closePopup() {
		
		return driver.findElement(WishlistLocators.popup);
	}
	
}

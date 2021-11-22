package com.mindtree.uistore;

import org.openqa.selenium.By;

public class WishlistLocators {
	
	public static By search=By.xpath("//form[@class='search-bar']/input[2]");
	
	public static By addToWishlist=By.xpath("//div[@id=\"ProductSection-9183285127\"]/div/div/div[1]/div[2]/div/div[1]/div[1]/div/button/span");
	
	public static By viewWishlist=By.linkText("View your Wishlist");
	
	public static By wishlist=By.xpath("//div[@class='swym-inner']/a");

	public static By selectWishlistItem=By.xpath("//*[@id=\"snize-product-9183285127\"]/a/div/span/span[1]");
	
	public static By popup=By.xpath("//*[@id=\"swym-welcome-button\"]");

//	public static By t=By.xpath("//div[@class='site-nav__icons']/a[2]/i");
//	
	
}

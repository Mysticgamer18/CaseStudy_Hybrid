package com.mindtree.uistore;

import org.openqa.selenium.By;

public class AddToCartLocators {

	public static By clickOnCart=By.linkText("cart");
	
	public static By selItem=By.xpath("//div[@id=\"CartDrawer\"]/form/div[2]/div[1]/div[1]/div[2]/div/div[1]/div/a/div[1]/div[1]/div/div");
	
	public static By AddItem=By.xpath("//button[@name='add']");
	
	public static By checkOut=By.xpath("//div[@id=\"CartDrawer\"]/form/div[2]/div[3]/button/span");
	
	public static By WApopup=By.xpath("//div[@class='wa-optin-widget-close-btn']/img");
	
	public static By orderSummary=By.id("order-summary");
	
	
	
}

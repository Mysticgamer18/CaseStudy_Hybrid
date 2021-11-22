package com.mindtree.uistore;

import org.openqa.selenium.By;

public class LoginLocators{
	
	public static By login=By.linkText("sign in");
	
	public static By userElement=By.id("CustomerEmail");

	public static By userPass=By.id("CustomerPassword");

	public static By signin=By.xpath("//form[@id=\"customer_login\"]/p[1]/input");

	public static By myaccount=By.id("customer_logout_link");
}
	
	

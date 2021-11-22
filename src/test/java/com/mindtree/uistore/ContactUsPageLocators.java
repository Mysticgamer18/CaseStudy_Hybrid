package com.mindtree.uistore;

import org.openqa.selenium.By;

public class ContactUsPageLocators {
	
	public static By Contact=By.linkText("Contact us");
	
	public static By contName=By.id("ContactFormName-page-contact-template-0");
	
	public static By contEmail=By.id("ContactFormEmail-page-contact-template-0");

	public static By contMessage=By.id("ContactFormMessage-page-contact-template-0");

	public static By contSubmit=By.xpath("//form[@id=\"contact_form\"]/button");
	
	public static By Thanks=By.xpath("//form[@id=\"contact_form\"]/p[1]");
	
}


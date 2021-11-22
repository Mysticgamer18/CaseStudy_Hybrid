package com.mindtree.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mindtree.reusablecomponent.Base;
import com.mindtree.uistore.OfficialMerchandiseLocators;

public class OfficialMerchandise extends Base {
	
	public OfficialMerchandise(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement getOfficialMerchandise() {
		return driver.findElement(OfficialMerchandiseLocators.officialMerchandise);
	}
	
	public WebElement getMarvelMerch() {
		return driver.findElement(OfficialMerchandiseLocators.marvel);
	}
	
	public WebElement getVerifiedTitle() {
		return driver.findElement(OfficialMerchandiseLocators.titleVerify);
	}

}

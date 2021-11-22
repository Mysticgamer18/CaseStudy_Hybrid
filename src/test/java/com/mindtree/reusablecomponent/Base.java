package com.mindtree.reusablecomponent;


import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.aventstack.extentreports.ExtentTest;
import com.mindtree.utilities.ReadProperty;


public class Base {

	public static ReadProperty rp = null;
	public static WebDriver driver = null;
	protected static ExtentTest test;

	public static WebDriver initializeDriver() throws Exception {
		
		rp = new ReadProperty();
//		System.out.println(rp.getDriverPath());
		if (rp.getBrowser().equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", rp.getDriverPath());

			driver = new ChromeDriver();
		} else if (rp.getBrowser().equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", rp.getDriverPath());

			driver = new InternetExplorerDriver();
		} else if (rp.getBrowser().equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", rp.getDriverPath());

			driver = new FirefoxDriver();

		}

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		return driver;
	}

	 public static WebDriver getDriver()
	 {
		 return driver;
	 }
}
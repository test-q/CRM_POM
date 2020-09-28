package com.qa.crm.utils;

import java.io.File;
import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionsManager {
	
	Properties prop;
	ChromeOptions co;
	FirefoxOptions fo;
	
	public OptionsManager(Properties prop) {
		this.prop = prop;
	}
	
	public ChromeOptions getChromeOptions() {
		co = new ChromeOptions();
		
		if(Boolean.parseBoolean(prop.getProperty("headless").trim())) {
			co.addArguments("--headless");
		}
		
		if(Boolean.parseBoolean(prop.getProperty("incognito").trim())) {
			co.addArguments("--incognito");
		}
		
		if(Boolean.parseBoolean(prop.getProperty("certificate").trim())) {
			co.setAcceptInsecureCerts(true);
		}
		if(Boolean.parseBoolean(prop.getProperty("addblocker").trim())) {
			//This code is used to activate ad blocker extension on the Chrome browser using Chrome Options and Desired Capabilities class.
			//With AdBlocker extension enabled on Chrome browser ads should be disabled
			//use site http://crxextractor.com/
			co.addExtensions(new File("Enter CRX file path "));
		}
			
		return co;
	}
	
	public FirefoxOptions getFirefoxOptions() {
		fo = new FirefoxOptions();
		
		if(Boolean.parseBoolean(prop.getProperty("headless").trim())) {
			fo.addArguments("--headless");
		}
		
		if(Boolean.parseBoolean(prop.getProperty("incognito").trim())) {
			fo.addArguments("--incognito");
		}
		
		if(Boolean.parseBoolean(prop.getProperty("certificate").trim())) {
			fo.setAcceptInsecureCerts(true);
		}
		return fo;
	}
	         

}

package com.qa.crm.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.crm.utils.ElementUtils;

public class SearchPage {

	private WebDriver driver;
	ElementUtils elementUtil;
	Properties prop;
	
	
	// Constructor of the page:
	public SearchPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtils(driver);
	}

	// By Locators - OR
	private By txt_username = By.name("username");
	private By txt_password = By.name("password");
	private By btn_login    = By.xpath("//input[@value='Login']");
	
	// Page Actions:
	
	public void getURL(String url) {
		driver.get(url);
	}
	
	
	//Hi Rupali
}

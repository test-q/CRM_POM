package com.qa.crm.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.crm.base.BasePage;
import com.qa.crm.utils.ConstantUtil;
import com.qa.crm.utils.ElementUtils;

public class LoginPage extends BasePage{
	
	private WebDriver driver;
	ElementUtils elementUtil;
	Properties prop;
	
	
	// Constructor of the page:
	public LoginPage(WebDriver driver) {
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
	
	public String getLoginPageTitle() {
		return elementUtil.waitForTitlePresent(ConstantUtil.LoginPage_Title.trim(), 20);
	}
	
	public void getLoginDetails(String un, String pwd) {
		elementUtil.doSendKeys(txt_username, un);
		elementUtil.doSendKeys(txt_password, pwd);
	}
	
	public HomePage doLogin() {
		elementUtil.doClick(btn_login);
		return new HomePage(driver);
	}
	
	
}

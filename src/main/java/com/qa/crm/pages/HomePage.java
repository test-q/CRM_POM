package com.qa.crm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.crm.base.BasePage;
import com.qa.crm.utils.ConstantUtil;
import com.qa.crm.utils.ElementUtils;


public class HomePage extends BasePage{

	private WebDriver driver;
	ElementUtils elementUtil;

	// By Locators - OR
	private By header = By.tagName("h1");
	private By accountName = By.cssSelector("span.account-name");
	private By settingsIcon = By.id("navSetting");
	private By contactsParentMenu = By.id("nav-primary-contacts-branch");
	private By contactsSubMenu =  By.id("nav-secondary-contacts");
	private By salesParentMenu = By.id("nav-primary-sales-branch");
	private By dealSubMenu = By.xpath("(//a[@id='nav-secondary-deals'])[1]");

	// Constructor of the page:
	public HomePage(WebDriver driver) {
		elementUtil = new ElementUtils(driver);
		this.driver = driver;
	}

	// Page Actions:
	public String getHomePageTitle() {
		return elementUtil.waitForTitlePresent(ConstantUtil.HOMEPAGE_TITLE.trim(), 10);
	}

	public String getHeaderValue() {
		if (elementUtil.doIsDisplayed(header)) {
			return elementUtil.doGetText(header);
		}
		return null;
	}

	public String getAccountName() {
		if (elementUtil.doIsDisplayed(accountName)) {
			return elementUtil.doGetText(accountName);
		}
		return null;
	}

	public boolean isSettingIconExist() {
		return elementUtil.doIsDisplayed(settingsIcon);
	}
	
	private void clickOnContacts() {
		elementUtil.waitForElementPresent(contactsParentMenu, 10);
		elementUtil.doClick(contactsParentMenu);
		elementUtil.waitForElementPresent(contactsSubMenu, 5);
		elementUtil.doClick(contactsSubMenu);	
	}
	
		
}

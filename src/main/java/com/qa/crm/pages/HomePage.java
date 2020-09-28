package com.qa.crm.pages;

import org.openqa.selenium.WebDriver;

import com.qa.crm.base.BasePage;
import com.qa.crm.utils.ConstantUtil;
import com.qa.crm.utils.ElementUtils;

public class HomePage extends BasePage{
	
	private WebDriver driver;
	ElementUtils elementUtil;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtils(driver);
	}
	
	public String getHomePageTitle() {
		return elementUtil.waitForTitlePresent(ConstantUtil.HomePage_Title, 10);
	}
	

}

package com.qa.crm.pages;

import java.util.ArrayList;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.qa.crm.base.BasePage;
import com.qa.crm.utils.ConstantUtil;
import com.qa.crm.utils.ElementUtils;
import com.qa.crm.utils.JavaScriptUtil;

public class HomePage extends BasePage{
	
	private WebDriver driver;
	ElementUtils elementUtil;
	JavaScriptUtil jscript;
	Properties prop;
	
	//By Locator
	 private By homepageheader     = By.xpath("//td[contains(text(), 'User: Demo User')]");
	 private By navmenu    = By.xpath("//div[@id='navmenu']/ul/li");
	 private By callReport = By.xpath("//td[text()='Call Reports']");
	 private By logout     = By.xpath("//a[contains(text(),'Logout')]");
	 
	
	//Page constructor
	public HomePage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtils(driver);
	}
	
	
	//Page actions
	
	public String getHomePageHeader() {
		driver.switchTo().frame(ConstantUtil.HomePage_FrameName);
		return elementUtil.doGetText(homepageheader);
	}
	
	public String getHomePageTitle() {
		return elementUtil.waitForTitlePresent(ConstantUtil.HomePage_Title, 10);
	}
	
	public void getHomePageMenu() {
		System.out.println("*****");
		driver.switchTo().frame(ConstantUtil.HomePage_FrameName);
		elementUtil.doAllListClick(navmenu);
	
		System.out.println("-----------");
	}
	
	public String getReportPageHeader() {
		return elementUtil.doGetText(callReport);	
	}
	
	public void doClickLogout() {
		driver.switchTo().frame(ConstantUtil.HomePage_FrameName.trim());
		//driver.findElement(logout);
		//elementUtil.doClick(logout);
		//jscript.clickElementByJS(driver.findElement(logout));
		 JavascriptExecutor js = (JavascriptExecutor)driver;
		 js.executeScript("arguments[0].click();", logout);
	}
	
	
	
	

}

package com.qa.crm.stepDefinations;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import com.qa.crm.base.BasePage;
import com.qa.crm.pages.HomePage;
import com.qa.crm.pages.LoginPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class MyHook {
	
	public static WebDriver driver;
	public static Properties prop;
	public static BasePage basepage;
	public static LoginPage loginpage;
	public static HomePage homepage;
	
	@Before
	public static void setup() {
		basepage = new BasePage();
		prop = basepage.init_prop();
		driver = basepage.init_driver(prop);
		loginpage = new LoginPage(driver);
		loginpage.getURL(prop.getProperty("url"));
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		
	}

	@After
	public void tearDown() {
		driver.quit();
	}
}

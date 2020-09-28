package com.qa.crm.stepDefinations;

import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.qa.crm.base.BasePage;
import com.qa.crm.pages.HomePage;
import com.qa.crm.pages.LoginPage;
import com.qa.crm.utils.ConstantUtil;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStep{
	WebDriver driver;
	Properties prop;
	public BasePage basepage;
	public LoginPage loginpage;
	public HomePage homepage;
	
	@Before
	public void setup() {
		basepage = new BasePage();
		prop = basepage.init_prop();
		driver = basepage.init_driver(prop);
		loginpage = new LoginPage(driver);
		
	}
	
	@When("CRM site is open")
	public void CRM_site_is_open() {
		loginpage.getURL(prop.getProperty("url"));
	}
	
	@Given("user is on login page")
	public void user_is_on_login_page() {
		String title = loginpage.getLoginPageTitle();
		if(title.contains(ConstantUtil.LoginPage_Title)) {
			System.out.println("User is on Login Page");
		}else {
			System.out.println("User is NOT on Login Page");
		}
	}
	
	@When("user enter valid {string} and {string}")
	public void user_enter_valid_and(String username, String password) {
		System.out.println("User Enter login details");
		loginpage.getLoginDetails(username,password);
	}
	
	@When("^user enter invalid (.*) and (.*)$")
	public void user_enter_invalid_and_test123(String username, String password) {
		System.out.println("User Enter login details");
		loginpage.getLoginDetails(username,password);
	}

	
	@And("click on login button")
	public void click_on_login_button() {
		System.out.println("Click on Login Button");
		homepage =loginpage.doLogin();
	 
	}
	@Then("user navigate to home page")
	public void user_navigate_to_home_page() {
	 String title = homepage.getHomePageTitle();
	 Assert.assertEquals(ConstantUtil.HomePage_Title, title);
	 System.out.println("User is on Home Page");
	}
	
	@Then("user not navigate to home page")
	public void user_not_navigate_to_home_page() {
		String title = loginpage.getLoginPageTitle();
		 Assert.assertEquals(ConstantUtil.LoginPage_Title, title);
		
	}

	@After
	public void tearDown() {
		driver.quit();
	}
	
}

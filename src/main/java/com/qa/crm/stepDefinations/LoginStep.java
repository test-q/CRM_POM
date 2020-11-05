package com.qa.crm.stepDefinations;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.qa.crm.utils.ConstantUtil;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStep {
	WebDriver driver;

//	@When("CRM site is open")
//	public void CRM_site_is_open() {
//		loginpage.getURL(prop.getProperty("url"));
//	}

	@Given("user is on login page")
	public void user_is_on_login_page() {
		String title = MyHook.loginpage.getLoginPageTitle();
		if (title.contains(ConstantUtil.LoginPage_Title)) {
			System.out.println("User is on Login Page");
		} else {
			System.out.println("User is NOT on Login Page");
		}
	}

	@When("user enter valid {string} and {string}")
	public void user_enter_valid_and(String username, String password) {
		MyHook.loginpage.getLoginDetails(username, password);
		System.out.println("User Entered login details");
	}

	@When("^user enter invalid (.*) and (.*)$")
	public void user_enter_invalid_and_test123(String username, String password) {
		MyHook.loginpage.getLoginDetails(username, password);
		System.out.println("User filled login details");
	}

	@And("click on login button")
	public void click_on_login_button() {
		MyHook.homepage = MyHook.loginpage.doLogin();
		System.out.println("Clicked on Login Button");
	}

	@Then("user navigate to home page")
	public void user_navigate_to_home_page() {
		String title = MyHook.homepage.getHomePageTitle();
		Assert.assertEquals(ConstantUtil.HomePage_Title, title);
		System.out.println("User is on Home Page");
	}

	@Then("user not navigate to home page")
	public void user_not_navigate_to_home_page() {
		String title = MyHook.loginpage.getLoginPageTitle();
		Assert.assertEquals(ConstantUtil.LoginPage_Title, title);

	}

}

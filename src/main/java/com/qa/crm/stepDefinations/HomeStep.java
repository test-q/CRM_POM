package com.qa.crm.stepDefinations;


import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.qa.crm.utils.ConstantUtil;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomeStep {
	
	WebDriver driver;

	
	
	@And("click on login button on home page")
	public void click_on_login_button_on_home_page() {
		MyHook.homepage = MyHook.loginpage.doLogin();		
		System.out.println("Clicked on Login Button");
	}
	
	@When("user check menu on home page")
	public void user_check_menu_on_home_page() {
		System.out.println("On menu Check");
		MyHook.homepage.getHomePageMenu();
		System.out.println("Done");
		
	}

//	@Then("user navigate to reports page")
//	public void user_navigate_to_report_page() {
//	   
//	    
//	}

	@When("user click on logout link on home page")
	public void user_click_on_logout_link_on_home_page() {
		MyHook.homepage.doClickLogout();
	   System.out.println("On Logout Check");
	}
	
	@Given("user is on home page")
	public void user_is_on_home_page() {
	   String text = MyHook.homepage.getHomePageHeader();
	   if(text.contains(ConstantUtil.HomePage_Header)) {
		   System.out.println("HomePage Header: " +text + "CORRECT");
	   }else {
		   System.out.println("HomePage Header: " +text + "	INCORRECT");
	   }
	   
	}

	@Then("user navigate to login page")
	public void user_navigate_to_login_page() {
	    
	}

}

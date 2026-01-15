package com.framework.stepdefinitions;

import com.framework.base.TestBase;
import com.framework.pages.AdminPage;
import com.framework.pages.DashboardPage;
import com.framework.pages.LoginPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class LoginSteps extends TestBase {
	LoginPage loginPage = new LoginPage();
	DashboardPage dashboardPage;
	
	@Given("I have logged into the application")
    public void i_have_logged_into_the_application() { 
		String siteUrl = prop.getProperty("url");
		driver.get(siteUrl);
		dashboardPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@And("I navigate to the Admin page")
	public AdminPage i_navigate_to_the_admin_page() {
		dashboardPage.clickAdmin();
		return new AdminPage();
	}
}

package com.framework.stepdefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.testng.Assert;

import com.framework.base.TestBase;
import com.framework.models.UserData;
import com.framework.pages.AdminPage;
import com.framework.pages.DashboardPage;
import com.framework.pages.LoginPage;
import com.framework.utils.JsonUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.ExcelUtils;

public class AdminSteps extends TestBase {
	
	LoginPage loginPage;
	DashboardPage dashboardPage;
	AdminPage adminPage = new AdminPage();
	
	@When("I add users from json file {string}")
	public void i_add_users_from_json_file(String fileName) throws InterruptedException, IOException {
		List<UserData> userList = JsonUtils.getUserData(fileName);
		
		for(UserData user : userList) {
			adminPage.addUser(); 
			
            System.out.println("Adding User: " + user);
            
            adminPage.addUser(user.getUserRole(), user.getEmployeeName(), user.getStatus(), user.getUsername(), user.getPassword());;
		}
	}
	
	@Then("I should see the users in the list")
	public void i_should_see_the_users_in_the_list() {
	    System.out.println("entered successfully");
	}
}

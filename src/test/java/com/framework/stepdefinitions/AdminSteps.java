package com.framework.stepdefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.testng.Assert;

import com.framework.base.TestBase;
import com.framework.pages.AdminPage;
import com.framework.pages.DashboardPage;
import com.framework.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.ExcelUtils;

public class AdminSteps extends TestBase {
	
	LoginPage loginPage;
	DashboardPage dashboardPage;
	AdminPage adminPage = new AdminPage();
	
	@When("I add users from excel {string} sheet {string}")
	public void i_add_users_from_excel_sheet(String fileName, String sheetName) throws InterruptedException, IOException {
		List<Map<String, String>> userData = ExcelUtils.getData(fileName, sheetName);
		
		for(Map<String, String> row : userData) {
			adminPage.addUser(); 
			
			String role = row.get("User Role");
			String employeeName = row.get("Employee Name");
			String status = row.get("Status");
            String user = row.get("Username");
            String pass = row.get("Password");
            
            System.out.println("Adding User: " + user);
            
            adminPage.addUser(role, employeeName, status, user, pass);
		}
	}
	
	@Then("I should see the users in the list")
	public void i_should_see_the_users_in_the_list() {
	    System.out.println("entered successfully");
	}
}

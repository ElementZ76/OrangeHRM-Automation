package com.framework.stepdefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.testng.Assert;

import com.framework.base.TestBase;
import com.framework.models.EmployeeData;
import com.framework.pages.PIMPage;
import com.framework.utils.JsonUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PIMSteps extends TestBase {
	PIMPage pimPage = new PIMPage();
	
	@Given("I navigate to the PIM module")
	public void i_navigate_to_the_pim_module() {
		pimPage.navigateToPIM();
	}
	
	@When("I add new employees from json file {string}")
	public void i_add_new_employees_from_json_file(String fileName) throws IOException {
		//1. read json
		List <EmployeeData> employees = JsonUtils.getEmployeeData(fileName);
		//2. loop thru each employee
		for(EmployeeData emp : employees) {
			pimPage.addingNewEmployee(emp.getFirstName(), emp.getLastName(), emp.getPhotoFile());
			
		}
	}
	
	@Then("the employees should be created successfully") 
	public void the_employees_should_be_created_successfully() {
		Assert.assertTrue(pimPage.isSuccessMessageDisplayed(), "Success message was not displayed!");
	}
}

package com.framework.pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.framework.base.TestBase;

public class AdminPage extends TestBase {
	@FindBy(xpath = "//button[normalize-space()='Add']")
	WebElement addBtn;
	
	@FindBy(xpath = "//label[text()='User Role']/parent::div/parent::div//div[contains(@class, 'select-text')]")
	WebElement userRoleDropdown;
	
	@FindBy(xpath = "//div[@role='listbox']//span")
	List<WebElement> dropdownOptions;
	
	@FindBy(xpath = "//input[@placeholder='Type for hints...']")
	WebElement employeeNameInput;
	
	@FindBy(xpath = "//label[text()='Status']/parent::div/parent::div//div[contains(@class, 'select-text')]")
	WebElement statusDropdown;
	
	@FindBy(xpath = "//label[text()='Username']/parent::div/parent::div//input[contains(@class, 'oxd-input')]")
	WebElement usernameInput;
	
	@FindBy(xpath = "//label[text()='Password']/parent::div/parent::div//input[contains(@class, 'oxd-input')]")
	WebElement passwordInput;
	
	@FindBy(xpath = "//label[text()='Confirm Password']/parent::div/parent::div//input[contains(@class, 'oxd-input')]")
	WebElement confirmPasswordInput;
	
	@FindBy(xpath = "//button[@type='submit']")
    WebElement saveButton;
	
	public AdminPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void addUser() {
		addBtn.click();
	}
	
	public void addUser(String role, String empName, String status, String username, String password) throws InterruptedException {
		selectFromDropdown(userRoleDropdown, role); //role dropdown
		
		//empname input and autofill
		employeeNameInput.sendKeys(empName);
		Thread.sleep(2000);
		employeeNameInput.sendKeys(Keys.ARROW_DOWN);
		employeeNameInput.sendKeys(Keys.ENTER);
		
		selectFromDropdown(statusDropdown, status); //status dropdown
		
		usernameInput.sendKeys(username); //input username
		passwordInput.sendKeys(password); //password input
		confirmPasswordInput.sendKeys(password); //confirm password input
		
		waitForClickability(saveButton);
		saveButton.click();
	}
}

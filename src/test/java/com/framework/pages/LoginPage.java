package com.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.framework.base.TestBase;

public class LoginPage extends TestBase {
	// 1. page factory - object repository (locators)
	//using @FindBy instead of using By.id
	
	@FindBy(name = "username")
	WebElement usernameInput;
	
	@FindBy(name = "password")
	WebElement passwordInput;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath = "//div[@class = 'orangehrm-login-logo']")
	WebElement logo;
	
	//2. constructor (initializing the objects)
	public LoginPage() {
		// "this" means: Initialize all the @FindBy elements in THIS class using the driver
		PageFactory.initElements(driver, this);
	}
	
	//3. actions (methods)
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateLogo() {
		return logo.isDisplayed();
	}
	
	public void enterUsername(String username) {
		enterText(usernameInput, username);
	}
	
	public void enterPassword(String password) {
		enterText(passwordInput, password);
	}
	
	public void clickLoginBtn() {
		waitForClickability(loginBtn);
		loginBtn.click();
	}
	
	public DashboardPage login(String un, String pwd) {
		enterText(usernameInput, un);
		enterText(passwordInput, pwd);
		waitForClickability(loginBtn);
		loginBtn.click();
		//returning the next page object
		return new DashboardPage();
	}

}

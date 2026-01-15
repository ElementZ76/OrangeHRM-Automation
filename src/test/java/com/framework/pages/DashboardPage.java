package com.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.framework.base.TestBase;

public class DashboardPage extends TestBase {
	//1. page facotry (locators)
	@FindBy(xpath = "//span[text()='Admin']")
	WebElement adminTab;
	
	//2. constructors
	public DashboardPage() {
		PageFactory.initElements(driver, this);
	}
	
	//3. methods
	public AdminPage clickAdmin() {
		waitForClickability(adminTab);
		adminTab.click();
		return new AdminPage();
	}
}

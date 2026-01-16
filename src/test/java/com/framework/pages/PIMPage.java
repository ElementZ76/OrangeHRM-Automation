package com.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.framework.base.TestBase;

public class PIMPage extends TestBase {
	@FindBy(xpath = "//span[normalize-space()='PIM']")
	WebElement pimTab;
	
	@FindBy(xpath = "//a[normalize-space()='Add Employee']")
	WebElement addEmployeeBtn;
	
	@FindBy(name = "firstName")
	WebElement firstNameInput;
	
//	@FindBy(name = "middleName")
//	WebElement middleNameInput;
	
	@FindBy(name = "lastName")
	WebElement lastNameInput;
	
	@FindBy(xpath = "//input[@type='file']")
    WebElement uploadFileInput;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement saveBtn;
    
    @FindBy(xpath = "//div[contains(@class, 'oxd-toast-content')]")
    WebElement successToast;
    
    @FindBy(className = "oxd-form-loader")
    WebElement loader;
    
    public PIMPage() {
        PageFactory.initElements(driver, this);
    }
    
    public void navigateToPIM() {
        waitForClickability(pimTab);
        pimTab.click();
    }
    
    public void addingNewEmployee (String fname, String lname, String imgName) {
    	waitForClickability(addEmployeeBtn);
    	addEmployeeBtn.click();
    	
    	try {
			waitForInvisibility(loader);
		} catch (Exception e) {
			System.out.print("loader was not present/disappeared too fast");
		}
    	
    	enterText(firstNameInput, fname);
//    	enterText(middleNameInput, mname);
    	enterText(lastNameInput, lname);
    	
    	String imagePath = System.getProperty("user.dir") + "/src/test/resources/testdata/images/" + imgName;
    	uploadFileInput.sendKeys(imagePath);
    	
    	waitForClickability(saveBtn);
    	saveBtn.click();
    }
    
    public boolean isSuccessMessageDisplayed() {
    	try {
			waitForVisibility(successToast);
			return successToast.isDisplayed();
		} catch (Exception e) {
			return false;
		}
    }
	
}

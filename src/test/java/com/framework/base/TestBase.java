package com.framework.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	
	//constructor for loading the config file immediately
	public TestBase() {
		try {
			prop = new Properties();
			//point to the config file path
			FileInputStream ip = new FileInputStream("src/test/resources/config.properties");
			prop.load(ip);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//method to launch the browser
	public static void initialization() {	
		String browserName = prop.getProperty("browser");
		
		if (browserName.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equals("edge")) {
			driver = new EdgeDriver();
		}
		else {
			System.out.println("Broser not supported:" + browserName);
			return; 
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(prop.getProperty("implicitWait"))));
		driver.get(prop.getProperty("url"));
	}
	
	// method to wait for element to be visible
	public static void waitForVisibility(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	
	// method to wait for element to be clickable
	public static void waitForClickability(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		wait.ignoring(StaleElementReferenceException.class);
		waitForVisibility(element);
	}
	
	// method to retry clicking the element with attempts in case the element does not fully load
	public static void clickOn(WebElement element) {
		int attempts = 0;
		while(attempts<3) {
			try {
				waitForClickability(element);
				element.click();
				break;
			} catch(StaleElementReferenceException e) {
				attempts++;
				System.out.println("element was stale. retrying....");
			} catch(Exception e) {
				System.out.println("element was stale. max attempts reachced.");
				throw e;
			}
		}
	}
	
	//method to enter text in an input field with retry attempts 
	public static void enterText(WebElement element, String text) {
		int attempts = 0;
		while (attempts<3) {
			try {
				waitForVisibility(element);
				element.click();
	            element.sendKeys(Keys.CONTROL + "a");
	            element.sendKeys(Keys.BACK_SPACE);
	            element.sendKeys(text);
	            break;
			} catch (StaleElementReferenceException e) {
				attempts++;
				System.out.println("element stale while typing. retrying....");
			} catch (Exception e) {
				System.out.println("stale element. max attempts breached.");
				throw e;
			}
		}
	}
	
	// method to select from given dropdown
	public static void selectFromDropdown(WebElement dropdown, String optionText) {
		waitForClickability(dropdown);
		dropdown.click();
		By optionLocator = By.xpath("//div[@role='listbox']//span[text()='"+ optionText + "']");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(optionLocator));
		option.click();
	}
	
	//method to wait for any element to disappear
	public static void waitForInvisibility(WebElement element) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	    // This waits until the element is either GONE from the DOM or invisible
	    wait.until(ExpectedConditions.invisibilityOf(element));
	}
	
	//teardown
	public void tearDown() {
		if(driver != null) {
			driver.quit();
		}
	}
	
}

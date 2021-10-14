package com.bankguru.customer;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bankguru.common.Login_01_Register_And_Login;
import com.data.bankguru.Customer.New_Customer_05;

import commons.BaseTest;
import environmentConfig.Environment;
import pageObjects.bankGuru.HomePageObject;
import pageObjects.bankGuru.LoginPageObject;
import pageObjects.bankGuru.NewCustomerPageObject;
import pageObjects.bankGuru.PageGeneratorManager;

public class New_Customer_05_Validate_PIN extends BaseTest {
	WebDriver driver;
	Environment environment;
	@Parameters({"browser"})
	@BeforeClass
	public void initBrowser(String browser) {
		String environmentName = System.getProperty("envMaven");
		if (environmentName == null) {
			environmentName = "testing";
		}
		ConfigFactory.setProperty("env", environmentName);
		environment = ConfigFactory.create(Environment.class);
		driver = getBrowser(browser, environment.appUrl());
		newCustomerData05 = New_Customer_05.getNewCustomer05();
		
		loginPage = PageGeneratorManager.getLoginPage(driver);
		loginPage.enterToTextBoxByTextTagAndName(driver, Login_01_Register_And_Login.userID, "UserID", "input", "uid");
		loginPage.enterToTextBoxByTextTagAndName(driver, Login_01_Register_And_Login.password, "Password", "input", "password");
		loginPage.clickToButtonByNameAttribute(driver, "btnLogin");
		showBrowserConsoleLogs(driver);
		
	}
	@Test
	public void  New_Customer_05_Validate_PIN_16_Must_Be_Numeric() {
		log.info("New_Customer_05_Validate_PIN_16 - Step 1 - Verify Welcome message is displayed at Home Page");
		homePage = PageGeneratorManager.getHomePage(driver);
		String welcomeMessage = "Welcome To Manager's Page of Guru99 Bank";
		verifyEquals(homePage.getWelcomeTextMessage(), welcomeMessage);
		
		log.info("New_Customer_05_Validate_PIN_16 - Step 2 - Click on menu 'New Customer' >>> Navigate to New Customer Page");
		homePage.clickToLinkText(driver, "New Customer");
		newCustomerPage = PageGeneratorManager.getNewCustomerPage(driver);
		
		log.info("New_Customer_05_Validate_PIN_16 - Step 3 - Enter to PIN textbox with data '" + newCustomerData05.PIN_NUMERIC + "'");
		newCustomerPage.enterToTextboxTextareaByTextTagAndName(driver, newCustomerData05.PIN_NUMERIC, "PIN", "input", "pinno");

		log.info("New_Customer_05_Validate_PIN_16 - Step 4 - Verify error message is displayed with content '" + newCustomerData05.ERROR_MSG_PIN_NUMERIC + "'");
		verifyEquals(newCustomerPage.getErrorValidationMessageByField("PIN"), newCustomerData05.ERROR_MSG_PIN_NUMERIC);

	}
	@Test
	public void  New_Customer_05_Validate_PIN_17_Not_Empty() {
		log.info("New_Customer_05_Validate_PIN_17 - Step 1 - Refresh New Customer Page");
		newCustomerPage.refreshCurrentPage(driver);
		
		log.info("New_Customer_05_Validate_PIN_17 - Step 2 - Leave Blank at PIN Textbox");
		newCustomerPage.enterToTextboxTextareaByTextTagAndName(driver, newCustomerData05.PIN_BLANK, "PIN", "input", "pinno");
		
		log.info("New_Customer_05_Validate_PIN_17 - Step 3 - Press Tab to move to next field");
		newCustomerPage.pressKeyboardToElementByTextTagAndName(driver, Keys.TAB, "PIN", "input", "pinno");
		
		log.info("New_Customer_05_Validate_PIN_17 - Step 4 - Verify error message is displayed with content '" + newCustomerData05.ERROR_MSG_PIN_BLANK + "'");
		verifyEquals(newCustomerPage.getErrorValidationMessageByField("PIN"), newCustomerData05.ERROR_MSG_PIN_BLANK);
	}
	@Test
	public void  New_Customer_05_Validate_PIN_18_Must_Six_Digits() {
		log.info("New_Customer_05_Validate_PIN_18 - Step 1 - Refresh New Customer Page");
		newCustomerPage.refreshCurrentPage(driver);
		
		log.info("New_Customer_05_Validate_PIN_18 - Step 2 - Enter to PIN textbox with data '" + newCustomerData05.PIN_LESS_SIX_DIGITS + "'");
		newCustomerPage.enterToTextboxTextareaByTextTagAndName(driver, newCustomerData05.PIN_LESS_SIX_DIGITS, "PIN", "input", "pinno");
		
		log.info("New_Customer_05_Validate_PIN_18 - Step 3 - Verify error message is displayed with content '" + newCustomerData05.ERROR_MSG_PIN_NOT_SIX_DIGITS + "'");
		verifyEquals(newCustomerPage.getErrorValidationMessageByField("PIN"), newCustomerData05.ERROR_MSG_PIN_NOT_SIX_DIGITS);
	}
	@Test
	public void  New_Customer_05_Validate_PIN_19_Special_Char() {
		log.info("New_Customer_05_Validate_PIN_19 - Step 1 - Refresh New Customer Page");
		newCustomerPage.refreshCurrentPage(driver);
		
		log.info("New_Customer_05_Validate_PIN_19 - Step 2 - Enter to PIN textbox with data '" + newCustomerData05.PIN_SPECIAL_CHAR + "'");
		newCustomerPage.enterToTextboxTextareaByTextTagAndName(driver, newCustomerData05.PIN_SPECIAL_CHAR, "PIN", "input", "pinno");
		
		log.info("New_Customer_05_Validate_PIN_19 - Step 3 - Verify error message is displayed with content '" + newCustomerData05.ERROR_MSG_PIN_SPECIAL_CHAR + "'");
		verifyEquals(newCustomerPage.getErrorValidationMessageByField("PIN"), newCustomerData05.ERROR_MSG_PIN_SPECIAL_CHAR);
	}
	@Test
	public void  New_Customer_05_Validate_PIN_20_First_Blank_Space() {
		log.info("New_Customer_05_Validate_PIN_20 - Step 1 - Refresh New Customer Page");
		newCustomerPage.refreshCurrentPage(driver);
		
		log.info("New_Customer_05_Validate_PIN_20 - Step 2 - Enter to PIN textbox with data '" + newCustomerData05.PIN_FIRST_CHAR_BLANK + "'");
		newCustomerPage.enterToTextboxTextareaByTextTagAndName(driver, newCustomerData05.PIN_FIRST_CHAR_BLANK, "PIN", "input", "pinno");
		
		log.info("New_Customer_05_Validate_PIN_20 - Step 3 - Verify error message is displayed with content '" + newCustomerData05.ERROR_MSG_PIN_FIRST_CHAR_BLANK + "'");
		verifyEquals(newCustomerPage.getErrorValidationMessageByField("PIN"), newCustomerData05.ERROR_MSG_PIN_FIRST_CHAR_BLANK);
	}
	@Test
	public void  New_Customer_05_Validate_PIN_21_Blank_Space() {
		log.info("New_Customer_05_Validate_PIN_21 - Step 1 - Refresh New Customer Page");
		newCustomerPage.refreshCurrentPage(driver);
		
		log.info("New_Customer_05_Validate_PIN_21 - Step 2 - Enter to PIN textbox with data '" + newCustomerData05.PIN_SPACE + "'");
		newCustomerPage.enterToTextboxTextareaByTextTagAndName(driver, newCustomerData05.PIN_SPACE, "PIN", "input", "pinno");
		
		log.info("New_Customer_05_Validate_PIN_21 - Step 3 - Verify error message is displayed with content '" + newCustomerData05.ERROR_MSG_PIN_SPACE + "'");
		verifyEquals(newCustomerPage.getErrorValidationMessageByField("PIN"), newCustomerData05.ERROR_MSG_PIN_SPACE);
	}

	
	@Parameters("browser")
	@AfterClass(alwaysRun = true)
	public void closeBrowser(String browserName) {
		log.info("Post-Condition - Close browser '" + browserName + "'");
		closeBrowserAndDriver();
	}
	
	HomePageObject homePage;
	LoginPageObject loginPage;
	NewCustomerPageObject newCustomerPage;
	New_Customer_05 newCustomerData05;

}
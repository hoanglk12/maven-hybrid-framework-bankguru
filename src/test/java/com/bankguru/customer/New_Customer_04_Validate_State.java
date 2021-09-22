package com.bankguru.customer;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bankguru.common.Login_01_Register_And_Login;
import com.data.bankguru.Customer.New_Customer_04;

import commons.BaseTest;
import environmentConfig.Environment;
import pageObjects.bankGuru.HomePageObject;
import pageObjects.bankGuru.LoginPageObject;
import pageObjects.bankGuru.NewCustomerPageObject;
import pageObjects.bankGuru.PageGeneratorManager;

public class New_Customer_04_Validate_State extends BaseTest {
	WebDriver driver;
	Environment environment;
	@Parameters({"browser"})
	@BeforeClass
	public void initBrowser(String browser) {
		String environmentName = System.getProperty("envMaven");
		ConfigFactory.setProperty("env", environmentName);
		environment = ConfigFactory.create(Environment.class);
		driver = getBrowser(browser, environment.appUrl());
		newCustomerData04 = New_Customer_04.getNewCustomer04();
		
		loginPage = PageGeneratorManager.getLoginPage(driver);
		loginPage.enterToTextBoxByTextTagAndName(driver, Login_01_Register_And_Login.userID, "UserID", "input", "uid");
		loginPage.enterToTextBoxByTextTagAndName(driver, Login_01_Register_And_Login.password, "Password", "input", "password");
		loginPage.clickToButtonByNameAttribute(driver, "btnLogin");
		showBrowserConsoleLogs(driver);
		
	}
	@Test
	public void  New_Customer_04_Validate_State_12_Not_Empty() {
		log.info("New_Customer_04_Validate_State_12 - Step 1 - Verify Welcome message is displayed at Home Page");
		homePage = PageGeneratorManager.getHomePage(driver);
		String welcomeMessage = "Welcome To Manager's Page of Guru99 Bank";
		verifyEquals(homePage.getWelcomeTextMessage(), welcomeMessage);
		
		log.info("New_Customer_04_Validate_State_12 - Step 2 - Click on menu 'New Customer' >>> Navigate to New Customer Page");
		homePage.clickToLinkText(driver, "New Customer");
		newCustomerPage = PageGeneratorManager.getNewCustomerPage(driver);
		
		log.info("New_Customer_04_Validate_State_12 - Step 3 - Leave blank at State Textbox");
		newCustomerPage.enterToTextboxTextareaByTextTagAndName(driver, newCustomerData04.STATE_BLANK, "State", "input", "state");
		
		log.info("New_Customer_04_Validate_State_12 - Step 4 - Press Tab to move to next field");
		newCustomerPage.pressKeyboardToElementByTextTagAndName(driver, Keys.TAB, "State", "input", "state");
		
		log.info("New_Customer_04_Validate_State_12 - Step 5 - Verify error message is displayed with content '" + newCustomerData04.ERROR_MSG_STATE_BLANK + "'");
		verifyEquals(newCustomerPage.getErrorValidationMessageByField("State"), newCustomerData04.ERROR_MSG_STATE_BLANK);
		
	}
	@Test
	public void  New_Customer_04_Validate_State_13_Not_Numeric() {
		log.info("New_Customer_04_Validate_State_13 - Step 1 - Refresh New Customer Page");
		newCustomerPage.refreshCurrentPage(driver);
		
		log.info("New_Customer_04_Validate_State_13 - Step 2 - Enter to State textbox with data '" + newCustomerData04.STATE_NUMERIC + "'");
		newCustomerPage.enterToTextboxTextareaByTextTagAndName(driver, newCustomerData04.STATE_NUMERIC, "State", "input", "state");
		
		log.info("New_Customer_04_Validate_State_13 - Step 3 - Verify error message is displayed with content '" + newCustomerData04.ERROR_MSG_STATE_NOT_NUMERIC + "'");
		verifyEquals(newCustomerPage.getErrorValidationMessageByField("State"), newCustomerData04.ERROR_MSG_STATE_NOT_NUMERIC);
	}
	@Test
	public void  New_Customer_04_Validate_State_14_Not_Special_Characters() {
		log.info("New_Customer_04_Validate_State_14 - Step 1 - Refresh New Customer Page");
		newCustomerPage.refreshCurrentPage(driver);
		
		log.info("New_Customer_04_Validate_State_14 - Step 2 - Enter to State textbox with data '" + newCustomerData04.STATE_SPECIAL_CHAR + "'");
		newCustomerPage.enterToTextboxTextareaByTextTagAndName(driver, newCustomerData04.STATE_SPECIAL_CHAR, "State", "input", "state");
		
		log.info("New_Customer_04_Validate_State_14 - Step 3 - Verify error message is displayed with content '" + newCustomerData04.ERROR_MSG_NOT_SPECIAL_CHAR + "'");
		verifyEquals(newCustomerPage.getErrorValidationMessageByField("State"), newCustomerData04.ERROR_MSG_NOT_SPECIAL_CHAR);
	
	}
	@Test
	public void  New_Customer_04_Validate_State_15_Not_First_Character_Blank() {
		log.info("New_Customer_04_Validate_State_15 - Step 1 - Refresh New Customer Page");
		newCustomerPage.refreshCurrentPage(driver);
		
		log.info("New_Customer_04_Validate_State_15 - Step 2 - Enter to State textbox with data '" + newCustomerData04.STATE_FIRST_CHAR_BLANK + "'");
		newCustomerPage.enterToTextboxTextareaByTextTagAndName(driver, newCustomerData04.STATE_FIRST_CHAR_BLANK, "State", "input", "state");
		
		log.info("New_Customer_04_Validate_State_15 - Step 3 - Verify error message is displayed with content '" + newCustomerData04.ERROR_MSG_FIRST_CHAR_BLANK + "'");
		verifyEquals(newCustomerPage.getErrorValidationMessageByField("State"), newCustomerData04.ERROR_MSG_FIRST_CHAR_BLANK);
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
	New_Customer_04 newCustomerData04;

}
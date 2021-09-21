package com.bankguru.customer;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bankguru.common.Login_01_Register_And_Login;
import com.data.bankguru.Customer.New_Customer_06;

import commons.BaseTest;
import environmentConfig.Environment;
import pageObjects.bankGuru.HomePageObject;
import pageObjects.bankGuru.LoginPageObject;
import pageObjects.bankGuru.NewCustomerPageObject;
import pageObjects.bankGuru.PageGeneratorManager;

public class New_Customer_06_Validate_Telephone extends BaseTest {
	WebDriver driver;
	Environment environment;
	@Parameters({"browser"})
	@BeforeClass
	public void initBrowser(String browser) {
		String environmentName = System.getProperty("envMaven");
		ConfigFactory.setProperty("env", environmentName);
		environment = ConfigFactory.create(Environment.class);
		driver = getBrowser(browser, environment.appUrl());
		newCustomerData06 = New_Customer_06.getNewCustomer06();
		
		loginPage = PageGeneratorManager.getLoginPage(driver);
		loginPage.enterToTextBoxByTextTagAndName(driver, Login_01_Register_And_Login.userID, "UserID", "input", "uid");
		loginPage.enterToTextBoxByTextTagAndName(driver, Login_01_Register_And_Login.password, "Password", "input", "password");
		loginPage.clickToButtonByNameAttribute(driver, "btnLogin");
		showBrowserConsoleLogs(driver);
		
	}
	@Test
	public void  New_Customer_06_Validate_Telephone_22_Not_Empty() {
		log.info("New_Customer_06_Validate_Telephone_22 - Step 1 - Verify Welcome message is displayed at Home Page");
		homePage = PageGeneratorManager.getHomePage(driver);
		String welcomeMessage = "Welcome To Manager's Page of Guru99 Bank";
		verifyEquals(homePage.getWelcomeTextMessage(), welcomeMessage);
		
		log.info("New_Customer_06_Validate_Telephone_22 - Step 2 - Click on menu 'New Customer' >>> Navigate to New Customer Page");
		homePage.clickToLinkText(driver, "New Customer");
		newCustomerPage = PageGeneratorManager.getNewCustomerPage(driver);
		
		log.info("New_Customer_06_Validate_Telephone_22 - Step 3 - Leave Blank at Mobile Number Textbox");
		newCustomerPage.enterToTextboxTextareaByTextTagAndName(driver, newCustomerData06.PHONE_BLANK, "Mobile Number", "input", "telephoneno");
		
		log.info("New_Customer_06_Validate_Telephone_22 - Step 4 - Press Tab to move to next field");
		newCustomerPage.pressKeyboardToElementByTextTagAndName(driver, Keys.TAB, "Mobile Number", "input", "telephoneno");
		
		log.info("New_Customer_06_Validate_Telephone_22 - Step 5 - Verify error message is displayed with content '" + newCustomerData06.ERROR_MSG_PHONE_BLANK + "'");
		verifyEquals(newCustomerPage.getErrorValidationMessageByField("Mobile Number"), newCustomerData06.ERROR_MSG_PHONE_BLANK);
	}
	@Test
	public void  New_Customer_06_Validate_Telephone_23_First_Char_Blank() {
		log.info("New_Customer_06_Validate_Telephone_23 - Step 1 - Refresh New Customer Page");
		newCustomerPage.refreshCurrentPage(driver);
		
		log.info("New_Customer_06_Validate_Telephone_23 - Step 2 - Enter to Mobile Number textbox with data '" + newCustomerData06.PHONE_FIRST_CHAR_BLANK + "'");
		newCustomerPage.enterToTextboxTextareaByTextTagAndName(driver, newCustomerData06.PHONE_FIRST_CHAR_BLANK, "Mobile Number", "input", "telephoneno");
		
		log.info("New_Customer_06_Validate_Telephone_23 - Step 3 - Verify error message is displayed with content '" + newCustomerData06.ERROR_MSG_PHONE_FIRST_CHAR_BLANK + "'");
		verifyEquals(newCustomerPage.getErrorValidationMessageByField("Mobile Number"), newCustomerData06.ERROR_MSG_PHONE_FIRST_CHAR_BLANK);
	}
	@Test
	public void  New_Customer_06_Validate_Telephone_24_Blank_Space() {
		log.info("New_Customer_06_Validate_Telephone_24 - Step 1 - Refresh New Customer Page");
		newCustomerPage.refreshCurrentPage(driver);
		
		log.info("New_Customer_06_Validate_Telephone_24 - Step 2 - Enter to Mobile Number textbox with data '" + newCustomerData06.PHONE_SPACE + "'");
		newCustomerPage.enterToTextboxTextareaByTextTagAndName(driver, newCustomerData06.PHONE_SPACE, "Mobile Number", "input", "telephoneno");
		
		log.info("New_Customer_06_Validate_Telephone_24 - Step 3 - Verify error message is displayed with content '" + newCustomerData06.ERROR_MSG_PHONE_SPACE + "'");
		verifyEquals(newCustomerPage.getErrorValidationMessageByField("Mobile Number"), newCustomerData06.ERROR_MSG_PHONE_SPACE);
	}
	@Test
	public void  New_Customer_06_Validate_Telephone_25_Not_Special_Char() {
		log.info("New_Customer_06_Validate_Telephone_25 - Step 1 - Refresh New Customer Page");
		newCustomerPage.refreshCurrentPage(driver);
		
		log.info("New_Customer_06_Validate_Telephone_25 - Step 2 - Enter to Mobile Number textbox with data '" + newCustomerData06.PHONE_SPECIAL_CHAR + "'");
		newCustomerPage.enterToTextboxTextareaByTextTagAndName(driver, newCustomerData06.PHONE_SPECIAL_CHAR, "Mobile Number", "input", "telephoneno");
		
		log.info("New_Customer_06_Validate_Telephone_25 - Step 3 - Verify error message is displayed with content '" + newCustomerData06.ERROR_MSG_PHONE_SPECIAL_CHAR + "'");
		verifyEquals(newCustomerPage.getErrorValidationMessageByField("Mobile Number"), newCustomerData06.ERROR_MSG_PHONE_SPECIAL_CHAR);
	}
	
	@Parameters("browser")
	@AfterClass(alwaysRun = true)
	public void closeBrowser(String browserName) {
		log.info("Post-Condition - Close browser '" + browserName + "'");
		closeBrowserAndDriver();
	}
	
	public HomePageObject homePage;
	public LoginPageObject loginPage;
	public NewCustomerPageObject newCustomerPage;
	New_Customer_06 newCustomerData06;

}
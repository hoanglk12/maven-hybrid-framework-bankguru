package com.bankguru.customer;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bankguru.common.Login_01_Register_And_Login;
import com.data.bankguru.Customer.New_Customer_05;

import commons.BaseTest;
import pageObjects.bankGuru.HomePageObject;
import pageObjects.bankGuru.LoginPageObject;
import pageObjects.bankGuru.NewCustomerPageObject;
import pageObjects.bankGuru.PageGeneratorManager;

public class New_Customer_06_Validate_Telephone extends BaseTest {
	WebDriver driver;
	@Parameters({"browser","urlBankGuru"})
	@BeforeClass
	public void initBrowser(String browser, String urlBankGuru) {
		driver = getBrowser(browser, urlBankGuru);
		newCustomerData05 = New_Customer_05.getNewCustomer05();
		
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
		
		log.info("New_Customer_06_Validate_Telephone_22 - Step 3 - Leave Blank at PIN Textbox");
		newCustomerPage.enterToTextboxTextareaByTextTagAndName(driver, newCustomerData05.PIN_BLANK, "PIN", "input", "pinno");
		
		log.info("New_Customer_06_Validate_Telephone_22 - Step 4 - Press Tab to move to next field");
		newCustomerPage.pressKeyboardToElementByTextTagAndName(driver, Keys.TAB, "PIN", "input", "pinno");
		
		log.info("New_Customer_06_Validate_Telephone_22 - Step 5 - Verify error message is displayed with content '" + newCustomerData05.ERROR_MSG_PIN_BLANK + "'");
		verifyEquals(newCustomerPage.getErrorValidationMessageByField("PIN"), newCustomerData05.ERROR_MSG_PIN_BLANK);
	}
	@Test
	public void  New_Customer_06_Validate_Telephone_23_First_Char_Blank() {
		log.info("New_Customer_06_Validate_Telephone_23 - Step 1 - Refresh New Customer Page");
		newCustomerPage.refreshCurrentPage(driver);
		
		log.info("New_Customer_06_Validate_Telephone_23 - Step 2 - Leave Blank at PIN Textbox");
		newCustomerPage.enterToTextboxTextareaByTextTagAndName(driver, newCustomerData05.PIN_BLANK, "PIN", "input", "pinno");
		
		log.info("New_Customer_06_Validate_Telephone_23 - Step 3 - Press Tab to move to next field");
		newCustomerPage.pressKeyboardToElementByTextTagAndName(driver, Keys.TAB, "PIN", "input", "pinno");
		
		log.info("New_Customer_06_Validate_Telephone_23 - Step 4 - Verify error message is displayed with content '" + newCustomerData05.ERROR_MSG_PIN_BLANK + "'");
		verifyEquals(newCustomerPage.getErrorValidationMessageByField("PIN"), newCustomerData05.ERROR_MSG_PIN_BLANK);
	}
	@Test
	public void  New_Customer_06_Validate_Telephone_24_Blank_Space() {
		log.info("New_Customer_06_Validate_Telephone_24 - Step 1 - Refresh New Customer Page");
		newCustomerPage.refreshCurrentPage(driver);
		
		log.info("New_Customer_06_Validate_Telephone_24 - Step 2 - Enter to PIN textbox with data '" + newCustomerData05.PIN_LESS_SIX_DIGITS + "'");
		newCustomerPage.enterToTextboxTextareaByTextTagAndName(driver, newCustomerData05.PIN_LESS_SIX_DIGITS, "PIN", "input", "pinno");
		
		log.info("New_Customer_06_Validate_Telephone_24 - Step 3 - Verify error message is displayed with content '" + newCustomerData05.ERROR_MSG_PIN_NOT_SIX_DIGITS + "'");
		verifyEquals(newCustomerPage.getErrorValidationMessageByField("PIN"), newCustomerData05.ERROR_MSG_PIN_NOT_SIX_DIGITS);
	}
	@Test
	public void  New_Customer_06_Validate_Telephone_25_Not_Special_Char() {
		log.info("New_Customer_06_Validate_Telephone_25 - Step 1 - Refresh New Customer Page");
		newCustomerPage.refreshCurrentPage(driver);
		
		log.info("New_Customer_06_Validate_Telephone_25 - Step 2 - Enter to PIN textbox with data '" + newCustomerData05.PIN_SPECIAL_CHAR + "'");
		newCustomerPage.enterToTextboxTextareaByTextTagAndName(driver, newCustomerData05.PIN_SPECIAL_CHAR, "PIN", "input", "pinno");
		
		log.info("New_Customer_06_Validate_Telephone_25 - Step 3 - Verify error message is displayed with content '" + newCustomerData05.ERROR_MSG_PIN_SPECIAL_CHAR + "'");
		verifyEquals(newCustomerPage.getErrorValidationMessageByField("PIN"), newCustomerData05.ERROR_MSG_PIN_SPECIAL_CHAR);
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
	New_Customer_05 newCustomerData05;

}
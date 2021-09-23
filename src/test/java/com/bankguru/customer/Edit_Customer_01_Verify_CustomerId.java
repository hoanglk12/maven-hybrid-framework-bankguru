package com.bankguru.customer;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bankguru.common.Login_01_Register_And_Login;
import com.data.bankguru.Customer.Common;
import com.data.bankguru.Customer.Edit_Customer_01;

import commons.BaseTest;
import environmentConfig.Environment;
import pageObjects.bankGuru.EditCustomerPageObject;
import pageObjects.bankGuru.HomePageObject;
import pageObjects.bankGuru.LoginPageObject;
import pageObjects.bankGuru.PageGeneratorManager;

public class Edit_Customer_01_Verify_CustomerId extends BaseTest {
	WebDriver driver;
	Environment environment;
	@Parameters({"browser"})
	@BeforeClass
	public void initBrowser(String browser) {
		String environmentName = System.getProperty("envMaven"); //only run with maven cmd line
		ConfigFactory.setProperty("env", environmentName);
		environment = ConfigFactory.create(Environment.class);
		driver = getBrowser(browser, environment.appUrl());
		editCustomerData01 = Edit_Customer_01.getEditCustomer01();
		
		loginPage = PageGeneratorManager.getLoginPage(driver);
		loginPage.enterToTextBoxByTextTagAndName(driver, Login_01_Register_And_Login.userID, "UserID", "input", "uid");
		loginPage.enterToTextBoxByTextTagAndName(driver, Login_01_Register_And_Login.password, "Password", "input", "password");
		loginPage.clickToButtonByNameAttribute(driver, "btnLogin");
		
	}
	@Test
	public void  Edit_Customer_01_Verify_CustomerId_01_Not_Empty() {
		log.info("Edit_Customer_01_Verify_CustomerId_01 - Step 1 - Verify Welcome message is displayed at Home Page");
		homePage = PageGeneratorManager.getHomePage(driver);
		String welcomeMessage = "Welcome To Manager's Page of Guru99 Bank";
		verifyEquals(homePage.getWelcomeTextMessage(), welcomeMessage);
		
		log.info("Edit_Customer_01_Verify_CustomerId_01 - Step 2 - Click on menu 'Edit Customer' >>> Navigate to Edit Customer Page");
		homePage.clickToLinkText(driver, "Edit Customer");
		editCustomerPage = PageGeneratorManager.getEditCustomerPage(driver);
		
		log.info("Edit_Customer_01_Verify_CustomerId_01 - Step 3 - Leave blank at Customer ID Textbox");
		editCustomerPage.enterToTextboxTextareaByTextTagAndName(driver, editCustomerData01.CUSTOMER_ID_BLANK, "Customer ID", "input", "cusid");
		
		log.info("Edit_Customer_01_Verify_CustomerId_01 - Step 4 - Press Tab to move to next field");
		editCustomerPage.pressKeyboardToElementByTextTagAndName(driver, Keys.TAB, "Customer ID", "input", "cusid");
		
		log.info("Edit_Customer_01_Verify_CustomerId_01 - Step 5 - Verify error message is displayed with content '" + editCustomerData01.ERROR_MSG_CUSTOMER_ID_BLANK + "'");
		verifyEquals(editCustomerPage.getErrorValidationMessageByField("Customer ID"), editCustomerData01.ERROR_MSG_CUSTOMER_ID_BLANK);
		
	}
	@Test
	public void  Edit_Customer_01_Verify_CustomerId_02_Numeric() {
		log.info("Edit_Customer_01_Verify_CustomerId_02 - Step 1 - Refresh Edit Customer Page");
		editCustomerPage.refreshCurrentPage(driver);
		
		log.info("Edit_Customer_01_Verify_CustomerId_02 - Step 2 - Enter to Customer ID textbox with data '" + editCustomerData01.CUSTOMER_ID_NUMERIC + "'");
		editCustomerPage.enterToTextboxTextareaByTextTagAndName(driver, editCustomerData01.CUSTOMER_ID_NUMERIC, "Customer ID", "input", "cusid");
		
		log.info("Edit_Customer_01_Verify_CustomerId_02 - Step 3 - Verify error message is displayed with content '" + editCustomerData01.ERROR_MSG_CUSTOMER_ID_NUMERIC + "'");
		verifyEquals(editCustomerPage.getErrorValidationMessageByField("Customer ID"), editCustomerData01.ERROR_MSG_CUSTOMER_ID_NUMERIC);
	}
	@Test
	public void  Edit_Customer_01_Verify_CustomerId_03_Not_Special_Characters() {
		log.info("Edit_Customer_01_Verify_CustomerId_03 - Step 1 - Refresh Edit Customer Page");
		editCustomerPage.refreshCurrentPage(driver);
		
		log.info("Edit_Customer_01_Verify_CustomerId_03 - Step 2 - Enter to Customer ID textbox with data '" + editCustomerData01.CUSTOMER_ID_SPECIAL_CHAR + "'");
		editCustomerPage.enterToTextboxTextareaByTextTagAndName(driver, editCustomerData01.CUSTOMER_ID_SPECIAL_CHAR, "Customer ID", "input", "cusid");
		
		log.info("Edit_Customer_01_Verify_CustomerId_03 - Step 3 - Verify error message is displayed with content '" + editCustomerData01.ERROR_MSG_CUSTOMER_ID_SPECIAL_CHAR + "'");
		verifyEquals(editCustomerPage.getErrorValidationMessageByField("Customer ID"), editCustomerData01.ERROR_MSG_CUSTOMER_ID_SPECIAL_CHAR);
	
	}
	@Test
	public void  Edit_Customer_01_Verify_CustomerId_04_Valid_CustomerId() {
		log.info("Edit_Customer_01_Verify_CustomerId_04 - Step 1 - Refresh New Customer Page");
		editCustomerPage.refreshCurrentPage(driver);
		
		log.info("Edit_Customer_01_Verify_CustomerId_04 - Step 2 - Enter to Customer Name textbox with data '" + Common.getCommon().CUSTOMER_ID_VALID + "'");
		editCustomerPage.enterToTextboxTextareaByTextTagAndName(driver, Common.getCommon().CUSTOMER_ID_VALID, "Customer ID", "input", "cusid");
		
		log.info("Edit_Customer_01_Verify_CustomerId_04 - Step 3 - Click to Submit button");
		editCustomerPage.clickToButtonByNameAttribute(driver, "AccSubmit");
		
		log.info("Edit_Customer_01_Verify_CustomerId_04 - Step 4 - Verify header text '" + editCustomerData01.HEADER_TEXT_EDIT_CUSTOMER_PAGE + " is displayed");
		verifyEquals(editCustomerPage.getTextHeaderPage(driver), editCustomerData01.HEADER_TEXT_EDIT_CUSTOMER_PAGE);
	}

	
	@Parameters("browser")
	@AfterClass(alwaysRun = true)
	public void closeBrowser(String browserName) {
		log.info("Post-Condition - Close browser '" + browserName + "'");
		closeBrowserAndDriver();
	}
	
	private HomePageObject homePage;
	private LoginPageObject loginPage;
	private EditCustomerPageObject editCustomerPage;
	Edit_Customer_01 editCustomerData01;
	
}
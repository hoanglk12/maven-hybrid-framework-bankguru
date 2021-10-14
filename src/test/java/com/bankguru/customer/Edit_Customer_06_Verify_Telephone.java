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
import com.data.bankguru.Customer.Edit_Customer_06;

import commons.BaseTest;
import environmentConfig.Environment;
import pageObjects.bankGuru.EditCustomerPageObject;
import pageObjects.bankGuru.HomePageObject;
import pageObjects.bankGuru.LoginPageObject;
import pageObjects.bankGuru.PageGeneratorManager;

public class Edit_Customer_06_Verify_Telephone extends BaseTest {
	WebDriver driver;
	Environment environment;
	@Parameters({"browser"})
	@BeforeClass
	public void initBrowser(String browser) {
		String environmentName = System.getProperty("envMaven"); //only run with maven cmd line
		if (environmentName == null) {
			environmentName = "testing";
		}
		ConfigFactory.setProperty("env", environmentName);
		environment = ConfigFactory.create(Environment.class);
		driver = getBrowser(browser, environment.appUrl());
		editCustomerData06 = Edit_Customer_06.getEditCustomer06();
		
		loginPage = PageGeneratorManager.getLoginPage(driver);
		loginPage.enterToTextBoxByTextTagAndName(driver, Login_01_Register_And_Login.userID, "UserID", "input", "uid");
		loginPage.enterToTextBoxByTextTagAndName(driver, Login_01_Register_And_Login.password, "Password", "input", "password");
		loginPage.clickToButtonByNameAttribute(driver, "btnLogin");
		
	}
	@Test
	public void Edit_Customer_06_Verify_Telephone_16_Not_Empty() {
		log.info("Edit_Customer_06_Verify_Telephone_16 - Step 1 - Verify Welcome message is displayed at Home Page");
		homePage = PageGeneratorManager.getHomePage(driver);
		String welcomeMessage = "Welcome To Manager's Page of Guru99 Bank";
		verifyEquals(homePage.getWelcomeTextMessage(), welcomeMessage);
		
		log.info("Edit_Customer_06_Verify_Telephone_16 - Step 2 - Click on menu 'Edit Customer' >>> Navigate to Edit Customer Page");
		homePage.clickToLinkText(driver, "Edit Customer");
		editCustomerPage = PageGeneratorManager.getEditCustomerPage(driver);
		
		log.info("Edit_Customer_06_Verify_Telephone_16 - Step 3 - Enter to Customer ID Textbox with data '" + Common.getCommon().CUSTOMER_ID_VALID);
		editCustomerPage.enterToTextboxTextareaByTextTagAndName(driver, Common.getCommon().CUSTOMER_ID_VALID, "Customer ID", "input", "cusid");
		
		log.info("Edit_Customer_06_Verify_Telephone_16 - Step 4 - Click to Submit button");
		editCustomerPage.clickToButtonByNameAttribute(driver, "AccSubmit");
		
		log.info("Edit_Customer_06_Verify_Telephone_16 - Step 5 - Enter to Mobile Number textbox with data '" + editCustomerData06.EDIT_PHONE_BLANK + "'");
		editCustomerPage.enterToTextboxTextareaByTextTagAndName(driver, editCustomerData06.EDIT_PHONE_BLANK, "Mobile Number", "input", "telephoneno");
		
		log.info("Edit_Customer_06_Verify_Telephone_16 - Step 6 - Press Tab to move to next field");
		editCustomerPage.pressKeyboardToElementByTextTagAndName(driver, Keys.TAB, "Mobile Number", "input", "telephoneno");
		
		log.info("Edit_Customer_06_Verify_Telephone_16 - Step 7 - Verify error message is displayed with content '" + editCustomerData06.ERROR_MSG_EDIT_PHONE_BLANK + "'");
		verifyEquals(editCustomerPage.getErrorValidationMessageByField("Mobile Number"), editCustomerData06.ERROR_MSG_EDIT_PHONE_BLANK);
	}
	@Test
	public void Edit_Customer_06_Verify_Telephone_17_Not_Special_Char() {
		log.info(" Edit_Customer_06_Verify_Telephone_17 - Step 1 - Enter to Mobile Number textbox with data '" + editCustomerData06.EDIT_PHONE_SPECIAL_CHAR + "'");
		editCustomerPage.enterToTextboxTextareaByTextTagAndName(driver, editCustomerData06.EDIT_PHONE_SPECIAL_CHAR, "Mobile Number", "input", "telephoneno");
		
		log.info(" Edit_Customer_06_Verify_Telephone_17 - Step 2 - Verify error message is displayed with content '" + editCustomerData06.ERROR_MSG_EDIT_PHONE_SPECIAL_CHAR + "'");
		verifyEquals(editCustomerPage.getErrorValidationMessageByField("Mobile Number"), editCustomerData06.ERROR_MSG_EDIT_PHONE_SPECIAL_CHAR);
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
	private Edit_Customer_06 editCustomerData06;

}
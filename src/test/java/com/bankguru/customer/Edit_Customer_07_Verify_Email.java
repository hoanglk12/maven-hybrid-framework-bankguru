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
import com.data.bankguru.Customer.Edit_Customer_07;

import commons.BaseTest;
import environmentConfig.Environment;
import pageObjects.bankGuru.EditCustomerPageObject;
import pageObjects.bankGuru.HomePageObject;
import pageObjects.bankGuru.LoginPageObject;
import pageObjects.bankGuru.PageGeneratorManager;

public class Edit_Customer_07_Verify_Email extends BaseTest {
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
		editCustomerData07 = Edit_Customer_07.getEditCustomer07();
		
		loginPage = PageGeneratorManager.getLoginPage(driver);
		loginPage.enterToTextBoxByTextTagAndName(driver, Login_01_Register_And_Login.userID, "UserID", "input", "uid");
		loginPage.enterToTextBoxByTextTagAndName(driver, Login_01_Register_And_Login.password, "Password", "input", "password");
		loginPage.clickToButtonByNameAttribute(driver, "btnLogin");
		
	}
	@Test
	public void Edit_Customer_07_Verify_Email_18_Not_Empty() {
		log.info("Edit_Customer_07_Verify_Email_18 - Step 1 - Verify Welcome message is displayed at Home Page");
		homePage = PageGeneratorManager.getHomePage(driver);
		String welcomeMessage = "Welcome To Manager's Page of Guru99 Bank";
		verifyEquals(homePage.getWelcomeTextMessage(), welcomeMessage);
		
		log.info("Edit_Customer_07_Verify_Email_18 - Step 2 - Click on menu 'Edit Customer' >>> Navigate to Edit Customer Page");
		homePage.clickToLinkText(driver, "Edit Customer");
		editCustomerPage = PageGeneratorManager.getEditCustomerPage(driver);
		
		log.info("Edit_Customer_07_Verify_Email_18 - Step 3 - Enter to Customer ID Textbox with data '" + Common.getCommon().CUSTOMER_ID_VALID);
		editCustomerPage.enterToTextboxTextareaByTextTagAndName(driver, Common.getCommon().CUSTOMER_ID_VALID, "Customer ID", "input", "cusid");
		
		log.info("Edit_Customer_07_Verify_Email_18 - Step 4 - Click to Submit button");
		editCustomerPage.clickToButtonByNameAttribute(driver, "AccSubmit");
		
		log.info("Edit_Customer_07_Verify_Email_18 - Step 5 - Enter to E-mail textbox with data '" + editCustomerData07.EDIT_EMAIL_BLANK + "'");
		editCustomerPage.enterToTextboxTextareaByTextTagAndName(driver, editCustomerData07.EDIT_EMAIL_BLANK, "E-mail", "input", "emailid");
		
		log.info("Edit_Customer_07_Verify_Email_18 - Step 6 - Press Tab to move to next field");
		editCustomerPage.pressKeyboardToElementByTextTagAndName(driver, Keys.TAB, "E-mail", "input", "emailid");
		
		log.info("Edit_Customer_07_Verify_Email_18 - Step 7 - Verify error message is displayed with content '" + editCustomerData07.ERROR_MSG_EDIT_EMAIL_BLANK + "'");
		verifyEquals(editCustomerPage.getErrorValidationMessageByField("E-mail"), editCustomerData07.ERROR_MSG_EDIT_EMAIL_BLANK);
	}
	@Test
	public void Edit_Customer_07_Verify_Email_19_Not_First_Char_Blank() {
		log.info("Edit_Customer_07_Verify_Email_19 - Step 1 - Enter to E-mail textbox with data '" + editCustomerData07.EDIT_EMAIL_SPACE + "'");
		editCustomerPage.enterToTextboxTextareaByTextTagAndName(driver, editCustomerData07.EDIT_EMAIL_SPACE, "E-mail", "input", "emailid");
		
		log.info("Edit_Customer_07_Verify_Email_19 - Step 2 - Verify error message is displayed with content '" + editCustomerData07.ERROR_MSG_EDIT_EMAIL_SPACE + "'");
		verifyEquals(editCustomerPage.getErrorValidationMessageByField("E-mail"), editCustomerData07.ERROR_MSG_EDIT_EMAIL_SPACE);
	}
	@Test
	public void Edit_Customer_07_Verify_Email_20_Not_Correct_Format() {
		log.info("Edit_Customer_07_Verify_Email_20 - Step 1 - Enter to E-mail textbox with data '" + editCustomerData07.EDIT_EMAIL_NOT_CORRECT_FORMAT + "'");
		editCustomerPage.enterToTextboxTextareaByTextTagAndName(driver, editCustomerData07.EDIT_EMAIL_NOT_CORRECT_FORMAT, "E-mail", "input", "emailid");
		
		log.info("Edit_Customer_07_Verify_Email_20 - Step 2 - Verify error message is displayed with content '" + editCustomerData07.ERROR_MSG_EDIT_EMAIL_NOT_CORRECT_FORMAT + "'");
		verifyEquals(editCustomerPage.getErrorValidationMessageByField("E-mail"), editCustomerData07.ERROR_MSG_EDIT_EMAIL_NOT_CORRECT_FORMAT);
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
	private Edit_Customer_07 editCustomerData07;

}
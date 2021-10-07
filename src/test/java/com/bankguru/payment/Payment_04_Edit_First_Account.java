package com.bankguru.payment;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bankguru.common.Login_01_Register_And_Login;
import com.bankguru.common.Login_02_Create_New_Customer;
import com.data.bankguru.Customer.Common;
import com.data.bankguru.Payment.Payment_03;

import commons.BaseTest;
import environmentConfig.Environment;
import pageObjects.bankGuru.EditAccountPageObject;
import pageObjects.bankGuru.HomePageObject;
import pageObjects.bankGuru.LoginPageObject;
import pageObjects.bankGuru.PageGeneratorManager;

public class Payment_04_Edit_First_Account extends BaseTest{
	WebDriver driver;
	Environment environment;
	@Parameters({"browser"})
	@BeforeClass
	public void initBrowser(String browser) {
		String environmentName = System.getProperty("envMaven"); //only run with maven cmd line
		ConfigFactory.setProperty("env", environmentName);
		environment = ConfigFactory.create(Environment.class);
		driver = getBrowser(browser, environment.appUrl());
		paymentData03 = Payment_03.getPayment_03();
				
		loginPage = PageGeneratorManager.getLoginPage(driver);
		loginPage.enterToTextBoxByTextTagAndName(driver, Login_01_Register_And_Login.userID, "UserID", "input", "uid");
		loginPage.enterToTextBoxByTextTagAndName(driver, Login_01_Register_And_Login.password, "Password", "input", "password");
		loginPage.clickToButtonByNameAttribute(driver, "btnLogin");
		
	}
	@Test
	public void Payment_04_Edit_First_Account_Customer() {
		log.info("Payment_04 - Step 1 - Verify Welcome message is displayed at Home Page");
		homePage = PageGeneratorManager.getHomePage(driver);
		String welcomeMessage = "Welcome To Manager's Page of Guru99 Bank";
		verifyEquals(homePage.getWelcomeTextMessage(), welcomeMessage);
		
		log.info("Payment_04 - Step 2 - Click on menu 'Edit Account' >>> Navigate to Edit Account Page");
		homePage.clickToLinkText(driver, "Edit Account");
		editAccountPage = PageGeneratorManager.getEditAccountPage(driver);
		
		log.info("Verify 'Add new account form' header text is displayed");
		verifyEquals(editAccountPage.getTextHeaderPage(driver), paymentData03.HEADER_TEXT_NEW_ACCOUNT_PAGE);
		
		log.info("Payment_04 - Step 3 - Input to Customer id Textbox with valid data '" + Login_02_Create_New_Customer.customerID);
		editAccountPage.enterToTextboxTextareaByTextTagAndName(driver, Login_02_Create_New_Customer.customerID, "Customer id", "input", "cusid");
		
		log.info("Payment_04 - Step 4 - Select From Account type dropdown with data '" + paymentData03.NEW_ACCOUNT_TYPE + "'");
		editAccountPage.selectItemFromAccountTypeDropdown(paymentData03.NEW_ACCOUNT_TYPE);
		
		log.info("Payment_04 - Step 5 - Input to Initial Deposit Textbox with data '" + paymentData03.NEW_ACCOUNT_INITIAL_DEPOSIT + "'");
		editAccountPage.enterToInitialDepositTextbox(paymentData03.NEW_ACCOUNT_INITIAL_DEPOSIT);
		
		log.info("Payment_04 - Step 6 - Click to Submit button");
		editAccountPage.clickToButtonByNameAttribute(driver, "button2");
		
		log.info("Payment_04 - Step 7 - Verify first New Account created successfully with Current Amount = " + paymentData03.NEW_ACCOUNT_INITIAL_DEPOSIT);
		verifyEquals(editAccountPage.getTextHeaderPage(driver), paymentData03.SUCCESS_MSG_ADD_NEW_ACCOUNT);
		verifyEquals(editAccountPage.getTextValueByRowName(driver, "Customer ID"), Common.getCommon().CUSTOMER_ID_VALID);
		verifyEquals(editAccountPage.getTextValueByRowName(driver, "Customer Name"), Common.NEW_CUSTOMER_NAME);
		verifyEquals(editAccountPage.getTextValueByRowName(driver, "Email"), Common.NEW_CUSTOMER_EMAIL);
		verifyEquals(editAccountPage.getTextValueByRowName(driver, "Account Type"), paymentData03.NEW_ACCOUNT_TYPE);
		verifyEquals(editAccountPage.getTextValueByRowName(driver, "Date of Opening"), getToday());
		verifyEquals(editAccountPage.getTextValueByRowName(driver, "Current Amount"), paymentData03.NEW_ACCOUNT_INITIAL_DEPOSIT);
		
	}
	
	@Parameters("browser")
	@AfterClass(alwaysRun = true)
	public void closeBrowser(String browserName) {
		log.info("Post-Condition - Close browser '" + browserName + "'");
		closeBrowserAndDriver();
	}
	
	private HomePageObject homePage;
	private LoginPageObject loginPage;
	private EditAccountPageObject editAccountPage;
	private Payment_03 paymentData03;
	
}

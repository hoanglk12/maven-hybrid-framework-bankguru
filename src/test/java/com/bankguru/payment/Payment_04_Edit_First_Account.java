package com.bankguru.payment;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bankguru.common.Login_01_Register_And_Login;
import com.data.bankguru.Customer.Common;
import com.data.bankguru.Payment.Payment_04;

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
		paymentData04 = Payment_04.getPayment_04();
				
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
		verifyEquals(editAccountPage.getTextHeaderPage(driver), paymentData04.HEADER_TEXT_EDIT_ACCOUNT_PAGE);
		
		log.info("Payment_04 - Step 3 - Input to Account No Textbox with valid data '" + Payment_03_Add_First_Account.firstAccountID);
		editAccountPage.enterToTextboxTextareaByTextTagAndName(driver, Payment_03_Add_First_Account.firstAccountID, "Account No", "input", "accountno");
		
		log.info("Payment_04 - Step 4 - Click to Submit button");
		editAccountPage.clickToButtonByNameAttribute(driver, "AccSubmit");
		
		log.info("Payment_04 - Step 5 - Select From Account type dropdown with data '" + paymentData04.EDIT_ACCOUNT_TYPE + "'");
		editAccountPage.selectItemFromAccountTypeDropdown(paymentData04.EDIT_ACCOUNT_TYPE);
		
		log.info("Payment_04 - Step 6 - Click to Submit button");
		editAccountPage.clickToButtonByNameAttribute(driver, "AccSubmit");
		
		log.info("Payment_04 - Step 7 - Verify first New Account updated successfully");
		verifyEquals(editAccountPage.getTextHeaderPage(driver), paymentData04.SUCCESS_MSG_ADD_NEW_ACCOUNT);
		verifyEquals(editAccountPage.getTextValueByRowName(driver, "Customer ID"), Common.getCommon().CUSTOMER_ID_VALID);
		verifyEquals(editAccountPage.getTextValueByRowName(driver, "Customer Name"), Common.NEW_CUSTOMER_NAME);
		verifyEquals(editAccountPage.getTextValueByRowName(driver, "Email"), Common.NEW_CUSTOMER_EMAIL);
		verifyEquals(editAccountPage.getTextValueByRowName(driver, "Account Type"), paymentData04.EDIT_ACCOUNT_TYPE);
		verifyEquals(editAccountPage.getTextValueByRowName(driver, "Date of Opening"), getToday());
		verifyEquals(editAccountPage.getTextValueByRowName(driver, "Current Amount"), paymentData04.NEW_ACCOUNT_INITIAL_DEPOSIT);
		
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
	private Payment_04 paymentData04;
	
}

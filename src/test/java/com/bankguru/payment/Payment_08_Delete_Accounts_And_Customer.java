package com.bankguru.payment;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bankguru.common.Login_01_Register_And_Login;
import com.bankguru.common.Login_02_Create_New_Customer;
import com.data.bankguru.Payment.Payment_08;

import commons.BaseTest;
import environmentConfig.Environment;
import pageObjects.bankGuru.DeleteAccountPageObject;
import pageObjects.bankGuru.DeleteCustomerPageObject;
import pageObjects.bankGuru.HomePageObject;
import pageObjects.bankGuru.LoginPageObject;
import pageObjects.bankGuru.PageGeneratorManager;

public class Payment_08_Delete_Accounts_And_Customer extends BaseTest {
	WebDriver driver;
	Environment environment;
	
	@Parameters({ "browser" })
	@BeforeClass
	public void initBrowser(String browser) {
		String environmentName = System.getProperty("envMaven"); // only run with maven cmd line
		if (environmentName == null) {
			environmentName = "testing";
		}
		ConfigFactory.setProperty("env", environmentName);
		environment = ConfigFactory.create(Environment.class);
		driver = getBrowser(browser, environment.appUrl());

		paymentData08 = Payment_08.getPayment_08();

		loginPage = PageGeneratorManager.getLoginPage(driver);
		loginPage.enterToTextBoxByTextTagAndName(driver, Login_01_Register_And_Login.userID, "UserID", "input", "uid");
		loginPage.enterToTextBoxByTextTagAndName(driver, Login_01_Register_And_Login.password, "Password", "input", "password");
		loginPage.clickToButtonByNameAttribute(driver, "btnLogin");

	}

	@Test
	public void Payment_08_01_Delete_Accounts() {
		log.info("Payment_08_01 - Step 1 - Verify Welcome message is displayed at Home Page");
		homePage = PageGeneratorManager.getHomePage(driver);
		String welcomeMessage = "Welcome To Manager's Page of Guru99 Bank";
		verifyEquals(homePage.getWelcomeTextMessage(), welcomeMessage);

		log.info("Payment_08_01 - Step 2 - Click on menu 'Delete Account' >>> Navigate to New Account Page");
		homePage.clickToLinkText(driver, "Delete Account");
		deleteAccountPage = PageGeneratorManager.getDeleteAccountPage(driver);

		log.info("Verify 'Delete Account Form' header text is displayed");
		verifyEquals(deleteAccountPage.getTextHeaderPage(driver), paymentData08.HEADER_TEXT_DELETE_ACCOUNT_PAGE);

		log.info("Payment_08_01 - Step 3 - Input to Account No Textbox with valid data '" + Payment_07_Transfer_Money.secondAccountID + "'");
		deleteAccountPage.enterToTextboxTextareaByTextTagAndName(driver, Payment_07_Transfer_Money.secondAccountID, "Account No", "input", "accountno");

		log.info("Payment_08_01 - Step 4 - Click to Submit button");
		deleteAccountPage.clickToButtonByNameAttribute(driver, "AccSubmit");

		log.info("Payment_08_01 - Step 5 - Accept first alert");
		deleteAccountPage.acceptAlert(driver);

		log.info("Payment_08_01 - Step 6 - Verify second alert with message 'Account Deleted Sucessfully' is displayed >>> Accept second alert");
		verifyEquals(deleteAccountPage.getTextAlert(driver), paymentData08.DELETE_ACCOUNT_ALERT_MESSAGE);
		deleteAccountPage.acceptAlert(driver);

		log.info("Payment_08_01 - Step 7 - Click on menu 'Delete Account' >>> Navigate to New Account Page");
		homePage.clickToLinkText(driver, "Delete Account");
		deleteAccountPage = PageGeneratorManager.getDeleteAccountPage(driver);

		log.info("Verify 'Delete Account Form' header text is displayed");
		verifyEquals(deleteAccountPage.getTextHeaderPage(driver), paymentData08.HEADER_TEXT_DELETE_ACCOUNT_PAGE);

		log.info("Payment_08_01 - Step 8 - Input to Account No Textbox with valid data '" + Payment_03_Add_First_Account.firstAccountID + "'");
		deleteAccountPage.enterToTextboxTextareaByTextTagAndName(driver, Payment_03_Add_First_Account.firstAccountID, "Account No", "input", "accountno");

		log.info("Payment_08_01 - Step 9 - Click to Submit button");
		deleteAccountPage.clickToButtonByNameAttribute(driver, "AccSubmit");

		log.info("Payment_08_01 - Step 10 - Accept first alert");
		deleteAccountPage.acceptAlert(driver);

		log.info("Payment_08_01 - Step 11 - Verify second alert with message 'Account Deleted Sucessfully' is displayed >>> Accept second alert");
		verifyEquals(deleteAccountPage.getTextAlert(driver), paymentData08.DELETE_ACCOUNT_ALERT_MESSAGE);
		deleteAccountPage.acceptAlert(driver);
	}

	@Test
	public void Payment_08_02_Delete_Customer() {
		log.info("Payment_08_02 - Step 1 - Click on menu 'Delete Customer' >>> Navigate to Delete Account Page");
		homePage.clickToLinkText(driver, "Delete Customer");
		deleteCustomerPage = PageGeneratorManager.getDeleteCustomerPage(driver);

		log.info("Verify 'Delete Customer Form' header text is displayed");
		verifyEquals(deleteCustomerPage.getTextHeaderPage(driver), paymentData08.HEADER_TEXT_DELETE_CUSTOMER_PAGE);

		log.info("Payment_08_02 - Step 2 - Input to Customer ID Textbox with valid data '" + Login_02_Create_New_Customer.customerID + "'");
		deleteCustomerPage.enterToTextboxTextareaByTextTagAndName(driver, Login_02_Create_New_Customer.customerID, "Customer ID", "input", "cusid");

		log.info("Payment_08_02 - Step 3 - Click to Submit button");
		deleteCustomerPage.clickToButtonByNameAttribute(driver, "AccSubmit");

		log.info("Payment_08_02 - Step 4 - Accept first alert");
		deleteCustomerPage.acceptAlert(driver);

		log.info("Payment_08_02 - Step 5 - Verify second alert with message 'Customer deleted Successfully' is displayed >>> Accept second alert");
		verifyEquals(deleteAccountPage.getTextAlert(driver), paymentData08.DELETE_CUSTOMER_ALERT_MESSAGE);
		deleteCustomerPage.acceptAlert(driver);
	}

	@Parameters("browser")
	@AfterClass(alwaysRun = true)
	public void closeBrowser(String browserName) {
		log.info("Post-Condition - Close browser '" + browserName + "'");
		closeBrowserAndDriver();
	}

	private HomePageObject homePage;
	private LoginPageObject loginPage;
	private DeleteAccountPageObject deleteAccountPage;
	private DeleteCustomerPageObject deleteCustomerPage;
	private Payment_08 paymentData08;

}

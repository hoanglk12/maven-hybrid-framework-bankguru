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
import com.data.bankguru.Payment.Payment_07;

import commons.BaseTest;
import environmentConfig.Environment;
import pageObjects.bankGuru.BalanceEnquiryPageObject;
import pageObjects.bankGuru.FundTransferPageObject;
import pageObjects.bankGuru.HomePageObject;
import pageObjects.bankGuru.LoginPageObject;
import pageObjects.bankGuru.NewAccountPageObject;
import pageObjects.bankGuru.PageGeneratorManager;

public class Payment_07_Transfer_Money extends BaseTest {
	WebDriver driver;
	Environment environment;
	static String secondAccountID;
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
	
		paymentData07 = Payment_07.getPayment_07();
				
		loginPage = PageGeneratorManager.getLoginPage(driver);
		loginPage.enterToTextBoxByTextTagAndName(driver, Login_01_Register_And_Login.userID, "UserID", "input", "uid");
		loginPage.enterToTextBoxByTextTagAndName(driver, Login_01_Register_And_Login.password, "Password", "input", "password");
		loginPage.clickToButtonByNameAttribute(driver, "btnLogin");
		
	}
	
	@Test
	public void Payment_07_00_Add_Second_Account() {
		log.info("Payment_07 - Step 1 - Verify Welcome message is displayed at Home Page");
		homePage = PageGeneratorManager.getHomePage(driver);
		String welcomeMessage = "Welcome To Manager's Page of Guru99 Bank";
		verifyEquals(homePage.getWelcomeTextMessage(), welcomeMessage);
		
		log.info("Payment_07_00 - Step 2 - Click on menu 'New Account' >>> Navigate to New Account Page");
		homePage.clickToLinkText(driver, "New Account");
		newAccountPage = PageGeneratorManager.getNewAccountPage(driver);
		
		log.info("Verify 'Add new account form' header text is displayed");
		verifyEquals(newAccountPage.getTextHeaderPage(driver), paymentData07.HEADER_TEXT_NEW_ACCOUNT_PAGE);
		
		log.info("Payment_07_00 - Step 3 - Input to Customer id Textbox with valid data '" + Login_02_Create_New_Customer.customerID);
		newAccountPage.enterToTextboxTextareaByTextTagAndName(driver, Login_02_Create_New_Customer.customerID, "Customer id", "input", "cusid");
		
		log.info("Payment_07_00 - Step 4 - Select From Account type dropdown with data '" + paymentData07.NEW_ACCOUNT_TYPE + "'");
		newAccountPage.selectItemFromAccountTypeDropdown(paymentData07.NEW_ACCOUNT_TYPE);
		
		log.info("Payment_07_00 - Step 5 - Input to Initial Deposit Textbox with data '" + paymentData07.NEW_ACCOUNT_INITIAL_DEPOSIT + "'");
		newAccountPage.enterToInitialDepositTextbox(paymentData07.NEW_ACCOUNT_INITIAL_DEPOSIT);
		
		log.info("Payment_07_00 - Step 6 - Click to Submit button");
		newAccountPage.clickToButtonByNameAttribute(driver, "button2");
		
		log.info("Payment_07_00 - Step 7 - Get Text Second Account ID");
		secondAccountID = newAccountPage.getTextValueByRowName(driver, "Account ID");
		
		log.info("Payment_07_00 - Step 8 - Verify second New Account created successfully with Current Amount = " + paymentData07.NEW_ACCOUNT_INITIAL_DEPOSIT);
		verifyEquals(newAccountPage.getTextHeaderPage(driver), paymentData07.SUCCESS_MSG_ADD_NEW_ACCOUNT);
		verifyEquals(newAccountPage.getTextValueByRowName(driver, "Customer ID"), Common.getCommon().CUSTOMER_ID_VALID);
		verifyEquals(newAccountPage.getTextValueByRowName(driver, "Customer Name"), Common.NEW_CUSTOMER_NAME);
		verifyEquals(newAccountPage.getTextValueByRowName(driver, "Email"), Common.NEW_CUSTOMER_EMAIL);
		verifyEquals(newAccountPage.getTextValueByRowName(driver, "Account Type"), paymentData07.NEW_ACCOUNT_TYPE);
		verifyEquals(newAccountPage.getTextValueByRowName(driver, "Date of Opening"), getToday());
		verifyEquals(newAccountPage.getTextValueByRowName(driver, "Current Amount"), paymentData07.NEW_ACCOUNT_INITIAL_DEPOSIT);
		
	}
	
	@Test
	public void Payment_07_01_Transfer_Money_From_FAccount_To_SAccount() {
		log.info("Payment_07_01 - Step 1 - Click on menu 'Fund Transfer' >>> Navigate to Fund Transfer Page");
		homePage.clickToLinkText(driver, "Fund Transfer");
		fundTransferPage = PageGeneratorManager.getFundTransferPage(driver);
		
		log.info("Verify 'Amount Withdrawal Form' header text is displayed");
		verifyEquals(fundTransferPage.getTextHeaderPage(driver), paymentData07.HEADER_TEXT_FUND_TRANSFER_PAGE);
		
		log.info("Payment_07_01 - Step 2 - Input to Payers account no Textbox with valid data '" + Payment_03_Add_First_Account.firstAccountID + "'");
		fundTransferPage.enterToTextBoxByTextTagAndName(driver, Payment_03_Add_First_Account.firstAccountID, "Payers account no", "input", "payersaccount");
		
		log.info("Payment_07_01 - Step 3 - Input to Payees account no Textbox with valid data '" + secondAccountID + "'");
		fundTransferPage.enterToTextBoxByTextTagAndName(driver, secondAccountID, "Payees account no", "input", "payeeaccount");
		
		log.info("Payment_07_01 - Step 4 - Input to Amount Textbox with valid data '" + paymentData07.FUND_TRANSFER_AMOUNT + "'");
		fundTransferPage.enterToTextBoxByTextTagAndName(driver, paymentData07.FUND_TRANSFER_AMOUNT, "Amount", "input", "ammount");
		
		log.info("Payment_07_01 - Step 5 - Input to Description Textbox with valid data '" + paymentData07.FUND_TRANSFER_DESCRIPTION + "'");
		fundTransferPage.enterToTextBoxByTextTagAndName(driver, paymentData07.FUND_TRANSFER_DESCRIPTION, "Description", "input", "desc");
		
		log.info("Payment_07_01 - Step 6 - Click to Submit button");
		fundTransferPage.clickToButtonByNameAttribute(driver, "AccSubmit");
		
		log.info("Payment_07_01 - Step 7 - Verify header text '" + paymentData07.HEADER_TEXT_FUND_TRANSFER_DETAILs + " is displayed and amount is '" + paymentData07.FUND_TRANSFER_AMOUNT + "'");
		verifyEquals(fundTransferPage.getTextHeaderPage(driver), paymentData07.HEADER_TEXT_FUND_TRANSFER_DETAILs);
		verifyEquals(fundTransferPage.getTextValueByRowName(driver, "From Account Number"), Payment_03_Add_First_Account.firstAccountID);
		verifyEquals(fundTransferPage.getTextValueByRowName(driver, "To Account Number"), secondAccountID);
		verifyEquals(fundTransferPage.getTextValueByRowName(driver, "Amount"), paymentData07.FUND_TRANSFER_AMOUNT);
		verifyEquals(fundTransferPage.getTextValueByRowName(driver, "Description"), paymentData07.FUND_TRANSFER_DESCRIPTION);
	}
	
	@Test
	public void Payment_07_02_Check_Account_Balance_On_First_Account() {
		log.info("Payment_07_02 - Step 1 - Click on menu 'Balance Enquiry' >>> Navigate to Balance Enquiry Page");
		homePage.clickToLinkText(driver, "Balance Enquiry");
		balanceEnquiryPage = PageGeneratorManager.getBalanceEnquiryPage(driver);
		
		log.info("Verify 'Balance Enquiry Form' header text is displayed");
		verifyEquals(fundTransferPage.getTextHeaderPage(driver), paymentData07.HEADER_TEXT_BALANCE_ENQUIRY_PAGE);
		
		log.info("Payment_07_02 - Step 2 - Input to Account no Textbox with valid data '" + Payment_03_Add_First_Account.firstAccountID + "'");
		balanceEnquiryPage.enterToTextBoxByTextTagAndName(driver, Payment_03_Add_First_Account.firstAccountID, "Account No", "input", "accountno");
				
		log.info("Payment_07_02 - Step 3 - Click to Submit button");
		balanceEnquiryPage.clickToButtonByNameAttribute(driver, "AccSubmit");
		
		log.info("Payment_07_02 - Step 4 - Verify header text '" + paymentData07.HEADER_TEXT_BALANCE_ENQUIRY_DETAILS_PAGE + " " + Payment_03_Add_First_Account.firstAccountID + "' is displayed and balance is '" + paymentData07.FUND_TRANSFER_AMOUNT + "'");
		verifyEquals(balanceEnquiryPage.getTextHeaderPage(driver), paymentData07.HEADER_TEXT_BALANCE_ENQUIRY_DETAILS_PAGE + " " + Payment_03_Add_First_Account.firstAccountID);
		verifyEquals(balanceEnquiryPage.getTextValueByRowName(driver, "Account No"), Payment_03_Add_First_Account.firstAccountID);
		verifyEquals(balanceEnquiryPage.getTextValueByRowName(driver, "Type of Account"), paymentData07.BALANCE_DETAILS_TYPE_OF_ACCOUNT);
		verifyEquals(balanceEnquiryPage.getTextValueByRowName(driver, "Balance"), String.valueOf(paymentData07.BALANCE_AMOUNT));
		
	}
	@Parameters("browser")
	@AfterClass(alwaysRun = true)
	public void closeBrowser(String browserName) {
		log.info("Post-Condition - Close browser '" + browserName + "'");
		closeBrowserAndDriver();
	}
	
	private HomePageObject homePage;
	private LoginPageObject loginPage;
	private NewAccountPageObject newAccountPage;
	private FundTransferPageObject fundTransferPage;
	private BalanceEnquiryPageObject balanceEnquiryPage;
	private Payment_07 paymentData07;
	
}

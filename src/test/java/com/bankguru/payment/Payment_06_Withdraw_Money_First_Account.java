package com.bankguru.payment;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bankguru.common.Login_01_Register_And_Login;
import com.data.bankguru.Payment.Payment_06;

import commons.BaseTest;
import environmentConfig.Environment;
import pageObjects.bankGuru.HomePageObject;
import pageObjects.bankGuru.LoginPageObject;
import pageObjects.bankGuru.PageGeneratorManager;
import pageObjects.bankGuru.WithdrawalPageObject;

public class Payment_06_Withdraw_Money_First_Account extends BaseTest {
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
		
		paymentData06 = Payment_06.getPayment_06();
				
		loginPage = PageGeneratorManager.getLoginPage(driver);
		loginPage.enterToTextBoxByTextTagAndName(driver, Login_01_Register_And_Login.userID, "UserID", "input", "uid");
		loginPage.enterToTextBoxByTextTagAndName(driver, Login_01_Register_And_Login.password, "Password", "input", "password");
		loginPage.clickToButtonByNameAttribute(driver, "btnLogin");
		
	}
	@Test
	public void Payment_06_Withdraw_Money_From_First_Account() {
		log.info("Payment_06 - Step 1 - Verify Welcome message is displayed at Home Page");
		homePage = PageGeneratorManager.getHomePage(driver);
		String welcomeMessage = "Welcome To Manager's Page of Guru99 Bank";
		verifyEquals(homePage.getWelcomeTextMessage(), welcomeMessage);
		
		log.info("Payment_06 - Step 2 - Click on menu 'Withdrawal' >>> Navigate to Withdrawal Page");
		homePage.clickToLinkText(driver, "Withdrawal");
		withdrawalPage = PageGeneratorManager.getWithdrawalPage(driver);
		
		log.info("Verify 'Amount Withdrawal Form' header text is displayed");
		verifyEquals(withdrawalPage.getTextHeaderPage(driver), paymentData06.HEADER_TEXT_WITHDRAWAL_PAGE);
		
		log.info("Payment_06 - Step 3 - Input to Account No Textbox with valid data '" + Payment_03_Add_First_Account.firstAccountID + "'");
		withdrawalPage.enterToTextBoxByTextTagAndName(driver, Payment_03_Add_First_Account.firstAccountID, "Account No", "input", "accountno");
		
		log.info("Payment_06 - Step 4 - Input to Amount Textbox with valid data '" + paymentData06.WITHDRAWAL_AMOUNT + "'");
		withdrawalPage.enterToTextBoxByTextTagAndName(driver, paymentData06.WITHDRAWAL_AMOUNT, "Amount", "input", "ammount");
		
		log.info("Payment_06 - Step 5 - Input to Description Textbox with valid data '" + paymentData06.WITHDRAWAL_DESCRIPTION + "'");
		withdrawalPage.enterToTextBoxByTextTagAndName(driver, paymentData06.WITHDRAWAL_DESCRIPTION, "Description", "input", "desc");
		
		log.info("Payment_06 - Step 6 - Click to Submit button");
		withdrawalPage.clickToButtonByNameAttribute(driver, "AccSubmit");
		
		log.info("Verify message '" + paymentData06.SUCCESS_MSG_UPDATE_ACCOUNT + " " + Payment_03_Add_First_Account.firstAccountID + "'" + " is displayed and current amount is '" + String.valueOf(paymentData06.WITHDRAWAL_CURRENT_AMOUNT) + "'");
		verifyEquals(withdrawalPage.getTextHeaderPage(driver), paymentData06.SUCCESS_MSG_UPDATE_ACCOUNT + " " + Payment_03_Add_First_Account.firstAccountID);
		verifyEquals(withdrawalPage.getTextValueByRowName(driver, "Account No"), Payment_03_Add_First_Account.firstAccountID);
		verifyEquals(withdrawalPage.getTextValueByRowName(driver, "Current Balance"), String.valueOf(paymentData06.WITHDRAWAL_CURRENT_AMOUNT));
		verifyEquals(withdrawalPage.getTextValueByRowName(driver, "Description"), paymentData06.WITHDRAWAL_DESCRIPTION);
	}
	
	@Parameters("browser")
	@AfterClass(alwaysRun = true)
	public void closeBrowser(String browserName) {
		log.info("Post-Condition - Close browser '" + browserName + "'");
		closeBrowserAndDriver();
	}
	
	private HomePageObject homePage;
	private LoginPageObject loginPage;
	private WithdrawalPageObject withdrawalPage;
	private Payment_06 paymentData06;
	
}

package com.bankguru.payment;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bankguru.common.Login_01_Register_And_Login;
import com.data.bankguru.Payment.Payment_05;

import commons.BaseTest;
import environmentConfig.Environment;
import pageObjects.bankGuru.DepositPageObject;
import pageObjects.bankGuru.HomePageObject;
import pageObjects.bankGuru.LoginPageObject;
import pageObjects.bankGuru.PageGeneratorManager;

public class Payment_05_Transfer_Money_First_Account extends BaseTest{
	WebDriver driver;
	Environment environment;
	@Parameters({"browser"})
	@BeforeClass
	public void initBrowser(String browser) {
		String environmentName = System.getProperty("envMaven"); //only run with maven cmd line
		ConfigFactory.setProperty("env", environmentName);
		environment = ConfigFactory.create(Environment.class);
		driver = getBrowser(browser, environment.appUrl());
		paymentData05 = Payment_05.getPayment_05();
				
		loginPage = PageGeneratorManager.getLoginPage(driver);
		loginPage.enterToTextBoxByTextTagAndName(driver, Login_01_Register_And_Login.userID, "UserID", "input", "uid");
		loginPage.enterToTextBoxByTextTagAndName(driver, Login_01_Register_And_Login.password, "Password", "input", "password");
		loginPage.clickToButtonByNameAttribute(driver, "btnLogin");
		
	}
	@Test
	public void Payment_05_Transfer_Money_To_First_Account() {
		log.info("Payment_05 - Step 1 - Verify Welcome message is displayed at Home Page");
		homePage = PageGeneratorManager.getHomePage(driver);
		String welcomeMessage = "Welcome To Manager's Page of Guru99 Bank";
		verifyEquals(homePage.getWelcomeTextMessage(), welcomeMessage);
		
		log.info("Payment_05 - Step 2 - Click on menu 'Deposit' >>> Navigate to Deposit Page");
		homePage.clickToLinkText(driver, "Deposit");
		depositPage = PageGeneratorManager.getDepositPage(driver);
		
		log.info("Verify 'Amount Deposit Form' header text is displayed");
		verifyEquals(depositPage.getTextHeaderPage(driver), paymentData05.HEADER_TEXT_DEPOSIT_PAGE);
		
		log.info("Payment_05 - Step 3 - Input to Account No Textbox with valid data '" + Payment_03_Add_First_Account.firstAccountID);
		depositPage.enterToTextBoxByTextTagAndName(driver, Payment_03_Add_First_Account.firstAccountID, "Account No", "input", "accountno");
		
		log.info("Payment_05 - Step 4 - Input to Amount Textbox with valid data '" + paymentData05.DEPOSIT_AMOUNT);
		depositPage.enterToTextBoxByTextTagAndName(driver, paymentData05.DEPOSIT_AMOUNT, "Amount", "input", "ammount");
		
		log.info("Payment_05 - Step 5 - Input to Description Textbox with valid data '" + paymentData05.DEPOSIT_DESCRIPTION);
		depositPage.enterToTextBoxByTextTagAndName(driver, paymentData05.DEPOSIT_DESCRIPTION, "Description", "input", "desc");
		
		log.info("Payment_05 - Step 6 - Click to Submit button");
		depositPage.clickToButtonByNameAttribute(driver, "AccSubmit");
		
		log.info("Verify message '" + paymentData05.SUCCESS_MSG_UPDATE_ACCOUNT + " " + Payment_03_Add_First_Account.firstAccountID + "'" + "is displayed and current amount is '" + String.valueOf(paymentData05.DEPOSIT_CURRENT_AMOUNT) + "'");
		verifyEquals(depositPage.getTextHeaderPage(driver), paymentData05.SUCCESS_MSG_UPDATE_ACCOUNT + " " + Payment_03_Add_First_Account.firstAccountID);
		verifyEquals(depositPage.getTextValueByRowName(driver, "Account No"), Payment_03_Add_First_Account.firstAccountID);
		verifyEquals(depositPage.getTextValueByRowName(driver, "Current Balance"), String.valueOf(paymentData05.DEPOSIT_CURRENT_AMOUNT));
		verifyEquals(depositPage.getTextValueByRowName(driver, "Description"), paymentData05.DEPOSIT_DESCRIPTION);
	}
	
	@Parameters("browser")
	@AfterClass(alwaysRun = true)
	public void closeBrowser(String browserName) {
		log.info("Post-Condition - Close browser '" + browserName + "'");
		closeBrowserAndDriver();
	}
	
	private HomePageObject homePage;
	private LoginPageObject loginPage;
	private DepositPageObject depositPage;
	private Payment_05 paymentData05;
	
}

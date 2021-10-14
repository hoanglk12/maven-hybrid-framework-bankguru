package com.bankguru.payment;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bankguru.common.Login_01_Register_And_Login;
import com.data.bankguru.Payment.Payment_08;

import commons.BaseTest;
import environmentConfig.Environment;
import pageObjects.bankGuru.DeleteAccountPageObject;
import pageObjects.bankGuru.HomePageObject;
import pageObjects.bankGuru.LoginPageObject;
import pageObjects.bankGuru.PageGeneratorManager;

public class Payment_08_Delete_Account extends BaseTest {
	WebDriver driver;
	Environment environment;
	static String secondAccountID;
	@Parameters({"browser"})
	@BeforeClass
	public void initBrowser(String browser) {
		String environmentName = System.getProperty("envMaven"); //only run with maven cmd line
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
	public void Payment_08_Delete_Account_Of_Customer() {
		log.info("Payment_08 - Step 1 - Verify Welcome message is displayed at Home Page");
		homePage = PageGeneratorManager.getHomePage(driver);
		String welcomeMessage = "Welcome To Manager's Page of Guru99 Bank";
		verifyEquals(homePage.getWelcomeTextMessage(), welcomeMessage);
		
		log.info("Payment_08 - Step 2 - Click on menu 'Delete Account' >>> Navigate to New Account Page");
		homePage.clickToLinkText(driver, "Delete Account");
		deleteAccountPage = PageGeneratorManager.getDeleteAccountPage(driver);
		
		log.info("Verify 'Delete Account Form' header text is displayed");
		verifyEquals(deleteAccountPage.getTextHeaderPage(driver), paymentData08.HEADER_TEXT_DELETE_ACCOUNT_PAGE);
		
		log.info("Payment_08 - Step 3 - Input to Account No Textbox with valid data '" + Payment_07_Transfer_Money.secondAccountID + "'");
		deleteAccountPage.enterToTextboxTextareaByTextTagAndName(driver, Payment_07_Transfer_Money.secondAccountID, "Account No", "input", "accountno");
		
		log.info("Payment_08 - Step 4 - Click to Submit button");
		deleteAccountPage.clickToButtonByNameAttribute(driver, "AccSubmit");
		
		log.info("Payment_08 - Step 5 - Accept first alert");
		deleteAccountPage.acceptAlert(driver);
				
		log.info("Payment_08 - Step 6 - Verify alert with message 'Account Deleted Sucessfully' is displayed >>> Accept second alert");
		verifyEquals(deleteAccountPage.getTextAlert(driver), paymentData08.DELETE_ACCOUNT_ALERT_MESSAGE);
		deleteAccountPage.acceptAlert(driver);
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
	private Payment_08 paymentData08;
	
}

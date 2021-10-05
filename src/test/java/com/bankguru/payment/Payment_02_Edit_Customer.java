package com.bankguru.payment;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bankguru.common.Login_01_Register_And_Login;
import com.data.bankguru.Customer.Common;
import com.data.bankguru.Payment.Payment_02;

import commons.BaseTest;
import environmentConfig.Environment;
import pageObjects.bankGuru.EditCustomerPageObject;
import pageObjects.bankGuru.HomePageObject;
import pageObjects.bankGuru.LoginPageObject;
import pageObjects.bankGuru.PageGeneratorManager;

public class Payment_02_Edit_Customer extends BaseTest{
	WebDriver driver;
	Environment environment;
	@Parameters({"browser"})
	@BeforeClass
	public void initBrowser(String browser) {
		String environmentName = System.getProperty("envMaven"); //only run with maven cmd line
		ConfigFactory.setProperty("env", environmentName);
		environment = ConfigFactory.create(Environment.class);
		driver = getBrowser(browser, environment.appUrl());
		paymentData02 = Payment_02.getPayment_02();
				
		loginPage = PageGeneratorManager.getLoginPage(driver);
		loginPage.enterToTextBoxByTextTagAndName(driver, Login_01_Register_And_Login.userID, "UserID", "input", "uid");
		loginPage.enterToTextBoxByTextTagAndName(driver, Login_01_Register_And_Login.password, "Password", "input", "password");
		loginPage.clickToButtonByNameAttribute(driver, "btnLogin");
		
	}
	@Test
	public void Payment_02_Edit_Customer_With_Valid_Data() {
		log.info("Payment_02 - Step 1 - Verify Welcome message is displayed at Home Page");
		homePage = PageGeneratorManager.getHomePage(driver);
		String welcomeMessage = "Welcome To Manager's Page of Guru99 Bank";
		verifyEquals(homePage.getWelcomeTextMessage(), welcomeMessage);
		
		log.info("Payment_02 - Step 2 - Click on menu 'Edit Customer' >>> Navigate to Edit Customer Page");
		homePage.clickToLinkText(driver, "Edit Customer");
		editCustomerPage = PageGeneratorManager.getEditCustomerPage(driver);
		
		log.info("Payment_02 - Step 3 - Input to Customer ID Textbox with valid data '" + paymentData02.CUSTOMER_ID_VALID);
		editCustomerPage.enterToTextboxTextareaByTextTagAndName(driver, paymentData02.CUSTOMER_ID_VALID, "Customer ID", "input", "cusid");
		
		log.info("Payment_02 - Step 4 - Click to Submit button");
		editCustomerPage.clickToButtonByNameAttribute(driver, "AccSubmit");
		
		log.info("Payment_02 - Step 5 - Input to Address Textarea with valid data '" + paymentData02.EDIT_CUSTOMER_ADDRESS);
		editCustomerPage.enterToTextboxTextareaByTextTagAndName(driver, paymentData02.EDIT_CUSTOMER_ADDRESS, "Address", "textarea", "addr");
		
		log.info("Payment_02 - Step 6 - Input to City Textbox with valid data '" + paymentData02.EDIT_CUSTOMER_CITY);
		editCustomerPage.enterToTextboxTextareaByTextTagAndName(driver, paymentData02.EDIT_CUSTOMER_CITY, "City", "input", "city");
		
		log.info("Payment_02 - Step 7 - Input to State Textbox with valid data '" + paymentData02.EDIT_CUSTOMER_STATE);
		editCustomerPage.enterToTextboxTextareaByTextTagAndName(driver, paymentData02.EDIT_CUSTOMER_STATE, "State", "input", "state");
		
		log.info("Payment_02 - Step 8 - Input to PIN Textbox with valid data '" + paymentData02.EDIT_CUSTOMER_PIN);
		editCustomerPage.enterToTextboxTextareaByTextTagAndName(driver, paymentData02.EDIT_CUSTOMER_PIN, "PIN", "input", "pinno");
		
		log.info("Payment_02 - Step 9 - Click to Submit button");
		editCustomerPage.clickToButtonByNameAttribute(driver, "sub");
		
		log.info("Payment_02 - Step 10 - Verify success message displayed with content '" + paymentData02.SUCCESS_MSG_UPDATE_CUSTOMER + "'");
		verifyEquals(editCustomerPage.getTextHeaderPage(driver), paymentData02.SUCCESS_MSG_UPDATE_CUSTOMER);
		
		log.info("Payment_02 - Step 11 - Verify old info remain unchaged and Address, City, PIN, State updated successfully");
		verifyEquals(editCustomerPage.getTextValueByRowName(driver, "Customer ID"), Common.getCommon().CUSTOMER_ID_VALID);
		verifyEquals(editCustomerPage.getTextValueByRowName(driver, "Customer Name"), Common.NEW_CUSTOMER_NAME);
		verifyEquals(editCustomerPage.getTextValueByRowName(driver, "Gender"), Common.NEW_CUSTOMER_GENDER);
		verifyEquals(editCustomerPage.getTextValueByRowName(driver, "Birthdate"), getFormatDateWithDash(Common.NEW_CUSTOMER_DATE_OF_BIRTH));
		verifyEquals(editCustomerPage.getTextValueByRowName(driver, "Address"), paymentData02.EDIT_CUSTOMER_ADDRESS);
		verifyEquals(editCustomerPage.getTextValueByRowName(driver, "City"), paymentData02.EDIT_CUSTOMER_CITY);
		verifyEquals(editCustomerPage.getTextValueByRowName(driver, "State"), paymentData02.EDIT_CUSTOMER_STATE);
		verifyEquals(editCustomerPage.getTextValueByRowName(driver, "Pin"), paymentData02.EDIT_CUSTOMER_PIN);
		verifyEquals(editCustomerPage.getTextValueByRowName(driver, "Mobile No."), Common.NEW_CUSTOMER_PHONE);
		verifyEquals(editCustomerPage.getTextValueByRowName(driver, "Email"), Common.NEW_CUSTOMER_EMAIL);
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
	private Payment_02 paymentData02;
	

}

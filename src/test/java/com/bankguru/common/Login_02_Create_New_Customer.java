package com.bankguru.common;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.data.bankguru.Customer.Common;

import commons.BaseTest;
import pageObjects.bankGuru.HomePageObject;
import pageObjects.bankGuru.LoginPageObject;
import pageObjects.bankGuru.NewCustomerPageObject;
import pageObjects.bankGuru.PageGeneratorManager;

public class Login_02_Create_New_Customer extends BaseTest {
	WebDriver driver;
	public static String customerID;
	
	@Parameters({"browser","urlBankGuru"})
	@Test
	public void createNewCustomer(String browser, String urlBankGuru) {
		driver = getBrowser(browser, urlBankGuru);
		commonData = Common.getCommon();
		String welcomeMessage = "Welcome To Manager's Page of Guru99 Bank";
		loginPage = PageGeneratorManager.getLoginPage(driver);
		loginPage.enterToTextBoxByTextTagAndName(driver, Login_01_Register_And_Login.userID, "UserID", "input", "uid");
		loginPage.enterToTextBoxByTextTagAndName(driver, Login_01_Register_And_Login.password, "Password", "input", "password");
		loginPage.clickToButtonByNameAttribute(driver, "btnLogin");
		homePage = PageGeneratorManager.getHomePage(driver);
		verifyEquals(homePage.getWelcomeTextMessage(), welcomeMessage);
		
		homePage.clickToLinkText(driver, "New Customer");
		newCustomerPage = PageGeneratorManager.getNewCustomerPage(driver);
		newCustomerPage.enterToTextBoxByTextTagAndName(driver, commonData.NEW_CUSTOMER_NAME, "Customer Name", "input", "name");
		newCustomerPage.clickToGenderMale();
		newCustomerPage.removeAttributeTagInDOM("type","Date of Birth", "input", "dob");
		newCustomerPage.enterToTextBoxByTextTagAndName(driver, commonData.NEW_CUSTOMER_DATE_OF_BIRTH, "Date of Birth", "input", "dob");
		newCustomerPage.enterToTextBoxByTextTagAndName(driver, commonData.NEW_CUSTOMER_ADDRESS, "Address", "textarea", "addr");
		newCustomerPage.enterToTextBoxByTextTagAndName(driver, commonData.NEW_CUSTOMER_CITY, "City", "input", "city");
		newCustomerPage.enterToTextBoxByTextTagAndName(driver, commonData.NEW_CUSTOMER_STATE, "State", "input", "state");
		newCustomerPage.enterToTextBoxByTextTagAndName(driver, commonData.NEW_CUSTOMER_PIN, "PIN", "input", "pinno");
		newCustomerPage.enterToTextBoxByTextTagAndName(driver, commonData.NEW_CUSTOMER_PHONE, "Mobile Number", "input", "telephoneno");
		newCustomerPage.enterToTextBoxByTextTagAndName(driver, commonData.NEW_CUSTOMER_EMAIL, "E-mail", "input", "emailid");
		newCustomerPage.enterToTextBoxByTextTagAndName(driver, commonData.NEW_CUSTOMER_PASSWORD, "Password", "input", "password");
		newCustomerPage.clickToButtonByNameAttribute(driver, "sub");
		customerID = newCustomerPage.getTextValueByRowName(driver, "Customer ID");
		closeDriverInstance();
	}

	
	
	public HomePageObject homePage;
	public LoginPageObject loginPage;
	public NewCustomerPageObject newCustomerPage;
	Common commonData;
}
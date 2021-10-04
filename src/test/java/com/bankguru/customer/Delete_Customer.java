package com.bankguru.customer;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bankguru.common.Login_01_Register_And_Login;
import com.data.bankguru.Customer.Delete_Customer_Data_Page;

import commons.BaseTest;
import environmentConfig.Environment;
import pageObjects.bankGuru.DeleteCustomerPageObject;
import pageObjects.bankGuru.HomePageObject;
import pageObjects.bankGuru.LoginPageObject;
import pageObjects.bankGuru.PageGeneratorManager;

public class Delete_Customer extends BaseTest {
	WebDriver driver;
	Environment environment;
	@Parameters({"browser"})
	@BeforeClass
	public void initBrowser(String browser) {
		String environmentName = System.getProperty("envMaven"); //only run with maven cmd line
		ConfigFactory.setProperty("env", environmentName);
		environment = ConfigFactory.create(Environment.class);
		driver = getBrowser(browser, environment.appUrl());
		deleteCustomerData = Delete_Customer_Data_Page.getDeleteCustomerDataPage();
		
		loginPage = PageGeneratorManager.getLoginPage(driver);
		loginPage.enterToTextBoxByTextTagAndName(driver, Login_01_Register_And_Login.userID, "UserID", "input", "uid");
		loginPage.enterToTextBoxByTextTagAndName(driver, Login_01_Register_And_Login.password, "Password", "input", "password");
		loginPage.clickToButtonByNameAttribute(driver, "btnLogin");
		
		log.info("Open url >>> Login To Page - Verify Welcome message is displayed at Home Page");
		homePage = PageGeneratorManager.getHomePage(driver);
		String welcomeMessage = "Welcome To Manager's Page of Guru99 Bank";
		verifyEquals(homePage.getWelcomeTextMessage(), welcomeMessage);
		
		log.info("Click on menu 'Delete Customer' >>> Navigate to Edit Customer Page");
		homePage.clickToLinkText(driver, "Delete Customer");
		deleteCustomerPage = PageGeneratorManager.getDeleteCustomerPage(driver);
		
		log.info("Verify 'Delete Customer Form' header text is displayed");
		verifyEquals(deleteCustomerPage.getTextHeaderPage(driver), deleteCustomerData.HEADER_TEXT_DELETE_CUSTOMER_PAGE);
		
	}
	@Test
	public void Delete_Customer_01_Customer_ID_Not_Empty() {
		log.info("Delete_Customer_01 - Step 1 - Enter to Customer ID Textbox with data '" + deleteCustomerData.DELETE_CUSTOMER_ID_BLANK + "'");
		deleteCustomerPage.enterToTextboxTextareaByTextTagAndName(driver, deleteCustomerData.DELETE_CUSTOMER_ID_BLANK, "Customer ID", "input", "cusid");
		
		log.info("Delete_Customer_01 - Step 2 - Press Tab to move to next field");
		deleteCustomerPage.pressKeyboardToElementByTextTagAndName(driver, Keys.TAB, "Customer ID", "input", "cusid");
		
		log.info("Delete_Customer_01 - Step 3 - Verify error message is displayed with content '" + deleteCustomerData.ERROR_MSG_DELETE_CUSTOMER_ID_BLANK + "'");
		verifyEquals(deleteCustomerPage.getErrorValidationMessageByField("Customer ID"), deleteCustomerData.ERROR_MSG_DELETE_CUSTOMER_ID_BLANK);
	}
	
	@Test
	public void Delete_Customer_02_Customer_ID_Numeric() {
		log.info("Delete_Customer_02 - Step 1 - Refresh page");
		deleteCustomerPage.refreshCurrentPage(driver);
		
		log.info("Delete_Customer_02 - Step 2 - Enter to Customer ID Textbox with data '" + deleteCustomerData.DELETE_CUSTOMER_ID_NUMERIC + "'");
		deleteCustomerPage.enterToTextboxTextareaByTextTagAndName(driver, deleteCustomerData.DELETE_CUSTOMER_ID_NUMERIC, "Customer ID", "input", "cusid");
		
		log.info("Delete_Customer_02 - Step 3 - Verify error message is displayed with content '" + deleteCustomerData.ERROR_MSG_DELETE_CUSTOMER_ID_NUMERIC + "'");
		verifyEquals(deleteCustomerPage.getErrorValidationMessageByField("Customer ID"), deleteCustomerData.ERROR_MSG_DELETE_CUSTOMER_ID_NUMERIC);
	}
	
	@Test
	public void Delete_Customer_03_Customer_ID_Not_Special_Char() {
		log.info("Delete_Customer_03 - Step 1 - Refresh page");
		deleteCustomerPage.refreshCurrentPage(driver);
		
		log.info("Delete_Customer_03 - Step 2 - Enter to Customer ID Textbox with data '" + deleteCustomerData.DELETE_CUSTOMER_ID_SPECIAL_CHAR + "'");
		deleteCustomerPage.enterToTextboxTextareaByTextTagAndName(driver, deleteCustomerData.DELETE_CUSTOMER_ID_SPECIAL_CHAR, "Customer ID", "input", "cusid");
		
		log.info("Delete_Customer_03 - Step 3 - Verify error message is displayed with content '" + deleteCustomerData.ERROR_MSG_DELETE_CUSTOMER_ID_SPECIAL_CHAR + "'");
		verifyEquals(deleteCustomerPage.getErrorValidationMessageByField("Customer ID"), deleteCustomerData.ERROR_MSG_DELETE_CUSTOMER_ID_SPECIAL_CHAR);
	}
	
	
	@Parameters("browser")
	@AfterClass(alwaysRun = true)
	public void closeBrowser(String browserName) {
		log.info("Post-Condition - Close browser '" + browserName + "'");
		closeBrowserAndDriver();
	}
	
	private HomePageObject homePage;
	private LoginPageObject loginPage;
	private DeleteCustomerPageObject deleteCustomerPage;
	private Delete_Customer_Data_Page deleteCustomerData;

}
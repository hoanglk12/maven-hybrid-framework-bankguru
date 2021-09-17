package com.bankguru.customer;

import com.bankguru.login.Login_01_Register_And_Login;
import com.data.bankguru.Customer.New_Customer_04;
import commons.BaseTest;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.bankGuru.*;

public class New_Customer_05_Validate_PIN extends BaseTest {
	WebDriver driver;
	@Parameters({"browser","urlBankGuru"})
	@BeforeClass
	public void initBrowser(String browser, String urlBankGuru) {
		driver = getBrowser(browser, urlBankGuru);
		newCustomerData04 = New_Customer_04.getNewCustomer04();
		
		loginPage = PageGeneratorManager.getLoginPage(driver);
		loginPage.enterToTextBoxByTextTagAndName(driver, Login_01_Register_And_Login.userID, "UserID", "input", "uid");
		loginPage.enterToTextBoxByTextTagAndName(driver, Login_01_Register_And_Login.password, "Password", "input", "password");
		loginPage.clickToButtonByNameAttribute(driver, "btnLogin");
		showBrowserConsoleLogs(driver);
		
	}
	@Test
	public void  New_Customer_05_Validate_PIN_16_Not_Empty() {
		log.info("New_Customer_05_Validate_PIN_16 - Step 1 - Verify Welcome message is displayed at Home Page");
		homePage = PageGeneratorManager.getHomePage(driver);
		String welcomeMessage = "Welcome To Manager's Page of Guru99 Bank";
		verifyEquals(homePage.getWelcomeTextMessage(), welcomeMessage);
		
		log.info("New_Customer_05_Validate_PIN_16 - Step 2 - Click on menu 'New Customer' >>> Navigate to New Customer Page");
		homePage.clickToLinkText(driver, "New Customer");
		newCustomerPage = PageGeneratorManager.getNewCustomerPage(driver);
		
		log.info("New_Customer_05_Validate_PIN_16 - Step 3 - Leave blank at State Textbox");
		newCustomerPage.enterToTextboxTextareaByTextTagAndName(driver, newCustomerData04.STATE_BLANK, "State", "input", "state");
		
		log.info("New_Customer_05_Validate_PIN_16 - Step 4 - Press Tab to move to next field");
		newCustomerPage.pressKeyboardToElementByTextTagAndName(driver, Keys.TAB, "State", "input", "state");
		
		log.info("New_Customer_05_Validate_PIN_16 - Step 5 - Verify error message is displayed with content '" + newCustomerData04.ERROR_MSG_STATE_BLANK + "'");
		verifyEquals(newCustomerPage.getErrorValidationMessageByField("State"), newCustomerData04.ERROR_MSG_STATE_BLANK);

	}	@Test
	public void  New_Customer_05_Validate_PIN_17_Not_Empty() {
		log.info("New_Customer_05_Validate_PIN_17 - Step 1 - Verify Welcome message is displayed at Home Page");
		homePage = PageGeneratorManager.getHomePage(driver);
		String welcomeMessage = "Welcome To Manager's Page of Guru99 Bank";
		verifyEquals(homePage.getWelcomeTextMessage(), welcomeMessage);

		log.info("New_Customer_05_Validate_PIN_17 - Step 2 - Click on menu 'New Customer' >>> Navigate to New Customer Page");
		homePage.clickToLinkText(driver, "New Customer");
		newCustomerPage = PageGeneratorManager.getNewCustomerPage(driver);

		log.info("New_Customer_05_Validate_PIN_17 - Step 3 - Leave blank at State Textbox");
		newCustomerPage.enterToTextboxTextareaByTextTagAndName(driver, newCustomerData04.STATE_BLANK, "State", "input", "state");

		log.info("New_Customer_05_Validate_PIN_17 - Step 4 - Press Tab to move to next field");
		newCustomerPage.pressKeyboardToElementByTextTagAndName(driver, Keys.TAB, "State", "input", "state");

		log.info("New_Customer_05_Validate_PIN_17 - Step 5 - Verify error message is displayed with content '" + newCustomerData04.ERROR_MSG_STATE_BLANK + "'");
		verifyEquals(newCustomerPage.getErrorValidationMessageByField("State"), newCustomerData04.ERROR_MSG_STATE_BLANK);

	}
	@Test
	public void  New_Customer_05_Validate_PIN_18() {
		log.info("New_Customer_05_Validate_PIN_18 - Step 1 - Refresh New Customer Page");
		newCustomerPage.refreshCurrentPage(driver);
		
		log.info("New_Customer_05_Validate_PIN_18 - Step 2 - Enter to State textbox with data '" + newCustomerData04.STATE_NUMERIC + "'");
		newCustomerPage.enterToTextboxTextareaByTextTagAndName(driver, newCustomerData04.STATE_NUMERIC, "State", "input", "state");
		
		log.info("New_Customer_05_Validate_PIN_18 - Step 3 - Verify error message is displayed with content '" + newCustomerData04.ERROR_MSG_STATE_NOT_NUMERIC + "'");
		verifyEquals(newCustomerPage.getErrorValidationMessageByField("State"), newCustomerData04.ERROR_MSG_STATE_NOT_NUMERIC);
	}

	
	@Parameters("browser")
	@AfterClass(alwaysRun = true)
	public void closeBrowser(String browserName) {
		log.info("Post-Condition - Close browser '" + browserName + "'");
		closeBrowserAndDriver();
	}
	
	public HomePageObject homePage;
	public LoginPageObject loginPage;
	public RegisterPageObject registerPage;
	public NewCustomerPageObject newCustomerPage;
	New_Customer_04 newCustomerData04;

}
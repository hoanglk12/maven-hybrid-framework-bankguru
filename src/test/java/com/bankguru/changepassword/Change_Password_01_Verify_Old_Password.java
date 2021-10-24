package com.bankguru.changepassword;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bankguru.common.Login_01_Register_And_Login;

import commons.BaseTest;
import environmentConfig.Environment;
import pageObjects.bankGuru.HomePageObject;
import pageObjects.bankGuru.LoginPageObject;
import pageObjects.bankGuru.PageGeneratorManager;

public class Change_Password_01_Verify_Old_Password extends BaseTest {
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
		
		loginPage = PageGeneratorManager.getLoginPage(driver);
		loginPage.enterToTextBoxByTextTagAndName(driver, Login_01_Register_And_Login.userID, "UserID", "input", "uid");
		loginPage.enterToTextBoxByTextTagAndName(driver, Login_01_Register_And_Login.password, "Password", "input", "password");
		loginPage.clickToButtonByNameAttribute(driver, "btnLogin");
		
		homePage = PageGeneratorManager.getHomePage(driver);
		String welcomeMessage = "Welcome To Manager's Page of Guru99 Bank";
		verifyEquals(homePage.getWelcomeTextMessage(), welcomeMessage);

	}

	@Test
	public void Change_Password_01_Old_Password_Not_Empty() {
	}

	@Parameters("browser")
	@AfterClass(alwaysRun = true)
	public void closeBrowser(String browserName) {
		log.info("Post-Condition - Close browser '" + browserName + "'");
		closeBrowserAndDriver();
	}
	private LoginPageObject loginPage;
	private HomePageObject homePage;
}

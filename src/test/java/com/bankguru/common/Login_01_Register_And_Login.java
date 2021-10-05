package com.bankguru.common;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import commons.BaseTest;
import environmentConfig.Environment;
import pageObjects.bankGuru.LoginPageObject;
import pageObjects.bankGuru.PageGeneratorManager;
import pageObjects.bankGuru.RegisterPageObject;

public class Login_01_Register_And_Login extends BaseTest {
	WebDriver driver;
	Environment environment;
	String  name, dob, address, city, state, pin, phone, customerID ;
	public static String userID, password, loginPageUrl, email;
	
	@Parameters({"browser"})
	@BeforeTest
	public void registerAndLogin(String browser) {
		String environmentName = System.getProperty("envMaven");
		ConfigFactory.setProperty("env", environmentName);
		environment = ConfigFactory.create(Environment.class);
		driver = getBrowser(browser, environment.appUrl());
		email = "johnwick_" + generateEmail();
	
		
		loginPage = PageGeneratorManager.getLoginPage(driver);
		loginPageUrl = loginPage.getCurrentPageUrl(driver);
		loginPage.clickToLinkText(driver, "here");
		registerPage = PageGeneratorManager.getRegisterPage(driver);
		registerPage.enterToTextBoxByTextTagAndName(driver, email , "Email ID", "input", "emailid");
		registerPage.clickToButtonByNameAttribute(driver, "btnLogin");
		userID = registerPage.getTextUserID();
		password = registerPage.getTextPassword();
		closeBrowserAndDriver();
	}
	private LoginPageObject loginPage;
	private RegisterPageObject registerPage;
}

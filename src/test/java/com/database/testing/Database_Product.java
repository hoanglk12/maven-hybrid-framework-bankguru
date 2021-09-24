package com.database.testing;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.DriverFactoryManager;
import commons.DriverManager;
import pageObjects.liveGuru.HomePageObject;
import pageObjects.liveGuru.LoginPageObject;
import pageObjects.liveGuru.MyDashboardPageObject;

public class Database_Product extends BaseTest {
	WebDriver driver;
	private DriverManager driverManager;
	String email, firstName, lastName, password, confirmPassword;
	
	@Parameters({"browser","url"})
	@BeforeClass
	public void initBrowser(String browserName, String appUrl) {
		
		driverManager = DriverFactoryManager.getBrowser(browserName);
		driver = driverManager.getDriver(appUrl);
		homePage = new HomePageObject(driver);
		Assert.assertTrue(homePage.isLogoPageDisplayed());
		homePage.clickToMyAccountLinkAtFooter();
		
	}

	@Test
	public void Database_01_Check_Total_Product() {
		homePage.clickToMobileLink();
		
		int totalProductUI = homePage.getTotalMobileProductUI();
		int totalProdyctDatabase = homePage.getTotalMobileProductDB();
		verifyEquals(totalProductUI, totalProdyctDatabase);
	}

	

	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}



	HomePageObject homePage;
	LoginPageObject loginPage;
	MyDashboardPageObject myDashboardPage;
}

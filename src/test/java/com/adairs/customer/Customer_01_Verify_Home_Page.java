package com.adairs.customer;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.adairs.HomePageObject;
import pageObjects.adairs.PageGeneratorManager;

public class Customer_01_Verify_Home_Page extends BaseTest {
	WebDriver driver;
	String adairsUrl;
	@Parameters({ "browser", "adairsFrontEndUrl" })
	@BeforeClass
	public void initBrowser(String browserName, String adairsFrontEndUrl) {
		log.info("Pre-Condition - Open browser '" + browserName + "' with url: '" + adairsFrontEndUrl + "'");
		adairsUrl = "https://www.adairs.com.au/";
		driver = getBrowser(browserName, adairsFrontEndUrl);
		homePage = PageGeneratorManager.getHomePage(driver);
	}
	
	@Test
	public void Customer_01_Home_Page_01_Url() {
		verifyEquals(homePage.getCurrentPageUrl(driver), adairsUrl);
	}
	
	@Test 
	public void Customer_01_Home_Page_02_Menu_Items() {
		verifyTrue(homePage.getAllMenuItems().contains("New"));
		verifyTrue(homePage.getAllMenuItems().contains("Bedroom"));
		verifyTrue(homePage.getAllMenuItems().contains("Bathroom"));
		verifyTrue(homePage.getAllMenuItems().contains("Furniture"));
		verifyTrue(homePage.getAllMenuItems().contains("Homewares"));
		verifyTrue(homePage.getAllMenuItems().contains("Kids"));
		verifyTrue(homePage.getAllMenuItems().contains("Gifts"));
		verifyTrue(homePage.getAllMenuItems().contains("Sale"));
		verifyTrue(homePage.getAllMenuItems().contains("Linen Lovers"));
	}
	
	@Parameters("browser")
	@AfterClass(alwaysRun = true)
	public void closeBrowser(String browserName) {
		log.info("Post-Condition - Close browser '" + browserName + "'");
		closeBrowserAndDriver();
	}
	private HomePageObject homePage;
}

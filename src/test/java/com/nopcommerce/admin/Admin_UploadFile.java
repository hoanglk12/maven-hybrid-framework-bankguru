package com.nopcommerce.admin;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.admin.nopCommerce.CustomerEditPageObject;
import pageObjects.admin.nopCommerce.CustomersPageObject;
import pageObjects.admin.nopCommerce.DashboardPageObject;
import pageObjects.admin.nopCommerce.LoginPageObject;
import pageObjects.admin.nopCommerce.PageGeneratorManager;
import pageObjects.admin.nopCommerce.ProductDetailsPageObject;
import pageObjects.admin.nopCommerce.ProductEditPageObject;
import pageObjects.admin.nopCommerce.ProductSearchPageObject;

public class Admin_UploadFile extends BaseTest {
	WebDriver driver;
	String email, password, arrowPicture, johnWickPicture;
	
	@Parameters({ "browser", "urlAdmin" })
	@BeforeClass
	public void initBrowser(String browserName, String urlNopCommerceAdmin) {
		log.info("Pre-Condition - Open browser '" + browserName + "' with url: '" + urlNopCommerceAdmin + "'");
		driver = getBrowser(browserName, urlNopCommerceAdmin);
		email = "admin@yourstore.com";		
		password = "admin";
		arrowPicture = "arrow.png";
		johnWickPicture = "John_Wick.jpg";
	}
	@Test
	public void Admin_00_Login_To_Admin_Page() {
		log.info("Admin_UploadFile_00 - Step 1: Open 'Admin Nopcommerce' page");
		loginPage = PageGeneratorManager.getLoginPage(driver);
		
		log.info("Admin_UploadFile_00 - Step 2: Input data to Email textbox " + email);
		loginPage.enterToTextboxByName(driver, email, "Email");
		
		log.info("Admin_UploadFile_00 - Step 3: Input data to Password textbox " + password);
		loginPage.enterToTextboxByName(driver, password, "Password");
		
		log.info("Admin_UploadFile_00 - Step 4: Verify Dashboard Header Text is displayed");
		dashboardPage = loginPage.clickToLoginButton();
		verifyTrue(dashboardPage.isDashBoardHeaderDisplayed());
	}
	@Test
	public void Admin_01_Upload_Picture_With_Product_Name() {
		log.info("Admin_UploadFile_01 - Step 1: At Dashboard Page, click to menu 'Catalog' and submenu 'Products'");
		dashboardPage.openMenuSubMenuByName("Catalog", "Products");
		productSearchPage = PageGeneratorManager.getProductSearchPage(driver);
		productSearchPage.sleepInSecond(1);
		
		log.info("Admin_UploadFile_01 - Step 2: Edit at product 'Build your own computer'");
		productSearchPage.clickToEditButtonAtProductName(driver, "Build your own computer");
		
		log.info("Admin_UploadFile_01 - Step 3: Upload picture");
		productEditPage = PageGeneratorManager.getProductEditPage(driver);
		productEditPage.uploadMultipleFiles(driver, arrowPicture);
		
		log.info("Admin_UploadFile_01 - Step 4: Verify picture uploaded successfully");
		//verifyTrue(productEditPage.isUploadedFileDisplayed());
	}
	
	
	@Parameters("browser")
	@AfterClass(alwaysRun = true)
	public void closeBrowser(String browserName) {
		log.info("Post-Condition - Close browser '" + browserName + "'");
		closeBrowserAndDriver();
	}

	LoginPageObject loginPage;
	DashboardPageObject dashboardPage;
	CustomersPageObject customersPage;
	CustomerEditPageObject customerEditPage;
	ProductSearchPageObject productSearchPage;
	ProductDetailsPageObject productDetailsPage;
	ProductEditPageObject productEditPage;
}

package pageObjects.liveGuru;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import jdbcConnection.SQLServerConnUtils;
import pageUIs.liveGuru.HomePageUI;

public class HomePageObject extends BasePage {
	private WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isLogoPageDisplayed() {
		waitForElementVisible(driver, HomePageUI.HOMEPAGE_LOGO);
		return isElementDisplayed(driver, HomePageUI.HOMEPAGE_LOGO);
	}

	public void clickToMyAccountLinkAtFooter() {
		waitForElementClickable(driver, HomePageUI.MYACCOUNT_LINK_FOOTER);
		clickToElement(driver, HomePageUI.MYACCOUNT_LINK_FOOTER);
	}

	public void clickToMobileLink() {
		waitForElementClickable(driver, HomePageUI.MOBILE_LINK);
		clickToElement(driver, HomePageUI.MOBILE_LINK);
	}

	public int getTotalMobileProductUI() {
		return getElementSize(driver, HomePageUI.PRODUCT_TITLE_LINKS);
	}

	public int getTotalMobileProductDB() {
		ArrayList<String> allMobileProducts = new ArrayList<>();
		String selectQuery = "select *from product where name like ?";
		try {
			Connection conn = SQLServerConnUtils.getSQLServerConnection();
			PreparedStatement prepareStatement = conn.prepareStatement(selectQuery);
			prepareStatement.setString(1, "%account");
			ResultSet result = prepareStatement.executeQuery();
			while (result.next()) {

				allMobileProducts.add(result.getString("NAME"));
			}
			conn.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return allMobileProducts.size();
	}

}

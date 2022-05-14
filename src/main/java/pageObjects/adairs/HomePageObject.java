package pageObjects.adairs;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.adairs.HomePageUI;

public class HomePageObject extends BasePage{
	WebDriver driver;
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	public List<String> getAllMenuItems() {
		waitForElementVisible(driver, HomePageUI.MENU_ITEM);
		return getElements(driver, HomePageUI.MENU_ITEM).stream().map(item->item.getText()).collect(Collectors.toList());
		
	}

}

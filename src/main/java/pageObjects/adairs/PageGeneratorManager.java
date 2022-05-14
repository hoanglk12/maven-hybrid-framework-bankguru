package pageObjects.adairs;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	private PageGeneratorManager() {

	}

	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}
}

package pageObjects.admin.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class ProductEditPageObject extends BasePage {
	WebDriver driver;
	public ProductEditPageObject(WebDriver driver) {
		this.driver =  driver;
	}
}

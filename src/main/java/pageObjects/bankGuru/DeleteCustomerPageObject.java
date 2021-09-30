package pageObjects.bankGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.bankGuru.EditCustomerPageUI;

public class DeleteCustomerPageObject extends BasePage {
	WebDriver driver;
	public DeleteCustomerPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public String getErrorValidationMessageByField(String fieldName) {
		return getTextElement(driver, EditCustomerPageUI.DYNAMIC_ERROR_MESSGAE_VALIDATION_BY_FIELD, fieldName);
	}
	
}
package pageObjects.bankGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.bankGuru.EditCustomerPageUI;

public class BalanceEnquiryPageObject extends BasePage {
	WebDriver driver;
	public BalanceEnquiryPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public String getErrorValidationMessageByField(String fieldName) {
		waitForElementVisible(driver, EditCustomerPageUI.DYNAMIC_ERROR_MESSGAE_VALIDATION_BY_FIELD, fieldName);
		return getTextElement(driver, EditCustomerPageUI.DYNAMIC_ERROR_MESSGAE_VALIDATION_BY_FIELD, fieldName);
	}
	
	
}

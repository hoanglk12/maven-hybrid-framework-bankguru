package pageObjects.bankGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.bankGuru.EditCustomerPageUI;
import pageUIs.bankGuru.NewAccountPageUI;

public class EditAccountPageObject extends BasePage {
	WebDriver driver;
	public EditAccountPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public String getErrorValidationMessageByField(String fieldName) {
		waitForElementVisible(driver, EditCustomerPageUI.DYNAMIC_ERROR_MESSGAE_VALIDATION_BY_FIELD, fieldName);
		return getTextElement(driver, EditCustomerPageUI.DYNAMIC_ERROR_MESSGAE_VALIDATION_BY_FIELD, fieldName);
	}
	public void selectItemFromAccountTypeDropdown(String accountExpected) {
		waitForElementVisible(driver, NewAccountPageUI.ACCOUNT_TYPE_DROPDOWN);
		selectItemInDropdown(driver, NewAccountPageUI.ACCOUNT_TYPE_DROPDOWN, accountExpected);
	}
	public void enterToInitialDepositTextbox(String value) {
		waitForElementVisible(driver, NewAccountPageUI.INITIAL_DEPOSIT_TEXTBOX);
		sendkeyToElement(driver, NewAccountPageUI.INITIAL_DEPOSIT_TEXTBOX, value);
	}
	
}

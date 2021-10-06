package pageObjects.bankGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.bankGuru.BankGuruBasePageUI;
import pageUIs.bankGuru.NewCustomerPageUI;

public class NewCustomerPageObject extends BasePage {
	WebDriver driver;

	public NewCustomerPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getErrorValidationMessageByField(String fieldName) {
		waitForElementVisible(driver, NewCustomerPageUI.DYNAMIC_ERROR_MESSGAE_VALIDATION_BY_FIELD, fieldName);
		return getTextElement(driver, NewCustomerPageUI.DYNAMIC_ERROR_MESSGAE_VALIDATION_BY_FIELD, fieldName);
	}

	public void removeAttributeTagInDOM(String attributeRemove, String textField, String tagType, String nameAttribute) {
		removeAttributeInDOM(driver, BankGuruBasePageUI.DYNAMIC_TEXTBOX_TEXTAREA, attributeRemove, textField, tagType, nameAttribute);
	}

	public void clickToGenderMale() {
		waitForElementClickable(driver, BankGuruBasePageUI.GENDER_MALE_RADIO);
		clickToElement(driver, BankGuruBasePageUI.GENDER_MALE_RADIO);
	}
	public void clickToGenderFemale() {
		waitForElementClickable(driver, BankGuruBasePageUI.GENDER_FEMALE_RADIO);
		clickToElement(driver, BankGuruBasePageUI.GENDER_FEMALE_RADIO);
	}

}

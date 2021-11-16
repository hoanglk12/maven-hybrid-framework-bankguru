package com.data.bankguru;

import utilities.DataHelper;

public class ChangePassword {
	public static String CHANGE_PASSWORD_TITLE_PAGE = "Change Password";
	public static String OLD_PASSWORD_BLANK = "";
	public static String ERROR_MSG_OLD_PASSWORD_NOT_BLANK = "Old Password must not be blank";
	public static String NEW_PASSWORD_BLANK = "";
	public static String ERROR_MSG_NEW_PASSWORD_NOT_BLANK = "New Password must not be blank";
	public static String NEW_PASSWORD_NOT_CONTAIN_NUMBER = DataHelper.getDataHelper().getRandomStringWithoutNumber() + "@#$";
	public static String ERROR_MSG_NEW_PASSWORD_NOT_CONTAIN_NUMBER = "Enter at-least one numeric value";
	public static String NEW_PASSWORD_NOT_CONTAIN_SPECIAL_CHAR = DataHelper.getDataHelper().getRandomStringWithoutSpecialChars();
	public static String ERROR_MSG_NEW_PASSWORD_NOT_CONTAIN_SPECIAL_CHAR = "Enter at-least one special character";
	public static String NEW_PASSWORD_NOT_CONTAIN_STRING_PASSWORD = DataHelper.getDataHelper().getRandomStringWithoutSpecialChars() + "!@Password";
	public static String ERROR_MSG_NEW_PASSWORD_NOT_CONTAIN_STRING_PASSWORD = "Enter at-least one special character";

}

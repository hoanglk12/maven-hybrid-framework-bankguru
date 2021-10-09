package com.data.bankguru;

import com.bankguru.common.Login_02_Create_New_Customer;

public class Payment {
	public static Payment getPayment() {
		return new Payment();
	}

	public Payment() {

	}
	
	public static class Payment_02 {
		Payment payment = Payment.getPayment();
		
		public static Payment_02 getPayment_02() {
			return new Payment_02();
		}
		public String CUSTOMER_ID_VALID = Login_02_Create_New_Customer.customerID;
		public String EDIT_CUSTOMER_ADDRESS = "1883 Cursus Avenue";
		public String EDIT_CUSTOMER_CITY = "Houston";
		public String EDIT_CUSTOMER_STATE = "Texas";
		public String EDIT_CUSTOMER_PIN = "166455";
		public String SUCCESS_MSG_UPDATE_CUSTOMER = "Customer details updated Successfully!!!";
		
	}

	public static class Payment_03 {
		Payment payment = Payment.getPayment();
		
		public static Payment_03 getPayment_03() {
			return new Payment_03();
		}
		public String NEW_ACCOUNT_TYPE = "Savings";
		public String NEW_ACCOUNT_INITIAL_DEPOSIT = "50000";
		public String HEADER_TEXT_NEW_ACCOUNT_PAGE = "Add new account form";
		public String SUCCESS_MSG_ADD_NEW_ACCOUNT = "Account Generated Successfully!!!";
		
	}
	public static class Payment_04 {
		Payment payment = Payment.getPayment();

		public static Payment_04 getPayment_04() {
			return new Payment_04();
		}
		public String EDIT_ACCOUNT_TYPE = "Current";
		public String NEW_ACCOUNT_INITIAL_DEPOSIT = "50000";
		public String HEADER_TEXT_EDIT_ACCOUNT_PAGE = "Edit Account Form";
		public String SUCCESS_MSG_UPDATE_ACCOUNT = "Account details updated Successfully!!!";

	}
}

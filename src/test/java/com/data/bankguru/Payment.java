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
	public static class Payment_05 {
		Payment payment = Payment.getPayment();
		
		public static Payment_05 getPayment_05() {
			return new Payment_05();
		}
		public String HEADER_TEXT_DEPOSIT_PAGE = "Amount Deposit Form";
		public String DEPOSIT_AMOUNT = "5000";
		public String DEPOSIT_DESCRIPTION = "Deposit";
		public String SUCCESS_MSG_UPDATE_ACCOUNT = "Transaction details of Deposit for Account";
		public int DEPOSIT_CURRENT_AMOUNT  = Integer.parseInt(Payment_04.getPayment_04().NEW_ACCOUNT_INITIAL_DEPOSIT) + Integer.parseInt(DEPOSIT_AMOUNT);
	}
	public static class Payment_06 {
		Payment payment = Payment.getPayment();

		public static Payment_06 getPayment_06() {
			return new Payment_06();
		}
		public String HEADER_TEXT_WITHDRAWAL_PAGE = "Amount Withdrawal Form";
		public String WITHDRAWAL_AMOUNT = "15000";
		public String WITHDRAWAL_DESCRIPTION = "Withdraw";
		public String SUCCESS_MSG_UPDATE_ACCOUNT = "Transaction details of Withdrawal for Account";
		public int WITHDRAWAL_CURRENT_AMOUNT  = Payment_05.getPayment_05().DEPOSIT_CURRENT_AMOUNT - Integer.parseInt(WITHDRAWAL_AMOUNT);
	}
	public static class Payment_07 {
		Payment payment = Payment.getPayment();
		
		public static Payment_07 getPayment_07() {
			return new Payment_07();
		}
		public String NEW_ACCOUNT_TYPE = "Savings";
		public String NEW_ACCOUNT_INITIAL_DEPOSIT = "10000";
		public String HEADER_TEXT_NEW_ACCOUNT_PAGE = "Add new account form";
		public String SUCCESS_MSG_ADD_NEW_ACCOUNT = "Account Generated Successfully!!!";
		public String HEADER_TEXT_FUND_TRANSFER_PAGE = "Fund transfer";
		public String FUND_TRANSFER_AMOUNT = "10000";
		public String FUND_TRANSFER_DESCRIPTION = "Transfer";
		public String HEADER_TEXT_FUND_TRANSFER_DETAILs = "Fund Transfer Details";
		public String HEADER_TEXT_BALANCE_ENQUIRY_PAGE = "Balance Enquiry Form";
		public String HEADER_TEXT_BALANCE_ENQUIRY_DETAILS_PAGE = "Balance Details for Account";
		public String BALANCE_DETAILS_TYPE_OF_ACCOUNT = Payment_04.getPayment_04().EDIT_ACCOUNT_TYPE;
		public int BALANCE_AMOUNT  = Payment_06.getPayment_06().WITHDRAWAL_CURRENT_AMOUNT - Integer.parseInt(FUND_TRANSFER_AMOUNT);
	}
	public static class Payment_08 {
		Payment payment = Payment.getPayment();
		
		public static Payment_08 getPayment_08() {
			return new Payment_08();
		}
		public String HEADER_TEXT_DELETE_ACCOUNT_PAGE = "Delete Account Form";
		public String DELETE_ACCOUNT_ALERT_MESSAGE = "Account Deleted Sucessfully";
	}
}

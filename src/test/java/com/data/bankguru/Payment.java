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
}

package com.data.bankguru;

import com.bankguru.common.Login_02_Create_New_Customer;

import utilities.DataHelper;

public class Customer {
    private DataHelper dataHelper;
   
    public static Customer getCustomer() {
        return new Customer();
    }

    public Customer() {
        dataHelper = DataHelper.getDataHelper();
    }
    
    public static class Common{
    	Customer customer = Customer.getCustomer();
    	
        public static Common getCommon() {
            return new Common();
        }
        public String CUSTOMER_ID_VALID = Login_02_Create_New_Customer.customerID;
        public String NEW_CUSTOMER_NAME = customer.dataHelper.getFirstName();
        public String NEW_CUSTOMER_DATE_OF_BIRTH = customer.dataHelper.getBirthday();
        public String NEW_CUSTOMER_ADDRESS = customer.dataHelper.getStreetAddress();
        public String NEW_CUSTOMER_CITY = customer.dataHelper.getCity();
        public String NEW_CUSTOMER_STATE = customer.dataHelper.getState();
        public String NEW_CUSTOMER_PIN = customer.dataHelper.getRandomSixDigitsNumber();
        public String NEW_CUSTOMER_PHONE = customer.dataHelper.getRandomTenDigitsNumber();
        public String NEW_CUSTOMER_EMAIL = customer.dataHelper.getEmailAddress();
        public String NEW_CUSTOMER_PASSWORD = customer.dataHelper.getPassword();
    }
    public static class New_Customer_01 {
        Customer customer = Customer.getCustomer();

        public static New_Customer_01 getNewCustomer01() {
            return new New_Customer_01();
        }

        public String NAME_BLANK = "";
        public String NAME_NUMERIC = customer.dataHelper.getFirstName() + String.valueOf(customer.dataHelper.getRandomNumber());
        public String NAME_SPECIAL_CHAR = customer.dataHelper.getFirstName() + "%$#";
        public String NAME_FIRST_CHAR_BLANK = " " + customer.dataHelper.getFirstName();
        public String ERROR_MSG_NAME_BLANK = "Customer name must not be blank";
        public String ERROR_MSG_NAME_NOT_NUMERIC = "Numbers are not allowed";
        public String ERROR_MSG_NOT_SPECIAL_CHAR = "Special characters are not allowed";
        public String ERROR_MSG_FIRST_CHAR_BLANK = "First character can not have space";
    }

    public static class New_Customer_02 {
        Customer customer = Customer.getCustomer();

        public static New_Customer_02 getNewCustomer02() {
            return new New_Customer_02();
        }

        public String ADDRESS_BLANK = "";
        public String ADDRESS_FIRST_CHAR_BLANK = " " + customer.dataHelper.getFullAddress();
        public String ERROR_MSG_ADDRESS_BLANK = "Address Field must not be blank";
        public String ERROR_MSG_ADDRESS_FIRST_CHAR_BLANK = "First character can not have space";

    }

    public static class New_Customer_03 {
        Customer customer = Customer.getCustomer();

        public static New_Customer_03 getNewCustomer03() {
            return new New_Customer_03();
        }

        public String CITY_BLANK = "";
        public String CITY_NUMERIC = customer.dataHelper.getCity() + String.valueOf(customer.dataHelper.getRandomNumber());
        public String CITY_SPECIAL_CHAR = customer.dataHelper.getCity() + "%$#";
        public String CITY_FIRST_CHAR_BLANK = " " + customer.dataHelper.getCity();
        public String ERROR_MSG_CITY_BLANK = "City Field must not be blank";
        public String ERROR_MSG_CITY_NOT_NUMERIC = "Numbers are not allowed";
        public String ERROR_MSG_NOT_SPECIAL_CHAR = "Special characters are not allowed";
        public String ERROR_MSG_FIRST_CHAR_BLANK = "First character can not have space";
    }

    public static class New_Customer_04 {
        Customer customer = Customer.getCustomer();

        public static New_Customer_04 getNewCustomer04() {
            return new New_Customer_04();
        }

        public String STATE_BLANK = "";
        public String STATE_NUMERIC = customer.dataHelper.getState() + String.valueOf(customer.dataHelper.getRandomNumber());
        public String STATE_SPECIAL_CHAR = customer.dataHelper.getState() + "%$#";
        public String STATE_FIRST_CHAR_BLANK = " " + customer.dataHelper.getState();
        public String ERROR_MSG_STATE_BLANK = "State must not be blank";
        public String ERROR_MSG_STATE_NOT_NUMERIC = "Numbers are not allowed";
        public String ERROR_MSG_NOT_SPECIAL_CHAR = "Special characters are not allowed";
        public String ERROR_MSG_FIRST_CHAR_BLANK = "First character can not have space";
    }

    public static class New_Customer_05 {
    	Customer customer = Customer.getCustomer();
    	
    	public static New_Customer_05 getNewCustomer05() {
    		return new New_Customer_05();
    	}
    	
    	public String PIN_NUMERIC = customer.dataHelper.getRandomNumber() + "PIN";
    	public String PIN_BLANK = "";
    	public String PIN_LESS_SIX_DIGITS = String.valueOf(customer.dataHelper.getRandomNumber());
    	public String PIN_SPECIAL_CHAR = String.valueOf(customer.dataHelper.getRandomNumber()) + "%$#";
    	public String PIN_FIRST_CHAR_BLANK = " " + customer.dataHelper.getPIN();
    	public String PIN_SPACE = " ";
    	public String ERROR_MSG_PIN_NUMERIC = "Characters are not allowed";
    	public String ERROR_MSG_PIN_BLANK = "PIN Code must not be blank";
    	public String ERROR_MSG_PIN_NOT_SIX_DIGITS = "PIN Code must have 6 Digits";
    	public String ERROR_MSG_PIN_SPECIAL_CHAR = "Special characters are not allowed";
    	public String ERROR_MSG_PIN_FIRST_CHAR_BLANK = "First character can not have space";
    	public String ERROR_MSG_PIN_SPACE = "First character can not have space";
    }
    public static class New_Customer_06 {
    	Customer customer = Customer.getCustomer();
    	
    	public static New_Customer_06 getNewCustomer06() {
    		return new New_Customer_06();
    	}
    	
    	
    	public String PHONE_BLANK = "";
    	public String PHONE_FIRST_CHAR_BLANK = " " + customer.dataHelper.getRandomNumber();
    	public String PHONE_SPACE = customer.dataHelper.getRandomNumber() + " " + customer.dataHelper.getRandomNumber();
    	public String PHONE_SPECIAL_CHAR = String.valueOf(customer.dataHelper.getRandomNumber()) + "%$#";
    	
    	public String ERROR_MSG_PHONE_BLANK = "Mobile no must not be blank";
    	public String ERROR_MSG_PHONE_FIRST_CHAR_BLANK = "First character can not have space";
    	public String ERROR_MSG_PHONE_SPACE = "Characters are not allowed";
    	public String ERROR_MSG_PHONE_SPECIAL_CHAR = "Special characters are not allowed";
    	
    }
    public static class Edit_Customer_01 {
    	Customer customer = Customer.getCustomer();
    	
    	public static Edit_Customer_01 getEditCustomer01() {
    		return new Edit_Customer_01();
    	}
    	
    	
    	public String CUSTOMER_ID_BLANK = "";
    	public String CUSTOMER_ID_NUMERIC = "aac" + customer.dataHelper.getRandomNumber();
    	public String CUSTOMER_ID_SPECIAL_CHAR = String.valueOf(customer.dataHelper.getRandomNumber()) + "%$#";
    	
    	
    	public String ERROR_MSG_CUSTOMER_ID_BLANK = "Customer ID is required";
    	public String ERROR_MSG_CUSTOMER_ID_NUMERIC = "Characters are not allowed";
    	public String ERROR_MSG_CUSTOMER_ID_SPECIAL_CHAR = "Special characters are not allowed";
    	public String HEADER_TEXT_EDIT_CUSTOMER_PAGE = "Edit Customer";
    	
    }
    public static class Edit_Customer_02 {
    	Customer customer = Customer.getCustomer();
    	
    	public static Edit_Customer_02 getEditCustomer02() {
    		return new Edit_Customer_02();
    	}
    	
    	public String EDIT_ADDRESS_BLANK = "";
    	public String ERROR_MSG_EDIT_ADDRESS_BLANK = "Address Field must not be blank";
    	
    }
    public static class Edit_Customer_03 {
    	Customer customer = Customer.getCustomer();
    	
    	public static Edit_Customer_03 getEditCustomer03() {
    		return new Edit_Customer_03();
    	}
    	
    	public String EDIT_CITY_BLANK = "";
    	public String EDIT_CITY_NUMERIC = customer.dataHelper.getCity() + String.valueOf(customer.dataHelper.getRandomNumber());
    	public String EDIT_CITY_SPECIAL_CHAR = customer.dataHelper.getCity() + "%$#";
    	public String ERROR_MSG_EDIT_CITY_BLANK = "City Field must not be blank";
    	public String ERROR_MSG_EDIT_CITY_NUMERIC = "Numbers are not allowed";
    	public String ERROR_MSG_EDIT_CITY_SPECIAL_CHAR = "Special characters are not allowed";
    	
    }
    public static class Edit_Customer_04 {
    	Customer customer = Customer.getCustomer();
    	
    	public static Edit_Customer_04 getEditCustomer04() {
    		return new Edit_Customer_04();
    	}
    	
    	public String EDIT_STATE_BLANK = "";
    	public String EDIT_STATE_NUMERIC =  customer.dataHelper.getState() + String.valueOf(customer.dataHelper.getRandomNumber());
    	public String EDIT_STATE_SPECIAL_CHAR = customer.dataHelper.getState() + "%$#";
    	public String ERROR_MSG_EDIT_STATE_BLANK = "State must not be blank";
    	public String ERROR_MSG_EDIT_STATE_NUMERIC = "Numbers are not allowed";
    	public String ERROR_MSG_EDIT_STATE_SPECIAL_CHAR = "Special characters are not allowed";
    	
    }
    public static class Edit_Customer_05 {
    	Customer customer = Customer.getCustomer();
    	
    	public static Edit_Customer_05 getEditCustomer05() {
    		return new Edit_Customer_05();
    	}
    	
    	public String EDIT_PIN_BLANK = "";
    	public String EDIT_PIN_NUMERIC = customer.dataHelper.getRandomNumber() + "PIN";
    	public String EDIT_PIN_LESS_SIX_DIGITS = String.valueOf(customer.dataHelper.getRandomNumber());
    	public String EDIT_PIN_SPECIAL_CHAR = String.valueOf(customer.dataHelper.getRandomNumber()) + "%$#";
    	public String ERROR_MSG_EDIT_PIN_BLANK = "PIN Code must not be blank";
    	public String ERROR_MSG_EDIT_PIN_NUMERIC = "Characters are not allowed";
    	public String ERROR_MSG_EDIT_PIN_NOT_SIX_DIGITS = "PIN Code must have 6 Digits";
    	public String ERROR_MSG_EDIT_PIN_SPECIAL_CHAR = "Special characters are not allowed";
    	
    }
    public static class Edit_Customer_06 {
    	Customer customer = Customer.getCustomer();
    	
    	public static Edit_Customer_06 getEditCustomer06() {
    		return new Edit_Customer_06();
    	}
    	
    	public String EDIT_PHONE_BLANK = "";
    	public String EDIT_PHONE_SPECIAL_CHAR = String.valueOf(customer.dataHelper.getRandomNumber()) + "%$#";
    	public String ERROR_MSG_EDIT_PHONE_BLANK = "Mobile no must not be blank";
    	public String ERROR_MSG_EDIT_PHONE_SPECIAL_CHAR = "Special characters are not allowed";
    	
    }
    public static class Edit_Customer_07 {
    	Customer customer = Customer.getCustomer();
    	
    	public static Edit_Customer_07 getEditCustomer07() {
    		return new Edit_Customer_07();
    	}
    	
    	public String EDIT_EMAIL_BLANK = "";
    	public String EDIT_EMAIL_SPACE = " ";
    	public String EDIT_EMAIL_NOT_CORRECT_FORMAT = customer.dataHelper.getRandomString();
    	public String ERROR_MSG_EDIT_EMAIL_BLANK = "Email-ID must not be blank";
    	public String ERROR_MSG_EDIT_EMAIL_SPACE = "First character can not have space";
    	public String ERROR_MSG_EDIT_EMAIL_NOT_CORRECT_FORMAT = "Email-ID is not valid";
    	
    }
    public static class Delete_Customer_Data_Page {
        Customer customer = Customer.getCustomer();

        public static Delete_Customer_Data_Page getDeleteCustomerDataPage() {
            return new Delete_Customer_Data_Page();
        }

        public String DELETE_CUSTOMER_ID_BLANK = "";
        public String DELETE_CUSTOMER_ID_NUMERIC = "Acc" + customer.dataHelper.getRandomNumber();
        public String DELETE_CUSTOMER_ID_SPECIAL_CHAR = "!@#" + customer.dataHelper.getRandomNumber();
        	   	
        public String ERROR_MSG_DELETE_CUSTOMER_ID_BLANK = "Customer ID is required";
        public String ERROR_MSG_DELETE_CUSTOMER_ID_NUMERIC = "Characters are not allowed";
    	public String ERROR_MSG_DELETE_CUSTOMER_ID_SPECIAL_CHAR = "Special characters are not allowed";

    	public String HEADER_TEXT_DELETE_CUSTOMER_PAGE = "Delete Customer Form";
        
    }


}

package com.madhan.restapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "customer")
public class Customer {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long customerId;
	    
	    private String customerName;
	    
	    @Column(unique = true)
	    private String email;
	    
	    private String phoneNo;
	    
	    private String password;

	    @Transient
	    private String reEnterPassword;

		public Customer() {
			super();
		}

		public Customer(Long customerId, String customerName, String email, String phoneNo, String password,
				String reEnterPassword) {
			super();
			this.customerId = customerId;
			this.customerName = customerName;
			this.email = email;
			this.phoneNo = phoneNo;
			this.password = password;
			this.reEnterPassword = reEnterPassword;
		}

		@Override
		public String toString() {
			return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", email=" + email
					+ ", phoneNo=" + phoneNo + ", password=" + password + ", reEnterPassword=" + reEnterPassword + "]";
		}

		public Long getCustomerId() {
			return customerId;
		}

		public void setCustomerId(Long customerId) {
			this.customerId = customerId;
		}

		public String getCustomerName() {
			return customerName;
		}

		public void setCustomerName(String customerName) {
			this.customerName = customerName;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPhoneNo() {
			return phoneNo;
		}

		public void setPhoneNo(String phoneNo) {
			this.phoneNo = phoneNo;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getReEnterPassword() {
			return reEnterPassword;
		}

		public void setReEnterPassword(String reEnterPassword) {
			this.reEnterPassword = reEnterPassword;
		}

	    
	    
}

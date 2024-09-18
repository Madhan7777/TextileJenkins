package com.madhan.restapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ProductOrder_table")
public class ProductOrder {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long orderId;

	    @ManyToOne
	    @JoinColumn(name = "customerId")
	    private Customer customer;

	    @ManyToOne
	    @JoinColumn(name = "productId")
	    private AdminProduct adminProduct;

	    @Column(name = "order_date")
	    private String orderDate;

	    // Customer information
	    private String userName;
	    private String email;
	    private Long contactNumber;

	    // Shipping address
	    private String plotNumber;
	    private String streetName;
	    private String cityName;
	    private String stateName;

	    // Payment information
	    private Long cardNum;
	    private int expMonth; 
	    private int expYear;  
	    private int cvv;
	    private int quantity;
	    @Column(name = "total_amount")
	    private Double totalAmount;
		public ProductOrder() {
			super();
		}
		public ProductOrder(Long orderId, Customer customer, AdminProduct adminProduct, String orderDate,
				String userName, String email, Long contactNumber, String plotNumber, String streetName,
				String cityName, String stateName, Long cardNum, int expMonth, int expYear, int cvv, int quantity,
				Double totalAmount) {
			super();
			this.orderId = orderId;
			this.customer = customer;
			this.adminProduct = adminProduct;
			this.orderDate = orderDate;
			this.userName = userName;
			this.email = email;
			this.contactNumber = contactNumber;
			this.plotNumber = plotNumber;
			this.streetName = streetName;
			this.cityName = cityName;
			this.stateName = stateName;
			this.cardNum = cardNum;
			this.expMonth = expMonth;
			this.expYear = expYear;
			this.cvv = cvv;
			this.quantity = quantity;
			this.totalAmount = totalAmount;
		}
		@Override
		public String toString() {
			return "ProductOrder [orderId=" + orderId + ", customer=" + customer + ", adminProduct=" + adminProduct
					+ ", orderDate=" + orderDate + ", userName=" + userName + ", email=" + email + ", contactNumber="
					+ contactNumber + ", plotNumber=" + plotNumber + ", streetName=" + streetName + ", cityName="
					+ cityName + ", stateName=" + stateName + ", cardNum=" + cardNum + ", expMonth=" + expMonth
					+ ", expYear=" + expYear + ", cvv=" + cvv + ", quantity=" + quantity + ", totalAmount="
					+ totalAmount + "]";
		}
		public Long getOrderId() {
			return orderId;
		}
		public void setOrderId(Long orderId) {
			this.orderId = orderId;
		}
		public Customer getCustomer() {
			return customer;
		}
		public void setCustomer(Customer customer) {
			this.customer = customer;
		}
		public AdminProduct getAdminProduct() {
			return adminProduct;
		}
		public void setAdminProduct(AdminProduct adminProduct) {
			this.adminProduct = adminProduct;
		}
		public String getOrderDate() {
			return orderDate;
		}
		public void setOrderDate(String orderDate) {
			this.orderDate = orderDate;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public Long getContactNumber() {
			return contactNumber;
		}
		public void setContactNumber(Long contactNumber) {
			this.contactNumber = contactNumber;
		}
		public String getPlotNumber() {
			return plotNumber;
		}
		public void setPlotNumber(String plotNumber) {
			this.plotNumber = plotNumber;
		}
		public String getStreetName() {
			return streetName;
		}
		public void setStreetName(String streetName) {
			this.streetName = streetName;
		}
		public String getCityName() {
			return cityName;
		}
		public void setCityName(String cityName) {
			this.cityName = cityName;
		}
		public String getStateName() {
			return stateName;
		}
		public void setStateName(String stateName) {
			this.stateName = stateName;
		}
		public Long getCardNum() {
			return cardNum;
		}
		public void setCardNum(Long cardNum) {
			this.cardNum = cardNum;
		}
		public int getExpMonth() {
			return expMonth;
		}
		public void setExpMonth(int expMonth) {
			this.expMonth = expMonth;
		}
		public int getExpYear() {
			return expYear;
		}
		public void setExpYear(int expYear) {
			this.expYear = expYear;
		}
		public int getCvv() {
			return cvv;
		}
		public void setCvv(int cvv) {
			this.cvv = cvv;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		public Double getTotalAmount() {
			return totalAmount;
		}
		public void setTotalAmount(Double totalAmount) {
			this.totalAmount = totalAmount;
		}
	    
		
				
	    
}

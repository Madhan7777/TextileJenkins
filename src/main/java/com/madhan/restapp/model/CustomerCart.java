package com.madhan.restapp.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "customercart")
public class CustomerCart {
	
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @OneToOne
	    @JoinColumn(name = "customerId")
	    private Customer customer;

	    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
	    private List<CartItem> cartItems;

	    private double totalAmount;

		public CustomerCart() {
			super();
		}

		public CustomerCart(Long id, Customer customer, List<CartItem> cartItems, double totalAmount) {
			super();
			this.id = id;
			this.customer = customer;
			this.cartItems = cartItems;
			this.totalAmount = totalAmount;
		}

		@Override
		public String toString() {
			return "CustomerCart [id=" + id + ", customer=" + customer + ", cartItems=" + cartItems + ", totalAmount="
					+ totalAmount + "]";
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Customer getCustomer() {
			return customer;
		}

		public void setCustomer(Customer customer) {
			this.customer = customer;
		}

		public List<CartItem> getCartItems() {
			return cartItems;
		}

		public void setCartItems(List<CartItem> cartItems) {
			this.cartItems = cartItems;
		}

		public double getTotalAmount() {
			return totalAmount;
		}

		public void setTotalAmount(double totalAmount) {
			this.totalAmount = totalAmount;
		}

	    
}

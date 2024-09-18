package com.madhan.restapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cart_item")
public class CartItem {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cartId")
    private CustomerCart cart;

    @ManyToOne
    @JoinColumn(name = "productId")
    private AdminProduct product;

    private int quantity;

    private double totalPrice;

	public CartItem() {
		super();
	}

	public CartItem(Long id, CustomerCart cart, AdminProduct product, int quantity, double totalPrice) {
		super();
		this.id = id;
		this.cart = cart;
		this.product = product;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "CartItem [id=" + id + ", cart=" + cart + ", product=" + product + ", quantity=" + quantity
				+ ", totalPrice=" + totalPrice + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CustomerCart getCart() {
		return cart;
	}

	public void setCart(CustomerCart cart) {
		this.cart = cart;
	}

	public AdminProduct getProduct() {
		return product;
	}

	public void setProduct(AdminProduct product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
    
    


}

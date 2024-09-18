package com.madhan.restapp.model;

import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "AdminProduct_table")
public class AdminProduct {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId;
	
	 @Lob
	    @Column(name = "productImage", length = 1000)
	    private byte[] productImage;

	    private String imageName;
	    private String imageType;

	    private String brand;
	    private String category; 
	    private String material; 
	    private String color;
	    private String pattern; 
	    private String size; 
	    private String gender; 

	    private String productName;
	    private String description;
	    private String careInstructions; 
	    private int price;
	    
	    private int quantity; 

	    @JsonIgnoreProperties("adminProduct")
	    @OneToMany(mappedBy = "adminProduct", cascade = CascadeType.ALL)
	    private List<ProductOrder> orders;

		public AdminProduct() {
			super();
		}

		public AdminProduct(Long productId, byte[] productImage, String imageName, String imageType, String brand,
				String category, String material, String color, String pattern, String size, String gender,
				String productName, String description, String careInstructions, int price, int quantity,
				List<ProductOrder> orders) {
			super();
			this.productId = productId;
			this.productImage = productImage;
			this.imageName = imageName;
			this.imageType = imageType;
			this.brand = brand;
			this.category = category;
			this.material = material;
			this.color = color;
			this.pattern = pattern;
			this.size = size;
			this.gender = gender;
			this.productName = productName;
			this.description = description;
			this.careInstructions = careInstructions;
			this.price = price;
			this.quantity = quantity;
			this.orders = orders;
		}

		@Override
		public String toString() {
			return "AdminProduct [productId=" + productId + ", productImage=" + Arrays.toString(productImage)
					+ ", imageName=" + imageName + ", imageType=" + imageType + ", brand=" + brand + ", category="
					+ category + ", material=" + material + ", color=" + color + ", pattern=" + pattern + ", size="
					+ size + ", gender=" + gender + ", productName=" + productName + ", description=" + description
					+ ", careInstructions=" + careInstructions + ", price=" + price + ", quantity=" + quantity
					+ ", orders=" + orders + "]";
		}

		public Long getProductId() {
			return productId;
		}

		public void setProductId(Long productId) {
			this.productId = productId;
		}

		public byte[] getProductImage() {
			return productImage;
		}

		public void setProductImage(byte[] productImage) {
			this.productImage = productImage;
		}

		public String getImageName() {
			return imageName;
		}

		public void setImageName(String imageName) {
			this.imageName = imageName;
		}

		public String getImageType() {
			return imageType;
		}

		public void setImageType(String imageType) {
			this.imageType = imageType;
		}

		public String getBrand() {
			return brand;
		}

		public void setBrand(String brand) {
			this.brand = brand;
		}

		public String getCategory() {
			return category;
		}

		public void setCategory(String category) {
			this.category = category;
		}

		public String getMaterial() {
			return material;
		}

		public void setMaterial(String material) {
			this.material = material;
		}

		public String getColor() {
			return color;
		}

		public void setColor(String color) {
			this.color = color;
		}

		public String getPattern() {
			return pattern;
		}

		public void setPattern(String pattern) {
			this.pattern = pattern;
		}

		public String getSize() {
			return size;
		}

		public void setSize(String size) {
			this.size = size;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public String getProductName() {
			return productName;
		}

		public void setProductName(String productName) {
			this.productName = productName;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getCareInstructions() {
			return careInstructions;
		}

		public void setCareInstructions(String careInstructions) {
			this.careInstructions = careInstructions;
		}

		public int getPrice() {
			return price;
		}

		public void setPrice(int price) {
			this.price = price;
		}

		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

		public List<ProductOrder> getOrders() {
			return orders;
		}

		public void setOrders(List<ProductOrder> orders) {
			this.orders = orders;
		}

		
	    

}

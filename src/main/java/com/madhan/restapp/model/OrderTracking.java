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
@Table(name = "OrderTracking_table")
public class OrderTracking {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long trackingId;

	    @ManyToOne
	    @JoinColumn(name = "orderId", nullable = false)
	    private ProductOrder productOrder;

	    @Column(name = "trackingNumber", unique = true, nullable = false)
	    private String trackingNumber;

	    @Column(name = "carrier")
	    private String carrier;

	    @Column(name = "status", nullable = false)
	    private String status;

	    @Column(name = "estimatedDeliveryDate")
	    private String estimatedDeliveryDate;

	    @Column(name = "lastUpdatedDate")
	    private String lastUpdatedDate;

	    @Column(name = "currentLocation")
	    private String currentLocation;

		public OrderTracking() {
			super();
		}

		public OrderTracking(Long trackingId, ProductOrder productOrder, String trackingNumber, String carrier,
				String status, String estimatedDeliveryDate, String lastUpdatedDate, String currentLocation) {
			super();
			this.trackingId = trackingId;
			this.productOrder = productOrder;
			this.trackingNumber = trackingNumber;
			this.carrier = carrier;
			this.status = status;
			this.estimatedDeliveryDate = estimatedDeliveryDate;
			this.lastUpdatedDate = lastUpdatedDate;
			this.currentLocation = currentLocation;
		}

		@Override
		public String toString() {
			return "OrderTracking [trackingId=" + trackingId + ", productOrder=" + productOrder + ", trackingNumber="
					+ trackingNumber + ", carrier=" + carrier + ", status=" + status + ", estimatedDeliveryDate="
					+ estimatedDeliveryDate + ", lastUpdatedDate=" + lastUpdatedDate + ", currentLocation="
					+ currentLocation + "]";
		}

		public Long getTrackingId() {
			return trackingId;
		}

		public void setTrackingId(Long trackingId) {
			this.trackingId = trackingId;
		}

		public ProductOrder getProductOrder() {
			return productOrder;
		}

		public void setProductOrder(ProductOrder productOrder) {
			this.productOrder = productOrder;
		}

		public String getTrackingNumber() {
			return trackingNumber;
		}

		public void setTrackingNumber(String trackingNumber) {
			this.trackingNumber = trackingNumber;
		}

		public String getCarrier() {
			return carrier;
		}

		public void setCarrier(String carrier) {
			this.carrier = carrier;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public String getEstimatedDeliveryDate() {
			return estimatedDeliveryDate;
		}

		public void setEstimatedDeliveryDate(String estimatedDeliveryDate) {
			this.estimatedDeliveryDate = estimatedDeliveryDate;
		}

		public String getLastUpdatedDate() {
			return lastUpdatedDate;
		}

		public void setLastUpdatedDate(String lastUpdatedDate) {
			this.lastUpdatedDate = lastUpdatedDate;
		}

		public String getCurrentLocation() {
			return currentLocation;
		}

		public void setCurrentLocation(String currentLocation) {
			this.currentLocation = currentLocation;
		}
	    
	    

}

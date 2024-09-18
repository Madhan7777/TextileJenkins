package com.madhan.restapp.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "ProductRequest_table")
public class ProductRequest {
	
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long requestId;

	    @ManyToOne
	    @JoinColumn(name = "adminProductId", nullable = false)
	    private AdminProduct adminProduct;

	    @ManyToOne
	    @JoinColumn(name = "supplierId", nullable = false)
	    private Supplier supplier;

	    @Column(name = "requestedQuantity", nullable = false)
	    private int requestedQuantity;

	    @Column(name = "suppliedQuantity")
	    private Integer suppliedQuantity;

	    @Column(name = "requestDate", nullable = false)
	    @Temporal(TemporalType.DATE)
	    private Date requestDate;

	    @Column(name = "responseDate")
	    @Temporal(TemporalType.DATE)
	    private Date responseDate;

	    @Column(name = "status", nullable = false)
	    private String status; 

	    @Column(name = "comments")
	    private String comments;

		public ProductRequest() {
			super();
		}

		public ProductRequest(Long requestId, AdminProduct adminProduct, Supplier supplier, int requestedQuantity,
				Integer suppliedQuantity, Date requestDate, Date responseDate, String status, String comments) {
			super();
			this.requestId = requestId;
			this.adminProduct = adminProduct;
			this.supplier = supplier;
			this.requestedQuantity = requestedQuantity;
			this.suppliedQuantity = suppliedQuantity;
			this.requestDate = requestDate;
			this.responseDate = responseDate;
			this.status = status;
			this.comments = comments;
		}

		@Override
		public String toString() {
			return "ProductRequest [requestId=" + requestId + ", adminProduct=" + adminProduct + ", supplier="
					+ supplier + ", requestedQuantity=" + requestedQuantity + ", suppliedQuantity=" + suppliedQuantity
					+ ", requestDate=" + requestDate + ", responseDate=" + responseDate + ", status=" + status
					+ ", comments=" + comments + "]";
		}

		public Long getRequestId() {
			return requestId;
		}

		public void setRequestId(Long requestId) {
			this.requestId = requestId;
		}

		public AdminProduct getAdminProduct() {
			return adminProduct;
		}

		public void setAdminProduct(AdminProduct adminProduct) {
			this.adminProduct = adminProduct;
		}

		public Supplier getSupplier() {
			return supplier;
		}

		public void setSupplier(Supplier supplier) {
			this.supplier = supplier;
		}

		public int getRequestedQuantity() {
			return requestedQuantity;
		}

		public void setRequestedQuantity(int requestedQuantity) {
			this.requestedQuantity = requestedQuantity;
		}

		public Integer getSuppliedQuantity() {
			return suppliedQuantity;
		}

		public void setSuppliedQuantity(Integer suppliedQuantity) {
			this.suppliedQuantity = suppliedQuantity;
		}

		public Date getRequestDate() {
			return requestDate;
		}

		public void setRequestDate(Date requestDate) {
			this.requestDate = requestDate;
		}

		public Date getResponseDate() {
			return responseDate;
		}

		public void setResponseDate(Date responseDate) {
			this.responseDate = responseDate;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public String getComments() {
			return comments;
		}

		public void setComments(String comments) {
			this.comments = comments;
		}

	    
}

package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="purchase_order_details")
public class PurchaseOrderDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="purchaseItemId")
	 private long purchaseItemId;
	
	@Column(name="purchaseOId")
	 private String purchaseOId;
	/*@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "purchaseOId")
    private ModelPOHead modelPOHead;*/
	
	@Column(name="productId")
	 private String productId;
	/*@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productId")
    private ModelProduct modelProduct;*/
	
	@Column(name="unitPrice")
	 private double unitPrice;
	
	
	@Column(name="quantity")
	 private long quantity;
	
	@Column(name="createdOn")
	 private String createdOn;
	
	@Column(name="createdBy")
	 private String createdBy;
	
	@Column(name="updatedOn")
	 private String updatedOn;
	
	@Column(name="updatedBy")
	 private String updatedBy;
	
	public PurchaseOrderDetails() {}

	public PurchaseOrderDetails(String purchaseOId, String productId, double unitPrice, long quantity,
			String createdOn, String createdBy, String updatedOn, String updatedBy) {
		super();
		this.purchaseOId = purchaseOId;
		this.productId = productId;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
		this.createdOn = createdOn;
		this.createdBy = createdBy;
		this.updatedOn = updatedOn;
		this.updatedBy = updatedBy;
	}

	public long getPurchaseItemId() {
		return purchaseItemId;
	}

	public void setPurchaseItemId(long purchaseItemId) {
		this.purchaseItemId = purchaseItemId;
	}

	public String getPurchaseOId() {
		return purchaseOId;
	}

	public void setPurchaseOId(String purchaseOId) {
		this.purchaseOId = purchaseOId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(String updatedOn) {
		this.updatedOn = updatedOn;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	
	
	
	
}

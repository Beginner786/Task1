package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="purchase_order_head")
public class PurchaseOrderHead {

	@Id
	@Column(name="purchaseOId")
	 private String purchaseOId;
	/*@OneToOne(mappedBy="POHeadTable", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private ModelPODet modelPODet;
	@OneToOne(mappedBy="POHeadTable", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private ModelInvoiceHead modelInvoiceHead;
	*/
	
	@Column(name="vendorId")
	 private String vendorId;
	/*@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vendorId")
    private ModelVendor modelVendor;
	*/
	
	@Column(name="totQuantity")
	 private long totQuantity;
	
	@Column(name="totPrice")
	 private double totPrice;
	
	@Column(name="status")
	 private int status;
	
	@Column(name="createdOn")
	 private String createdOn;
	
	@Column(name="createdBy")
	 private String createdBy;
		
	@Column(name="updatedOn")
	 private String updatedOn;
	
	@Column(name="updatedBy")
	 private String updatedBy;
	
	public PurchaseOrderHead() {}

	public PurchaseOrderHead(String purchaseOId, String vendorId, long totQuantity, double totPrice, int status,
			String createdOn, String createdBy, String updatedOn, String updatedBy) {
		super();
		this.purchaseOId = purchaseOId;
		this.vendorId = vendorId;
		this.totQuantity = totQuantity;
		this.totPrice = totPrice;
		this.status = status;
		this.createdOn = createdOn;
		this.createdBy = createdBy;
		this.updatedOn = updatedOn;
		this.updatedBy = updatedBy;
	}

	public String getPurchaseOId() {
		return purchaseOId;
	}

	public void setPurchaseOId(String purchaseOId) {
		this.purchaseOId = purchaseOId;
	}

	public String getVendorId() {
		return vendorId;
	}

	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}

	public long getTotQuantity() {
		return totQuantity;
	}

	public void setTotQuantity(long totQuantity) {
		this.totQuantity = totQuantity;
	}

	public double getTotPrice() {
		return totPrice;
	}

	public void setTotPrice(double totPrice) {
		this.totPrice = totPrice;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
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

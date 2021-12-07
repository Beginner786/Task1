package com.example.adding;

public class PurchaseOrder {
	
	private String vendorId;
	private Long totQuantity;
	private String productId;
	private Long quantity;
	
	public PurchaseOrder() {}

	public PurchaseOrder(String vendorId, Long totQuantity, String productId, Long quantity) {
		super();
		this.vendorId = vendorId;
		this.totQuantity = totQuantity;
		this.productId = productId;
		this.quantity = quantity;
	}

	public String getVendorId() {
		return vendorId;
	}

	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}

	public Long getTotQuantity() {
		return totQuantity;
	}

	public void setTotQuantity(Long totQuantity) {
		this.totQuantity = totQuantity;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	
	

}

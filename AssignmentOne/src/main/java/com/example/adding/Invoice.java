package com.example.adding;

import java.sql.Timestamp;

public class Invoice {

	private String purchaseOId;
	private Long totalQuantityReceived;
	private Timestamp receivedOn;
	private Long quantity;
	private String productId;
	public Invoice(String purchaseOId, Long totalQuantityReceived, Timestamp receivedOn, Long quantity,
			String productId) {
		super();
		this.purchaseOId = purchaseOId;
		this.totalQuantityReceived = totalQuantityReceived;
		this.receivedOn = receivedOn;
		this.quantity = quantity;
		this.productId = productId;
	}
	public String getPurchaseOId() {
		return purchaseOId;
	}
	public void setPurchaseOId(String purchaseOId) {
		this.purchaseOId = purchaseOId;
	}
	public Long getTotalQuantityReceived() {
		return totalQuantityReceived;
	}
	public void setTotalQuantityReceived(Long totalQuantityReceived) {
		this.totalQuantityReceived = totalQuantityReceived;
	}
	public Timestamp getReceivedOn() {
		return receivedOn;
	}
	public void setTimestamp(Timestamp receivedOn) {
		this.receivedOn = receivedOn;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	
	
	
}

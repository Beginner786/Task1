package com.example.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="invoice_head")
public class InvoiceHead {

	@Id
	@Column(name="invoiceId")
	private String invoiceId;
	/*@OneToOne(mappedBy="InvoiceHeadTable", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private ModelInvoiceItem modelInvoiceItem;*/
	
	@Column(name="purchaseOId")
	private String purchaseOId;
	
	/*@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "purchaseOId")
    private ModelPOHead modelPOHead;*/
	
	@Column(name="totQuantityReceived")
	private long totQuantityReceived;
	
	@Column(name="totalPrice")
	private double totalPrice;
	
	
	@Column(name="receivedOn")
	private Timestamp receivedOn;
	
	
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
	
	public InvoiceHead() {}

	public InvoiceHead(String invoiceId, String purchaseOId, long totQuantityReceived,
			double totalPrice, Timestamp receivedOn, int status, String createdOn, String createdBy, String updatedOn,
			String updatedBy) {
		super();
		this.invoiceId = invoiceId;
		this.purchaseOId = purchaseOId;
		this.totQuantityReceived = totQuantityReceived;
		this.totalPrice = totalPrice;
		this.receivedOn = receivedOn;
		this.status = status;
		this.createdOn = createdOn;
		this.createdBy = createdBy;
		this.updatedOn = updatedOn;
		this.updatedBy = updatedBy;
	}

	public String getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(String invoiceId) {
		this.invoiceId = invoiceId;
	}

	public String getPurchaseOId() {
		return purchaseOId;
	}

	public void setPurchaseOId(String purchaseOId) {
		this.purchaseOId = purchaseOId;
	}

	public long getTotQuantityReceived() {
		return totQuantityReceived;
	}

	public void setTotQuantityReceived(long totQuantityReceived) {
		this.totQuantityReceived = totQuantityReceived;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Timestamp getReceivedOn() {
		return receivedOn;
	}

	public void setReceivedOn(Timestamp receivedOn) {
		this.receivedOn = receivedOn;
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

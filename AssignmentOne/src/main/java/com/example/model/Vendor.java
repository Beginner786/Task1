package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="vendor")
public class Vendor {

	@Id
	@Column(name="vendorId")
	 private String vendorId;
	/*
	@OneToOne(mappedBy="VendorTable", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private ModelVendMapProd modelVendMapProd;
	*/
	
	
	@Column(name="vendorName")
	 private String vendorName;
	
	
	@Column(name="addedOn")
	 private String addedOn;
	
	
	@Column(name="addedBy")
	 private String addedBy;
	
	
	@Column(name="vendorAddress")
	 private String vendorAddress;
	
	@Column(name="updatedOn")
	 private String updatedOn;
	
	@Column(name="updatedBy")
	 private String updatedBy;
	
	public Vendor()
	{
	}

	public Vendor(String vendorId,  String vendorName,  String addedOn,  String addedBy,
			 String vendorAddress, String updatedOn, String updatedBy) {
		super();
		this.vendorId = vendorId;
		this.vendorName = vendorName;
		this.addedOn = addedOn;
		this.addedBy = addedBy;
		this.vendorAddress = vendorAddress;
		this.updatedOn = updatedOn;
		this.updatedBy = updatedBy;
	}

	public String getVendorId() {
		return vendorId;
	}

	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getAddedOn() {
		return addedOn;
	}

	public void setAddedOn(String addedOn) {
		this.addedOn = addedOn;
	}

	public String getAddedBy() {
		return addedBy;
	}

	public void setAddedBy(String addedBy) {
		this.addedBy = addedBy;
	}

	public String getVendorAddress() {
		return vendorAddress;
	}

	public void setVendorAddress(String vendorAddress) {
		this.vendorAddress = vendorAddress;
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

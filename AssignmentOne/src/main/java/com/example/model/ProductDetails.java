package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="product")
public class ProductDetails {

	@Id
	@Column(name="productId")
	 private String productId;
	/*
	@OneToOne(cascade=CascadeType.ALL,optional=false)
	@JoinColumn(name="productId")
	private ModelVendMapProd modelVendMapProd;
	@OneToOne(cascade=CascadeType.ALL,optional=false)
	@JoinColumn(name="productId")
	private ModelPODet modelPODet;
	@OneToOne(cascade=CascadeType.ALL,optional=false)
	@JoinColumn(name="productId")
	private ModelInvoiceItem modelInvoiceItem;
	*/
	/*@OneToOne(mappedBy="ProductTable", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private ModelPODet modelPODet;
	@OneToOne(mappedBy="ProductTable", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private ModelInvoiceItem modelInvoiceItem;*/
	
	
	@Column(name="productName")
	 private String productName;
	
	
	@Column(name="unitPrice")
	 private double unitPrice;
	
	
	@Column(name="description")
	 private String description;
	
	
	@Column(name="addedOn")
	 private String addedOn;
	
	
	@Column(name="addedBy")
	 private String addedBy;
	
	@Column(name="updatedOn")
	 private String updatedOn;
	
	@Column(name="updatedBy")
	 private String updatedBy;

	public ProductDetails()
	{		
	}

	public ProductDetails(String productId,  String productName,  double unitPrice,
			 String description,  String addedOn,  String addedBy, String updatedOn,
			String updatedBy) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.unitPrice = unitPrice;
		this.description = description;
		this.addedOn = addedOn;
		this.addedBy = addedBy;
		this.updatedOn = updatedOn;
		this.updatedBy = updatedBy;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

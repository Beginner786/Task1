package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="vendor_map_product")
public class VendorMapProduct {

	
	@Id
	@Column(name="productId")
	private String productId;
		
	
	@Column(name="vendorId")
	private String vendorId;
	
	/*@Id
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productId")
    private ModelProduct modelProduct;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vendorId")
    private ModelVendor modelVendor;
    */
	
	/*@OneToOne(mappedBy = "modelVendMapProd")
	private ModelProduct modelProduct;
	
	@OneToOne(mappedBy = "modelVendMapProd")
	private ModelVendor modelVendor;
	*/
	
	
	@Column(name="unitPrice")
	private double unitPrice;
	
	public VendorMapProduct() {}
	
	
	public VendorMapProduct(String productId, String vendorId, double unitPrice) {
		super();
		this.productId = productId;
		this.vendorId = vendorId;
		this.unitPrice = unitPrice;
	}


	public String getProductId() {
		return productId;
	}


	public void setProductId(String productId) {
		this.productId = productId;
	}


	public String getVendorId() {
		return vendorId;
	}


	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}


	public double getUnitPrice() {
		return unitPrice;
	}


	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	
	
}

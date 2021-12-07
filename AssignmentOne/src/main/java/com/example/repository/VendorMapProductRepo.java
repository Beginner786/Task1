package com.example.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.model.VendorMapProduct;

@Repository
public interface VendorMapProductRepo extends JpaRepository<VendorMapProduct,String>{

	//@Query(value = "SELECT * from VendMapProdTable where vendorId= ?1",nativeQuery = true)
	//public Optional<ModelVendMapProd> getProdsUsingVend(String vendId);
	
	@Query(value = "UPDATE vendor_map_product SET vendorId= ?2, unitPrice= ?3 where productId= ?1",nativeQuery = true)
	public void upd(String prodId, String vendId, double up);
	
}

package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.model.PurchaseOrderHead;

@Repository
public interface PurchaseOrderHeadRepo extends JpaRepository<PurchaseOrderHead,String>{

	@Query(value = "UPDATE purchase_order_head SET status= 1 where purchaseOId= ?1",nativeQuery = true)
	public void appr(String purOId);
	
}

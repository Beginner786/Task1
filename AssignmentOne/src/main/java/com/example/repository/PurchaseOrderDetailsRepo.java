package com.example.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.model.PurchaseOrderDetails;

@Repository
public interface PurchaseOrderDetailsRepo extends JpaRepository<PurchaseOrderDetails,Long>{
	
	@Query("select mpd from purchase_order_details mpd where mpd.purchaseOId=?1")
	Optional<PurchaseOrderDetails> findModelPODetByPurchaseOId(String purchaseOId);

}

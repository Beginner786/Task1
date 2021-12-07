package com.example.repository;

//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.model.ProductDetails;

@Repository
public interface ProductRepo extends JpaRepository<ProductDetails,String>{

	//@Query(value = "SELECT * from ProductTable where vendorId= ?1",nativeQuery = true)
	//public Optional<AssignmentOneModelProduct> getProdsUsingVend(String vendId);
	
}

package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Vendor;

@Repository
public interface VendorRepo extends JpaRepository<Vendor,String>{

}

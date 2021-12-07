package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.InvoiceHead;

@Repository
public interface InvoiceHeadRepo extends JpaRepository<InvoiceHead,String>{

}

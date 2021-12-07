package com.example.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.model.InvoiceItem;

@Repository
public interface InvoiceItemRepo extends JpaRepository<InvoiceItem,Long>{

	@Query("select iit from invoice_item iit where iit.invoiceId=?1")
	Optional<InvoiceItem> findModelInvoiceItemByInvoiceId(String invoiceId);
	
}

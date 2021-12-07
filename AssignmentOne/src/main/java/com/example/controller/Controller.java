package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.adding.Invoice;
import com.example.adding.PurchaseOrder;
import com.example.adding.Product;
import com.example.model.ProductDetails;
import com.example.model.User;
import com.example.model.Vendor;
import com.example.services.Services;

@RestController
@RequestMapping("/api")
public class Controller {

	@Autowired
	Services services;
	
	// POST requests ------------------------------------------------------
	
	@PostMapping("/{userId}/CreateUser")
	public String addUser(@RequestBody User modelUser, @PathVariable String uId)
	{
		return services.addUser(modelUser, uId);
	}
	
	@PostMapping("/{userId}/AddProduct")
	public String addProduct(@RequestBody Product addingProduct, @PathVariable String uId)
	{
		return services.addProduct(addingProduct, uId);
	}
	
	@PostMapping("/{userId}/AddVendor")
	public String addVendor(@RequestBody Vendor modelVendor, @PathVariable String uId)
	{
		return services.addVendor(modelVendor, uId);
	}
	
	@PostMapping("/{userId}/CreatePO")
	public String addPO(@RequestBody PurchaseOrder addingPO, @PathVariable String uId)
	{
		return services.addPO(addingPO, uId);
	}
	
	@PostMapping("/{userId}/CreateInvoice")
	public String addInvoice(@RequestBody Invoice addingInvoice, @PathVariable String uId)
	{
		return services.addInvoice(addingInvoice, uId);
	}
	
	// GET requests ------------------------------------------------------
	
	@GetMapping("/GetAllUsers")
	public List<User> getAllUsers()
	{
		return services.getAllUsers();
	}
	
	@GetMapping("/GetAllVendors")
	public List<Vendor> getAllVendors()
	{
		return services.getAllVendors();
	}

	@GetMapping("/GetAllProducts")
	public List<Object> getAllProducts()
	{
		return services.getAllProds();
	}
	
	@GetMapping("/GetAllPOs")
	public List<Object> getAllPOs()
	{
		return services.getAllPOs();
	}
	
	@GetMapping("/GetAllInvoice")
	public List<Object> getAllInvoice()
	{
		return services.getAllInvoice();
	}
	
	@GetMapping("/GetUserByUserId/{id}")
	public Optional<User> getUserById(@PathVariable String uId)
	{
		return services.getUserById(uId);
	}
	
	@GetMapping("/GetVendorByVendId/{id}")
	public Optional<Vendor> getVendorById(@PathVariable String uId)
	{
		return services.getVendorById(uId);
	}
	
	@GetMapping("/GetProductByProdId/{id}")
	public Optional<ProductDetails> getProductById(@PathVariable String uId)
	{
		return services.getProductById(uId);
	}
	
	/*@GetMapping("/GetPOByPOId/{id}")
	public Optional<Object> getPObth(@PathVariable String uId)
	{
		return services.getPObth(uId);
	}*/
	
	
}

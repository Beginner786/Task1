package com.example.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.example.model.*;
import com.example.repository.*;
import com.example.adding.*;

@Service
public class Services {
	
	static long purchaseIdG=0,invoiceIdG=0;
	
	@Autowired
	InvoiceHeadRepo repoInvoiceHead;
	
	@Autowired
	InvoiceItemRepo repoInvoiceItem;
	
	@Autowired
	PurchaseOrderDetailsRepo repoPODet;
	
	@Autowired
	PurchaseOrderHeadRepo repoPOHead;
	
	@Autowired
	ProductRepo repoProduct;
	
	@Autowired
	UserRepo repoUser;
	
	@Autowired
	VendorMapProductRepo repoVendMapProd;
	
	@Autowired
	VendorRepo repoVendor;
	
	@Autowired
	UserRolesRepo userRolesRepo;
	
	@Autowired
	StatusRepo statusRepo;
	
	public int checkAdmin(String name)
	{
		Optional<User> v=getUserById(name);
		if(!v.isPresent())
			return 0;
		if(v.get().getUserRole()!=1)
			return 1;
		return 2;
	}
	
	// POST ----------------------------------------------------------------------------------------
	
	public String addUser(User modelUser, String name)
	{
		int v=checkAdmin(name);
		if(v==0)
			return "User with this Id: "+name+" is not present";
		if(v==1)
			return "You are not an Admin! This operation cannot be done";
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String s=""+timestamp+"";
		modelUser.setCreatedOn(s);
		modelUser.setCreatedBy(name);
		repoUser.save(modelUser);
		return "User created successfully!";
	}
	
	public String addProduct(Product addingProduct, String name)
	{
		int v=checkAdmin(name);
		if(v==0)
			return "User with this Id: "+name+" is not present";
		if(v==1)
			return "You are not an Admin! This operation cannot be done";
		if(!getVendorById(addingProduct.getVendorId()).isPresent())
			return "Vendor with Id: "+addingProduct.getVendorId()+" is not present";
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String s=""+timestamp+"";
		ProductDetails mp=new ProductDetails(
				addingProduct.getProductId(),
				addingProduct.getProductName(),
				addingProduct.getUnitPrice(),
				addingProduct.getDescription(),
				s,name,"-","-"
				);
		VendorMapProduct mvmp=new VendorMapProduct(
				addingProduct.getProductId(),
				addingProduct.getVendorId(),
				addingProduct.getUnitPrice()
				);
		repoProduct.save(mp);
		repoVendMapProd.save(mvmp);
		return "Product added successfully!";
	}
	
	public String addVendor(Vendor modelVendor, String name)
	{
		int v=checkAdmin(name);
		if(v==0)
			return "User with this Id: "+name+" is not present";
		if(v==1)
			return "You are not an Admin! This operation cannot be done";
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String s=""+timestamp+"";
        modelVendor.setAddedOn(s);
        modelVendor.setAddedBy(name);
		repoVendor.save(modelVendor);
		return "Vendor added successfully!";
	}
	
	public String addPO(PurchaseOrder addingPO, String name)
	{
		if(!getVendorById(addingPO.getVendorId()).isPresent())
			return "Vendor with Id: "+addingPO.getVendorId()+" is not present";
		Optional<ProductDetails> v=getProductById(addingPO.getProductId());
		if(!v.isPresent())
			return "Product with Id: "+addingPO.getProductId()+" is not present";
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String s=""+timestamp+"";
        purchaseIdG++;
        String purId="Pur"+addingPO.getProductId()+""+purchaseIdG+"";
		PurchaseOrderHead modelPOHead=new PurchaseOrderHead(
				purId,
				addingPO.getVendorId(),
				addingPO.getTotQuantity(),
				v.get().getUnitPrice()*addingPO.getTotQuantity(),
				0, s, name, "-", "-"
				);
		PurchaseOrderDetails modelPODet=new PurchaseOrderDetails(
				purId,
				addingPO.getProductId(),
				v.get().getUnitPrice(),
				addingPO.getQuantity(),
				s, name, "-", "-"
				);
		repoPOHead.save(modelPOHead);
		repoPODet.save(modelPODet);
		return "Purchase order placed successfully! Please note down the Purchase Order ID: "+purId;
	}
	
	public String addInvoice(Invoice addingInvoice,String name)
	{
		Optional<ProductDetails> v=getProductById(addingInvoice.getProductId());
		if(!v.isPresent())
			return "Product with Id: "+addingInvoice.getProductId()+" is not present";
		Optional<PurchaseOrderHead> vv=getPOHeadById(addingInvoice.getPurchaseOId());
		if(!vv.isPresent())
			return "Purchase Order with Id: "+addingInvoice.getPurchaseOId()+" is not present";
		invoiceIdG++;
		String invoId="Inv"+addingInvoice.getPurchaseOId()+""+invoiceIdG+"";
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String s=""+timestamp+"";
		InvoiceHead mih=new InvoiceHead(
				invoId,
				addingInvoice.getPurchaseOId(),
				addingInvoice.getTotalQuantityReceived(),
				addingInvoice.getTotalQuantityReceived()*v.get().getUnitPrice(),
				addingInvoice.getReceivedOn(),
				0, s, name, "-", "-"
				);
        InvoiceItem mii=new InvoiceItem(
        		invoId,
        		addingInvoice.getProductId(),
        		v.get().getUnitPrice(),
        		addingInvoice.getQuantity(),
        		s, name, "-", "-"
        		);
        repoInvoiceHead.save(mih);
        repoInvoiceItem.save(mii);
		return "Invoice created successfully! Please note down the Invoice ID: "+invoId;
	}
	
	public String addUserRole(UserRoles userRoles)
	{
		userRolesRepo.save(userRoles);
		return "New status added successfully Status Id: "+userRoles.getRoleId()+" Status Name: "+userRoles.getRoleName();
	}
	
	public String addStatus(Status status)
	{
		statusRepo.save(status);
		return "New status added successfully Status Id: "+status.getStatusId()+" Status Name: "+status.getStatusName();
	}
	
	//  GET ------------------------------------------------------------------------------------------------
	
	public Optional<User> getUserById(String UId)
	{
		return repoUser.findById(UId);
	}
	
	public Optional<UserRoles> getUserRoleById(int i)
	{
		return userRolesRepo.findById(i);
	}
	
	public Optional<Status> getStatusById(int i)
	{
		return statusRepo.findById(i);
	}
	
	public Optional<Vendor> getVendorById(String id)
	{
		return repoVendor.findById(id);
	}
	
	public Optional<ProductDetails> getProductById(String id)
	{
		return repoProduct.findById(id);
	}
	
	public Optional<PurchaseOrderHead> getPOHeadById(String id)
	{
		return repoPOHead.findById(id);
	}
	
	public Optional<PurchaseOrderDetails> getPODetByPOId(String id)
	{
		return repoPODet.findModelPODetByPurchaseOId(id);
	}
	
	public Optional<InvoiceHead> getInvoiceHeadById(String id)
	{
		return repoInvoiceHead.findById(id);
	}
	
	public Optional<InvoiceItem> getInvoiceItemByInvId(String id)
	{
		return repoInvoiceItem.findModelInvoiceItemByInvoiceId(id);
	}
	
	public List<User> getAllUsers()
	{
		return repoUser.findAll();
	}
	
	public List<UserRoles> getAllUserRoles()
	{
		return userRolesRepo.findAll();
	}
	
	public List<Status> getAllStatus()
	{
		return statusRepo.findAll();
	}
	
	public List<Vendor> getAllVendors()
	{
		return repoVendor.findAll();
	}
	
	public List<Object> getAllProducts()
	{
		List<Object> obj=new ArrayList<Object>();
		obj.addAll(repoProduct.findAll());
		obj.addAll(repoVendMapProd.findAll());
		return obj;
	}
	
	public List<Object> getAllInvoice()
	{
		List<Object> obj=new ArrayList<Object>();
		obj.addAll(repoInvoiceHead.findAll());
		obj.addAll(repoInvoiceItem.findAll());
		return obj;
	}
	
	public List<Object> getAllProds()
	{
		List<Object> obj=new ArrayList<Object>();
		obj.addAll(repoProduct.findAll());
		obj.addAll(repoVendMapProd.findAll());
		return obj;
	}
	
	public List<Object> getAllPOs()
	{
		List<Object> obj=new ArrayList<Object>();
		obj.addAll(repoPOHead.findAll());
		obj.addAll(repoPODet.findAll());
		return obj;
	}
	
	//  PUT --------------------------------------------------------------------------------
	
	public String editPO(PurchaseOrder addingPO, String purchaseOId, String name)
	{
		Optional<PurchaseOrderHead> v1=getPOHeadById(purchaseOId);
		if(!v1.isPresent())
			return "Purchase Order with Id: "+purchaseOId+" is not present";
		if(v1.get().getStatus()==1)
			return "Purchase Order with this ID ("+purchaseOId+") is already closed";
		Optional<PurchaseOrderDetails> v2=getPODetByPOId(purchaseOId);
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String s=""+timestamp+"";
		PurchaseOrderHead modelPOHead=new PurchaseOrderHead();
		PurchaseOrderDetails modelPODet=new PurchaseOrderDetails();
        modelPOHead.setPurchaseOId(purchaseOId);
        modelPOHead.setVendorId(addingPO.getVendorId());
        modelPOHead.setTotQuantity(addingPO.getTotQuantity());
        Optional<ProductDetails> v3=getProductById(addingPO.getProductId());
        modelPOHead.setTotPrice(addingPO.getTotQuantity()*(v3.get().getUnitPrice()));
        modelPOHead.setStatus(v1.get().getStatus());
        modelPOHead.setCreatedOn(v1.get().getCreatedOn());
        modelPOHead.setCreatedBy(v1.get().getCreatedBy());
		modelPOHead.setUpdatedOn(s);
		modelPOHead.setUpdatedBy(name);
		repoPOHead.save(modelPOHead);
		modelPODet.setPurchaseOId(purchaseOId);
        modelPODet.setProductId(addingPO.getProductId());
        modelPODet.setQuantity(addingPO.getQuantity());
        modelPODet.setPurchaseItemId(v2.get().getPurchaseItemId());
        modelPODet.setCreatedOn(v2.get().getCreatedOn());
        modelPODet.setCreatedBy(v2.get().getCreatedBy());
		modelPODet.setUpdatedOn(s);
		modelPODet.setUnitPrice(v3.get().getUnitPrice());
		modelPODet.setUpdatedBy(name);
		repoPODet.save(modelPODet);
		return "Updated successfully for Purchase Order Id: "+purchaseOId;
	}
	
	public String editInvo(Invoice addingInvoice, String invId, String name)
	{
		Optional<InvoiceHead> v1=getInvoiceHeadById(invId);
		if(!v1.isPresent())
			return "Invoice with Id: "+invId+" is not present";
		if(v1.get().getStatus()==1)
			return "Invoice with this ID ("+invId+") is already closed";
		Optional<PurchaseOrderHead> v2=getPOHeadById(addingInvoice.getPurchaseOId());
		if(!v2.isPresent())
			return "Purchase Order with Id: "+addingInvoice.getPurchaseOId()+" is not present";
		if(v2.get().getStatus()==1)
			return "Purchase Order with this ID ("+addingInvoice.getPurchaseOId()+") is already closed";
		Optional<InvoiceItem> v3=getInvoiceItemByInvId(invId);
		Optional<ProductDetails> v4=getProductById(addingInvoice.getProductId());	
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String s=""+timestamp+"";
        InvoiceHead modelInvoiceHead=new InvoiceHead();
		InvoiceItem modelInvoiceItem=new InvoiceItem();
        modelInvoiceHead.setInvoiceId(invId);
        modelInvoiceHead.setPurchaseOId(addingInvoice.getPurchaseOId());
        modelInvoiceHead.setTotQuantityReceived(addingInvoice.getTotalQuantityReceived());
        modelInvoiceHead.setStatus(v1.get().getStatus());
        modelInvoiceHead.setCreatedOn(v1.get().getCreatedOn());
        modelInvoiceHead.setCreatedBy(v1.get().getCreatedBy());
		modelInvoiceHead.setUpdatedOn(s);
		modelInvoiceHead.setUpdatedBy(name);
		modelInvoiceHead.setTotalPrice(addingInvoice.getTotalQuantityReceived()*v4.get().getUnitPrice());
		repoInvoiceHead.save(modelInvoiceHead);
		modelInvoiceItem.setInvoiceItemId(v3.get().getInvoiceItemId());
        modelInvoiceItem.setInvoiceId(invId);
        modelInvoiceItem.setQuantity(addingInvoice.getQuantity());
        modelInvoiceItem.setUnitPrice(v4.get().getUnitPrice());
        modelInvoiceItem.setCreatedOn(v3.get().getCreatedOn());
        modelInvoiceItem.setCreatedBy(v3.get().getCreatedBy());
        modelInvoiceItem.setUpdatedOn(s);
        modelInvoiceItem.setUpdatedBy(name);
        modelInvoiceItem.setProductId(addingInvoice.getProductId());
		repoInvoiceItem.save(modelInvoiceItem);
        return "Invoice updated successfully for Invoice ID: "+invId;
	}
	
	public String editUser(User modelUser, String userId)
	{
		int v=checkAdmin(userId);
		if(v==0)
			return "User with this Id: "+userId+" is not present";
		if(v==1)
			return "You are not an Admin! This operation cannot be done";
		repoUser.save(modelUser);
		return "User details with ID: "+userId+" updated successfully";
	}
	
	public String editVendor(Vendor modelVendor, String vendId, String name)
	{
		int v=checkAdmin(name);
		if(v==0)
			return "User with this Id: "+name+" is not present";
		if(v==1)
			return "You are not an Admin! This operation cannot be done";
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String s=""+timestamp+"";
		modelVendor.setUpdatedBy(name);
		modelVendor.setUpdatedOn(s);
		repoVendor.save(modelVendor);
		return "Vendor details with ID: "+vendId+" updated successfully";
	}
	
	public String editProduct(Product addingProduct, String prodId, String name)
	{
		int v=checkAdmin(name);
		if(v==0)
			return "User with this Id: "+name+" is not present";
		if(v==1)
			return "You are not an Admin! This operation cannot be done";
		Optional<ProductDetails> v1=getProductById(prodId);	
		ProductDetails modelProduct=new ProductDetails();
		modelProduct.setProductId(prodId);
		modelProduct.setProductName(addingProduct.getProductName());
		modelProduct.setUnitPrice(addingProduct.getUnitPrice());
		modelProduct.setDescription(addingProduct.getDescription());
		modelProduct.setAddedOn(v1.get().getAddedOn());
		modelProduct.setAddedBy(v1.get().getAddedBy());
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String s=""+timestamp+"";
		modelProduct.setUpdatedOn(s);
		modelProduct.setUpdatedBy(name);
		repoProduct.save(modelProduct);
		repoVendMapProd.upd(prodId, addingProduct.getVendorId(), modelProduct.getUnitPrice());
		return "Product details with ID: "+prodId+" updated successfully";
	}
	
	public String approvePO(String purchaseOId,String name)
	{
		int v=checkAdmin(name);
		if(v==0)
			return "User with this Id: "+name+" is not present";
		if(v==1)
			return "You are not an Admin! This operation cannot be done";
		Optional<PurchaseOrderHead> t=getPOHeadById(purchaseOId);
		if(t.get().getStatus()==1)
			return "The provided Purchase ID ("+purchaseOId+") is already closed";
		t.get().setStatus(1);
		repoPOHead.appr(purchaseOId);
		return "Updated successfully for Purchase ID: "+ purchaseOId;
	}
	
	public String closePO(String purchaseId)
	{
		Optional<PurchaseOrderHead> t=repoPOHead.findById(purchaseId);
		PurchaseOrderHead obj=new PurchaseOrderHead();
		//if(t.get().getQuantity()!=repoInvoiceHead.sumQR(purchaseId))
		//	return "You cannot close this Purchase Order with ID: "+purchaseId+" since the total target quantity has not yet received";
		//if(repoInvoiceHead.purchaseCount(purchaseId)!=repoInvoiceHead.purchaseclosedCount(purchaseId))
		//	return "All the Invoices related to this purchase Id ("+purchaseId+") are not closed yet!";
		//if(t.get().getClosedStatus()==1)
		//	return "The provided Purchase ID ("+purchaseId+") is already closed on "+t.get().getClosedOn();
		//if(t.get().getApprovalStatus()==0)
		//	return "This Purchase Order with ID: "+purchaseId+" cannot be closed because it is not yet approved";
		//obj.setPurchaseId(purchaseId);
		//obj.setProductId(t.get().getPurchaseOId());
		//obj.setQuantity(t.get().getQuantity());
		//obj.setUnitPrice(t.get().getUnitPrice());
		//obj.setTotalPrice(t.get().getTotalPrice());
		//obj.setPurchaseMadeOn(t.get().getPurchaseMadeOn());
		//obj.setPurchaseMadeBy(t.get().getPurchaseMadeBy());
		//obj.setApprovalStatus(t.get().getApprovalStatus());
		//obj.setApprovedOn(t.get().getApprovedOn());
		//obj.setApprovedBy(t.get().getApprovedBy());
		//obj.setLastEditedOn(t.get().getLastEditedOn());
		//obj.setClosedStatus(1);
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String s=""+timestamp+"";
		//obj.setClosedOn(s);
		repoPOHead.save(obj);
		return "Purchase Order with ID: "+purchaseId+" closed successfully on: "+ s;
	}
	
	public String closeInv(String invoiceId)
	{
		Optional<InvoiceHead> t=repoInvoiceHead.findById(invoiceId);
		InvoiceHead obj=new InvoiceHead();
		//if(t.get().getClosedStatus()==1)
		//	return "The Invoice ID ("+invoiceId+") is already closed on "+t.get().getClosedOn();
		//obj.setInvoiceId(t.get().getInvoiceId());
		//obj.setPurchaseId(t.get().getPurchaseId());
		//obj.setQuantityReceived(t.get().getQuantityReceived());
		//obj.setTotalPrice(t.get().getTotalPrice());
		//obj.setReceivedOn(t.get().getReceivedOn());
		//obj.setInvoiceCreatedOn(t.get().getInvoiceCreatedOn());
		//obj.setLastEditedOn(t.get().getLastEditedOn());
		//obj.setClosedStatus(1);
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String s=""+timestamp+"";
		//obj.setClosedOn(s);
		repoInvoiceHead.save(obj);
		return "Invoice with ID: "+invoiceId+" is successfully closed";
	}
	
	
	
	
	/*
	public Optional<ModelVendMapProd> getProdByVend(String vendId)
	{
		return repoVendMapProd.getProdsUsingVend(vendId);
	}
	
	public Optional<ModelInvoiceHead> getInvByPur(String purId)
	{
		return repoInvoiceHead.getInvsUsingPur(purId);
	}
	
	public Optional<modelPOHead> getPOByProd(String prodId)
	{
		return repoPOHead.getPOsUsingProd(prodId);
	}
	*/
	
	public String deleteAllUsers(String name) {
		repoUser.deleteAll();
		return "Deleted all users by "+ name;
	}
	
	public String deleteAllProds(String name) {
		repoProduct.deleteAll();
		return "Deleted all products by "+name;
	}
	
	public String deleteAllVendors(String name) {
		repoVendor.deleteAll();
		return "Deleted all vendors by "+ name;
	}
	
	public String deleteAllPOs(String name) {
		repoPOHead.deleteAll();
		return "Deleted all purchase orders by "+name;
	}
	
	public String deleteAllInvs(String name) {
		repoInvoiceHead.deleteAll();
		return "Deleted all invoices by "+ name;
	}
	
	public String deleteByUserId(String uid) {
		repoUser.deleteById(uid);
		return "Deleted user with Id: "+uid;
	}
	
	public String deleteByProdId(String pid) {
		repoProduct.deleteById(pid);
		return "Deleted product with Id: "+pid;
	}
	
	public String deleteByVendId(String vid) {
		repoVendor.deleteById(vid);
		return "Deleted vendor with Id: "+vid;
	}
	
	public String deleteByPOId(String poid) {
		repoPOHead.deleteById(poid);
		return "Deleted purchase order with Id: "+poid;
	}
	
	public String deleteByInvId(String iid) {
		repoInvoiceHead.deleteById(iid);
		return "Deleted invoice with Id: "+iid;
	}
	
	
}

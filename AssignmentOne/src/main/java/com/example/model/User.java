package com.example.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="user")
public class User {

	@Id
	@Column(name="userId")
	
	private String userId;
	
	
	@Column(name="userName")
	private String userName;
	
	
	@Column(name="userRole")
	private int userRole;
	
	
	@Column(name="createdOn")
	private String createdOn;
	
	
	@Column(name="createdBy")
	private String createdBy;
	
	@Column(name="updatedOn")
	private String updatedOn;
	
	@Column(name="updatedBy")
	private String updatedBy;
	
	
	public User()
	{	
	}


	public User(String userId, String userName, int userRole, String createdOn, String createdBy,
			String updatedOn, String updatedBy) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userRole = userRole;
		this.createdOn = createdOn;
		this.createdBy = createdBy;
		this.updatedOn = updatedOn;
		this.updatedBy = updatedBy;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public int getUserRole() {
		return userRole;
	}


	public void setUserRole(int userRole) {
		this.userRole = userRole;
	}


	public String getCreatedOn() {
		return createdOn;
	}


	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}


	public String getCreatedBy() {
		return createdBy;
	}


	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}


	public String getUpdatedOn() {
		return updatedOn;
	}


	public void setUpdatedOn(String updatedOn) {
		this.updatedOn = updatedOn;
	}


	public String getUpdatedBy() {
		return updatedBy;
	}


	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	
	
	
}

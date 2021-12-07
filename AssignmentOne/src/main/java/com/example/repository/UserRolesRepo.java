package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.UserRoles;

public interface UserRolesRepo  extends JpaRepository<UserRoles, Integer>{

}

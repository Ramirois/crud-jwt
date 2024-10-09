package com.ivan.app.springboot_crud.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ivan.app.springboot_crud.entities.Role;

/**
 * RoleRepository
 */
public interface RoleRepository extends CrudRepository<Role, Long>{

    
}
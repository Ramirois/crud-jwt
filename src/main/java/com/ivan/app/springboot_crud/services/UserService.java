package com.ivan.app.springboot_crud.services;

import java.util.List;

import com.ivan.app.springboot_crud.entities.User;

public interface UserService {
    List<User> findAll();


}

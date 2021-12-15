package com.ratnikov.services;

import com.ratnikov.model.User;

import java.util.List;

public interface UserService {

    boolean userExists(String username);

    void createUser(User user);

    User get(Long id);

    List<User> getList();
}

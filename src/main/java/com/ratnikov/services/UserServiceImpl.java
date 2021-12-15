package com.ratnikov.services;

import com.ratnikov.model.User;
import com.ratnikov.model.Role;
import com.ratnikov.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public boolean userExists(String username) {
        return userRepository.findByUsername(username).isPresent();
    }

    @Override
    @Transactional
    public void createUser(User user) {
        if (user.getRoles() == null) {
            user.setRoles(new HashSet<>(Collections.singletonList(Role.ROLE_USER)));
        }

        userRepository.save(user);
    }

    @Override
    @Transactional
    public User get(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    @Transactional
    public List<User> getList() {
        return userRepository.findAll();
    }
}
package com.ratnikov.config;

import com.ratnikov.model.Role;
import com.ratnikov.model.User;
import com.ratnikov.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

@Component
public class DefaultDataConfig {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public DefaultDataConfig(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    private void createDefaultUsers() {
        List.of(
                User.builder().username("john").password(passwordEncoder.encode("123")).build(),
                User.builder().username("jane").password(passwordEncoder.encode("123")).build()
        ).forEach(userService::createUser);

        userService.createUser(
                User.builder().username("admin").password(passwordEncoder.encode("admin")).roles(new HashSet<>(Collections.singletonList(Role.ADMIN))).build()
        );

        userService.createUser(
                User.builder().username("moder").password(passwordEncoder.encode("moder")).roles(new HashSet<>(Collections.singletonList(Role.MODERATOR))).build()
        );

        userService.createUser(
                User.builder().username("moderator").password(passwordEncoder.encode("12345")).roles(new HashSet<>(Arrays.asList(Role.ADMIN, Role.MODERATOR))).build()
        );
    }

}


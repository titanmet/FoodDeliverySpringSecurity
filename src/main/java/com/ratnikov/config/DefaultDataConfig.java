package com.ratnikov.config;

import com.ratnikov.model.Role;
import com.ratnikov.model.User;
import com.ratnikov.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

@Component
public class DefaultDataConfig {

    private final UserService userService;

    @Autowired
    public DefaultDataConfig(UserService userService) {
        this.userService = userService;
    }

    private void createDefaultUsers() {
        List.of(
                User.builder().username("john").password("123").build(),
                User.builder().username("jane").password("123").build()
        ).forEach(userService::createUser);

        userService.createUser(
                User.builder().username("admin").password("admin").roles(new HashSet<>(Collections.singletonList(Role.ROLE_ADMIN))).build()
        );

        userService.createUser(
                User.builder().username("moder").password("moder").roles(new HashSet<>(Collections.singletonList(Role.ROLE_MODERATOR))).build()
        );

        userService.createUser(
                User.builder().username("moderator").password("12345").roles(new HashSet<>(Arrays.asList(Role.ROLE_ADMIN, Role.ROLE_MODERATOR))).build()
        );
    }

}


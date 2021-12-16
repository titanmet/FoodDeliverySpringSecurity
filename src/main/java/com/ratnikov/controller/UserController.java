package com.ratnikov.controller;

import com.ratnikov.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/{id}")
    public String welcome(@PathVariable Long id, Model model) {
        model.addAttribute("user", userService.get(id));
        return "user-profile";
    }

    @GetMapping("/admin/{id}")
    public String getAdminPage(@PathVariable Long id, Model model) {
        model.addAttribute("admin", userService.get(id));
        model.addAttribute("list" , userService.getList());
        return "admin-page";
    }

    @GetMapping("/login")
    public String signInPage(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("error", true);
        }
        if (logout != null) {
            model.addAttribute("logout", true);
        }
        return "login";
    }

    @GetMapping("/access-denied")
    public String accessDenied() {
        return "access-denied";
    }

}
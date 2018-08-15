package com.dat.starter.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;

@Controller
public class Index {

    @GetMapping("/")
    @PermitAll
    public String index(Model model) {
        model.addAttribute("message", "Hello World!");
        return "index/index";
    }

    @GetMapping(path = "/admin")
    @Secured("ROLE_ADMIN")
    public String admin() {
        return "index/admin";
    }

    @GetMapping(path = "/user")
    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    public String user() {
        return "index/user";
    }
}

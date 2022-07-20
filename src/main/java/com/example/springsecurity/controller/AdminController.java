package com.example.springsecurity.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/admin" )
public class AdminController {
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/get")
    String getAdmin(){
        return "This is admin!";
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/create")
    String createUser(){
        return "User created!";
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/delete")
    String deleteUser(){
        return "User deleted!";
    }



}

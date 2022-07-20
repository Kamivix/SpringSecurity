package com.example.springsecurity.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@PreAuthorize("hasRole('admin')")
@RestController
@RequestMapping("/api/admin" )
public class AdminController {

    @GetMapping("/get")
    String getAdmin(){
        return "This is admin!";
    }

    @GetMapping("/create")
    String createUser(){
        return "User created!";
    }

    @GetMapping("/delete")
    String deleteUser(){
        return "User deleted!";
    }



}

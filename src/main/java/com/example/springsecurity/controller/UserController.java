package com.example.springsecurity.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user" )
public class UserController {
    @PreAuthorize("hasAnyAuthority('USER_READ','ADMIN')")
@GetMapping("/get")
    String getUser(){
        return "This is user!";
    }
@PreAuthorize("hasAnyAuthority('USER_EDIT','ADMIN')")
    @GetMapping("/update")
    String updateUser(){
    return "User updated!";
    }

}

package com.example.springsecurity.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user" )
public class UserController {
@GetMapping("/get")
    String getUser(){
        return "This is user!";
    }

    @GetMapping("/update")
    String updateUser(){
    return "User updated!";
    }

}

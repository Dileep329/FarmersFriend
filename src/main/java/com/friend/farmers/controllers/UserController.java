package com.friend.farmers.controllers;

import com.friend.farmers.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

    @Autowired
    UserService userService;


    @GetMapping("/test")
    public String test(){
        System.out.println("User is able to access the source");
        return "User is able to access this controller";
    }


    @GetMapping("/testAdmin")
    public String adminTest(){
        return "Admin is able to access this controller";
    }

    @GetMapping("/testSeller")
    public String sellerTest(){
        return "Seller is able to access this controller";
    }
}

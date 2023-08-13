package com.medicare.schedular.medicareschedular.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/v1")
public class HomeController {

    @GetMapping("/home")
    public String display(){
        return "Welcome to Medicare";
    }
}

package com.mazebuddy.play.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Value;

@CrossOrigin(origins = "*")
@RestController
public class Welcome {
    @Value("${welcome.message}")
    private String welcomeMessage;


    @GetMapping("/")
    public String app(){
        return welcomeMessage;
    }

}

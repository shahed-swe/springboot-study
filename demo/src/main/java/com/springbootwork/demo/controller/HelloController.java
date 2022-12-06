package com.springbootwork.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController
public class HelloController {

//    @RequestMapping(value="/", method = RequestMethod.GET) -> vast thing

    @GetMapping("/") //simple thing
    public String helloworld(){
        return "Welcome to New Page New Change";
    }
}

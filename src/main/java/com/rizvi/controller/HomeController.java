package com.rizvi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping("/")
    public String greet() {
        return "Welcome to the Home Page!";
    }

    @RequestMapping("/about")
    public String about() {
        return "This is the About Page!";
    }
}

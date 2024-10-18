package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bakery_bread")
public class ControllerBreadType {

    @GetMapping
    public String home() {
        return "principal/Home";
    }

    @GetMapping("/bread")
    public String breadCrud() {
        return "principal/BreadCrud";
    }
}

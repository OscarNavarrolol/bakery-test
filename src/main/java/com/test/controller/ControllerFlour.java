package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("bakery_flour")
public class ControllerFlour {

    @GetMapping
    public String bread_crud(){
        return "/principal/FlourCrud";
    }

}

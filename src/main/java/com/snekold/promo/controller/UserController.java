package com.snekold.promo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/")
    public String index(){
        return "user/index";
    }

    @GetMapping("/check-cod")
    public String checkCod(){
        return "user/chek_cod";
    }



}

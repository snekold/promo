package com.snekold.promo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController {
    @GetMapping("/how-to-participate")
    public String howToParticipate(){
        return "Для участия в промо акции подпишитесь на Егора tg ";
    }
}

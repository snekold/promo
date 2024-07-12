package com.snekold.promo.controller;

import com.snekold.promo.model.Prize;
import com.snekold.promo.service.PrizeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@Slf4j
public class UserController {
    private PrizeService prizeService;

    public UserController(PrizeService prizeService) {
        this.prizeService = prizeService;
    }

    @GetMapping("/")
    public String index(){
        System.out.println("index");
        return "user/index";
    }



    @GetMapping("/form-completion")
    public String formCompletion(@RequestParam String code) {
        log.info(code+" = CODE");
        return "user/form_get_prize";
    }


    @GetMapping("/how-to-participate")
    public ResponseEntity<String> howToParticipate(){
        return ResponseEntity.ok("Для участия в промо акции подпишитесь на Егора tg ");
    }


}

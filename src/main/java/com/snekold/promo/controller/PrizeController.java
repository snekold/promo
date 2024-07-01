package com.snekold.promo.controller;


import com.snekold.promo.model.Prize;
import com.snekold.promo.service.PrizeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/promo-admin-panel")
public class PrizeController {
    private static final Logger log = LoggerFactory.getLogger(PrizeController.class);
    private PrizeService prizeService;

    public PrizeController(PrizeService prizeService) {
        this.prizeService = prizeService;
    }

    @GetMapping("/add-prize")
    public String addNewPrizeThroughAdminPanel() {
        return "admin/add_new_prize";
    }

    @PostMapping("/add-prize")
    public String addNewPrizeThroughAdminPanelPost
            (@RequestParam String name_prize,
             @RequestParam String codes_prize,
             @RequestParam MultipartFile image_prize
            ) {
        String image_path = saveImage(image_prize);

        String[] codes = codes_prize.split("[,;]");

        for (String code : codes) {
            Prize prize = new Prize();
            prize.setNamePrize(name_prize);
            prize.setImagePath(image_path);
            prize.setCod(code);

            prizeService.addPrize(prize);
        }
        return addNewPrizeThroughAdminPanel();
    }


    private String saveImage(MultipartFile image_prize) {
        String folder = "src/main/resources/static/images/";
        String fileName = image_prize.getOriginalFilename();

        Path path = Paths.get(folder + fileName);


        try {
            Files.write(path, image_prize.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "/images/" + fileName;
    }

    @GetMapping("/spisok-prize")

    public String getPrizeSpisok(Model model) {
        List<Prize> allPrize = prizeService.getAllPrize();
        model.addAttribute("prizeList", allPrize);

        return "admin/spisok-prize";
    }

    @GetMapping("/")
    public String getPrizeList(Model model) {
        return "admin/admin_panel";
    }

    @PostMapping("/set-status")
    public ResponseEntity<String> changeStatus(@RequestBody Map<String, Long> jsonMap) {
        long prize_id = jsonMap.get("id");
        boolean setStatus = prizeService.setStatusById(prize_id);
        if (setStatus) {
            return ResponseEntity.ok("status change");
        } else {
            return ResponseEntity.internalServerError().body("error");
        }


    }

    @PostMapping("/check-code")
    public ResponseEntity<String> checkCode(@RequestBody Map<String, String> jsonMap) {
        String code = jsonMap.get("code");
        log.info(code + "-----------------------<<<<<<");
        Prize prize = prizeService.getPrizeByCode(code);
        if(prize != null) {
            return ResponseEntity.ok(code);
        }else {
            return ResponseEntity.internalServerError().body("error");
        }
    }

}

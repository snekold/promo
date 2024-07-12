package com.snekold.promo.controller;

import com.snekold.promo.model.Prize;
import com.snekold.promo.service.PrizeService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

@Controller
public class AdminController {
    private PrizeService prizeService;

    public AdminController(PrizeService prizeService) {
        this.prizeService = prizeService;
    }

    @GetMapping("/admin-panel")
    public String getPrizeList(Model model) {
        return "admin/admin_panel";
    }

}

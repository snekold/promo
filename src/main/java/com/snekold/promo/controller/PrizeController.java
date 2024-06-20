package com.snekold.promo.controller;



import com.snekold.promo.model.Prize;
import com.snekold.promo.service.PrizeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
public class PrizeController {
    private PrizeService prizeService;

    public PrizeController(PrizeService prizeService) {
        this.prizeService = prizeService;
    }

    @GetMapping("/promo-admin-panel/add-prize")
    public String addNewPrizeThroughAdminPanel(){
    return "add_new_prize";
    }

    @PostMapping("/promo-admin-panel/add-prize")
    public String addNewPrizeThroughAdminPanelPost
            (@RequestParam String name_prize,
             @RequestParam String codes_prize,
             @RequestParam MultipartFile image_prize
             )
    {
    String image_path = saveImage(image_prize);

    String[] codes =  codes_prize.split("[,;]");

    for (String code : codes) {
        Prize prize = new Prize();
        prize.setNamePrize(name_prize);
        prize.setImagePath(image_path);
        prize.setCod(code);

        prizeService.addPrize(prize);
    }
        return addNewPrizeThroughAdminPanel();
    }



    private String saveImage(MultipartFile image_prize){
        String folder = "src/main/resources/static/images/";
        String fileName = image_prize.getOriginalFilename();

        Path path = Paths.get(folder + fileName);


        try {
            Files.write(path,image_prize.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "/images/"+fileName;
    }

    @GetMapping("/promo-admin-panel/spisok-prize")

    public String getPrizeSpisok(Model model){
        List<Prize> allPrize = prizeService.getAllPrize();
        model.addAttribute("prizeList",allPrize);

        return "spisok-prize";
    }


}

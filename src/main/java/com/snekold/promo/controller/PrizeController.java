package com.snekold.promo.controller;



import com.snekold.promo.model.Prize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class PrizeController {

    @GetMapping("/promo-admin-panel/add-prize")
    public String addNewPrizeThroughAdminPanel(){
    return "promo-admin-panel/add-prize";
    }
    @PostMapping("/promo-admin-panel/add-prize")
    public String addNewPrizeThroughAdminPanelPost
            (@RequestParam String name_prize,
             @RequestParam String codes_prize,
             @RequestParam MultipartFile image_prize
             )
    {
    String image_path = saveImage(image_prize);

    String[] codes =  codes_prize.split(",");

        Prize prize = new Prize();
        prize.setNamePrize(name_prize);
        prize.setImagePath(image_path);


        return"admin-panel";


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
}
